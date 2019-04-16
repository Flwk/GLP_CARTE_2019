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
