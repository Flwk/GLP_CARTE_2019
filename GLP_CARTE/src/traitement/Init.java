package traitement;


import java.util.ArrayList;

import carte.Card;
import carte.Discard;
import carte.Hand;
import carte.Player;
import carte.Scoreboard;
import carte.Stock;
import carte.Table;
/**
 * 
 * @author cvericel
 */
public class Init{
	
	private  ArrayList<Player> players=new ArrayList<Player>();
	private Management management=new Management();;
	private  Stock stock=new Stock();
	private Discard discard=new Discard();
	private Table table ;
	private int nbPlayer=5;
	
	public Init() {
		ArrayList<Player> players=new ArrayList<Player>();
		Discard discard=new Discard();
		discard.setType(0);
		Stock stock=new Stock();		
	}
	
	public void launch() {
		initStock();
	}
	
	public Table initTable() {
		
		for(int i=0; i<nbPlayer; i++) {
			players.add(initPlayer(i, stock));
		}
		Table table=new Table(stock, discard, players);
		return table;
	}
	
	public Player initPlayer(int i, Stock stock) {
		Player p=new Player("Player"+i, null, null, null, 0);
		Hand h= new Hand();
		Scoreboard score=new Scoreboard(100);
		p.setScore(score);
		p.setHand(h);
		initHand(p, stock);
		return p;
	}
	
	public void initHand(Player player, Stock stock) {
		for(int i=0; i<5; i++) {
			management.stockManagement(player.getHand(), stock);
		}
	}
	
	public void initStock() {

		Card as_trefle=new Card("as de trefle", 11);
		Card as_coeur=new Card("as de coeur", 12);
		Card as_pic=new Card("as de pic", 13);
		Card as_carreaux=new Card("as de carreaux", 14);
		
		Card deux_trefle=new Card("2 de trefle", 21);
		Card deux_coeur=new Card("2 de coeur", 22);
		Card deux_pic=new Card("2 de pic", 23);
		Card deux_carreaux=new Card("2 de carreaux", 24);
		
		Card trois_trefle=new Card("3 de trefle", 31);
		Card trois_coeur=new Card("3 de coeur", 32);
		Card trois_pic=new Card("3 de pic", 33);
		Card trois_carreaux=new Card("3 de trecarreauxfle", 34);
		
		Card quatre_trefle=new Card("4", 41);
		Card quatre_coeur=new Card("4 de coeur", 42);
		Card quatre_pic=new Card("4 de pic", 43);
		Card quatre_carreaux=new Card("4 de carreaux", 44);
		
		Card cinq_trefle=new Card("5 de trefle", 51);
		Card cinq_coeur=new Card("5 de coeur", 52);
		Card cinq_pic=new Card("5 de pic", 53);
		Card cinq_carreaux=new Card("5 de carreaux", 54);
		
		Card six_trefle=new Card("6 de trefle", 61);
		Card six_coeur=new Card("6 de coeur", 62);
		Card six_pic=new Card("6 de pic", 63);
		Card six_carreaux=new Card("6 de carreaux", 64);
		
		Card sept_trefle=new Card("7 de trefle", 71);
		Card sept_coeur=new Card("7 de coeur", 72);
		Card sept_pic=new Card("7 de pic", 73);
		Card sept_carreaux=new Card("7 de carreaux", 74);
		
		Card huit_trefle=new Card("8 de trefle", 81);
		Card huit_coeur=new Card("8 de coeur", 82);
		Card huit_pic=new Card("8 de pic", 83);
		Card huit_carreaux=new Card("8 de carreaux", 84);

		Card neuf_trefle=new Card("9 de trefle", 91);
		Card neuf_coeur=new Card("9 de coeur", 92);
		Card neuf_pic=new Card("9 de pic", 93);
		Card neuf_carreaux=new Card("9 de carreaux", 94);

		Card dix_trefle=new Card("10 de trefle", 101);
		Card dix_coeur=new Card("10 de coeur", 102);
		Card dix_pic=new Card("10 de pic", 103);
		Card dix_carreaux=new Card("10 de carreaux", 104);
		
		Card valet_trefle=new Card("valet de trefle", 111);
		Card valet_coeur=new Card("valet de coeur", 112);
		Card valet_pic=new Card("valet de pic", 113);
		Card valet_carreaux=new Card("valet de carreaux", 114);
		
		Card dame_trefle=new Card("dame de trefle", 121);
		Card dame_coeur=new Card("dame de coeur", 122);
		Card dame_pic=new Card("dame de pic", 123);
		Card dame_carreaux=new Card("dame de carreaux", 124);
		
		Card roi_trefle=new Card("roi de trefle", 131);
		Card roi_coeur=new Card("roi de coeur", 132);
		Card roi_pic=new Card("roi de pic", 133);
		Card roi_carreaux=new Card("roi de carreaux", 134);
		
		Card joker_a=new Card("joker rouge", 141);
		Card joker_b=new Card("joker noir", 142);
		
		
		stock.add(as_trefle);
		stock.add(as_coeur);
		stock.add(as_pic);
		stock.add(as_carreaux);
		
		stock.add(deux_trefle);
		stock.add(deux_coeur);
		stock.add(deux_pic);
		stock.add(deux_carreaux);
		
		stock.add(trois_trefle);
		stock.add(trois_coeur);
		stock.add(trois_pic);
		stock.add(trois_carreaux);
		
		stock.add(quatre_trefle);
		stock.add(quatre_coeur);
		stock.add(quatre_pic);
		stock.add(quatre_carreaux);

		stock.add(cinq_trefle);
		stock.add(cinq_coeur);
		stock.add(cinq_pic);
		stock.add(cinq_carreaux);
		
		stock.add(six_trefle);
		stock.add(six_coeur);
		stock.add(six_pic);
		stock.add(six_carreaux);
		
		stock.add(sept_trefle);
		stock.add(sept_coeur);
		stock.add(sept_pic);
		stock.add(sept_carreaux); 
		
		stock.add(huit_trefle);
		stock.add(huit_coeur);
		stock.add(huit_pic);
		stock.add(huit_carreaux); 
		
		stock.add(neuf_trefle);
		stock.add(neuf_coeur);
		stock.add(neuf_pic);
		stock.add(neuf_carreaux); 
		
		stock.add(dix_trefle);
		stock.add(dix_coeur);
		stock.add(dix_pic);
		stock.add(dix_carreaux);
		
		stock.add(valet_trefle);
		stock.add(valet_coeur);
		stock.add(valet_pic);
		stock.add(valet_carreaux);
		
		stock.add(dame_trefle);
		stock.add(dame_coeur);
		stock.add(dame_pic);
		stock.add(dame_carreaux);
		
		stock.add(roi_trefle);
		stock.add(roi_coeur);
		stock.add(roi_pic);
		stock.add(roi_carreaux);
		
		stock.add(joker_a);
		stock.add(joker_b);
		
	}
	
	public void test() {
		table=initTable();
		System.out.println("Taille de la pioche après distribution:" + stock.size());
		//System.out.println("Nombre de joueur: \n" + table.getPlayers().toString());
		System.out.println("");
	}
	
	public Table getTable() {
		return table;
	}

	public void setNbPlayer(int nbPlayer) {
		this.nbPlayer = nbPlayer;
	}
}