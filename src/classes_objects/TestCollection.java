package classes_objects;
import java.util.ArrayList;

public class TestCollection {
	public static void main(String[] args) {
		ArrayList Heros=new ArrayList();
		Heros.add(new Hero("garen"));
		int i=3;
		String s=new String("����");
	//	Heros.add(new Hero("����"));
		Heros.add(s);
	//	int j=3;
		System.out.println("�Ƿ���ͬ��"+Heros.contains(new String("����")));
	//	System.out.println("�Ƿ���ͬ��"+Heros.contains(new Hero("����")));
	//	System.out.println("�Ƿ���ͬ��"+Heros.contains(j));
		Heros.add(i);
		Heros.add(new String("Hello!"));
		Heros.add(2,new String("Ŷţ"));
		System.out.println(Heros.toString());
	}
	
}
