package assign8;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Collections;

/**
 * This class represents a hand of playing cards
 * @author James Yeates
 *
 */
public class Hand {
	
	private ArrayList<PlayingCard> hand;
	
	
	public Hand() {
		hand = new ArrayList<PlayingCard>();
	}
	
	/**
	 * adds a card to this hand
	 * 
	 * @param c the card to be added
	 */
	public void addCard(PlayingCard c) {   
		
		hand.add(c);
	}
	
	/**
	 * removes a card from this hand, if card is
	 * not in this hand does nothing.
	 * 
	 * @param c the card to be removed
	 */
	public void removeCard(PlayingCard c) {
		// FILL IN to remove c from the hand,
		// doing nothing if c is not in the hand
		hand.remove(c);
		
	}
	
	/**
	 * removes all cards from this hand
	 */
	public void removeAllCards() {
		// FILL in to remove all cards from the hand
		int currentHandSize = hand.size();
		for(int i =0; i< currentHandSize; i++){
			hand.remove(0);
		}
	}
	
	/**
	 *  @return returns the number of playing cards in this hand
	 */
	public int cardCount() {
		// FILL IN to return the number of cards in the hand
		return hand.size();
	}
	
	/**
	 * sorts the cards in this hand, putting the
	 * lowest card at index 0
	 */
	public void sort() {

		Collections.sort(hand);
	}
	
	/**
	 * get the playing card at the specified index
	 * @param i the index to get to playing card from
	 * @return the playing card at the specified index
	 */
	public PlayingCard getCard(int i) {
		// FILL IN to return the card at index i, throwing an
		// IndexOutOfBoundsExcpetion if i is out of range
		if(i >=hand.size()|| i< 0)
			throw new IndexOutOfBoundsException();
		return hand.get(i);
	}
	
	/**
	 * gets the highest playing card from the hand.
	 * Throws a NoSuchElementException if there are no cards in the hand
	 * @return the highest playing card from the hand
	 */
	
	public PlayingCard getHighestCard() {
		// FILL IN to return the highest card in the hand,
		// throwing a NoSuchElementException if there are no cards in the hand
		if(hand.size() == 0)
			throw new NoSuchElementException();
		//make sure the hand is sorted
		sort();
		return hand.get(hand.size()-1);
	}
	
	/**
	 * gets the lowest playing card from the hand.
	 * Throws a NoSuchElementException if there are no cards in the hand
	 * @return the lowest playing card from the hand
	 */
	public PlayingCard getLowestCard() {
		// FILL IN to return the lowest card in the hand,
		// throwing a NoSuchElementException if there are no cards in the hand
		if(hand.size() == 0)
			throw new NoSuchElementException();
		//make sure the hand is sorted
		sort();
		return hand.get(0);
		
	}
	
	/**
	 * returns a formatted representation of the hand
	 */
	
	public String toString() {
		// FILL IN to return a formatted string representing the hand
		// E.g., "4 of clubs, 6 of hearts, king of spades"	
		String handToString = "";
		if( hand.size() > 0)
			handToString += hand.get(0).toString();
		for(int i = 1; i < hand.size(); i++)
			handToString += ", " +hand.get(i).toString();
		//handToString += "\"";
		return handToString;
	}
	

}
