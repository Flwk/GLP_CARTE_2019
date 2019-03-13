package carte;

public class JokerCard extends Card {

	
	private String name;
	private Integer key;
	private String picturePath;
	public JokerCard(String name, Integer key, String picturePath) {
		super(name, key);
		// TODO Auto-generated constructor stub
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
