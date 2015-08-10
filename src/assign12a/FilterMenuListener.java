package assign12a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class FilterMenuListener extends JMenuItem implements ActionListener {
	
	private JMenuItem bwFilter; 
	ImageProcessor ip ;
	
	public FilterMenuListener(){
		ip = new ImageProcessor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void checkStatus(ImageRegionFilter f){
//		if(!multipleFX){
//			f.setRegion(orginalImagePanel.getSelectedRegion());
//			
//		}
		f.setRegion(ip.getTheImgPanel().getSelectedRegion());
		//createFilteredImage(f);
		//f.setRegion(0, 0, 0, 0);
		//orginalImagePanel.resetXY();
		
	}
//	public void createFilteredImage(ImageRegionFilter i) {
//		
//
//
//		if ( !ip.getcu){
//			currentImage = arrayOfImages.get(0);
//			currentImage = i.filter(currentImage);
//		
//		}
//		else{
//		// create and add filtered image
//		currentImage = i.filter(currentImage);
//		arrayOfImages.add(currentImage);
//		}
//		
//		theImgPanel = new ImagePanel(currentImage);
//		imageCount++;
//		pane.setComponentAt(0, theImgPanel);
//		//pane.setSelectedIndex(1);
//		
//		//i.setRegion(0, 0, 0, 0);
//		saveFile.setEnabled(true);
//
//	}

}
