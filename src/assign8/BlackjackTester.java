package assign8;
/**
 * This class test the Blackjack class.
 * @author James Yeates
 *
 */

public class BlackjackTester {
	
	public static void main(String[] args) {
		
		Deck deck1 = new Deck();
		
		deck1.shuffle();
		PlayingCard card1 = new PlayingCard(CardSuit.SPADES, CardValue.ACE);
		PlayingCard card2 = new PlayingCard(CardSuit.DIAMONDS, CardValue.JACK);
		PlayingCard card3 = new PlayingCard(CardSuit.DIAMONDS, CardValue.SEVEN);
		
		
		// value and toString testing
		BlackjackHand bjHand1 = new BlackjackHand();
		
		if(bjHand1.value() != 0)
			System.out.println(getLine() + " " + bjHand1.value() );
		if(!(bjHand1.toString().equals(" has a Blackjack value of 0")))
			System.out.println(getLine() + " " + bjHand1.toString() );
		
		
		
		bjHand1.addCard(card1);
		if(bjHand1.value() != 11)
			System.out.println(getLine() + " " + bjHand1.value() );
		if(!(bjHand1.toString().equals("ace of spades has a Blackjack value of 11")))
			System.out.println(getLine() + " " + bjHand1.toString() );
		
		
		
		bjHand1.addCard(card1);
		if(bjHand1.value() != 12)
			System.out.println(getLine() + " " + bjHand1.value() );
		if(!(bjHand1.toString().equals("ace of spades, ace of spades has a Blackjack value of 12")))
			System.out.println(getLine() + " " + bjHand1.toString() );
		
		bjHand1.addCard(card1);
		if(bjHand1.value() != 13)
			System.out.println(getLine() + " " + bjHand1.value() );
		if(!(bjHand1.toString().equals("ace of spades, ace of spades, ace of spades has a Blackjack value of 13")))
			System.out.println(getLine() + " " + bjHand1.toString() );
		
		bjHand1.addCard(card2);
		if(bjHand1.value() != 13)
			System.out.println(getLine() + " " + bjHand1.value() );
		if(!(bjHand1.toString().equals("ace of spades, ace of spades, ace of spades, jack of diamonds has a Blackjack value of 13")))
			System.out.println(getLine() + " " + bjHand1.toString() );
		
		bjHand1.addCard(card1);
		if(bjHand1.value() != 14)
			System.out.println(getLine() + " " + bjHand1.value() );
		if(!(bjHand1.toString().equals("ace of spades, ace of spades, ace of spades, " +
				"jack of diamonds, ace of spades has a Blackjack value of 14")))
			System.out.println(getLine() + " " + bjHand1.toString() );
		
		bjHand1.addCard(card3);
		if(bjHand1.value() != 21)
			System.out.println(getLine() + " " + bjHand1.value() );
		
		bjHand1.removeCard(card3);
		if(bjHand1.value() != 14)
			System.out.println(getLine() + " " + bjHand1.value() );
		
		bjHand1.removeAllCards();
		if(bjHand1.value() != 0)
			System.out.println(getLine() + " " + bjHand1.value() );
		if(!(bjHand1.toString().equals(" has a Blackjack value of 0")))
			System.out.println(getLine() + " " + bjHand1.toString() );
		
		
		System.out.println("Testing done." );
	}
	
	
	
	
	
	/** 
	 * This helper method prints the line it was called on
	 * @return  - Current line number.
	 */ 
	public static String getLine() {
	    return "line: " +Thread.currentThread().getStackTrace()[2].getLineNumber();
	}

}


