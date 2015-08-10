package assign8;

import java.awt.image.BufferedImage;

public class CardSheet {
	
	private BufferedImage cardSheet;
	
	public CardSheet(BufferedImage cardSheet){
		this.cardSheet = cardSheet;
	}
	
	public BufferedImage getCard(int col, int row){
		
		BufferedImage img = cardSheet.getSubimage((col*79)-80+(col*2), (row*115)-115+(row*2), 79,115);
		
		return img;
		
	}

}
