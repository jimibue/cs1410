package part3;

import java.awt.image.BufferedImage;
/**
 * This filter blurs an image by getting the average of the pixels neighbors individual rgb 
 * and assigning it to the new pixel.
 * @author James Yeates
 *
 */

public class BlurFilter extends ImageRegionFilter {
	private static int blurAmount=1;


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
				
					//get the rgb averages of the pixels
					int red = getNeighborsRed(x, y, pixel, img);
					int green = getNeighborsGreen(x, y, pixel, img);
					int blue = getNeighborsBlue(x, y, pixel, img);
				
					//set the pixel
					pixel = (red<<16) | (green<<8)| blue;
					result.setRGB(x, y, pixel);
				}else
					result.setRGB(x, y, img.getRGB(x, y));
			}
		}
			
		return result;
	}
	/**
	 * gets the average red amount of all the pixels around the pixel to changed.
	 * @param row the current row of the pixel
	 * @param col the current column of the pixel
	 * @param pixel the pixel that is being changed
	 * @param img the image that is being filtered
	 * @return the average red amount of the pixel and neighboring pixel (0-255)
	 */
	
	public static int getNeighborsRed(int row, int col, int pixel, BufferedImage img){
		
		int value;
		int sum =0;
		int count = 0;
		int xVAl = img.getWidth();
		int yVAl = img.getHeight();
		
		//go through the neighboring pixels
		for(int i = -1*blurAmount; i<1*blurAmount; i++){
			for(int j = -1*blurAmount; j<1*blurAmount; j++){
				
				//get the red amount add it to sum
				try{
					value = img.getRGB(row+i, col+j);
					value = (value>>16)& 0xff;
					sum += value;
					count++;
					
				}
				catch(ArrayIndexOutOfBoundsException e){
					//do nothing
				}
			}	
		}
		//find the average
		return sum/count;
		
		
		
	}
	/**
	 * gets the average green amount of all the pixels around the pixel to changed.
	 * @param row the current row of the pixel
	 * @param col the current column of the pixel
	 * @param pixel the pixel that is being changed
	 * @param img the image that is being filtered
	 * @return the average green amount of the pixel and neighboring pixel (0-255)
	 */
	public static int getNeighborsGreen(int row, int col, int pixel, BufferedImage img){
		
		int value;
		int sum =0;
		int count = 0;
		//go through the neighboring pixels
		for(int i = -1*blurAmount; i<1*blurAmount; i++){
			for(int j = -1*blurAmount; j<1*blurAmount; j++){
				
				//get the green amount add it to sum
				try{
					value = img.getRGB(row +i, col+j);
					value = (value>>8)& 0xff;
					sum += value;
					count++;
					
				}
				catch(ArrayIndexOutOfBoundsException e){
					//do nothing
				}
			}	
		}
		return sum/count;
		
		
		
	}
	/**
	 * gets the average blue amount of all the pixels around the pixel to changed.
	 * @param row the current row of the pixel
	 * @param col the current column of the pixel
	 * @param pixel the pixel that is being changed
	 * @param img the image that is being filtered
	 * @return the average blue amount of the pixel and neighboring pixel (0-255)
	 */
	public static int getNeighborsBlue(int row, int col, int pixel, BufferedImage img){
		
		int value;
		int sum =0;
		int count = 0;
		//go through the neighboring pixels
		for(int i = -1*blurAmount; i<1*blurAmount; i++){
			for(int j = -1*blurAmount; j<1*blurAmount; j++){
				
				//get the blue amount add it to sum
				try{
					value = img.getRGB(row +i, col+j);
					value = (value>>0)& 0xff;
					sum += value;
					count++;
					
				}
				catch(ArrayIndexOutOfBoundsException e){
					//do nothing
				}
			}	
		}
		return sum/count;
		
		
		
	}
	
	public static void setBlurAmount(int n){
		blurAmount = n/2;
		//System.out.println("blur amount is " + blurAmount);
	}

}