package classes_objects;
import java.util.ArrayList;

public class TestCollection {
	public static void main(String[] args) {
		ArrayList Heros=new ArrayList();
		Heros.add(new Hero("garen"));
		int i=3;
		String s=new String("呃呃");
	//	Heros.add(new Hero("呃呃"));
		Heros.add(s);
	//	int j=3;
		System.out.println("是否相同："+Heros.contains(new String("呃呃")));
	//	System.out.println("是否相同："+Heros.contains(new Hero("呃呃")));
	//	System.out.println("是否相同："+Heros.contains(j));
		Heros.add(i);
		Heros.add(new String("Hello!"));
		Heros.add(2,new String("哦牛"));
		System.out.println(Heros.toString());
	}
	
}
