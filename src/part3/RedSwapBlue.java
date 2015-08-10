package part3;

import java.awt.image.BufferedImage;
/**
 * This class is filter that take an image and swaps the red and blue value of each 
 * pixel in the picture
 * @author James Yeates
 *
 */

public class RedSwapBlue extends ImageRegionFilter {

	@Override
	public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		//determine if a region has not been selected to filter the whole image
		if(getMinX()==0 &&getMinY()==0)
			setRegion(0, i.getWidth(), 0, i.getHeight());
		
		for(int y = 0; y<i.getHeight(); y++){
			for(int x =0; x<i.getWidth(); x++){
				
				if(x <= getMaxX()&& x >= getMinX()&& y <= getMaxY() && y >= getMinY()){
					//get rgb values
					int pixel = i.getRGB(x, y);
					int red = (pixel>>16) & 0xff;
					int green = (pixel>>8) & 0xff;
					int blue = (pixel>>0) & 0xff;
				
					//swap red and blue
					int temp = red;
					red = blue;
					blue = temp;
				
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