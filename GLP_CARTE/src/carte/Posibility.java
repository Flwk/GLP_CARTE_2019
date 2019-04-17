package carte;

import java.util.ArrayList;

public class Posibility {
	
	ArrayList<Card> card=new ArrayList<Card>();
	int type;
	int proba;
	
	public Posibility(int type, ArrayList<Card> card) {
		this.card=card;
		this.type=type;
		this.proba=0;
	}
	
	public ArrayList<Card> getList(){
		return card;
	}
	
	public int getProba() {
		return proba;
	}
	
	public void setProba(int i) {
		proba=i;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int i) {
		type=i;
	}
}
