package assign9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class contains the mainFrame for the Light Outs out button
 * @author James Yeates
 *
 */

public class LightsOut extends JFrame implements ActionListener {
	
	private static LightOutButton [][] multiArray = new LightOutButton[5][5];
	private int row, col;
	private JButton shuffleBtn,manualBtn,autoPlay,playAgain,startButton;
	private Panel buttonPanel,thePanel;
	IntroPanel centerPanel ;
	private boolean toogleSelected = false;
	private Panel  startPanel;
	private Icon v = new ImageIcon(getClass().getResource("Vader.png"));
	private Icon y = new ImageIcon(getClass().getResource("Yoda.png"));

	public static void main(String[] args) {
		
		LightsOut l = new LightsOut();
		l.setVisible(true);
		}
	
	//constructor
	public LightsOut(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lights Out");
		setSize(850, 850);
		
		//main panel
		thePanel = new Panel();
		thePanel.setLayout(new BorderLayout());
		
		startButton = new JButton("!!!!!!!!!!!Click here to start!!!!!!!!!!!!!!");
		startButton.addActionListener(this);
		
		//IntroPanel created here
		centerPanel = new IntroPanel();
		thePanel.add(startButton,BorderLayout.NORTH);
		thePanel.add(centerPanel,BorderLayout.CENTER);
		add(thePanel);
		
		}
		

	/**
	 * Action listener method.. handles events
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Start Game
		if(e.getSource().equals(startButton)|| e.getSource().equals(playAgain))
			playGame();
	
		//Procedure if a LightOutButton is pressed
		if(e.getSource() instanceof LightOutButton){
			LightOutButton button = (LightOutButton)e.getSource(); 
			lightButtonPressed(button);

		}
		//Procedure if shuffleBtn is pressed
		else if ( e.getSource().equals(shuffleBtn)) {	
			shuffleBtn.setOpaque(true);
			
			shuffle1(multiArray, 20);
		}
		//Procedure for manualButton
		else if(e.getSource().equals(manualBtn)){
			toogleSelected =(!(toogleSelected));
			if(manualBtn.getBackground().equals(Color.RED)){
				manualBtn.setText("Enter Manual Setup");
				manualBtn.setBackground(Color.WHITE);
			}
			else{
				manualBtn.setText("Exit Manual Setup ");
				manualBtn.setBackground(Color.RED);
			}
		}
		//procedure for autoPlay button
		else if(e.getSource().equals(autoPlay)){
			autoPlay.setText("trying to solve..please wait");
			autoPlay();
		}
	}	

	
	/**
	 * this method toggle the light out button that was pressed
	 * and sets the the icon
	 * @param b LightOutButton
	 */
	public void toggle(LightOutButton b){
		if(b.getValue()==1){
			b.setBackground(Color.YELLOW);
			b.setIcon(y);
		}
		else{
			b.setBackground(Color.WHITE);
			b.setIcon(v);
		}
	}
	/**
	 * This method toggles the neighbors buttons if manual mode is not selected
	 * @param b LightOutButton
	 */
	public void toggleNeighbors(LightOutButton b){
		int row = b.getRow();
		int col = b.getCol();
		
		if( row != 0 ){
			multiArray[row-1][col].changeValue();
			toggle(multiArray[row-1][col]);
			multiArray[row-1][col].turnOn();
			}
		if( row != 4 ){
			multiArray[row+1][col].changeValue();
			toggle(multiArray[row+1][col]);
			multiArray[row+1][col].turnOn();
		}
		if( col != 0 ){
			multiArray[row][col-1].changeValue();
			toggle(multiArray[row][col-1]);
			multiArray[row][col-1].turnOn();
		}
		if( col != 4 ){
			multiArray[row][col+1].changeValue();
			toggle(multiArray[row][col+1]);
			multiArray[row][col+1].turnOn();
		}
		
	}
	/**
	 * this method check for win both if the lights are all out
	 * or if they are all on
	 * @return 1 if all lights are on, 0 if all or off, if not return -1.
	 */
	public static int checkForWin(){
		int first = multiArray[0][0].getValue();
		for(int i =0; i<5;i++){
			for(int j = 0; j<5; j++)
				if(multiArray[i][j].getValue()!=first)
					return -1;
		
		}
		return first;
	}
	/**
	 * this method shuffles the lights out buttons
	 * @param matrix the 2-d array of buttons to be shuffled
	 * @param shuffler how many times array is shuffled
	 */
	public  void shuffle1(LightOutButton[][] matrix, int shuffler){
		int x;
		int y;
		
		
		for(int i = 0; i<shuffler; i ++){
			x =(int)(Math.random()*5);
			y =(int)(Math.random()*5);
			matrix[x][y].changeValue();
			
		}
		turnOnlights1();
	}
	/**
	 * this method goes through the 2-d array and turns on/off the buttons
	 */
	public void turnOnlights1(){
		
		for(int i =0; i<5;i++){
			for(int j = 0; j<5; j++)
				if(multiArray[i][j].getValue()==1){
					this.multiArray[i][j].setBackground(Color.YELLOW);
					this.multiArray[i][j].setIcon(y);
					this.multiArray[i][j].turnOn();
			}
				else{
					this.multiArray[i][j].setBackground(Color.WHITE);
					this.multiArray[i][j].setIcon(v);
					this.multiArray[i][j].turnOn();
					
				}
			
		}
	}
	/**
	 * this method plays to completion by randomly changing the light out buttons
	 */
	
	public void autoPlay(){
		
		int count = 0;
		while(checkForWin() ==-1){
			int x1 =(int)(Math.random()*5);
			int x2 =(int)(Math.random()*5);
			multiArray[x1][x2].changeValue();
			count++;
		
			}
		if(checkForWin()==0){
			//create the winPanel the parameter 3 is used to
			//identify that 'Vader' won.
			JPanel winPanel = new WinPanel(3,count);
			//create button that will allow the player to play again
			playAgain = new JButton("Play Agian ");
			playAgain.addActionListener(this);
			winPanel.add(playAgain);
			
			winPanel.setVisible(true);
			thePanel.removeAll();
			thePanel.add(winPanel,BorderLayout.CENTER);
		}
			if(checkForWin()==1){
				//button.setBackground(Color.green);
				JPanel winPanel = new WinPanel(2,count);
				playAgain = new JButton("Play Agian ");
				playAgain.addActionListener(this);
				winPanel.add(playAgain);
				
				winPanel.setVisible(true);
				winPanel.setBackground(Color.RED);
				thePanel.removeAll();
				thePanel.add(winPanel,BorderLayout.CENTER);
			}
		
	}
	/**
	 * this method starts a new game of lights out.
	 */
	public void playGame(){
		
		row = 0;
		col = 0;
		thePanel.removeAll();
		
		buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(5,5));
		
		//create the LightOutButton's,add to GUI.  Also create a 2-d array to represent the buttons
		for (int i = 0; i<25; i++){
			
			LightOutButton b = new LightOutButton(row,col);
			b.addActionListener(this);
			buttonPanel.add(b);
			b.setOpaque(true);
			b.setIcon(v);
			
			b.turnOn();
			
			//add the button to the multi dimesional
			//array at the correct place
			multiArray[row][col]= b;
			
			if(col>=4 ){
				row++;
				col =0;
			}
			else
				col++;
			}
	
		/*
		 * create the Bottom Panel and the buttons that go along with it
		 */
				shuffleBtn = new JButton("Shuffle");
				shuffleBtn.addActionListener(this);
				
				manualBtn = new JButton("Enter Manual Mode");
				manualBtn.setOpaque(true);
				manualBtn.addActionListener(this);
				
				autoPlay = new JButton("Auto Play");
				autoPlay.addActionListener(this);
				
				Panel btmPanel = new Panel();
				btmPanel.setLayout(new BorderLayout());
				btmPanel.add(shuffleBtn, BorderLayout.WEST);
				btmPanel.add(manualBtn,BorderLayout.EAST);
				btmPanel.add(autoPlay,BorderLayout.CENTER);
				
				thePanel.add(btmPanel, BorderLayout.SOUTH);
				
	
		thePanel.add(buttonPanel,BorderLayout.CENTER);
		shuffle1(multiArray, 10);

	}
	/**
	 * this organizes the instructions for when a light Button is pressed,
	 * which includes toggling itself and neighbors if necessary, turn on
	 * and checking for win.
	 * @param button
	 */
	

	public void lightButtonPressed(LightOutButton button){
		
		
		button.changeValue();
		//button.setBackground(Color.YELLOW);
		toggle(button);
		button.turnOn();
		if(!(toogleSelected)){
			toggleNeighbors(button);
				//check for win
			if(checkForWin()==1){
				//button.setBackground(Color.green);
				JPanel winPanel = new WinPanel(1);
				playAgain = new JButton("Play Agian");
				playAgain.addActionListener(this);
				winPanel.add(playAgain);
			
				winPanel.setVisible(true);
				
				thePanel.removeAll();
				thePanel.add(winPanel,BorderLayout.CENTER);
			}
			if(checkForWin()==0){
				//button.setBackground(Color.green);
				JPanel winPanel = new WinPanel(0);
				playAgain = new JButton("Vader wins play Agian");
				playAgain.addActionListener(this);
				winPanel.add(playAgain);
			
				winPanel.setVisible(true);
				winPanel.setBackground(Color.RED);
				thePanel.removeAll();
				thePanel.add(winPanel,BorderLayout.CENTER);
			}	
		}
	}




}