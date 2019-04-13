

package traitement;
import java.util.ArrayList;

import carte.*;




public class PlayerAction {
	private ArrayList<String> listC= new ArrayList<String>();
	private static PlayerAction instance = new PlayerAction();
	public PlayerAction(){

}
	
	public int verify(ArrayList<Card> cards, Discard discard) {
		
		switch(cards.size()) {
		case 1:
			if(isLegit(cards.get(0), discard) == 1) {
				return 1;
			}
			else if(isLegit(cards.get(0), discard) == 0) {
				return 0;
			}
			break;
		case 2:
			if(isLegit(cards.get(0), cards.get(1), discard) == 1) {
				return 1;
			}
			return 0;
		
		case 3:
			return 0;
			
		default:
			return 0;
		}
		
		return 2;
	}

public int isLegit(Card card, Discard lastPlay) {
	if(lastPlay.getType()==0) {
		lastPlay.setType(1);
		return 1;
	}
	else if(lastPlay.getType() == 1) { // Si c'est la premiere carte joué toute carte est accepté
			int nbr=lastPlay.cardCount();
			int lastKey=lastPlay.getCards().get(nbr-1).getKey();
			if(isJoker(lastKey)) {
				lastKey=lastPlay.getCards().get(nbr-2).getKey()+10;
			}
			int cardPlayKey= card.getKey();
			if(isJoker(cardPlayKey)) {
				lastPlay.setType(1);
				return 1; //Si la carte est un joker ou un 2 on accepte la carte
			}
			else if(cardPlayKey == 21 || cardPlayKey == 22 || cardPlayKey == 23 || cardPlayKey == 24){
				return 2;
			}
			else {
				int a=cardPlayKey - lastKey;
				if(Math.abs(a) > 14 || cardPlayKey - lastKey < 4) { // Si la carte ne suit pas on refuse
					return 0;
				}
				else {
					lastPlay.setType(1);
					return 1;
					
				}
			}
	}
	else{
		return 0;
	}
	
}
	
int isLegit(Card c1, Card c2, Discard lastPlay) {
	if(lastPlay.getType()==0) {
		if(isDouble(c1, c2)){
				lastPlay.setType(2);
				return 1;
		}
		return 0;
	}
	else if(lastPlay.getType()==2) {
		
		int nbr=lastPlay.cardCount();
		int lastKey=lastPlay.getCards().get(nbr-1).getKey();
		if(isJoker(lastKey)) {
			lastKey=lastPlay.getCards().get(nbr-2).getKey()+10;
		}
		
		if(c1.getKey()-20 < 5 && isDouble(c1, c2, lastKey)){
			return 2;
		}
		else {
			if(c1.getKey() == lastKey) {
				return 0;
			}
			else if(c1.getKey() - lastKey < 14 && isDouble(c1, c2, lastKey)) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	else {
		return 0;
	}
}
//isDouble pour les debuts de partie
Boolean isDouble(Card c1, Card c2) {
	int val=c1.getKey() - c2.getKey();
	if(Math.abs(val) < 4 || (isJoker(c1.getKey()) || (isJoker(c2.getKey())))){
		return true;
	}
	else {
		return false;
	}
}	
//Test si les cartes sont bien des doubles
Boolean isDouble(Card c1, Card c2, int lastKey) {
	int val=c1.getKey() - c2.getKey();
	if(Math.abs(val) < 4 || (isJoker(c1.getKey()) && (c2.getKey() - lastKey < 14) || (isJoker(c2.getKey()) && (c1.getKey() - lastKey < 14)))){
		return true;
	}
	else {
		return false;
	}
}
	
Boolean isBomb(ArrayList<String> listC) {
	int i;
	
	for (i=0;i<listC.size();i++) {
		Integer a = Integer.valueOf(listC.get(i)) - Integer.valueOf(listC.get(i+1));
		if (Math.abs(a)>3) {
			return false;
		}
	}
	return true;
}

Boolean isSuit(ArrayList<String> listC) {
	if (listC.size()<3) {
		return false;
	}
	else {
		int i=0;
		while(i<listC.size()) {
			if (Integer.valueOf(listC.get(i)) <= Integer.valueOf(listC.get(i+1))) {
				i++;
			}
			else {
				i=listC.size();
				return false;
			}
		}
		return true;
	}
}

Boolean isLegal(ArrayList<String> listC, Table table) {
	
	int size=table.getDiscard().getCards().size();
	if (listC.size()==1) {
		if (table.getDiscard().getCards().get(size).getKey() < Integer.valueOf(listC.get(0)) - 14) {
			return true;
		}
		else {
			System.out.println("Tu n'y peux rien");
			return false;
		}
	}
	else if (listC.size()==2){
		if (table.getType()==2 && table.getDiscard().getCards().get(size).getKey()< Integer.valueOf(listC.get(0)) - 14) {
			return true;
		}
	}
	else {
		return false;
	}
		return null;
	}

Boolean isJoker(int key) {
		if(key == 141 || key == 142){
			return true;
		}
		else {
			return false;
		}
	}
}



