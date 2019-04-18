package carte;
import carte.Hand;
import carte.Player;
import carte.Scoreboard;
import carte.Stock;
import traitement.Init;

public class BotPlayer extends Player{
	
	public BotPlayer(String username, Scoreboard score, Hand hand, int toPass) {
		super(username, score, 1, hand, toPass);
	}
}
