package carte;

import java.util.ArrayList;

public class Game {
	ArrayList<Table> game;
	ArrayList<Player> players;
	int id;
	
	public Game(Table table, ArrayList<Player> players) {
		game=new ArrayList<Table>();
		addTable(table);
		this.players=players;
	}

	public void addTable(Table table) {
		game.add(table);
	}

	public Table getTable(int i) {
		return game.get(i);
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
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public int tableCount() {
		return game.size();
	}
	
	public void setId(int i) {
		id=i;
	}
	
	public int getId() {
		return id;
	}
}
