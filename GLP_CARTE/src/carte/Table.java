package carte;

import java.util.ArrayList;

public class Table {
		private ArrayList<Player> players;
		private Stock stock;
		private Discard discard;
		
		public Table(Stock stock, Discard discard){
			this.stock=stock;
			this.discard=discard;
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
		
}
