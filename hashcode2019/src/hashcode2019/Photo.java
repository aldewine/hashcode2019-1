package hashcode2019;

import java.util.HashSet;
import java.util.List;

public class Photo {
	private String id;
	private HashSet<String> tags;
	private boolean isVertical;
	private boolean isUsed;
	
	public Photo(String id, boolean isVertical, HashSet<String> tags) {
		super();
		this.id = id;
		this.tags = tags;
		this.isVertical = isVertical;
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
	public boolean isVertical() {
		return isVertical;
	}
	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
}
