package classes_objects;

//public abstract class Item implements LOL {
public class Item implements LOL,Comparable<Item> {
	int price;
	String name;
//	public abstract boolean disposable();
	public int compareTo(Item i) {
		if(price>i.price)return -1;
		return 1;
	}
	public Item() {
	}
	public Item(String s,int a) {
		name=s;price=a;
	}
	public Item(String s) {
		name=s;
	}
	public Item(int a) {
		price=a;
	}
	public void Print() {
		System.out.println("试试看哦");
	}
	public String toString() {
		return name+" price:"+price;
	}
	//private static Item instance;
//	public static Item getIstance() {
//		if(instance==null) {
//			instance=new Item();
//		}
//		return instance;
//	}
	public void finalize() {
		System.out.println("当前对象正在被回收");
	}
	public boolean equals(Object o) {
		if(o instanceof Item) {
			if(((Item) o).price==price)return true;
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
	//	Hero h1=new Hero();
	//	Hero h1=Hero.getInstance();
	//	h1.hp=455;
	//	System.out.println(h1.hp);
	
	//	Item i1=new Item();
		
		Item i1=new Item() {
			public boolean disposable() {
				return true;
			}
		};
//		System.out.println(i1.disposable());
		
	}
}