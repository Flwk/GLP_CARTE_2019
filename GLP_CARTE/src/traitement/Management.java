package traitement;

import carte.Card;
import carte.Hand;
import carte.Stock;


public class Management {
		
		private Stock stock=new Stock() ;
		
		public void stockManagement(Hand hand) {
			Card card= getRandomCard();
			hand.add(card);
			deleteDiscardCard(card);
		}
		
		public Card getRandomCard() {
			double index= Math.random()*(stock.cardCount()-0);
			return stock.get((int) index);
		}
		
		public void deleteDiscardCard(Card card) {
			stock.remove(card);
		}
}
