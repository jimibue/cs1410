package f;

public interface Tourney {
    // Returns the total number of points scored in all of the games
    // of this Tourney. If there were no games played, returns zero.
    public int getTotalPoints();
    // Returns the name of the team that won this Tourney. If there
    // is only one team in this Tourney, returns its name.
    public String getWinner();
} // end Tourney
// A Team is the simplest kind of Tourney. It represents a basketball
// team and conceptually represents the winner of a single-elimination
// tournament with only one participant and thus no games.