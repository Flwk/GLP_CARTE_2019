package carte;

import java.util.ArrayList;
/**
 * 
 * @author cvericel
 */
public class Table {
		private ArrayList<Player> players;
		private Stock stock;
		private Discard discard;
		private int type;
		
		public Table(Stock stock, Discard discard, ArrayList<Player> players){
			this.stock=stock;
			this.discard=discard;
			this.players=players;
		}
		
		public Stock getStock() {
			return stock;
		}

		public void setStock(Stock stock) {
			this.stock = stock;
		}

		public Discard getDiscard() {
			return discard;
		}

		public void setDiscard(Discard discard) {
			this.discard = discard;
		}
		
		public void addPlayers(Player card) {
			players.add(card);
		}
		
		public void removePlayers(Player player) {
			players.remove(player);
		}
		
		
		public int playersCount() {
			return players.size();
		}

		public ArrayList<Player> getPlayers() {
			return players;
		}

		public int getType() {
			return type;
		}
		
		public String toString() {
			String str="";
			str=players.toString();
			return str;
		}
		
}
