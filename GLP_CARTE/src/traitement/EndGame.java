package traitement;
import carte.Player;
import carte.Scoreboard;
import carte.Table;
import java.util.ArrayList;

/**
 * @author msia
 *
 */

public class EndGame {
	
	private Player winner;
	private Scoreboard winnerScore;
	public  ArrayList <Player> players;
	
	
	public Player theWinner () {
	
		for (int i=0; i<players.size(); i++) {
			if ((players.getScore(i))==0) {
			winner= Table.players.get(i);
			}
		
			else {
			Table.getMethod(initTable();
			} 
		}
		return winner;
	}
}
		
		
		
		



