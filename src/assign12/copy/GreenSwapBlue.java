package assign12.copy;

import java.awt.image.BufferedImage;

/**
 * This class is a filter that swaps the green and blue pixels
 * @author James Yeates
 *
 */

public class GreenSwapBlue extends ImageRegionFilter {

	@Override
	public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y<i.getHeight(); y++){
			for(int x =0; x<i.getWidth(); x++){
				
				//get rgb values
				int pixel = i.getRGB(x, y);
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
			}
		}
			
		return result;
	}
	

}