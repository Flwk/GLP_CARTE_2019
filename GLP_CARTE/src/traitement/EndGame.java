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
		
	public static Player winner(ArrayList <Player> players) {
		for(int i=0; i<players.size(); i++) {
			if(players.get(i).getHand().cardCount() == 0) {			
				return players.get(i);
			}
		}
		return null;
	}
}
		
		
		
		



