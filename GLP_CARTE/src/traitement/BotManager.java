package traitement;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import carte.Card;
import carte.Game;
import carte.Hand;
import carte.Player;
import carte.Posibility;

public class BotManager {

	public static void botCanPlay(Game game, JPanel pan, JTextArea text) {
		ArrayList<Posibility> posibility = new ArrayList<Posibility>();
		Hand hand = game.getPlayers().get(game.getPlayingPlayer()).getHand();

		switch (game.getTable(0).getDiscard().getType()) {

		case 0:
			for (int index = 0; index < hand.cardCount(); index++) {
				// On recupere la valeur retourner par isLegit
				int val = PlayerAction.isLegit(hand.getList().get(index), game.getTable(0).getDiscard());
				if (val == 2) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Posibility play = new Posibility(0, card);
					posibility.add(play);
				} else if (val == 1) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Posibility play = new Posibility(1, card);
					posibility.add(play);
				}
			}
			if(hand.cardCount()>=2) {
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						// On recupere la valeur retourner par isLegit pour deux cartes
						int val = PlayerAction.isLegit(hand.getList().get(index), hand.getList().get(index_2),
								game.getTable(0).getDiscard());
						if (val == 1) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							Posibility play = new Posibility(1, card);
							posibility.add(play);
						}
					}
				}
			}
			if(hand.cardCount()>=3) {
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							card.add(hand.getList().get(index_3));
							int val = PlayerAction.isLegit(card, game.getTable(0).getDiscard());
							if (val == 3) {
								Posibility play = new Posibility(1, card);
								posibility.add(play);
							}
						}
					}
				}
			}
			if(hand.cardCount()>=4) {
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
							for (int index_4 = index_3 + 1; index_4 < hand.cardCount(); index_4++) {
								ArrayList<Card> card = new ArrayList<Card>();
								card.add(hand.getList().get(index));
								card.add(hand.getList().get(index_2));
								card.add(hand.getList().get(index_3));
								card.add(hand.getList().get(index_4));
								int val = PlayerAction.isLegit(card, game.getTable(0).getDiscard());
								if (val == 4) {
									Posibility play = new Posibility(1, card);
									posibility.add(play);
								}
							}
						}
					}
				}
			}
			break;

		case 1:
			for (int index = 0; index < hand.cardCount(); index++) {
				// On recupere la valeur retourner par isLegit
				int val = PlayerAction.isLegit(hand.getList().get(index), game.getTable(0).getDiscard());
				if (val == 2) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Posibility play = new Posibility(0, card);
					posibility.add(play);
				} else if (val == 1) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Posibility play = new Posibility(1, card);
					posibility.add(play);
				}
			}
			break;
		case 2:
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					// On recupere la valeur retourner par isLegit pour deux cartes
					int val = PlayerAction.isLegit(hand.getList().get(index), hand.getList().get(index_2),
							game.getTable(0).getDiscard());
					if (val == 2) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						Posibility play = new Posibility(0, card);
						posibility.add(play);
					} else if (val == 1) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						Posibility play = new Posibility(1, card);
						posibility.add(play);
					}
				}
			}
			break;
		case 3:
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						card.add(hand.getList().get(index_3));
						int val = PlayerAction.isLegit(card, game.getTable(0).getDiscard());
						if (val == 3) {
							Posibility play = new Posibility(1, card);
							posibility.add(play);
						}
					}
				}
			}
			break;
		case 4:
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
						for (int index_4 = index_3 + 1; index_4 < hand.cardCount(); index_4++) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							card.add(hand.getList().get(index_3));
							card.add(hand.getList().get(index_4));
							int val = PlayerAction.isLegit(card, game.getTable(0).getDiscard());
							if (val == 4) {
								Posibility play = new Posibility(1, card);
								posibility.add(play);
							}
						}
					}
				}
			}
		}
		for (int index = 0; index < hand.cardCount(); index++) {
			for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
				for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					card.add(hand.getList().get(index_2));
					card.add(hand.getList().get(index_3));
					int val = PlayerAction.isLegit(card, game.getTable(0).getDiscard());
					if (val == 2) {
						Posibility play = new Posibility(0, card);
						posibility.add(play);
					}
				}
			}
		}
		/*
		 * Si le bot peut jouer au moins une carte	
		 */
		if(posibility.size()>0) {
			Posibility p=Probability.bestPlay(posibility, game);
			//SI LA PROBA EST SUPERIEUR A 0 
			if(p.getProba()>0) {
				TurnManagement.turnManagement(game, pan, text, p);
			}
			else {
				TurnManagement.turnManagement(game, pan, text);
			}
		}
		else {
			TurnManagement.turnManagement(game, pan, text);			
		}
	}
}
