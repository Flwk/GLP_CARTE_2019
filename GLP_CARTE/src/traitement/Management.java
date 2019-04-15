package traitement;

import java.util.ArrayList;
import java.util.Collections;

import carte.Card;
import carte.Hand;
import carte.Stock;

public class Management {

	public static void stockManagement(Hand hand, Stock stock) {
		Card card = getRandomCard(stock);
		hand.add(card);
		deleteStockCard(card, stock);
	}

	public static Card getRandomCard(Stock stock) {
		
		double index = Math.random() * (stock.cardCount() - 0);
		return stock.getCard((int) index);
	}

	public static void deleteStockCard(Card card, Stock stock) {
		stock.remove(card);
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
