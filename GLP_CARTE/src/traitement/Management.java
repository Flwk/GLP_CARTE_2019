package traitement;

import carte.Card;
import carte.Hand;
import carte.Stock;


public class Management {
		
		
		public Management() {
			
		}
		
		public void stockManagement(Hand hand, Stock stock) {
			Card card= getRandomCard(stock);
			hand.add(card);
			deleteDiscardCard(card, stock);
		}
		
		public Card getRandomCard(Stock stock) {
			double index= Math.random()*(stock.cardCount()-0);
			return stock.getCard((int) index);
		}
		
		public void deleteDiscardCard(Card card, Stock stock) {
			stock.remove(card);
		}
}
