package carte;

import java.util.ArrayList;

public class Stock {
	private ArrayList<CardType> cards;
	
	public Stock() {
		cards=new ArrayList<CardType>();
	}
	
	public void add(CardType card) {
		cards.add(card);
	}
	
	public void remove(CardType card) {
		cards.remove(card);
	}
	
	public int cardCount() {
		return cards.size();
	}

	public CardType getCard(int index) {
		return cards.get(index);
	}
	
	public ArrayList<CardType> getStock(){
		return cards;
	}

	public int size() {
		return cards.size();
	}


}
