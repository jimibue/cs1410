package part3;

import java.awt.image.BufferedImage;
/**
 * This filter reduces the quality of the picture by reducing the bit depth of the image.
 * @author James Yeates
 *
 */

public class BitFilter extends ImageRegionFilter {
	

	@Override
	public BufferedImage filter(BufferedImage img) {
		
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		//determine if a region has not been selected to filter the whole image
		if(getMinX()==0 &&getMinY()==0)
			setRegion(0, img.getWidth(), 0, img.getHeight());
		
		for(int y = 0; y < img.getHeight(); y++)
			for(int x = 0; x < img.getWidth(); x++) {

				if(x <= getMaxX()&& x >= getMinX()&& y <= getMaxY() && y >= getMinY()){
					int pixel = img.getRGB(x, y);
					int redAmount = (pixel >> 16) & 0xff;
					int greenAmount = (pixel >> 8) & 0xff;
					int blueAmount = (pixel >> 0) & 0xff;
				
					//reduce the bit depth of image
					redAmount = (redAmount/64) * 64;
					greenAmount = (greenAmount/64)*64;
					greenAmount = (greenAmount/64)*64;

					int newPixel = (redAmount << 16 ) | (greenAmount << 8) | blueAmount;
					result.setRGB(x, y, newPixel);
				}
				else
					result.setRGB(x, y, img.getRGB(x, y));
			}
		
		
		return result;
	
	}

}