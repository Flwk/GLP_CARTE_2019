package carte;

import java.util.ArrayList;

public class Discard {

	private ArrayList<Card> cards;
	
	public Discard() {
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
