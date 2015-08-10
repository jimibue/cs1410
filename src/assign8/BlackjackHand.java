package assign8;
/**
 * This class represent a Blackjack hand
 * @author James Yeates
 *
 */
public class BlackjackHand extends Hand {
	
	/**
	 * this method determines the blackjack value of this hand
	 * @return the blackjack value of the hand
	 */
	public int value(){
		int sum = 0;
		PlayingCard tempCard;
		
		//since sorting is used to determine the value this hand
		//a copy of the hand is made so that original hand is not modified
		Hand tempHand = new Hand();
		for(int i = 0; i< cardCount(); i++)
			tempHand.addCard(getCard(i));
		tempHand.sort();
		
		//figure out the value
		for(int i = cardCount()-1; i>=0; i--){
			tempCard = tempHand.getCard(i);
			//check to see if card is ace
			if(tempCard.getValue().ordinal()==1){
				if (sum<11 && i==0)
					sum += 11;
				else
					sum += 1;
			}
			//if card is not an ace add the ordinal card value 
			else
				sum += cardValue(tempCard);
			}
		return sum;
	}
	
	/**
	 * returns a formatted string of the hand with the blackjack value
	 */
	
	public String toString(){
		return super.toString() + " has a Blackjack value of " + value();
	}
	
	public int cardValue(PlayingCard c){
		if (c.getValue().ordinal() > 10 )
			return 10;
		else return c.getValue().ordinal();
	}
	/**
	 * This method determines if this hands value is twenty one
	 * @return boolean returns true if value is twenty one
	 */
	
	public boolean isTwentyOne(){
		if(value() ==21 ){
			return true;
		}
		else
			return false;
	}
	/**
	 * This method determines if this hands value is over twenty one
	 * @return boolean returns true if value is over twenty one
	 */
	
	public boolean isOverTwentyOne(){
		if(value() >21 ){
			return true;
		}
		else
			return false;
	}
	/**
	 * This method determines if this hands value is under 17
	 * @return boolean returns true if value is under 17
	 */
	
	public boolean underSeventeen(){
		if(value() < 17){
			return true;
		}
		else
			return false;
	}
}
