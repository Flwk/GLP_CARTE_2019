package carte;
import carte.Hand;
import carte.Player;
import carte.Scoreboard;
import carte.Stock;
import traitement.Init;

public class BotPlayer extends Player{
	
	private static Stock fictif;
	
	public BotPlayer(String username, Scoreboard score, Hand hand, int toPass) {
		super(username, score, 1, hand, toPass);
		fictif=Init.initStock();
	}

	public static Stock getFictif() {
		return fictif;
	}

}
