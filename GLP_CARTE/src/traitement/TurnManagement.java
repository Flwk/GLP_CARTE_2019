package traitement;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import carte.Card;
import carte.Game;
import carte.Player;
import carte.Posibility;
import gui.MainGUI;

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

	public static boolean endGame(ArrayList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getHand().cardCount() == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void turnManagement(Game game, JPanel pan, JTextArea text) {
		game.getPlayers().get(game.getPlayingPlayer()).pass();
		PrintDiscard.printLog(text, game);
		endTurn(game, text, pan);
		if(game.getTable(0).getDiscard().getType() != 0) {
			game.setPlayingPlayer(game.getNextPlayingPlayer());		
		}
		Management.stockManagement(game.getPlayers().get(game.getPlayingPlayer()).getHand(), game.getTable(0).getStock());	
		if(game.getPlayers().get(game.getPlayingPlayer()).getType() == 1) {
			BotManager.botCanPlay(game, pan, text);
		}
	}
	
	
	public static void turnManagement(Game game, JPanel pan, JTextArea text, Posibility pos) {
			if(endGame(game.getPlayers())) {
	
					/*
					 * On gere le score des joueurs
					 */
					//game.setPlayers(EndGame.scoreManager(game.getPlayers(), game.getPlayingPlayer()));
					
					/*
					 * On initialise une nouvelle table de jeu 
					 * comportant une pioche et un defausse
					 */
				//	game.addTable(Init.initTable());					
			//		game.setId(game.getId()+1);
					//EndGame.resetHand(game.getPlayers());
				//	EndGame.initNewHand(game.getTable(game.getId()+1).getStock(), game.getPlayers());
				
			}
			/*
			 * Si ce n'est pas la fin de la partie
			 */
			else {
				TurnManagement.lastPlayerWhoPlay(game.getPlayingPlayer());
				for(int index=0; index<pos.getList().size(); index++) {
					
					game.getTable(0).getDiscard().add(pos.getList().get(index));
					game.getPlayers().get(game.getPlayingPlayer()).getHand().remove(pos.getList().get(index).getKey());
					
				}
				
				game.getTable(0).getDiscard().setType(pos.getList().size());
				game.getTable(0).getDiscard().setLastPlaySize(pos.getList().size());
				PrintDiscard.printLog(text, game);
				PrintDiscard.printCard(pan, game.getTable(0).getDiscard());
				
				
				if(pos.getType() == 0) {
					game.getTable(0).getDiscard().setType(0);
					Management.stockManagement(game.getPlayers().get(game.getPlayingPlayer()).getHand(), game.getTable(0).getStock());
					
					if(game.getPlayers().get(game.getPlayingPlayer()).getType() == 1 ) {
						BotManager.botCanPlay(game, pan, text);
					}
				}
				else {
					endTurn(game, text, pan);
					game.setPlayingPlayer(game.getNextPlayingPlayer());
					Management.stockManagement(game.getPlayers().get(game.getPlayingPlayer()).getHand(), game.getTable(0).getStock());
					
					if(game.getPlayers().get(game.getPlayingPlayer()).getType() == 1 ) {
						BotManager.botCanPlay(game, pan, text);
					}
				}	
			}
		}		
	
public static void endTurn(Game game, JTextArea area, JPanel pan) {

		if(game.getPlayers().get(game.getPlayingPlayer()).getToPass() == 0) {
			int index=game.getPlayingPlayer();
			if(game.getPlayingPlayer() == 0) {
				index=Init.getNbPlayer()-1;
			}
			else {
				index--;
			}
			while(game.getPlayers().get(index).getToPass() != 0) {
				game.getPlayers().get(index).reset();
				if(index == 0) {
					index=Init.getNbPlayer()-1;
				}
				else {
					index--;
				}
			}
		}
		else {
			int nextPlayerPlace=game.getNextPlayingPlayer();
			int index=game.getPlayingPlayer();
			while(index != nextPlayerPlace && game.getPlayers().get(index).getToPass() != 0) {	
				if(index == 0) {
					index=Init.getNbPlayer()-1;
				}
				else {
					index--;
				}
			}
			if(index == nextPlayerPlace) {
				area.append("----------------- \n");
				area.append("reset \n");
				for(int i=0; index<Init.getNbPlayer(); index++) {
					game.getPlayers().get(i).reset();
				}
				game.setPlayingPlayer(getLastPlayerWhoPlay());
				game.getTable(0).getDiscard().setType(0);
				
			}
			
		}
	}
}
