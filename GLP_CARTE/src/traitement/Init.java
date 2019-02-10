package traitement;


import java.util.ArrayList;

import carte.Card;
import carte.Discard;
import carte.Player;
import carte.Scoreboard;
import carte.Stock;
import carte.Table;
import management.Management;
/**
 * 
 * @author cvericel
 */
public class Init{
	
	private ArrayList<Player> players;
	Management management;
	Stock stock=new Stock();
	Discard discard=new Discard();

	public Table initTable() {
		initStock();
		for(int i=0; i<5; i++) {
			players.add(initPlayer(i));
		}
		Table table=new Table(stock, discard, players);
		return table;
	}
	
	public Player initPlayer(int i) {
		
		Player p=new Player("Player"+i, null, null, null);
		Scoreboard score=new Scoreboard(100);
		p.setScore(score);
		initHand(p);
		return p;
	}
	
	public void initHand(Player player) {
		for(int i=0; i<5; i++) {
			management.stockManagement(player.getHand());
		}
	}
	
	public void initStock() {
		Card as_trefle=new Card("as de trefle", 11, null);
		//Card as_coeur=new Card("as de coeur", 12, null);
		//Card as_pic=new Card("as de pic", 13, null);
		//Card as_carreaux=new Card("as de carreaux", 14, null);
		/* 
		 * etc ???
		 * J'ai un doute sur la méthode a utiliser
		 */
		stock.add(as_trefle);
	}
}