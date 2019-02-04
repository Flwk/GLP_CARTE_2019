package carte;
/**
 * 
 * @author bsadiki
 */
public class Card {

	private String name;
	private Integer key;
	private String picturePath;
	
	public Card(String name, Integer key, String picturePath) {
		this.name = name;
		this.key = key;
		this.picturePath = picturePath;
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

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}
