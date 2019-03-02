package hashcode2019;

import java.util.HashSet;

public class Slide {
	private String id;
	private HashSet<String> tags;
	private int rValue;
	private boolean isUsed;
	
	public Slide(String id, HashSet<String> tags) {
		super();
		this.id = id;
		this.tags = tags;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashSet<String> getTags() {
		return tags;
	}

	public void setTags(HashSet<String> tags) {
		this.tags = tags;
	}

	public int getrValue() {
		return rValue;
	}

	public void setrValue(int rValue) {
		this.rValue = rValue;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
}
