package traitement;

import java.util.ArrayList;

import carte.Card;
import carte.CardType;
import carte.Game;
import carte.Posibility;
import carte.Stock;

public class Probability {
	static int proba = 0;
	static Game game;
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

	public static Posibility bestPlay(ArrayList<Posibility> posibility, Game gamee, int playerIdd) {

		playerId = playerIdd;
		game = gamee;

		/*
		 * On prepare la liste des cartes pas encore presente dans la defausse On y
		 * retire également les cartes comprisent dans la main du robot
		 */
		fictif = game.getTable(0).getStock();
		Management.fictifManagement(game.getPlayers().get(playerId).getHand().getList(), fictif);
		Management.fictifManagement(game.getTable(0).getDiscard().getCards(), fictif);

		/*
		 * On calcule le nombre de deux présent en jeu ainsi que le nombre de bombe
		 * possible On les initialises a 0
		 */
		nbrOfBombPossibility = 0;
		nbrOfTwo = 0;
		nbrOfJoker=0;
		for (int index = 0; index < fictif.size(); index++) {
			if (fictif.getCard(index).getKey() == 20) {
				for (int j = 0; j < fictif.getCard(index).getList().size(); j++) {
					nbrOfTwo++;
				}
			} 
			else if(fictif.getCard(index).getKey() == 140) {
				nbrOfJoker++;
			}	
			else {
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
			calculateRisk(posibility.get(index), posibility.size());
		}
		int posibilityPlace = 0;
		int minProba=posibility.get(posibilityPlace).getProba();
		
		/*
		 * Boucle pour recuperer la meilleur option possible
		 * Si deux option on la même valeur alors on en tire une au hasard
		 */
		for (int index = 0; index < posibility.size(); index++) {
			
			if (posibility.get(posibilityPlace).getProba() > posibility.get(index).getProba() && index !=0) {
				posibilityPlace=index;
			}
			else if(posibility.get(posibilityPlace).getProba() == posibility.get(index).getProba() && index !=0) {
				if(Math.random()*(1-0) == 1) {
					posibilityPlace=index;
				}
			}
		}
		return posibility.get(posibilityPlace);
	}

	public static void calculateRisk(Posibility posibility, int size) {
		calculateProba(game.getTable(0).getDiscard().getType(), size, posibility);
		posibility.setProba(proba);
		proba = 0;
	}

	/*
	 * @param int i | i represente le type de jeu en cours | 0 étant une fin de
	 * manche
	 */
	public static void calculateProba(int i, int size, Posibility posibility) {

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
							CardType nbr=fictif.searchByKey(key+10);
							for(int index=0; index<nbr.getList().size(); index++) {
								proba++;
							}
						} else {
							proba = 3;
						}

						if (nbrOfTwo > 2) {
							proba = proba * 2;
						}
						
						if(nbrOfJoker > 1) {
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
			System.out.println("pas encore pret");
		}
	}

}
