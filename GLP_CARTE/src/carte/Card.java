package carte;
/**
 * @author bsadiki
 */
public class Card {

	private String name;
	private Integer key;
	
	public Card(String name, Integer key) {
		this.name = name;
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "Card [name=" + name + ", key=" + key + "]";
	}

}
