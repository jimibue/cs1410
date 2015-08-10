package part3;

import java.awt.image.BufferedImage;


/**
 * This class converts an image to a black and white image by averaging the rgb values of each pixel
 * @author James Yeates
 *
 */

public class BlackAndWhite extends ImageRegionFilter{

	@Override
	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
	
		if(getMinX()==0 &&getMinY()==0)
			setRegion(0, i.getWidth(), 0, i.getHeight());
		
		for(int y = 0; y<i.getHeight(); y++){
			for(int x =0; x<i.getWidth(); x++){
				
			    if(x <= getMaxX()&& x >= getMinX()&& y <= getMaxY() && y >= getMinY()){
				
			    	int pixel = i.getRGB(x, y);
			    	int red = (pixel>>16) & 0xff;
			    	int green = (pixel>>8) & 0xff;
			    	int blue = (pixel>>0) & 0xff;
				
			    	//find the averages to get effect
			    	int average = (red+green+blue)/3;
				
			    	red = average;
			    	green = average;
			    	blue = average;
				
			    	//set the pixel
			    	pixel = (red<<16) | (green<<8)| blue;
			    	result.setRGB(x, y, pixel);
			
					}
				else
					result.setRGB(x, y, i.getRGB(x, y));
			}
		}
			
		return result;
	}
	

}