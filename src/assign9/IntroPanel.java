package assign9;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;



/**
 * This class is an abstraction of the JPanel that is add to frame at the beginning of
 * the game that contains instruction for how to play the game
 * @author James Yeates
 *
 */
public class IntroPanel extends JPanel {

	private int x = 0;
	private int y = 0;


	public IntroPanel(){
		}
	
	/**
	 * this method is used to draw the graphics on this panel
	 * 
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		// draw the instruction for the game on the Panel
		Color c = new Color(90,(x/4)%255,(x/8)%255);
		g.setColor(c);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
		g.drawString("Lights Out", (this.getWidth()/2)-200, 200);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
		g.drawString("CLICK ABOVE TO PLAY", 40, 70);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 25));
		g.setColor(Color.BLACK);
		g.drawString("- Try to get the board to contian all the same Icons", 20, 300);
		g.drawString("- When a button is clicked it is toggled as well as.... ", 20, 350);
		g.drawString("..the buttons North, South, East and West of it", 20, 400);
		g.drawString("- Manual mode allows you just to toggle one switch", 20, 450);
		g.drawString("-Autoplay randomly solves the puzzle(this can take some time)", 20, 500);
		
		//change the value of x
		if( x< getWidth())
			x++;
		if( x > getWidth()-100)
			x=0;
		
		setBackground(Color.BLUE);
		repaint();
		
	}



}
