package carte;
import java.util.ArrayList;

/**
 * 
 * @author cvericel
 */

public class Hand {
		private ArrayList<Card> cards;
		
		public Hand() {
			cards=new ArrayList<Card>();
		}
		
		public void add(Card card) {
			cards.add(card);
		}
		
		public void remove(Card card) {
			cards.remove(card);
		}
		
		public int cardCount() {
			return cards.size();
		}
}
