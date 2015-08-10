package part3;

import java.awt.image.BufferedImage;
/**
 * adds a grid to the image and also distorts the image by changing the pixels by random numbers.
 * @author James Yeates
 *
 */

public class GridFilter extends ImageRegionFilter {

	@Override
	public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
		//determine if a region has not been selected to filter the whole image
		if(getMinX()==0 &&getMinY()==0)
			setRegion(0, i.getWidth(), 0, i.getHeight());
	
		int random = (int)(Math.random()*255);
		for(int y = 0; y<i.getHeight(); y++){
			for(int x =0; x<i.getWidth(); x++){
				
				if(x <= getMaxX()&& x >= getMinX()&& y <= getMaxY() && y >= getMinY()){
					//get rgb values
					int pixel = i.getRGB(x, y);
					int red = (pixel>>16) & 0xff;
					int green = (pixel>>8) & 0xff;
					int blue = (pixel>>0) & 0xff;
				
					//draw a grid
				
					if( y%40 ==0 ||x%40==0){
						red =0;
						green = random;
						blue = random;
					
						random = (int)(Math.random()*120);
					
					}
					else{
						int random2 = (int)(Math.random()*3);
						if (random2 == 0){
							red = random;
						}
						else if (random2 == 1){
							blue = random;
						}
						else  if (random2 == 2){
							green = random;
						}
						else{
							throw new RuntimeException("fail");
						}
					
					}
					//set the pixel
					pixel = (red<<16) | (green<<8)| blue;
					result.setRGB(x, y, pixel);
				}else
					result.setRGB(x, y, i.getRGB(x, y));
			}
		}
			
		return result;
	}
	

}