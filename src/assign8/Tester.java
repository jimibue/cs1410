package assign8;

import java.util.NoSuchElementException;
/**
 * This class test PlayingCard, Hand, and Deck.
 * @author James Yeates
 * 
 *
 */

public class Tester {
	
	public static void main(String[] args) {
		
		
		//Testing Playing Card
		PlayingCard card1 = new PlayingCard(CardSuit.SPADES, CardValue.ACE);
		PlayingCard card2 = new PlayingCard(CardSuit.CLUBS, CardValue.SIX);
		PlayingCard card3 = new PlayingCard(CardSuit.CLUBS, CardValue.SIX);
		PlayingCard card4 = new PlayingCard(CardSuit.HEARTS, CardValue.KING);
		PlayingCard card5 = new PlayingCard(CardSuit.DIAMONDS, CardValue.SIX);
		
		//uncomment to throw error 
		//PlayingCard card6 = new PlayingCard(CardSuit.DIAMONDS, CardValue.BLANK);
		
		//to string
		if (!(card1.toString().equals("ace of spades")))
			System.out.println(getLine() + "!(card1.toString().equals(\"ace of spades\")) equals..... " + card1.toString() );
		if (!(card2.toString().equals("six of clubs")))
			System.out.println(getLine() + "!(card1.toString() should equal \"six of clubs\", but equals.. " + card1.toString() );
		
		//value
		if( card3.getValue().ordinal() != 6 )
			System.out.println(getLine() + " value should be 6 but is..  " + card3.getValue().ordinal());
		if( card4.getValue().ordinal() != 13 )
			System.out.println(getLine() + " value should be 13 but is..  " + card4.getValue().ordinal());
		
		//equals
		if(!(card2.equals(card3)))
			System.out.println(getLine() + " value should be true but is... " + card3.equals(card3));
		if(card1.equals(card3))
			System.out.println(getLine() + " value should be false but is... " + card2.equals(card3));
		if(card3.equals(card5))
			System.out.println(getLine() + " value should be false but is... " + card3.equals(card5));
		
		//compare to
		if(card2.compareTo(card3) != 0)
			System.out.println(getLine() + " value should be 0 but is... " + card2.compareTo(card3));
		if(card2.compareTo(card5) != -1)
			System.out.println(getLine() + " value should be -1 but is... " + card2.compareTo(card5));
		if(card5.compareTo(card2) != 1)
			System.out.println(getLine() + " value should be 1 but is... " + card5.compareTo(card2));
		if(card4.compareTo(card5) != 1)
			System.out.println(getLine() + " value should be 1 but is... " + card4.compareTo(card5));
		if(card5.compareTo(card4) != -1)
			System.out.println(getLine() + " value should be -1 but is... " + card5.compareTo(card4));
		
		
	
		
		//Hand/Deck Testing
		
		Deck deck1 = new Deck();
		Hand hand1 = new Hand();
		
		if(hand1.cardCount() != 0)
			System.out.println(getLine() + " " + hand1.cardCount());
		if(!(hand1.toString()).equals(""))
			System.out.println(getLine() + " " + hand1.toString());
		
		hand1.addCard(card5);
		if(!(hand1.toString()).equals("six of diamonds"))
			System.out.println(getLine() + " " + hand1.toString());
		
		if(hand1.cardCount() != 1)
			System.out.println(getLine() + " " + hand1.cardCount());
		
		hand1.removeCard(card5);
		
		if(hand1.cardCount() != 0)
			System.out.println(getLine() + " " + hand1.cardCount());
		
		try{
			System.out.println(hand1.getCard(0));
			System.out.println(getLine() + " should have thrown exception");
		}catch(IndexOutOfBoundsException e ){}
		
		try{
			System.out.println(hand1.getHighestCard());
			System.out.println(getLine() + " should have thrown exception");
		}catch(NoSuchElementException e ){}
		
		try{
			System.out.println(hand1.getLowestCard());
			System.out.println(getLine() + " should have thrown exception");
		}catch(NoSuchElementException e ){}
		
		
		for(int i = 0; i< 52; i++){
			hand1.addCard(deck1.deal());
		}
		try{
			System.out.println(hand1.getCard(52));
			System.out.println(getLine() + " should have thrown exception");
		}catch(IndexOutOfBoundsException e ){}
		
		if (!(hand1.getCard(0)).toString().equals("ace of clubs"))
			System.out.println(getLine() +" " +  hand1.getCard(0));
		if (!(hand1.getCard(51)).toString().equals("king of spades"))
			System.out.println(getLine()+" " +  hand1.getCard(51));
		if( hand1.cardCount() != 52)
			System.out.println(getLine()+ " " + hand1.cardCount());
		
		hand1.removeAllCards();
		try{
			System.out.println(hand1.getCard(0));
			System.out.println(getLine() + " should have thrown exception");
		}catch(IndexOutOfBoundsException e ){}
		
		try{
			System.out.println(hand1.getHighestCard());
			System.out.println(getLine() + " should have thrown exception");
		}catch(NoSuchElementException e ){}
		
		try{
			System.out.println(hand1.getLowestCard());
			System.out.println(getLine() + " should have thrown exception");
		}catch(NoSuchElementException e ){}
		
		
		
	
		
		Deck d = new Deck();
		d.shuffle();
		
		Hand hand2 = new Hand();
		for(int i = 0; i < 52; i++)
			hand2.addCard(d.deal());
		
		if(hand2.getHighestCard().equals("king of spades"))
			System.out.println(getLine() + " " + hand2.getHighestCard());
		if(hand2.getLowestCard().equals("two of clubs"))
			System.out.println(getLine() + " " + hand2.getLowestCard());
		hand2.sort();
		
		if (!(hand2.getCard(0)).toString().equals("ace of clubs"))
			System.out.println(getLine() +" " +  hand2.getCard(0));
		if (!(hand2.getCard(5)).toString().equals("two of diamonds"))
			System.out.println(getLine() +" " +  hand2.getCard(5));
		if (!(hand2.getCard(51)).toString().equals("king of spades"))
			System.out.println(getLine()+" " +  hand2.getCard(51));
		if( hand2.cardCount() != 52)
			System.out.println(getLine()+ " " + hand2.cardCount());
		
		
		Hand hand3 = new Hand();
		hand3.addCard(card5);
		hand3.addCard(card4);
		hand3.addCard(card3);
		hand3.addCard(card1);
		
		if(!(hand3.toString().equals("six of diamonds, king of hearts, six of clubs, ace of spades")))
			System.out.println(getLine() + " " + hand3.toString());
		
		System.out.println("Testing Done");
			
		
		
		System.exit(0);
		
		
		
		
		for(int i = 0; i < 52; i++)
			System.out.println(hand2.getCard(i).toString());
		
		
		
		
		
		
	}
	
	/** 
	 * This helper method prints the line it was called on
	 * @return  - Current line number.
	 */ 
	public static String getLine() {
	    return "line: " +Thread.currentThread().getStackTrace()[2].getLineNumber();
	}

}
