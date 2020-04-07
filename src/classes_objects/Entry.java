package classes_objects;

public class Entry {
	public Entry(Object key,Object value) {
		super();
		this.key=key;
		this.value=value;
	}
	public Object key;
	public Object value;
	public String toString() {
		return "[key="+key+", value="+value+"]";
	}
	public boolean equals(Entry x) {
		if(x.key==key)return true;
		return false;
	}
}
