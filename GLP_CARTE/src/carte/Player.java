package carte;
/**
 * 
 * @author cvericel
 */
public class Player {
		
	private String username;
	private Scoreboard score;
	private Hand hand= new Hand();
	private String type;
	
	public Player(String username, Scoreboard score, Hand hand, String type) {
		this.username=username;
		this.score=score;
		this.hand=hand;
		this.type=type;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Scoreboard getScore() {
		return score;
	}

	public void setScore(Scoreboard score) {
		this.score = score;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		String str="\n";
		str= getUsername() + "\n "+" nombre de carte: " + hand.cardCount()+ "\n" + getHand()  +"\n\n";
		return str;
	}
}
