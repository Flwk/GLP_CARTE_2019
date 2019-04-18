package carte;

import java.util.ArrayList;

public class Discard {
	//type 1 == 1 cartes jouées
	//.... 2 == 2 ....
	//.... 3 == 3 ....
	//....
	private int type;
	private int lastPlaySize=0;
	private int turn=1;
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
	
	public int getTurn() {
		return turn;
	}
	
	public void setTurn(int turn) {
		this.turn=turn;
	}
	
	public int getLastCardPlay() {
		int nbr=cardCount();
		if(cards.get(nbr-1).getKey() > 140) {
			if(cards.get(nbr-2).getKey() > 140) {
				return cards.get(nbr-3).getKey()+20;
			}
			else {
				return cards.get(nbr-2).getKey()+10;
			}	
		}
		else {
			return cards.get(nbr-1).getKey();
		}
	}

	public int getLastPlaySize() {
		return lastPlaySize;
	}

	public void setLastPlaySize(int lastPlaySize) {
		this.lastPlaySize = lastPlaySize;
	}
}
