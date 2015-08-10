package assign12.copy;

import java.awt.image.BufferedImage;

public class CropFilter extends ImageRegionFilter{
	

	@Override
	public BufferedImage filter(BufferedImage img) {
		System.out.println(getMaxX());
		System.out.println(getMinX());
		System.out.println(getMaxY());
		System.out.println(getMinY());
		System.out.println((getMaxX()-getMinX()) +"    " +( getMaxY()- getMinY()));
		BufferedImage result = new BufferedImage(getMaxX()-getMinX(),getMaxY()- getMinY(), BufferedImage.TYPE_INT_RGB);
		for(int y = 0;y < getMaxY()-getMinY(); y++){
			
			for ( int x = 0; x < getMaxX()-getMinX(); x++){
				int pixel = img.getRGB(x, y);
				result.setRGB(x, y, pixel);
				
				
			
			}
		}
		return result;
	}
	
	

}
