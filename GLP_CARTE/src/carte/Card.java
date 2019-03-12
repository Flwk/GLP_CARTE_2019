package carte;
/**
 * @author bsadiki
 */
public class Card {

	private String name;
	private int key;
	
	public Card(String name, int key) {
		this.name = name;
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return name;
	}
}
