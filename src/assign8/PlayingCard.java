package assign8;

/**
 * Represents a playing card (e.g, ace of spades, 2 of clubs, king of hearts).
 * 
 * @author James Yeates, Erin Parker, and CS 1410 class 
 */
public class PlayingCard implements Comparable<PlayingCard> {
		
	private final CardSuit suit;   
	private final CardValue value;   // TO DO: Update to use enum for card value.
		
	public PlayingCard(CardSuit _suit, CardValue _value) {   // TO DO: Update parameter type for _value.
		//Don't allow the "Blank" value to be used.
		if (_value.ordinal() == 0)
			throw new RuntimeException("not a valid card value");
		suit = _suit;
		value = _value;

	}
	
	/**
	 * Returns the suit of this playing card.
	 */
	public CardSuit getSuit() {
		return suit;
	}
	
	/**
	 * Returns the value of this playing card.
	 */
	public CardValue getValue() {    // TO DO: Update return type and body to use enum for card value.
		return value;
	}
	
	/**
	 * Returns a formatted string representation of this card (e.g., "ace of spades, "9 of hearts").
	 * 
	 * @return formatted string
	 */
	public String toString() {

		return value + " of " + suit;
	}

	
	/** Returns true if the card represented by this object is equal to the
	 * other card.
	 * 
	 * @param other
	 * @return true if this is equal to other
	 */
	public boolean equals(Object other) {
		if(!(other instanceof PlayingCard))
			return false;
		
		PlayingCard rhs = (PlayingCard)other;
		
		// Note that enums may be compared with ==.
		return suit == rhs.suit && value == rhs.value;
	}

	/**
	 * This method take to cards and compares the values
	 * it returns 1 if 'this' card is greater than 'others' value,
	 * -1 if it is less than.  In case of a tie between card value the 
	 * suit is the tie breaker with clubs having to lowest value and
	 * spades having the highest.  Return 0 if the card is identical.
	 * 
	 * 
	 * @returns 1 if card is bigger, -1 if smaller, 0 it equal
	 */
	public int compareTo(PlayingCard other) {
		if (this.value.ordinal() > other.value.ordinal())
			return 1;
		if (this.value.ordinal() < other.value.ordinal())
			return -1;
		//if (this.value.ordinal() == other.value.ordinal())//This is unesccary!!!!!!
		if(this.suit.ordinal()> other.suit.ordinal())
			return 1;
		if(this.suit.ordinal()< other.suit.ordinal())
			return -1;
		return 0;
	}
}
