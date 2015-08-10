package assign12a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/** 
 * A JPanel for displaying a BufferedImage.
 *
 * @author Erin Parker
 */
public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener {
	
	private BufferedImage image;
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	
	public ImagePanel(BufferedImage img) {
		image = img;
		setPreferredSize(new Dimension(img.getHeight(), image.getWidth()));
		image.getGraphics().drawImage(image, 0, 0, this);   // More on this later in the week.
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		g.setColor(new Color(105, 105, 105, 125));
		if(maxX>minX && maxY > minY)
			g.fillRect(minX, minY, maxX - minX, maxY - minY);
		else if(maxX>minX && maxY < minY)
			g.fillRect(minX, maxY, maxX - minX,  minY- maxY);
		else if(maxX< minX && maxY < minY)
			g.fillRect(maxX, maxY, minX - maxX,  minY- maxY);
		else if(maxX< minX && maxY > minY)
			g.fillRect(maxX, minY, minX - maxX,  maxY-minY);
	}
	
	public Region2d getSelectedRegion() {
		if(minX > maxX){
			int temp = minX;
			minX = maxX;
			maxX = temp;
		}
		if(minY > maxY){
			int temp = minY;
			minY = maxY;
			maxY = temp;
		}
		return new Region2d(minX, maxX, minY, maxY);
	}
	public Region2d resetXY(){
		return new Region2d(0,0,0,0);
		
	}
	
	// More on this later in the week.
//	public void paint(Graphics g) {
//		g.drawImage(image, 0, 0, this);
//		g.setColor(new Color(105, 105, 105, 125));
//		g.fillRect(minX, minY, maxX - minX, maxY - minY);
//	}

	@Override
	public void mouseDragged(MouseEvent e) {
		maxX = e.getX();
		maxY = e.getY();
		//System.out.println(maxX +" "+ maxY);
		
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		minX = e.getX();
		minY = e.getY();
		
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}