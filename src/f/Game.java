package f;

public class Game implements Tourney {
    private Tourney tourney1;  // Tourney whose winner plays in this game
    private Tourney tourney2;  // Tourney whose winner plays in this game
    private int score1;  // score of the tourney1 winner in this game
    private int score2;  // score of the tourney2 winner in this game
    // Creates a Game that represents a game between the winner of
    // tourney1 and the winner of tourney2. The winner of tourney1 scores
    // score1 points in this game, and the winner of tourney scores score2
    // points in this game. (Assume that both score1 and score2 are
    // non-negative and that score1 is different from score2.)
    public Game(Tourney _tourney1, Tourney _tourney2, int _score1,
                int _score2) {
        tourney1 = _tourney1;
        tourney2 = _tourney2;
        score1 = _score1;
        score2 = _score2;
    }
    public int getTotalPoints() {
        return score1 + score2;
}
    public String getWinner() {
    	
    	
    		  if(score1 > score2)
    			return tourney1.getWinner();
    		  else
    			return tourney2.getWinner();
    	}
    	
    
      

} // end Game
