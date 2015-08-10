package assign10;

import java.awt.image.BufferedImage;

public class Pixelate implements ImageFilter {
	
	@Override
	public BufferedImage filter(BufferedImage img) {
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		int pixel =0;
		int red=0;
		int green=0;
		int blue=0;
		for(int y = 0; y<img.getHeight(); y++){
			for(int x =0; x<img.getWidth(); x++){
				
				if( (y+10)%10 ==0 || (x+10)%10==0){
					pixel = img.getRGB(x, y);
					red = (pixel>>16) & 0xff;
					green = (pixel>>8)& 0xff;
					blue = pixel & 0xff;
				}
			
				
				//set the pixel
				pixel = (red<<16) | (green<<8)| blue;
				result.setRGB(x, y, pixel);
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
		//go through the neighboring pixels
		for(int i = -1; i<1; i++){
			for(int j = -1; j<1; j++){
				
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
		for(int i = -1; i<1; i++){
			for(int j = -1; j<1; j++){
				
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
		for(int i = -1; i<1; i++){
			for(int j = -1; j<1; j++){
				
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

}
