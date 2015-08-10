package assign11;

import java.awt.image.BufferedImage;

/**
 * Changes the contrast among pixels in an image by scaling all color components by X.
 * X must be > 0.  
 * X < 1 decreases contrast and makes the image darker.
 * X > 1 increases contrast and makes the image lighter.
 * 
 * @author James Yeates, Erin Parker and CS 1410 class
 */
public class GainFilter implements ImageFilter {
	private static double gainFactor =1;
	
	public BufferedImage filter(BufferedImage img) {
		
		
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < img.getHeight(); y++)
			for(int x = 0; x < img.getWidth(); x++) {

				int pixel = img.getRGB(x, y);
				int redAmount = (pixel >> 16) & 0xff;
				int greenAmount = (pixel >> 8) & 0xff;
				int blueAmount = (pixel >> 0) & 0xff;
				
				// scale each component by X, clamp to 255 as needed
				redAmount *= gainFactor;
				if(redAmount > 255)
					redAmount = 255;
				
				greenAmount *= gainFactor;
				if(greenAmount > 255)
					greenAmount = 255;
				
				blueAmount *= gainFactor;
				if(blueAmount > 255)
					blueAmount = 255;
				
				int newPixel = (redAmount << 16 ) | (greenAmount << 8) | blueAmount;
				result.setRGB(x, y, newPixel);
			}
		
		return result;
	}
	public static void setGainFactor(double n){
		gainFactor = n;
	}
}