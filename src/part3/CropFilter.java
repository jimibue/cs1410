package part3;

import java.awt.image.BufferedImage;
/**
 * takes a region of an image and crops the region to create a new BufferedImage.
 * @author James Yeates
 *
 */

public class CropFilter extends ImageRegionFilter{
	

	@Override
	public BufferedImage filter(BufferedImage img) {
		
		if(getMaxX() >= img.getWidth() || getMaxY() >=img.getHeight()){
			System.out.println("worked");
			return img;
		}
		
		//if user did not select a region just return the img
		if(getMaxX()-getMinX()==0 &&getMaxY()- getMinY()==0)
			return img;
		//get the region and perform the crop
		else{
	
//			if(getMinX()<0)
//				setMinX(1);
//			if(getMinY()<0)
//				setMinY(1);
			System.out.println(getMinY());
		
			BufferedImage result = new BufferedImage(Math.abs(getMaxX()-getMinX()),Math.abs(getMaxY()- getMinY()), BufferedImage.TYPE_INT_RGB);
		
		for(int y = getMinY(),  y1 = 0;y < getMaxY(); y++, y1++){
			 
			for ( int x = getMinX(), x1 = 0; x < getMaxX(); x++, x1++){
				int pixel = img.getRGB(x, y);
				result.setRGB(x1, y1, pixel);
				
				}
			}
		
		return result;
		}
	}
	
	

}
