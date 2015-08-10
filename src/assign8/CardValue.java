package assign8;
/**
 * Represents the values of Playing Cards
 * 
 * @author James Yeates
 *
 */

public enum CardValue {
	
	//Note: the value blank is not meant to be used
	BLANK, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	
	/**
	 * Returns the value of this card value as a formatted string.
	 */
	public String toString(){
		if (this == BLANK)
			return "ERROR";
		if (this == ACE )
			return "ace";
		if (this == TWO)
			return "two";
		if (this == THREE)
			return "three";
		if (this == FOUR )
			return "four";
		if (this == FIVE)
			return "five";
		if (this == SIX)
			return "six";
		if (this == SEVEN)
			return "seven";
		if (this == EIGHT)
			return "eight";
		if (this == NINE)
			return "nine";
		if (this == TEN)
			return "ten";
		if (this == JACK)
			return "jack";
		if (this == QUEEN)
			return "queen";

		return "king";
	}
					
					
}
