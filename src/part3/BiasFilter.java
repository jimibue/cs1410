package part3;

import java.awt.image.BufferedImage;

/**
 * Increases or decreases the brightness of an image by adding X to each color component.  
 * X > 0 increases brightness.
 * X < 0 decreases brightness.
 * 
 * @author James Yeates, Erin Parker and CS 1410 class.
 */
public class BiasFilter extends ImageRegionFilter {
	
	private static int biasAmount = 0;
	
	public BufferedImage filter(BufferedImage img) {
		
		
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		//determine if a region has not been selected to filter the whole image
		if(getMinX()==0 &&getMinY()==0)
			setRegion(0, img.getWidth(), 0, img.getHeight());
		
		
		for(int y = 0; y < img.getHeight(); y++){
			for(int x = 0; x < img.getWidth(); x++) {
				
				if(x <= getMaxX()&& x >= getMinX()&& y <= getMaxY() && y >= getMinY()){
					int pixel = img.getRGB(x, y);
					int redAmount = (pixel >> 16) & 0xff;
					int greenAmount = (pixel >> 8) & 0xff;
					int blueAmount = (pixel >> 0) & 0xff;
				
					redAmount += biasAmount;
					if(redAmount < 0)
						redAmount = 0;
					else if(redAmount > 255)
						redAmount = 255;
				
					greenAmount += biasAmount;
					if(greenAmount < 0)
						greenAmount = 0;
					else if(greenAmount > 255)
						greenAmount = 255;
					
					blueAmount += biasAmount;
					if(blueAmount < 0)
						blueAmount = 0;
					else if(blueAmount > 255)
						blueAmount = 255;
				
					int newPixel = (redAmount << 16 ) | (greenAmount << 8) | blueAmount;
					result.setRGB(x, y, newPixel);
				}
			else
				result.setRGB(x, y, img.getRGB(x, y));
			}
		}		
		
		return result;
	}
	public static void setBiasAmount(int x){
		biasAmount = x;
	}
}