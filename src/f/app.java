package f;

public class app {
	
	public static void main(String[] args) {
		Team byu = new Team("BYU");
		Team usu = new Team("USU");
		Game g1 = new Game(byu, usu, 80, 81);
		    Team utah = new Team("Utah");
		    Team weber = new Team("Weber");
		    Game g2 = new Game(utah, weber, 82, 70);
		    Game g3 = new Game(g1, g2, 50, 60);
		    
		    
		     System.out.println(utah.getTotalPoints()); 
		     System.out.println(byu.getWinner() );
		     System.out.println( g1.getTotalPoints()); 
		     System.out.println( g1.getWinner()); 
		     System.out.println(g2.getWinner());
		     System.out.println(g3.getTotalPoints());
		     System.out.println(g3.getWinner() );
		    
		     
		     
	
	}

}
