package personal.chencs.learn.domain;

public class SalesVolume {
	
	private String category;
	private int volume;
	
	public SalesVolume(String category, int volume) {
		super();
		this.category = category;
		this.volume = volume;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	

}
