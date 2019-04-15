package traitement;

import java.util.ArrayList;

import carte.Player;

public class TurnManagement {

	private static int lastPlay;

	/*
	 * Methode qui va permettre de stocker l'ID du dernier joueur ayant poser une ou
	 * des cartes sur le terrain
	 */
	public static void lastPlayerWhoPlay(int i) {
		lastPlay = i;
	}

	/*
	 * Methode qui va recuperer l'ID du dernier joueur ayant poser une ou des cartes
	 * sur le terrain
	 */
	public static int getLastPlayerWhoPlay() {
		return lastPlay;
	}

	/*
	 * Methode qui va s'assurer que deux joueur minimum puisse jouer
	 */
	/**
	 * @param players
	 * @return
	 */
	public static boolean canPlay(ArrayList<Player> players) {
		int p = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getToPass() == 0) {
				p++;
			}
		}

		if (p == 1 || p == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean endGame(ArrayList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getHand().cardCount() == 0) {
				return true;
			}
		}
		return false;
	}
}
