package carte;

import java.util.ArrayList;

public class Posibility {
	
	ArrayList<Card> card=new ArrayList<Card>();
	int type;
	
	public Posibility(int type, ArrayList<Card> card) {
		this.card=card;
		this.type=type;
	}
	
	public ArrayList<Card> getList(){
		return card;
	}
}
