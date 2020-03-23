package classes_objects;

public abstract class Item {
	int price;
	String name;
	public abstract boolean disposable();
	public Item() {
	}
	public Item(int a) {
		price=a;
	}
	public void Print() {
		System.out.println("���Կ�Ŷ");
	}
	private static Item instance;
	public static Item getIstance() {
		if(instance==null) {
			instance=new Item();
		}
		return instance;
	}
	public String toString() {
		return name+price;
	}
	public void finalize() {
		System.out.println("��ǰ�������ڱ�����");
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
		System.out.println(i1.disposable());
		
	}
}
