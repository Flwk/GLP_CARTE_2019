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
		
		public void remove(int key) {
			int i;
			for(i=0;i<cards.size();i++) {
				if(cards.get(i).getKey()==key) {
					cards.remove(i);
				}
			}
		}
		
		public int cardCount() {
			return cards.size();
		}
		
		public String toString() {
			String str="";
			str=cards.toString();
			return str;
		}
		
		public int getCardKey (int index) {
			return cards.get(index).getKey();
		}
}
