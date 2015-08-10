package assign11;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/** 
 * A JPanel for displaying a BufferedImage.
 *
 * @author Erin Parker
 */
public class ImagePanel extends JPanel {
	
	private BufferedImage image;
	
	public ImagePanel(BufferedImage img) {
		image = img;
		setPreferredSize(new Dimension(img.getHeight(), image.getWidth()));
		image.getGraphics().drawImage(image, 0, 0, this);   // More on this later in the week.
	}
	
	// More on this later in the week.
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}