package traitement;

import carte.Player;
import carte.Scoreboard;
import carte.Stock;
import carte.Table;
import java.util.ArrayList;

/**
 * @author cvericel
 * EndGame gere les fin de partie notament le score des joueurs ainsi que le gagnant
 */

public class EndGame {

	/**
	 * @param players
	 * ArrayList de joueur de la partie
	 * 
	 * @return Player
	 * retourne la joueur ayant gagn� la partie
	 */
	public static Player winner(ArrayList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getHand().cardCount() == 0) {
				return players.get(i);
			}
		}
		return null;
	}
	
	/**
	 * @param players 
	 * ArrayList de joueur de la partie
	 * 
	 * @param winnerID
	 * Place dans l'arrayList du gagnant de la partie (Score  a incremente)
	 * 
	 * @return ArrayList<Player> 
	 * retourne l'arrayList rentr� en param�tre avec les Score Modifi�
	 */
	public static ArrayList<Player> scoreManager(ArrayList<Player> players, int winnerId) {
		int totalScore = 0;
		int playersScore = 0;
		int multiplicateur = 1;
		for (int i = 0; i < players.size(); i++) {
			if (i != winnerId) {
				for (int j = 0; j < players.get(i).getHand().cardCount(); j++) {
					if (PlayerAction.isJoker(players.get(i).getHand().getCardKey(j))) {
						multiplicateur = multiplicateur * 2;
					}
				}
				playersScore = players.get(i).getHand().cardCount() * multiplicateur;
				players.get(i).getScore().decrement(playersScore);
				totalScore = totalScore + playersScore;
			}
			multiplicateur = 1;
		}
		players.get(winnerId).getScore().increment(totalScore);
		return players;
	}
	
	/*
	 * remet a 0 les mains des joueurs
	 */
	public static void resetHand(ArrayList<Player> players) {
		for(int index=0; index<Init.getNbPlayer(); index++) {
			players.get(index).getHand().getList().clear();
		}
	}
	
	/*
	 * Initialise de nouvelle main pour les joueurs
	 */
	public static void initNewHand(Stock stock, ArrayList<Player> players) {
		for(int index=0; index<Init.getNbPlayer(); index++) {
			Init.initHand(players.get(index), stock);
		}
	}
}
