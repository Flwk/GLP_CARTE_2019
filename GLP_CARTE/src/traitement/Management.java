package traitement;

import java.util.ArrayList;
import java.util.Collections;

import carte.Card;
import carte.CardType;
import carte.Hand;
import carte.Stock;

public class Management {

	public static void stockManagement(Hand hand, Stock stock) {
		CardType cardType = getRandomCard(stock); //La sa resort "un type de carte" Il faut maintenant recuperer une couleur 
		Card card=getRandomCardColor(cardType);
		hand.add(card);
		deleteStockCard(cardType, card, stock);
	}

	public static CardType getRandomCard(Stock stock) {
		double index = Math.random() * (stock.cardCount() - 0);
		return stock.getCard((int) index);
	}
	
	public static Card getRandomCardColor(CardType card) {
		
		double index = Math.random() * (card.getList().size() - 0);
		return card.getList().get((int) index); 
	}


	
	
	public static void deleteStockCard(CardType cardType, Card card, Stock stock) {
		cardType.getList().remove(card);
		if(cardType.getList().size()==0) {
			stock.remove(cardType);
		}
	}

	/*
	 * méthode pour gerer la pioche fictif des joueur robots qui sert a calculer les probabilités
	 */
	public static void fictifManagement(ArrayList <Card> cardList, Stock fictif) {
		
		for(int index=0; index<cardList.size(); index++) {
			int cardKey=cardList.get(index).getKey();
			Card card=cardList.get(index);
			
			if(10 < cardKey && cardKey < 15) {		
				CardType cardType=fictif.searchByKey(10);
				deleteStockCard(cardType, card, fictif);		
			}
			else if(20 < cardKey && cardKey < 25) {		
				CardType cardType=fictif.searchByKey(20);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(30 < cardKey && cardKey < 35) {			
				CardType cardType=fictif.searchByKey(30);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(40 < cardKey && cardKey < 45) {			
				CardType cardType=fictif.searchByKey(40);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(50 < cardKey && cardKey < 55) {			
				CardType cardType=fictif.searchByKey(50);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(60 < cardKey && cardKey < 65) {			
				CardType cardType=fictif.searchByKey(60);
				deleteStockCard(cardType, card, fictif);				
			}
			else if(70 < cardKey && cardKey < 75) {			
				CardType cardType=fictif.searchByKey(70);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(80 < cardKey && cardKey < 85) {			
				CardType cardType=fictif.searchByKey(80);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(90 < cardKey && cardKey < 95) {			
				CardType cardType=fictif.searchByKey(90);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(100 < cardKey && cardKey < 105) {			
				CardType cardType=fictif.searchByKey(60);
				deleteStockCard(cardType, card, fictif);		
			}
			else if(110 < cardKey && cardKey < 115) {		
				CardType cardType=fictif.searchByKey(110);
				deleteStockCard(cardType, card, fictif);				
			}
			else if(120 < cardKey && cardKey < 125) {			
				CardType cardType=fictif.searchByKey(120);
				deleteStockCard(cardType, card, fictif);			
			}
			else if(130 < cardKey && cardKey < 135) {			
				CardType cardType=fictif.searchByKey(130);
				deleteStockCard(cardType, card, fictif);
			}
			else {	
				CardType cardType=fictif.searchByKey(140);
				deleteStockCard(cardType, card, fictif);
	
			}
		}
	}
	
	public static ArrayList<Integer> calculate(ArrayList<Card> list) {
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			keyList.add(list.get(i).getKey());
		}
		Collections.sort(keyList);
		keyList = listWithoutJoker(keyList);
		return keyList;
	}

	public static ArrayList<Integer> listWithoutJoker(ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (PlayerAction.isJoker(list.get(i))) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (Math.abs(list.get(j) - list.get(j + 1)) > 14) {
						temp.add(list.get(j) + 10);
						break;
					}
				}
			} else {
				temp.add(list.get(i));
			}
		}
		Collections.sort(temp);
		return temp;
	}
}
