package assign8;

import java.util.Scanner;
/**
 * This class play's an interactive game of Blackjack
 * @author James Yeates
 *
 */

public class BlackjackGame {
	
	public static void main(String[] args) {
		
		int dealerScore = -1; 
		Deck deck = new Deck();
		BlackjackHand dealer = new BlackjackHand();
		BlackjackHand player = new BlackjackHand();
		
		
		System.out.println("Let's play some Blackjack! \n");
		deck.shuffle();
		dealer.addCard(deck.deal());
		player.addCard(deck.deal());
		dealer.addCard(deck.deal());
		player.addCard(deck.deal());
		
		int playerScore = playerTurn(player, deck);
		
		//player busted dealer just shows hand
		if(playerScore>21){
			System.out.println("dealer hand " + dealer.toString() + "\n");
			System.out.println("-------Dealer wins---------");
			System.exit(0);
		}
		else
			dealerScore = dealerTurn(dealer, deck);
		System.out.println();
		
		//determine outcome
		if(dealer.isOverTwentyOne())
			System.out.println("--------player wins--------");
		else if(dealerScore == playerScore)
			System.out.println("--------Push--------");
		else if(dealerScore > playerScore)
			System.out.println("--------dealer wins--------");
		else
			System.out.println("--------player wins--------");
		

	}//end of main
	
	/**
	 * This method does organize's the steps in the dealer's turn
	 * and return the final blackjack value of the hand
	 * 
	 * @param dealer the dealers hand
	 * @param d a deck of card
	 * @return the final blackjack value of the dealers hand
	 */
	
	public static int dealerTurn(BlackjackHand dealer, Deck d){
		
		boolean under = dealer.underSeventeen();
		System.out.println("Dealers hand:   " + dealer.toString());
		
		while(under){
			System.out.println("dealer hits");
			dealer.addCard(d.deal());
			System.out.println("Dealers hand:   " +dealer.toString());
			under = dealer.underSeventeen();
		}
		
		if(dealer.isOverTwentyOne())
			System.out.println("dealer busts");
		else if(dealer.isTwentyOne())
			System.out.println("dealer has blackjack");
		else
			System.out.println("Dealer Stays");
		
		return dealer.value();
		
	}
	
	/**
	 * This method does organize's the steps in the players turn
	 * and return the final blackjack value of the hand
	 * 
	 * @param player the players hand
	 * @param d a deck of card
	 * @return the final blackjack value of the players hand
	 */
	
	public static int playerTurn(BlackjackHand player, Deck d){
		//check to see if player was dealt 21
		if(player.isTwentyOne()){
			System.out.println("Player hand:   " + player.toString());
			System.out.println("player has blackjack");
			System.out.println("player stays \n");
			return 21;
			
		}
		System.out.println("Player hand:   " + player.toString());
		boolean hit = playerHit();
		
		//System.out.println();
		while(hit){
			System.out.println("player hits ");
			player.addCard(d.deal());
			System.out.println("player hand:   " +player.toString());
			if(player.value() > 20)
				break;
			hit = playerHit();
			
			//System.out.println();
		}
		
		if(player.isOverTwentyOne()){
			System.out.println("player busts");
		}
		else if(player.isTwentyOne()){
			System.out.println("player has blackjack");
		}
		else
			System.out.println("player Stays");
		
		System.out.println();
		return player.value();
		
		
	}
	/**
	 * this method determines if the player wants to hit or stay
	 * @return true if the player wants to hit, false if not
	 */
	
	public static boolean playerHit(){
		
		int hit = getInput();
		if(hit ==1)
			return true;
		
		return false;
	}
	/**
	 * this method gets, checks, and returns input from the user
	 * 1 and 0 are the only inputs 
	 * @return 1 or 0 entered by user
	 */
	
	public static int getInput(){
		boolean check = true;
		int num = -1;
		while(check && (num != 0 || num !=1)){
			try{
				System.out.println("Enter 1 to hit 0 to stay");
				Scanner input = new Scanner(System.in);
				num = input.nextInt();
				check = false;
			}catch(Exception e){
				System.out.println("invalid entry try again");
			}
		
		}
		
		return num;
	}
		

}
