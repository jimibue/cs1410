package assign10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * This class opens a window in which the user can select a filter and apply that filter to a photo
 * @author James Yeates
 *
 */
public class FilterWindow extends JFrame implements ActionListener{
	
	private JRadioButton redSwapGreen;
	private JRadioButton redSwapBlue;
	private JRadioButton greenSwapBlue;
	private JRadioButton blackAndWhite;
	private JRadioButton rotateClockWise;
	private JRadioButton rotateCounterClockWise;
	private JRadioButton gain;
	private JRadioButton bias;
	private JRadioButton blur;
	private JRadioButton gridFilter;
	private JRadioButton bitFilter;
	private JButton button;
	private BufferedImage image;
	ImageFilter f;

	private JPanel filterPanel;
	
	public FilterWindow(BufferedImage i){
		
		image = i;
		
		//create the Frame
		setLayout(new BorderLayout());
		setSize(300, 700);
		setTitle("Filter window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create the radio buttons
		redSwapGreen = new JRadioButton("Red-green swap",true);
		redSwapBlue = new JRadioButton("Red-blue swap");
		greenSwapBlue = new JRadioButton("Green-blue swap");
		blackAndWhite = new JRadioButton("Black and white");
		rotateClockWise = new JRadioButton("Rotate clockwise");
		rotateCounterClockWise = new JRadioButton("Rotate counter-clockwise");
		gain = new JRadioButton("Gain");
		bias = new JRadioButton("Bias");
		blur = new JRadioButton("Blur");
		gridFilter = new JRadioButton("Grid filter");
		bitFilter = new JRadioButton("Bit filter");
		
		
		
		//create the button group
		ButtonGroup group = new ButtonGroup();
		group.add(redSwapGreen);
		group.add(redSwapBlue);
		group.add(greenSwapBlue);
		group.add(blackAndWhite);
		group.add(rotateClockWise);
		group.add(rotateCounterClockWise);
		group.add(gain);
		group.add(bias);
		group.add(blur);
		group.add(gridFilter);
		group.add(bitFilter);
		
		
		///create the panel and add buttons to the panel
		filterPanel = new JPanel();
		filterPanel.setLayout(new GridLayout(12,1));
		filterPanel.add(redSwapGreen);
		filterPanel.add(redSwapBlue);
		filterPanel.add(greenSwapBlue);
		filterPanel.add(blackAndWhite);
		filterPanel.add(rotateClockWise);
		filterPanel.add(rotateCounterClockWise);
		filterPanel.add(gain);
		filterPanel.add(bias);
		filterPanel.add(blur);
		filterPanel.add(gridFilter);
		filterPanel.add(bitFilter);
		filterPanel.setBackground(Color.YELLOW);
		
		//create and add the button
		button = new JButton("Apply Filter");
		button.addActionListener(this);
		filterPanel.add(button, BorderLayout.SOUTH);
		
		//create a border
		filterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select one:"));
		
		add(filterPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		//check to see which radio button is selected and perform appropriate tasks
		
		if(redSwapGreen.isSelected()){
			f = new RedSwapGreen();
			savePicture(f, image);
			System.exit(0);
			
		}
			
		else if(redSwapBlue.isSelected()){
			f = new RedSwapBlue();
			savePicture(f, image);
			System.exit(0);
			
		}
		
		else if(greenSwapBlue.isSelected()){
			f = new GreenSwapBlue();
			savePicture(f, image);
			System.exit(0);
		
		}
		else if(blackAndWhite.isSelected()){
			
			f = new BlackAndWhite();
			savePicture(f, image);
			System.exit(0);
		}
		
		else if(rotateClockWise.isSelected()){
			f = new RotateClockwise();
			savePicture(f, image);
			System.exit(0);
			

		}
		else if(rotateCounterClockWise.isSelected()){
			f = new RotateCounterClockwise();
			savePicture(f, image);
			System.exit(0);
		}
			
		
		else if(gain.isSelected()){
			f = new GainFilter();
			savePicture(f, image);
			System.exit(0);
		}
		
		else if(bias.isSelected()){
			f = new BiasFilter();
			savePicture(f, image);
			System.exit(0);
		}
		
		else if(blur.isSelected()){
			f = new Blur();
			savePicture(f, image);
			System.exit(0);
		}
		
		else if(gridFilter.isSelected()){
			f = new GridFilter();
			savePicture(f, image);
			System.exit(0);
		}
		else if(bitFilter.isSelected()){
			f = new BitFilter();
			savePicture(f, image);
			System.exit(0);
		}
		
	}
	/**
	 * this static method takes creates a new image based off the filter that was selected and 
	 * and opens a JFileChooser for the user to save the new image.
	 * 
	 * @param f = the filter to be applied to the image
	 * @param image the image to be filtered and saved
	 */
	
	public static void savePicture(ImageFilter f,BufferedImage image){
		
		BufferedImage filteredImage;
		
		//create file chooser to save new image
		JFileChooser chooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("jpg","jpg");
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal =chooser.showSaveDialog(null);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			
			//get the file location
			String file = chooser.getSelectedFile().getAbsolutePath();
			//add a jpg extension/create new File
			file +=".jpg";
			File outputfile = new File(file);
			
			// Read the image file into a BufferedImage object.
			filteredImage = f.filter(image);
			try {
				
				ImageIO.write(filteredImage, "jpg", outputfile);
				
			}
			catch(Exception e1) {
				System.out.println(e1);
				System.exit(0);
			}
			
		}
		//user did not select to save. Exit Program
		else{
			JOptionPane closeMessgae = new JOptionPane();
			closeMessgae.showMessageDialog(null,"You did not selct a file to save.  Click ok to close program.");
			System.exit(0);
		}
	
		System.exit(0);
		
	}
		
	

}
