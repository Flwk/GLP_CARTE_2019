package carte;

import java.util.ArrayList;

public class Stock {
	private ArrayList<Card> cards;
	
	public Stock() {
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

	public Card getCard(int index) {
		return cards.get(index);
	}

	public int size() {
		// TODO Auto-generated method stub
		return cards.size();
	}


}
