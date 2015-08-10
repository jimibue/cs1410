package f;



public class Team implements Tourney {
    private String name;  // name of team
    // Creates a Team with the specified name.
    public Team(String _name) {
name = _name;
}

public int getTotalPoints() {
     return 0;
}
 public String getWinner() {
    return name;
}
} // end Team
