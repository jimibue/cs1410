package assign10;


import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;


/**
 * Opens a JFile chooser for user to choose a image.  Once image is chosen a new GUI 
 * from the FilterWindow class will open and finish the image processing and saving
 * the file
 * @author James Yeates
 *
 */

public class ImageProcessor {
	
	public static void main(String[] args) {
		
		//create the file chooser
		JFileChooser imageChooser = new JFileChooser();
		
		//FileNameFilter allows only options with the appropriate extensions  
		FileFilter filter = new FileNameFilter( );
		imageChooser.setFileFilter(filter);
		int returnVal = imageChooser.showOpenDialog(null);
		
		BufferedImage origImage = null;
		// check to see if user selected a file,
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		
			String file = imageChooser.getSelectedFile().getAbsolutePath();
			// Read the image file into a BufferedImage object.
			
			try {
				origImage = ImageIO.read(new File(file));
			}
			catch(Exception e) {
				System.out.println(e);
				System.exit(0);
			}
			
		}
		//user did not select an image. Exit Program
		else{
			JOptionPane closeMessgae = new JOptionPane();
			closeMessgae.showMessageDialog(null,"You did not selct a file.  Click ok to close program.");
			System.exit(0);
		}
		FilterWindow win = new FilterWindow(origImage);
			

	}

}
