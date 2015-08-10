package assign10;

import java.awt.image.BufferedImage;
/**
 * This class converts an image to a black and white image by averaging the rgb values of each pixel
 * @author James Yeates
 *
 */

public class BlackAndWhite implements ImageFilter{

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
				
				//find the averages to get effect
				int average = (red+green+blue)/3;
				
				red = average;
				green = average;
				blue = average;
				
				//set the pixel
				pixel = (red<<16) | (green<<8)| blue;
				result.setRGB(x, y, pixel);
			}
		}
			
		return result;
	}
	

}
