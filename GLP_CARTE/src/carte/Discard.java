package carte;

import java.util.ArrayList;

public class Discard {
	//type 1 == 1 cartes jouées
	//.... 2 == 2 ....
	//.... 3 == 3 ....
	//....
	private int type;
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

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int typePlayed) {
		type=typePlayed;
	}
	
	public int getLastCardPlay() {
		int nbr=cardCount();
		return cards.get(nbr-1).getKey();
	}
}
