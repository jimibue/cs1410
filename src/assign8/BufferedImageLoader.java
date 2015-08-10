//package assign8;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.JFrame;
//
//public class BufferedImageLoader {
//	
//	private BufferedImage cardSheet;
//
//	public BufferedImage loadCardSheet(){
//	
//		try {
//			
//		String file = "/Users/jcc/Desktop/cards.jpg";
//		cardSheet = ImageIO.read(getClass().getResource("cardz.png"));
//		System.out.println(cardSheet.getHeight()+ "  "+ cardSheet.getWidth());
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println("didn't work");
//	}
//		System.out.println("worked");
//		return cardSheet;
//	}
//
//}
