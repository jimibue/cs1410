package part3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This opens a window that allow the user to select a file, apply a filter and
 * see the result of the filter of the image before saving the file. Everything
 * occurs in one window.
 * 
 * @author James Yeates
 * 
 */

public class ImageProcessor extends JFrame implements ActionListener,
		ChangeListener {

	//private JMenuBar menuBar;
	//private JMenu fileMenu;
	private JMenu filterMenu;
	private JMenuItem openFile;
	private JMenuItem saveFile;
	private JMenuItem biasFilter;
	private JMenuItem bitFilter; 
	private JMenuItem bwFilter; 
	private JMenuItem blurFilter;
	private JMenuItem cropFilter;
	private JMenuItem gainFilter;
	private JMenuItem greenSwapBlueFilter;
	private JMenuItem gridFilter;
	private JMenuItem redSwapBlueFilter;
	private JMenuItem redSwapGreenFilter;
	private JMenuItem rotateCW;
	private JMenuItem rotateCCW;
	private JFrame theFrame;
	private BufferedImage currentImage;
	

	private JTabbedPane pane;
	private JSlider gainSlider, biasSlider, blurSlider;
	private ImagePanel theImgPanel;

	private JButton multiple;
	private JButton stepBack;
	private JButton stepFoward;
	private JButton orginal;
	
	private ArrayOfImages arrayOfImages ;
	private boolean cumaltiveOn = false;
	private int cumaltivewasturnedoffindex=0;

	public static void main(String[] args) {
		new ImageProcessor();
		//theFrame.setVisible(true);
	}

	// constructor
	public ImageProcessor() {
		
		arrayOfImages = new ArrayOfImages();
		
		theFrame = new JFrame();
		theFrame.setLayout(new BorderLayout());

		// /////////////////MENUS/////////////////////////////
		// create the menus
		JMenu fileMenu = new JMenu("File");
		filterMenu = new JMenu("Filter");
		filterMenu.setEnabled(false);

		// add menu items to fileMenu
		openFile = new IPMenuItem("Open File","Open a File", this, fileMenu);
		saveFile = new IPMenuItem("Save File","Save a File",this ,fileMenu);
		saveFile.setEnabled(false);
		
		// add menus to filterMeun
		biasFilter = new IPMenuItem("Bias","makes the picture lighter and darker by add/subtracting value from pixel",this , filterMenu);
		gainFilter = new IPMenuItem("Gain","makes the picture lighter and darker by mulitpling value from pixel", this, filterMenu);
		bwFilter = new IPMenuItem("Black and White", "creates a black and white image", this, filterMenu);
		blurFilter = new IPMenuItem("Blur", "Blurs the image", this, filterMenu);
		bitFilter = new IPMenuItem("Bit Redux","reduces the bit depth of the color", this, filterMenu);
		greenSwapBlueFilter = new IPMenuItem("Green Blue Swap", "Swaps all of the green pixel values of an image with the blue pixels", this, filterMenu);
		gridFilter = new IPMenuItem("Grid", "adds a grid to the image and distorts the color", this, filterMenu);
		redSwapBlueFilter = new IPMenuItem("Red Blue Swap", "Swaps all of the red pixel values of an image with the blue pixels", this, filterMenu );
		redSwapGreenFilter = new IPMenuItem("Red Green Swap", "Swaps all of the red pixel values of an image with the green pixels", this, filterMenu);
		rotateCW = new IPMenuItem("Rotate Clockwise", "rotates the image clockwise", this, filterMenu);
		rotateCCW = new IPMenuItem("Rotate Counter-Clockwise", "rotates the image counter-clockwise", this, filterMenu);
		cropFilter = new IPMenuItem("Crop", "Crops the image", this, filterMenu);
		
		// create the menuBar and add the menu's
		JMenuBar menuBar = new JMenuBar();
		menuBar.setVisible(true);
		menuBar.add(fileMenu);
		menuBar.add(filterMenu);

		theFrame.setJMenuBar(menuBar);

		// ////////////////////SLIDERS///////////////////////////
		// create the sliders...
		JPanel btmPanel = new JPanel();
		btmPanel.setLayout(new GridLayout(1, 3));
		gainSlider = new JSlider(1, 8);
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
		//gainSlider.setValue(5);
		gainSlider.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Gain",
				TitledBorder.CENTER, TitledBorder.TOP));

		// bias slider
		biasSlider = new JSlider(-200, 200, 0);
		biasSlider.addChangeListener(this);
		biasSlider.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Bias",
				TitledBorder.CENTER, TitledBorder.TOP));
		biasSlider.setEnabled(true);
		//biasSlider.setValue(50);
		biasSlider.setMajorTickSpacing(50);
		biasSlider.setMinorTickSpacing(25);
		biasSlider.setVisible(true);
		biasSlider.setPaintLabels(true);
		biasSlider.setPaintTicks(true);
		

		// blur slider
		blurSlider = new JSlider(3, 7, 3);
		blurSlider.addChangeListener(this);
		blurSlider.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Blur",
				TitledBorder.CENTER, TitledBorder.TOP));
		blurSlider.setEnabled(false);
		blurSlider.setMajorTickSpacing(2);
		blurSlider.setSnapToTicks(true);
		blurSlider.setVisible(true);
		blurSlider.setPaintLabels(true);
		blurSlider.setPaintTicks(true);
		blurSlider.setToolTipText("Select a value the higher.  The higher the value the more pronounced the effect is.");

		// add the sliders to the bottom of the frame
		btmPanel.setLayout(new GridLayout(1, 3));
		btmPanel.add(gainSlider);
		btmPanel.add(biasSlider);
		btmPanel.add(blurSlider);
		
		
		
		//buttons
		stepBack = new JButton("Step back");
		stepFoward = new JButton("Step foward");
		multiple = new JButton("Cumulative - OFF");
		orginal = new JButton("Orginal/reset all");
		orginal.setEnabled(false);
		stepFoward.addActionListener(this);
		stepBack.setEnabled(false);
		stepFoward.setEnabled(false);
		stepBack.addActionListener(this);
		orginal.addActionListener(this);
		multiple.addActionListener(this);
		
		
		//top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3));
		topPanel.add(stepBack);
		topPanel.add(stepFoward);
		topPanel.add(multiple);
		topPanel.add(orginal);

		// create and customize the JFrame
		theFrame.setSize(1000, 800);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setVisible(true);
		theFrame.add(btmPanel, BorderLayout.SOUTH);
		theFrame.add(topPanel, BorderLayout.NORTH);
	
	}//End of Constructor

	/**
	 * this uses a JFile chooser to get an gif, jpg, bmp, tiff, or png file.
	 * 
	 * @return a BufferedImage
	 */

	public BufferedImage getImage() {
		
		// create the file chooser
		JFileChooser imageChooser = new JFileChooser();

		// FileNameFilter allows only options with the appropriate extensions
		FileFilter filter = new FileNameFilter();
		imageChooser.setFileFilter(filter);
		int returnVal = imageChooser.showOpenDialog(null);

		BufferedImage origImage = null;
		// check to see if user selected a file,
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			String file = imageChooser.getSelectedFile().getAbsolutePath();
			// Read the image file into a BufferedImage object.

			try {
				origImage = ImageIO.read(new File(file));
				arrayOfImages.clear();
				orginal.setEnabled(false);
				arrayOfImages.setCurrentPostion(0);
				arrayOfImages.add(origImage);
				
				return origImage;
				
			} catch (Exception e) {
				System.out.println(e);
				System.exit(0);
			}

		}

		return null;
	}

	
	//Listen for menu items
	public void actionPerformed(ActionEvent e) {
		BufferedImage img;
		biasSlider.setEnabled(false);
		gainSlider.setEnabled(false);
		blurSlider.setEnabled(false);
		if(e.getSource()== multiple){
			if(!cumaltiveOn){
			cumaltiveOn = true;
			
			multiple.setText("Cumulative - ON");
			}
			else{
				cumaltiveOn = false;
				cumaltivewasturnedoffindex = arrayOfImages.getCurrentPostion();
				multiple.setText("Cumulative - OFF");
			}
		}
		else if (e.getSource() == openFile) {
			img = getImage();
			if (img != null)
				loadImage(img);
		}
		else if (e.getSource()==orginal){
			
			orginal.setEnabled(false);
			BufferedImage imag = arrayOfImages.get(0);
			arrayOfImages.clear();
			arrayOfImages.setCurrentPostion(0);
			currentImage = imag;
		
			arrayOfImages.add(imag);
			theImgPanel = new ImagePanel(arrayOfImages.get(0));
			
			pane.setComponentAt(0,theImgPanel);
		
			cumaltivewasturnedoffindex=0; 
			
			
		}

		else if (e.getSource() == biasFilter) {
			biasSlider.setValue(50);
			biasSlider.setEnabled(true);
			
			ImageRegionFilter f = new BiasFilter();
		//	if(f.getMaxX()==0 && f.getMaxY()==0)
			//	checkStatus(f);
		}
		else if (e.getSource() == bwFilter){
			ImageRegionFilter  f= new BlackAndWhite();
			checkStatus(f);
			
		}
		
		else if (e.getSource() == bitFilter) {
			ImageRegionFilter  f = new BitFilter();
			checkStatus(f);
		}
		else if (e.getSource() == blurFilter) {
			blurSlider.setValue(1);
			blurSlider.setEnabled(true);
//			ImageRegionFilter  f = new BlurFilter();
//			checkStatus(f);
		} 
		else if (e.getSource() == cropFilter) {
			ImageRegionFilter  f= new CropFilter();
			checkStatus(f);
		
		}
			
		else if (e.getSource() == gainFilter) {
			gainSlider.setValue(5);
			gainSlider.setEnabled(true);
//			ImageRegionFilter  f = new GainFilter();
//			checkStatus(f);
		}
		else if (e.getSource() == gridFilter) {
			ImageRegionFilter  f = new GridFilter();
			checkStatus(f);
		}
		
		
		else if (e.getSource() == greenSwapBlueFilter) {
			ImageRegionFilter  f = new GreenSwapBlue();
			checkStatus(f);
		}
			
		 
		else if (e.getSource() == redSwapBlueFilter) {
			ImageRegionFilter  f = new RedSwapBlue();
			checkStatus(f);
		}
		
		
		else if (e.getSource() == redSwapGreenFilter) {
			
			ImageRegionFilter  f = new RedSwapGreen();
			checkStatus(f);
		}
		
		else if (e.getSource() == rotateCW) {
			ImageRegionFilter  f = new RotateClockwise();
			checkStatus(f);
		}
		else if (e.getSource() == rotateCCW) {
			ImageRegionFilter  f = new RotateCounterClockwise();
			checkStatus(f);
		}
			
		else if (e.getSource() == saveFile) 
			savePicture(arrayOfImages.get(arrayOfImages.getCurrentPostion()));
		
		else if ( e.getSource()==stepBack){
			arrayOfImages.decrementCurrentPostion();
			
			
		
			theImgPanel = new ImagePanel(arrayOfImages.get(arrayOfImages.getCurrentPostion()));
			pane.setComponentAt(0,theImgPanel);
			
			
		}
		else if ( e.getSource()==stepFoward){
	
			arrayOfImages.increamentCurrentPostion();
			theImgPanel = new ImagePanel(arrayOfImages.get(arrayOfImages.getCurrentPostion()));
			pane.setComponentAt(0,theImgPanel);
			
		}
		if(!arrayOfImages.checkFowardStepEnabled())
			stepFoward.setEnabled(false);
		else{
			stepFoward.setEnabled(true);
		}
		if(!arrayOfImages.checkBackStepEnabled())
			stepBack.setEnabled(false);
		else{
			stepBack.setEnabled(true);
		}
		
		if(arrayOfImages.getCurrentPostion()==0){
			orginal.setEnabled(false);
		}
		else
			orginal.setEnabled(true);
		
		System.out.println("---from action performed____");
		System.out.println("arrayOfImages.size() "+  arrayOfImages.size());
		System.out.println("arrayOfImages.getCurrentPostion() " + arrayOfImages.getCurrentPostion());
		System.out.println(cumaltivewasturnedoffindex+ " cumaltivewasturnedofindex");
		System.out.println("---____");
		System.out.println("---____");
	}
		
	/**
	 * this method adds a tabbed pane on the frame with the image chosen by the
	 * user
	 * 
	 * @param img
	 */
	public void loadImage(BufferedImage img) {
		
		currentImage = img;
		// if a image has has yet to be selected create a new JTabbedPane
		if (pane == null)
			pane = new JTabbedPane();
		// pane has already been created remove all tabs from the pane so the
		// new image can be added
		else
			pane.removeAll();
			
			

		// add image and pane the JFrame
		theImgPanel = new ImagePanel(img);
		pane.add("Original image", theImgPanel);
		//pane.add("Original image", new ImagePanel(img));

		theFrame.add(pane, BorderLayout.CENTER);
		theFrame.pack();
		theFrame.setSize(1000, 800);
		theFrame.setVisible(true);
		filterMenu.setEnabled(true);

	}

	public void savePicture(BufferedImage image) {

		// create file chooser to save new image
		JFileChooser chooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("jpg", "jpg");
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			// get the file location
			String file = chooser.getSelectedFile().getAbsolutePath();
			// add a jpg extension/create new File
			file += ".jpg";
			File outputfile = new File(file);

			// Read the image file into a BufferedImage object.

			try {

				ImageIO.write(image, "jpg", outputfile);

			} catch (Exception e1) {
				System.out.println(e1);
				System.exit(0);
			}
		}
		stepBack.setEnabled(false);
		arrayOfImages.setCurrentPostion(0);
		arrayOfImages.clear();
	}

	/**
	 * this helper method adds and remove filtered images to the pane as needed
	 * 
	 * @param i
	 */
	public void createFilteredImage(ImageRegionFilter i) {
		
		if ( !cumaltiveOn){
			currentImage = arrayOfImages.get(cumaltivewasturnedoffindex);
			currentImage = i.filter(currentImage);
			}
		else{
		// create and add filtered image
	    currentImage =arrayOfImages.get(arrayOfImages.getCurrentPostion());
		currentImage = i.filter(currentImage);
		
		}
		arrayOfImages.add(currentImage);
		theImgPanel = new ImagePanel(currentImage);
		arrayOfImages.increamentCurrentPostion();
		pane.setComponentAt(0, theImgPanel);
		saveFile.setEnabled(true);
//		System.out.println("arrayOfImages.size() "+  arrayOfImages.size());
//		System.out.println("arrayOfImages.getCurrentPostion() " + arrayOfImages.getCurrentPostion());
		
	}

	@Override
	//Listen for Sliders and perform desired operations
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider) e.getSource();

		if (e.getSource() == gainSlider) {
			if (!src.getValueIsAdjusting()) {
				int val = (int) src.getValue();
				GainFilter.setGainFactor(val * 0.25);
				ImageRegionFilter f= new GainFilter();
				checkStatus(f);

			}
		} 
		else if (e.getSource() == biasSlider) {
			if (!src.getValueIsAdjusting()) {
				int val = (int) src.getValue();
				BiasFilter.setBiasAmount(val);
				ImageRegionFilter f= new BiasFilter();
				checkStatus(f);

			}
		} 
		else if (e.getSource() == blurSlider) {
			
			if (!src.getValueIsAdjusting()) {
				int val = (int) src.getValue();
				BlurFilter.setBlurAmount(val);
				ImageRegionFilter f= new BlurFilter();
				checkStatus(f);
			}
		}
		
		System.out.println("---from slider performed____");
		System.out.println("arrayOfImages.size() "+  arrayOfImages.size());
		System.out.println("arrayOfImages.getCurrentPostion() " + arrayOfImages.getCurrentPostion());
		System.out.println(cumaltivewasturnedoffindex+ " cumaltivewasturnedofindex");
		System.out.println("---____");

	}
	public void checkStatus(ImageRegionFilter f){

		f.setRegion(theImgPanel.getSelectedRegion());
		createFilteredImage(f);
		
		
		
	}

	

}
