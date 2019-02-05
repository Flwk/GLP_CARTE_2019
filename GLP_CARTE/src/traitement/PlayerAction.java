package traitement;
import java.util.ArrayList;

import carte.*;

public class PlayerAction {
	private static PlayerAction instance = new PlayerAction();
	
	private PlayerAction(){
		
	}
	
	public PlayerAction getInstance() {
		return instance;
	}
	
	Boolean isBomb(ArrayList<Card> listC) {
		int i;
		for (i=0;i<listC.size();i++) {
			int a=listC.get(i).getKey().intValue() - listC.get(i+1).getKey().intValue();
			if (Math.abs(a)>3) {
				return false;
			}
				
			}
		return true;
	}
	
	Boolean isSuit(ArrayList<Card> listC) {
		if (listC.size()<3) {
			return false;
		}
		else {
			int i=0;
			while(i<listC.size()) {
				if (listC.get(i).getKey().intValue() <= listC.get(i+1).getKey().intValue()) {
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
	
	Boolean isLegal(ArrayList<Card> listC, Table table) {
		int size=table.getDiscard().getCards().size();
		if (listC.size()==1) {
			if (table.getDiscard().getCards().get(size).getKey()< listC.get(0).getKey() - 14) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (listC.size()==2){
			if (table.getType()==2 && table.getDiscard().getCards().get(size).getKey()< listC.get(0).getKey() - 14) {
				return true;
			}
		}
		else {
				return false;
		}
		return null;
	}
}

