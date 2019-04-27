package traitement;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import carte.Card;
import carte.Game;
import carte.Hand;
import carte.Possibility;
import carte.picturePath;
import gui.PanelImage;

public class PrintPlayerPossibility {
	/*
	 * La m�me class que BotManager mais pour un joueur humain
	 */
	public static void printHandPossibility(Game game, JPanel pan) {
		
		/*
		 * On creer une arrayList de possibilit� ou l'on stockera toute les possibilites du joueurs
		 */
		ArrayList<Possibility> posibility = new ArrayList<Possibility>();
		Hand hand = game.getPlayers().get(game.getPlayingPlayer()).getHand(); // On recupere sa main 

		/*
		 * Ce switch va permettre de trier les possibilit� que l'on va chercher
		 * Par exemple si le type de la d�fausse est deux 
		 * Alors on va chercher uniquement des doubles ou bien une bombe
		 */
		switch (game.getTable(game.getId()).getDiscard().getType()) {
		
		case 0:
			/*
			 * On test toutes les cartes une par une
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				// On recupere la valeur retourner par isLegit
				int val = PlayerAction.isLegit(hand.getList().get(index), game.getTable(game.getId()).getDiscard());
				/*
				 * Si la val retourn� par isLegit est 2 cela veut dire que c'est une bombe ou une combinaison de deux 
				 * Si val == 1 c'est une action valide normal
				 * Sinon les cartes sont injouables
				 */
				if (val == 2) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(0, card); //On indique que cette possibilit� de jeu mettra fin a la "manche"
					posibility.add(play);
				} else if (val == 1) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(1, card); //On indique que cette possibilit� de jeu ne mettra pas fin a la "manche"
					posibility.add(play);
				}
			}
			//S'il n'y a pas 2 carte ou plus on ne test pas les double
			if(hand.cardCount()>=2) {
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						// On recupere la valeur retourner par isLegit pour deux cartes
						int val = PlayerAction.isLegit(hand.getList().get(index), hand.getList().get(index_2),
								game.getTable(game.getId()).getDiscard());
						if (val == 1) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							Possibility play = new Possibility(1, card); //On indique que cette possibilit� de jeu ne mettra pas fin a la "manche"
							posibility.add(play);
						}
						else if (val == 2) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							Possibility play = new Possibility(0, card); //On indique que cette possibilit� de jeu mettra  fin a la "manche"
							posibility.add(play);
						}
					}
				}
			}
			//S'il n'y a pas 3 carte ou plus on ne test pas les suites de 3
			if(hand.cardCount()>=3) {
				/*
				 * Triple boucle for qui va nous permettre de tester toutes les possibilit� de suites de trois cartes
				 * On n'y cherche pas les bombes
				 */
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							card.add(hand.getList().get(index_3));
							int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
							if (val == 3) {
								Possibility play = new Possibility(1, card);
								posibility.add(play);
							}
						}
					}
				}
			}
			//S'il n'y a pas 3 carte ou plus on ne test pas les suites de 4
			if(hand.cardCount()>=4) {
				/*
				 * Quadruple boucle for qui va nous permettre de tester toutes les possibilit� de suites de trois cartes
				 * On n'y cherche pas les bombes
				 */
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
							for (int index_4 = index_3 + 1; index_4 < hand.cardCount(); index_4++) {
								ArrayList<Card> card = new ArrayList<Card>();
								card.add(hand.getList().get(index));
								card.add(hand.getList().get(index_2));
								card.add(hand.getList().get(index_3));
								card.add(hand.getList().get(index_4));
								int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
								if (val == 4) {
									Possibility play = new Possibility(1, card);
									posibility.add(play);
								}
							}
						}
					}
				}
			}
			break;
		//Si one joue des cartes une par une on cherche toute cartes qui suits celle pr�c�dante
		case 1:
			for (int index = 0; index < hand.cardCount(); index++) {
				// On recupere la valeur retourner par isLegit
				int val = PlayerAction.isLegit(hand.getList().get(index), game.getTable(game.getId()).getDiscard());
				//Si c'est un deux on indique que cette possibilit� met fin a la manche
				if (val == 2) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(0, card);
					posibility.add(play);
				//Sinon c'est une carte valide qui suit selon les r�gles
				} else if (val == 1) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(1, card);
					posibility.add(play);
				}
			}
			break;
		//Si on joue des paires
		case 2:
			/*
			 * Double boucle for qui va nous permettre de tester toutes les possibilit� de doubles
			 * On n'y cherche pas les bombes
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					// On recupere la valeur retourner par isLegit pour deux cartes
					int val = PlayerAction.isLegit(hand.getList().get(index), hand.getList().get(index_2),
							game.getTable(game.getId()).getDiscard());
					//Si c'est un double deux alors on indique que la possibilit� met fin a la manche
					if (val == 2) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						Possibility play = new Possibility(0, card);
						posibility.add(play);
					//Sinon c'est des doubles valident qui suivent les r�gles
					} else if (val == 1) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						Possibility play = new Possibility(1, card);
						posibility.add(play);
					}
				}
			}
			break;
		//Si on joue des suites de trois
		case 3:
			/*
			 * triple boucle for qui va nous permettre de tester toutes les possibilit� de suites de trois cartes
			 * On n'y cherche pas les bombes
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						card.add(hand.getList().get(index_3));
						int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
						if (val == 3) {
							Possibility play = new Possibility(1, card);
							posibility.add(play);
						}
					}
				}
			}
			break;
			//Si on joue des suites de quatre	
		case 4:
			/*
			 * Quadruple boucle for qui va nous permettre de tester toutes les possibilit� de suites de trois cartes
			 * On n'y cherche pas les bombes
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
						for (int index_4 = index_3 + 1; index_4 < hand.cardCount(); index_4++) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							card.add(hand.getList().get(index_3));
							card.add(hand.getList().get(index_4));
							int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
							if (val == 4) {
								Possibility play = new Possibility(1, card);
								posibility.add(play);
							}
						}
					}
				}
			}
		}
		/*
		 * D�sormais on cherche toute les possibilit� de bombes dans la main du joueur
		 * On cherche uniquement des bombes potentiel
		 */
		for (int index = 0; index < hand.cardCount(); index++) {
			for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
				for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					card.add(hand.getList().get(index_2));
					card.add(hand.getList().get(index_3));
					int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
					if (val == 2) {
						Possibility play = new Possibility(0, card);//On indique que la possibilit� mettre fin a la manche
						posibility.add(play);
					}
				}
			}
		}
		
		/*
		 * On initialise les variables pour possitioner les cartes
		 */
		int x=0;
		int y=0;
		
		/*
		 * On supprime tous le contenu du JPanel
		 */
		pan.removeAll();
		
		if(posibility.size()>0) {
			for(int index=0; index<posibility.size(); index++) {
				
				if(posibility.get(index).getProba()>=0) {
					
					for(int index2=0; index2<posibility.get(index).getList().size(); index2++) {
						/*
						 * On creer un PanelImage par carte
						 */
						PanelImage pI= new PanelImage();
						pI.setBounds(x, y, 97, 143); //On place l'image
						
						try {
							//On indique au panel le chemin d'acc�es a l'image de la carte
							pI.setImage(picturePath.getPicturePath(posibility.get(index).getList().get(index2).getKey()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						x=x+100;
						pan.add(pI);
					}
					y=y+143;
				}
				x=0;
			}
			/*
			 * On indique la taille du panel pour le scrollPane
			 */
			pan.setPreferredSize(new Dimension(x , y));
		}
	}
}
