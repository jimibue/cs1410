package assign10;

import java.awt.image.BufferedImage;
/**
 * This filter rotates an image counter clockwise
 * @author James Yeates
 *
 */

public class RotateCounterClockwise implements ImageFilter{
	
	public BufferedImage filter(BufferedImage i) {
		
		//switch x and y
		BufferedImage result = new BufferedImage(i.getHeight(),i.getWidth(),  BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y<i.getHeight(); y++){
			for(int x =0; x<i.getWidth(); x++){
				
				//get rgb values
				int pixel = i.getRGB(x, y);
				
				result.setRGB(y, x, pixel);
			}
		}
			
		return result;
	}

}
