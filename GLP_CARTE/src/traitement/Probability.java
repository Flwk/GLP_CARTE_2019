package traitement;

import java.util.ArrayList;


import carte.CardType;
import carte.Game;
import carte.Posibility;
import carte.Stock;

public class Probability {
	static int proba = 0;
	static int playerId;
	static Stock fictif = new Stock();
	static int nbrOfBombPossibility;
	static int nbrOfTwo;
	static int nbrOfJoker;
	/*
	 * J'envoie un arrayList de Posibility posibility a une arraylist de carte
	 * pouvant être joue et un type un type =1 la partie continue si c'est un type =
	 * 0 la partie s'arrete genre c'est une bombe ou un deux qui est posé
	 */

	public static Posibility bestPlay(ArrayList<Posibility> posibility, Game game) {

		playerId = game.getPlayingPlayer();
		/*
		 * On prepare la liste des cartes pas encore presente dans la defausse On y
		 * retire également les cartes comprisent dans la main du robot
		 */
		fictif = Init.initStock();
		Management.fictifManagement(game.getPlayers().get(playerId).getHand().getList(), fictif);
		Management.fictifManagement(game.getTable(0).getDiscard().getCards(), fictif);

		/*
		 * On calcule le nombre de deux présent en jeu ainsi que le nombre de bombe
		 * possible On les initialises a 0
		 */
		nbrOfBombPossibility = 0;
		nbrOfTwo = 0;
		nbrOfJoker = 0;
		for (int index = 0; index < fictif.size(); index++) {
			if (fictif.getCard(index).getKey() == 20) {
				for (int j = 0; j < fictif.getCard(index).getList().size(); j++) {
					nbrOfTwo++;
				}
			} else if (fictif.getCard(index).getKey() == 140) {
				nbrOfJoker++;
			} else {
				if (fictif.getCard(index).getList().size() > 3) {
					nbrOfBombPossibility = nbrOfBombPossibility + 2;
				} else if (fictif.getCard(index).getList().size() > 2) {
					nbrOfBombPossibility++;
				}
			}
		}

		/*
		 * On cherche quelle est la meilleur option a joué pour le robot
		 */
		for (int index = 0; index < posibility.size(); index++) {
			calculateRisk(posibility.get(index), posibility.size(), game);
		}
		int posibilityPlace = 0;

		/*
		 * Boucle pour recuperer la meilleur option possible Si deux option on la même
		 * valeur alors on en tire une au hasard
		 */
		for (int index = 0; index < posibility.size(); index++) {

			if (posibility.get(posibilityPlace).getProba() > posibility.get(index).getProba() && index != 0) {
				posibilityPlace = index;
			} else if (posibility.get(posibilityPlace).getProba() == posibility.get(index).getProba() && index != 0) {
				if (Math.random() * (1 - 0) == 1) {
					posibilityPlace = index;
				}
			}
		}
		return posibility.get(posibilityPlace);
	}

	public static void calculateRisk(Posibility posibility, int size, Game game) {
		calculateProba(game.getTable(0).getDiscard().getType(), size, posibility, game);
		posibility.setProba(proba);
		proba = 0;
	}

	/*
	 * @param int i | i represente le type de jeu en cours | 0 étant une fin de
	 * manche
	 */
	public static void calculateProba(int i, int size, Posibility posibility, Game game) {

		if (i == 0) {
			if (posibility.getType() == 0) {
				proba = 100;
			} else {
				// Le robot n'a qu'une seul option donc il la joue
				if (size < 2) {
					proba = 1;
				} else {
					/*
					 * Maintenant on cherche la meilleur option parmis la liste
					 */
					switch (posibility.getList().size()) {
					case 1:
						proba = 10;
						int key = posibility.getList().get(0).getKey();

						// On arrondi la clef pour obtenir un multiple de 10 pour faciliter la recherche

						key = key / 10;
						key = (int) Math.round((double) key);
						key = key * 10;

						if (fictif.keyCardExist(key + 10)) {
							CardType nbr = fictif.searchByKey(key + 10);
							for (int index = 0; index < nbr.getList().size(); index++) {
								proba++;
							}
						} else {
							proba = 3;
						}

						if (nbrOfTwo > 2) {
							proba = proba * 2;
						}

						if (nbrOfJoker > 1) {
							proba = proba * 2;
						}
						break;

					case 2:
						proba = 5;
						for (int index = 0; index < posibility.getList().size(); index++) {
							if (posibility.getList().get(index).getKey() > 140) {
								proba = proba + 6;
							}
						}
						break;
					case 3:
						proba = 2;
						for (int index = 0; index < posibility.getList().size(); index++) {
							if (posibility.getList().get(index).getKey() > 140) {
								proba++;
							}
						}
						break;
					case 4:
						proba = 1;
						for (int index = 0; index < posibility.getList().size(); index++) {
							if (posibility.getList().get(index).getKey() > 140) {
								proba = proba + 2;
							}
						}
						break;
					}
				}
			}
		} else {
			
			/*
			 * Ici on gere les possibilité qui font recuperer la main
			 */
			if (posibility.getType() == 0) {
				/*
				 * On incremente la proba selon le nombre de deux present dans la partie
				 */
				switch (nbrOfTwo) {
				case 1:
					if (i == 1) {
						proba = proba + 10;
					} else {
						proba = proba + 20;
					}
				case 2:
					if (i == 1) {
						proba = proba + 8;
					} else if (i == 2) {
						proba = proba + 10;
					}

				case 3:
					if (i == 1) {
						proba = proba + 5;
					} else if (i == 2) {
						proba = proba + 8;
					}
				case 4:
					if (i == 1) {
						proba = proba + 2;
					} else if (i == 2) {
						proba = proba + 5;
					}

				}

				/*
				 * Selon le nombre de bombe encore disponible en jeu on incremente l'action
				 */
				if (nbrOfBombPossibility < 5) {
					proba = proba + 10;
				}

				/*
				 * Si c'est notre seul choix on joue que si un joueur potentiel peut avoir la carte d'aprés celle joue le tour d'avant
				 * Pour cela on recupere la clef de la derniere carte joué
				 */
				if(size == 1) {
					int lastKeyPlay=game.getTable(0).getDiscard().getLastCardPlay();
					lastKeyPlay = lastKeyPlay / 10;
					lastKeyPlay = (int) Math.round((double) lastKeyPlay);
					lastKeyPlay = lastKeyPlay * 10;
					if (fictif.keyCardExist(lastKeyPlay)) {
						CardType nbr = fictif.searchByKey(lastKeyPlay + 10);
						if(nbr.getList().size()>2) {
							proba=0;
						}
						else {
							proba=-1;
						}
					}
				}
				/*
				 * Si un joueur a deux carte ou moins on joue notre bombe ou deux automatiquent
				 */
				for (int index = 0; index < game.getPlayers().size(); index++) {
					if (index != playerId) {
						if (game.getPlayers().get(index).getHand().cardCount() <= 2) {
							proba = 0;
							break;
						} 
					}
				}
			} else {

				/*
				 * Maintenant on cherche la meilleur option parmis la liste plusieurs option apres lesquelles le jeu continue
				 */
				switch (posibility.getList().size()) {
				case 1:
					proba = 10;
					int key = posibility.getList().get(0).getKey();

					// On arrondi la clef pour obtenir un multiple de 10 pour faciliter la recherche

					key = key / 10;
					key = (int) Math.round((double) key);
					key = key * 10;

					//On recherche si la carte qui suit existe et s'il elle exite pas on reduit la proba
					if (fictif.keyCardExist(key + 10)) {
						CardType nbr = fictif.searchByKey(key + 10);
						for (int index = 0; index < nbr.getList().size(); index++) {
							proba=proba+5;
						}
					} else {
						proba = 3;
					}

					if (nbrOfTwo > 2) {
						proba = proba * 2;
					}

					if (nbrOfJoker > 1) {
						proba = proba * 2;
					}
					break;

				case 2:
					proba = 5;
					for (int index = 0; index < posibility.getList().size(); index++) {
						if (posibility.getList().get(index).getKey() > 140) {
							proba = proba + 6;
						}
					}
					if(nbrOfBombPossibility >5) {
						proba=proba+5;
					}
					break;
				case 3:
					proba = 2;
					for (int index = 0; index < posibility.getList().size(); index++) {
						if (posibility.getList().get(index).getKey() > 140) {
							proba++;
						}
					}
					break;
				case 4:
					proba = 1;
					for (int index = 0; index < posibility.getList().size(); index++) {
						if (posibility.getList().get(index).getKey() > 140) {
							proba = proba + 2;
						}
					}
					break;
				}
			}
		}

	}
}
