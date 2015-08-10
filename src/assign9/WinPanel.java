package assign9;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * this class is the panel to be added once game has been won.  It is
 * responsible for drawing the message to the panel.  This class was largely 
 * used to help me organize the potential message I wanted to have shown at the 
 * end of the game.
 * @author James Yeates
 *
 */

public class WinPanel extends JPanel {
	JButton playAgain;
	JPanel winPanel;
	int value;
	int numOfTrys;
	
	/**
	 * Constructor 
	 * @param value  0 for vader(lights off), 1 for yoda(lights on)
	 */
	public WinPanel( int value){
		//value is used to determine which items to add to the Panel
		//in the paintComponent method
		this.value = value;
		}
	
	/**
	 * Construtor
	 * @param value 2 for vader(lights off), 1 for yoda(lights on)
	 * @param numOfTrys
	 */
	public WinPanel(int value, int numOfTrys){
		this.value = value;
		this.numOfTrys = numOfTrys;//how many time it took autoplay() to solve
		
	}
	/**
	 * This method determines draws and changes panel based off the final value 
	 * of the game
	 */
	
	public void paintComponent(Graphics g){
		//executed if all of the icons are set to 'Vader' by the user
		if(value ==0){
			super.paintComponent(g);
			this.setBackground(Color.BLACK);
			g.setColor(Color.RED);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
			g.drawString("Welcome to the Dark Side", 30, 300);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
			g.drawString("Click the button above to play again", 150, 380);
			repaint();
		}
		//executed if all of the icons are set to 'Yoda' by the user
		if(value ==1){
			super.paintComponent(g);
			this.setBackground(Color.GREEN);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
			g.drawString("Turned on Yoda....you did" , 30, 300);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
			g.drawString("Click the button above to play again", 150, 380);
			repaint();
		}
		//executed if all of the icons are set to 'vader' in autoPlay mode
		if(value ==2){
			super.paintComponent(g);
			this.setBackground(Color.BLACK);
			g.setColor(Color.RED);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,80));
			g.drawString("Vader Wins" , 180, 200);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
			g.drawString("it only took " + numOfTrys + " random clicks to solve this puzzle", 60, 360);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
			g.drawString("Click the button above to play again", 130, 430);
			repaint();
		}
		//executed if all of the icons are set to 'Yoda' in autoPlay mode
		if(value ==3){
			super.paintComponent(g);
			this.setBackground(Color.GREEN);
			g.setColor(Color.RED);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,80));
			g.drawString("Yoda Wins" , 180, 200);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
			g.drawString("it only took " + numOfTrys + " random clicks to solve this puzzle", 60, 360);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
			g.drawString("Click the button above to play again", 130, 430);
			repaint();
		
		}
	}


}
