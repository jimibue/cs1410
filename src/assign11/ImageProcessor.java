package assign11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;




/**
 * This opens a window that allow the user to select a file, apply a filter and see the result of the filter of the image before 
 * saving the file.  Everything occurs in one window.
 * @author James Yeates
 *
 */

public class ImageProcessor extends JFrame implements ActionListener, ChangeListener{
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private static JMenu filterMenu;
	private JMenuItem openFile;
	private static JMenuItem saveFile;
	private JMenuItem biasFilter, bitFilter, bwFilter, blurFilter, gainFilter, greenSwapBlueFilter,
						gridFilter, redSwapBlueFilter, redSwapGreenFilter, rotateCW,rotateCCW;
	private static JFrame theFrame;
	private static BufferedImage currentImage;
	private static BufferedImage filteredImage;
	private ImageFilter imageFilter;
	private static JTabbedPane pane;
	private static JSlider gainSlider, biasSlider, blurSlider;
	
	public static void main(String[] args) {
		new ImageProcessor();
		theFrame.setVisible(true);
	}
	
	//constructor
	public ImageProcessor(){
		theFrame = new JFrame();
		theFrame.setLayout(new BorderLayout());
		
		///////////////////MENUS/////////////////////////////
		//create the menus
		fileMenu = new JMenu("File");
		filterMenu =new JMenu("Filter");
		filterMenu.setEnabled(false);
		
		//add menu items for fileMenu
		openFile = new JMenuItem("Open File");
		openFile.addActionListener(this);
		saveFile = new JMenuItem("Save File");
		saveFile.addActionListener(this);
		saveFile.setEnabled(false);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		
	
		//add menus for filter
		biasFilter = new JMenuItem("Bias");
		biasFilter.addActionListener(this);
		biasFilter.setToolTipText("makes the picture lighter and darker by add/subtracting value from pixel");
		filterMenu.add(biasFilter);
		
		gainFilter = new JMenuItem("Gain");
		gainFilter.addActionListener(this);
		gainFilter.setToolTipText("makes the picture lighter and darker by mulitpling value from pixel");
		filterMenu.add(gainFilter);
		
		bwFilter = new JMenuItem("Black and White");
		bwFilter.addActionListener(this);
		bwFilter.setToolTipText("creates a black and white image");
		filterMenu.add(bwFilter);
		
		blurFilter = new JMenuItem("Blur");
		blurFilter.addActionListener(this);
		blurFilter.setToolTipText("Blurs the image");
		filterMenu.add(blurFilter);
		
		bitFilter = new JMenuItem("Bit Redux");
		bitFilter.addActionListener(this);
		bitFilter.setToolTipText("reduces the bit depth of the color");
		filterMenu.add(bitFilter);
		
		greenSwapBlueFilter = new JMenuItem("Green Blue Swap");
		greenSwapBlueFilter.addActionListener(this);
		greenSwapBlueFilter.setToolTipText("Swaps all of the green pixel values of an image with the blue pixels");
		filterMenu.add(greenSwapBlueFilter);
		
		gridFilter = new JMenuItem("Grid");
		gridFilter.addActionListener(this);
		gridFilter.setToolTipText("adds a grid to the image and distorts the color");
		filterMenu.add(gridFilter);
		
		redSwapBlueFilter = new JMenuItem("Red Blue Swap");
		redSwapBlueFilter.addActionListener(this);
		redSwapBlueFilter.setToolTipText("Swaps all of the red pixel values of an image with the blue pixels");
		filterMenu.add(redSwapBlueFilter);
		
		redSwapGreenFilter = new JMenuItem("Red Green Swap");
		redSwapGreenFilter.addActionListener(this);
		redSwapGreenFilter.setToolTipText("Swaps all of the red pixel values of an image with the green pixels");
		filterMenu.add(redSwapGreenFilter);
		
		rotateCW = new JMenuItem("Rotate Clockwise");
		rotateCW.addActionListener(this);
		rotateCW.setToolTipText("rotates the image clockwise");
		filterMenu.add(rotateCW);
		
		rotateCCW = new JMenuItem("Rotate Counter-Clockwise");
		rotateCCW.addActionListener(this);
		rotateCCW.setToolTipText("rotates the image counter-clockwise");
		filterMenu.add(rotateCCW);
		
		//create the menuBar and add the menu's
		menuBar = new JMenuBar();
		menuBar.setVisible(true);
		menuBar.add(fileMenu);
		menuBar.add(filterMenu);
		
		theFrame.setJMenuBar(menuBar);
		
		//////////////////////SLIDERS///////////////////////////
		//create the sliders...
		JPanel btmPanel = new JPanel();
		btmPanel.setLayout(new GridLayout(1,3));
		gainSlider = new JSlider(1,8);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(1, new JLabel("0.25"));
		labelTable.put(2, new JLabel("0.5"));
		labelTable.put(3, new JLabel("0.75"));
		labelTable.put(4, new JLabel("org"));
		labelTable.put(5, new JLabel("1.25"));
		labelTable.put(6, new JLabel("1.5"));
		labelTable.put(7, new JLabel("1.75"));
		labelTable.put(8, new JLabel("2.0"));
		gainSlider.setLabelTable(labelTable);
		gainSlider.addChangeListener(this);
		gainSlider.setVisible(true);
		gainSlider.setPaintLabels(true);
		gainSlider.setMajorTickSpacing(1);
		gainSlider.setSnapToTicks(true);
		gainSlider.setPaintTicks(true);
		gainSlider.setEnabled(false);
		gainSlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Gain",TitledBorder.CENTER,TitledBorder.TOP));
		
		//bias slider
		biasSlider = new JSlider(-200,200, 0);
		biasSlider.addChangeListener(this);
		biasSlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Bias",TitledBorder.CENTER,TitledBorder.TOP));
		biasSlider.setEnabled(false);
		biasSlider.setMajorTickSpacing(50);
		biasSlider.setMinorTickSpacing(25);
		biasSlider.setVisible(true);
		biasSlider.setPaintLabels(true);
		biasSlider.setPaintTicks(true);
		
		//blur slider
		blurSlider = new JSlider(3,9,3);
		blurSlider.addChangeListener(this);
		blurSlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Blur",TitledBorder.CENTER,TitledBorder.TOP));
		blurSlider.setEnabled(false);
		blurSlider.setMajorTickSpacing(2);
		blurSlider.setSnapToTicks(true);
		blurSlider.setVisible(true);
		blurSlider.setPaintLabels(true);
		blurSlider.setPaintTicks(true);
		blurSlider.setToolTipText("Select a value the higher.  The higher the value the more pronounced the effect is.");
		
		//add the sliders to the bottom of the frame
		btmPanel.setLayout(new GridLayout(1,3));
		btmPanel.add(gainSlider);
		btmPanel.add(biasSlider);
		btmPanel.add(blurSlider);
		
		//create and customize the JFrame
		theFrame.setSize(1000, 800);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setVisible(true);
		theFrame.add(btmPanel,BorderLayout.SOUTH);
	}
	
	/**
	 * this uses a JFile chooser to get an gif, jpg, bmp, tiff, or png  file.
	 * @return a BufferedImage
	 */
	
	public static BufferedImage getImage(){
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
				return origImage;
			}
			catch(Exception e) {
				System.out.println(e);
				System.exit(0);
			}
			
		}
		//user did not select an image. Exit Program
//		else{
//			JOptionPane closeMessgae = new JOptionPane();
//			closeMessgae.showMessageDialog(null,"You did not selct a file.  Click ok to close program.");
//			System.exit(0);
//		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		biasSlider.setEnabled(false);
		gainSlider.setEnabled(false);
		blurSlider.setEnabled(false);
		if(e.getSource() == openFile){
			BufferedImage img =getImage();
			if(img!=null)
				loadImage(img);
			
			System.out.println("done");
		}
		//if else here////////////////////////////////////////////////////////
		if(e.getSource()==biasFilter){
			imageFilter = new BiasFilter();
			createFilteredImage(imageFilter);
			biasSlider.setEnabled(true);
		}
		else if(e.getSource()==bwFilter){
			imageFilter = new BlackAndWhite();
			createFilteredImage(imageFilter);
		}
		else if(e.getSource()==bitFilter){
			imageFilter = new BitFilter();
			createFilteredImage(imageFilter);
		}
		else if(e.getSource()==blurFilter){
			blurSlider.setEnabled(true);
			imageFilter = new BlurFilter();
			createFilteredImage(imageFilter);
			
		}
		else if(e.getSource()==gainFilter){
			createFilteredImage(new GainFilter());
			gainSlider.setEnabled(true);
		}
		
		else if(e.getSource()==gridFilter){
			createFilteredImage(new GridFilter());
			
		}
		
		else if(e.getSource()==greenSwapBlueFilter){
			imageFilter = new GreenSwapBlue();
			createFilteredImage(imageFilter);
		}
		else if(e.getSource()==redSwapBlueFilter){
			imageFilter = new RedSwapBlue();
			createFilteredImage(imageFilter);
		}
		else if(e.getSource()==redSwapGreenFilter){
			imageFilter = new RedSwapGreen();
			createFilteredImage(imageFilter);
		}
		
		else if(e.getSource()==rotateCW){
			imageFilter = new RotateClockwise();
			createFilteredImage(imageFilter);
		}
		
		else if(e.getSource()==rotateCCW){
			imageFilter = new RotateCounterClockwise();
			createFilteredImage(imageFilter);
		}
		else if(e.getSource()==saveFile){
			savePicture(filteredImage);
		}
		
	}
	/**
	 * this method adds a tabbed pane on the frame with the image chosen by the user
	 * @param img
	 */
	public static void loadImage(BufferedImage img){
		gainSlider.setEnabled(false);
		currentImage = img;
		//if a image has  has yet to be selected create a new JTabbedPane
		if(pane==null)
			pane = new JTabbedPane();
		//pane has already been created remove all tabs from the pane so the new image can be added
		else		
			pane.removeAll();
		
		//add image and pane the JFrame
		pane.add("Original image", new ImagePanel(img));
	
		theFrame.add(pane,BorderLayout.CENTER);
		//theFrame.pack();
		filterMenu.setEnabled(true);
			
		
	}
	public static void savePicture( BufferedImage image){
		
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
			
			try {
				
				ImageIO.write(image, "jpg", outputfile);
				
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
	
		//System.exit(0);
		
	}
	/**
	 * this helper method adds and remove filtered images to the pane as needed
	 * @param i
	 */
	public static void createFilteredImage(ImageFilter i){
		
		if(pane.getTabCount()==2)
			pane.remove(1);
		
		//create and add filtered image	
		filteredImage = i.filter(currentImage);
		pane.add("Filtered image", new ImagePanel(filteredImage));
		pane.setSelectedIndex(1);
		
		saveFile.setEnabled(true);
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		  JSlider src = (JSlider)e.getSource();
		  
		  if(e.getSource()== gainSlider){
			  if(!src.getValueIsAdjusting()) {
				  int val = (int)src.getValue();
				  GainFilter.setGainFactor(val * 0.25);
				  createFilteredImage(new GainFilter());
				 
			  }
		  }	
		  else if(e.getSource()== biasSlider){
			  if(!src.getValueIsAdjusting()) {
				  int val = (int)src.getValue();
				  BiasFilter.setBiasAmount(val);
				  createFilteredImage(new BiasFilter());
				 
			  }
		  }	
		  else if(e.getSource()== blurSlider){
			  if(!src.getValueIsAdjusting()) {
				  int val = (int)src.getValue();
				  BlurFilter.setBlurAmount(val);
				  createFilteredImage(new BlurFilter());
			  	}
		  }	
			  
		
	}


}
