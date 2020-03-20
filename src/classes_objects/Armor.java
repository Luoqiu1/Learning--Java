package classes_objects;

public class Armor extends Item {
	int ac;
	public static void main(String[] args) {
		Armor A1=new Armor();
		Armor A2=new Armor();
		A1.name="²¼¼×";A1.ac=15;A1.price=300;
		A2.name="Ëø×Ó¼×";A2.ac=40;A2.price=500;
		int a[]=new int[4];
		//int []a
		a[3]=1;
		System.out.println(a[3]);
	}
}
