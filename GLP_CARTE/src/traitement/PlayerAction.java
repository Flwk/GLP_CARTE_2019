

package traitement;
import java.util.ArrayList;

import carte.*;




public class PlayerAction {
	private ArrayList<String> listC= new ArrayList<String>();
	private static PlayerAction instance = new PlayerAction();
	private Discard lastPlay=new Discard();
	public PlayerAction(){

}
	
	public boolean verify(ArrayList<String> listKey, Discard discard) {
		System.out.println("test");
		Discard lastPlay=discard;
		System.out.println("test1");
		switch(listKey.size()) {
		case 1:
			System.out.println("test3");
			if(isLegit(listKey.get(0))) {
				System.out.println("test3bis");
				return true;
			}
			
			break;
		case 2:
			if(isLegit(listKey.get(0), listKey.get(1))) {
				return true;
			}
			break;
		case 3:
			
			break;
		default:
		}
		return false;
	}

Boolean isLegit(String keyCard1) {
	System.out.println(lastPlay.getType());
	if(lastPlay.getType()==0) {
		System.out.println("test5");
		lastPlay.setType(1);
		return true;
	}
	else if(lastPlay.getType() == 1) { // Si c'est la premiere carte joué toute carte est accepté
			System.out.println("test5bis");
			int nbr=lastPlay.cardCount();
			int lastKey=lastPlay.getCards().get(nbr).getKey();
			if(isJoker(lastKey)) {
				lastKey=lastPlay.getCards().get(nbr).getKey()+10;
			}
			int cardPlayKey= Integer.valueOf(keyCard1);
			if(isJoker(cardPlayKey) || cardPlayKey == 21 || cardPlayKey == 22 || cardPlayKey == 23 || cardPlayKey == 24) {
				lastPlay.setType(1);
				System.out.println("testbeta");
				return true; //Si la carte est un joker ou un 2on accepte la carte
			}
			else {
				if(cardPlayKey - lastKey > 14) { // Si la carte ne suit pas on refuse
					return false;
				}
				else {
					lastPlay.setType(1);
					System.out.println("testal");
					return true;
					
				}
			}
	}
	else{
		System.out.println("test5c");
		return false;
	}
	
}
	
Boolean isLegit(String card1, String card2) {
	return true;
	
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

Boolean isDouble(ArrayList<String> ListC) {
	int i=0;
	while(i<ListC.size()) {
		if (ListC.size()<2) {
			return false;
		}
		else if (ListC.get(i) == ListC.get(i+1)) {
			return true;
		}
		i++;
	}
	return null;
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



