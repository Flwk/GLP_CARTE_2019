package carte;

public class NormalCard extends Card {

	private String name;
	private Integer key;
	private String picturePath;
	public NormalCard(String name, Integer key, String picturePath) {
		super(name, key, picturePath);
		// TODO Auto-generated constructor stub
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
