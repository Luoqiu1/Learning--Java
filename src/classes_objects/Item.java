package classes_objects;

public class Item {
	int price;
	private Item() {
	}
	private static Item instance;
	public static Item getIstance() {
		if(instance==null) {
			instance=new Item();
		}
		return instance;
	}
	public static void main(String[] args) {
	//	Hero h1=new Hero();
		Hero h1=Hero.getInstance();
		h1.hp=455;
		System.out.println(h1.hp);
	}
}
