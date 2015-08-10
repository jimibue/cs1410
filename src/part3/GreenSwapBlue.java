package part3;

import java.awt.image.BufferedImage;

/**
 * This class is a filter that swaps the green and blue pixels
 * @author James Yeates
 *
 */

public class GreenSwapBlue extends ImageRegionFilter {

	@Override
	public BufferedImage filter(BufferedImage img) {
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		//determine if a region has not been selected to filter the whole image
		if(getMinX()==0 &&getMinY()==0)
			setRegion(0, img.getWidth(), 0, img.getHeight());
		
		for(int y = 0; y<img.getHeight(); y++){
			for(int x =0; x<img.getWidth(); x++){
				
				if(x <= getMaxX()&& x >= getMinX()&& y <= getMaxY() && y >= getMinY()){
					//get rgb values
					int pixel = img.getRGB(x, y);
					int red = (pixel>>16) & 0xff;
					int green = (pixel>>8) & 0xff;
					int blue = (pixel>>0) & 0xff;
				
					//swap green and blue
					int temp = green;
					green = blue;
					blue = temp;
				
					//set the pixel
					pixel = (red<<16) | (green<<8)| blue;
					result.setRGB(x, y, pixel);
				}else
					result.setRGB(x, y, img.getRGB(x, y));
				
			}
		}
			
		return result;
	}
	

}