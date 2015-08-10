package assign12a;

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

	private JMenuItem bwFilter; 

	private JFrame theFrame;
	private BufferedImage currentImage;
	//private BufferedImage filteredImage;

	private JTabbedPane pane;
	private JSlider gainSlider, biasSlider, blurSlider;
	private ImagePanel theImgPanel;
	//private ImagePanel theImgPanel;
	
	private JButton multiple;
	private JButton stepBack;
	private JButton stepFoward;
	private JButton orginal;
	private boolean cumaltiveOn = false;
	private ArrayOfImages arrayOfImages ;
	

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

		bwFilter = new IPMenuItem("Black and White", "creates a black and white image", this, filterMenu);
		
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
	

		// bias slider
		biasSlider = new JSlider(-200, 200, 0);


		// blur slider
		blurSlider = new JSlider(3, 7, 3);
		

		// add the sliders to the bottom of the frame
		btmPanel.setLayout(new GridLayout(1, 3));
		btmPanel.add(gainSlider);
		btmPanel.add(biasSlider);
		btmPanel.add(blurSlider);
		
		//buttons
		stepBack = new JButton("Step back");
		stepFoward = new JButton("Step foward");
		multiple = new JButton("Cumulative - OFF");
		orginal = new JButton("cf Orginal");
		stepFoward.addActionListener(this);
		stepBack.setEnabled(false);
		stepFoward.setEnabled(false);
		stepBack.addActionListener(this);
		orginal.addActionListener(this);
		multiple.addActionListener(this);
		
		
		//top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 4));
		topPanel.add(stepBack);
		topPanel.add(multiple);
		topPanel.add(stepFoward);
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
		stepBack.setEnabled(false);
		arrayOfImages.setCurrentPostion(0);
		arrayOfImages.clear();
		
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
				arrayOfImages.add(origImage);
				//arrayOfImages.increamentCurrentPostion();
				System.out.println(arrayOfImages.size());
				System.out.println(arrayOfImages.getCurrentPostion());
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
			
				multiple.setText("Cumulative - OFF");
				//cumaltivewasturnedoffindex=arrayOfImages.getCurrentPostion();
				}
		}
		if (e.getSource() == openFile) {
			img = getImage();
			if (img != null)
				loadImage(img);
		}


		else if (e.getSource() == bwFilter){
			ImageRegionFilter  f= new BlackAndWhite();
			checkStatus(f);
			f.setRegion(0, 0,0, 0);
			System.out.println(f.getMaxX());

		}
		else if (e.getSource()==orginal){
			theImgPanel = new ImagePanel(arrayOfImages.get(0));
			pane.setComponentAt(0,theImgPanel);
			System.out.println("og");
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
		theImgPanel = new ImagePanel(arrayOfImages.get(0));
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
			currentImage = arrayOfImages.get((cumaltivewasturnedoffindex));
			currentImage = i.filter(currentImage);
			
		
		}
		else{
		// create and add filtered image
		currentImage = i.filter(currentImage);
		
		}
		arrayOfImages.add(currentImage);
		theImgPanel = new ImagePanel(currentImage);
		arrayOfImages.increamentCurrentPostion();
		pane.setComponentAt(0, theImgPanel);
		saveFile.setEnabled(true);
		System.out.println("arrayOfImages.size() "+  arrayOfImages.size());
		System.out.println("arrayOfImages.getCurrentPostion() " + arrayOfImages.getCurrentPostion());
	}


	public void checkStatus(ImageRegionFilter f){

		f.setRegion(theImgPanel.getSelectedRegion());
		createFilteredImage(f);
		
		
	}
	
	
	@Override
	//Listen for Sliders and perform desired operations
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider) e.getSource();


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public JMenu getFilterMenu() {
		return filterMenu;
	}

	public void setFilterMenu(JMenu filterMenu) {
		this.filterMenu = filterMenu;
	}

	public JMenuItem getOpenFile() {
		return openFile;
	}

	public void setOpenFile(JMenuItem openFile) {
		this.openFile = openFile;
	}

	public JMenuItem getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(JMenuItem saveFile) {
		this.saveFile = saveFile;
	}

	public JMenuItem getBwFilter() {
		return bwFilter;
	}

	public void setBwFilter(JMenuItem bwFilter) {
		this.bwFilter = bwFilter;
	}

	public JFrame getTheFrame() {
		return theFrame;
	}

	public void setTheFrame(JFrame theFrame) {
		this.theFrame = theFrame;
	}

	public BufferedImage getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(BufferedImage currentImage) {
		this.currentImage = currentImage;
	}

	public JTabbedPane getPane() {
		return pane;
	}

	public void setPane(JTabbedPane pane) {
		this.pane = pane;
	}

	public JSlider getGainSlider() {
		return gainSlider;
	}

	public void setGainSlider(JSlider gainSlider) {
		this.gainSlider = gainSlider;
	}

	public JSlider getBiasSlider() {
		return biasSlider;
	}

	public void setBiasSlider(JSlider biasSlider) {
		this.biasSlider = biasSlider;
	}

	public JSlider getBlurSlider() {
		return blurSlider;
	}

	public void setBlurSlider(JSlider blurSlider) {
		this.blurSlider = blurSlider;
	}

	public ImagePanel getTheImgPanel() {
		return theImgPanel;
	}

	public void setTheImgPanel(ImagePanel theImgPanel) {
		this.theImgPanel = theImgPanel;
	}

	public JButton getMultiple() {
		return multiple;
	}

	public void setMultiple(JButton multiple) {
		this.multiple = multiple;
	}

	public JButton getStepBack() {
		return stepBack;
	}

	public void setStepBack(JButton stepBack) {
		this.stepBack = stepBack;
	}

	public JButton getStepFoward() {
		return stepFoward;
	}

	public void setStepFoward(JButton stepFoward) {
		this.stepFoward = stepFoward;
	}

	public JButton getOrginal() {
		return orginal;
	}

	public void setOrginal(JButton orginal) {
		this.orginal = orginal;
	}

	public boolean isCumaltiveOn() {
		return cumaltiveOn;
	}

	public void setCumaltiveOn(boolean cumaltiveOn) {
		this.cumaltiveOn = cumaltiveOn;
	}

	public ArrayList<BufferedImage> getArrayOfImages() {
		return arrayOfImages;
	}





	public int getCumaltivewasturnedoffindex() {
		return cumaltivewasturnedoffindex;
	}

	public void setCumaltivewasturnedoffindex(int cumaltivewasturnedoffindex) {
		this.cumaltivewasturnedoffindex = cumaltivewasturnedoffindex;
	}

}
