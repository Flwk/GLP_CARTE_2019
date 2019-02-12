package traitement;

import carte.Card;
import carte.Stock;

public class InitStock {
	private Stock stock;
	
	public InitStock(){
		Card as_trefle=new Card("as de trefle", 11, null);
		Card as_pic=new Card("as de pic",12, null);
		Card as_coeur=new Card("as de coeur", 13, null);
	}
}
