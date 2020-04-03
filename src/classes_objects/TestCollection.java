package classes_objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TestCollection {
	public static void main(String[] args) {
		List<Hero> Heros=new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Heros.add(new Hero("hero "+i));
		}
//		for (int i = 0; i < 100; i++) {
//			String s[]=Heros.get(i).toString().split(" ");
//			if(Integer.parseInt(s[1])%8==0)Heros.remove(i);
//		}
		//这样做必有风险！因为在删除项的时候，ArrayList的长度在缩小
//		而i一直在增大，没有相应的缩小！
		
//		for (int i = 0; i < Heros.size(); i++) {
//		String s[]=Heros.get(i).toString().split(" ");
//		if(Integer.parseInt(s[1])%8==0)Heros.remove(i);
//	}
		
//		Iterator<Hero> it=Heros.iterator();//得导入Iterator包
//		while(it.hasNext()) {
//			Hero h=it.next();
//			String s[]=h.toString().split(" ");
//			if(Integer.parseInt(s[1])%8==0)Heros.remove(h);
//		}
		
//		for(Iterator<Hero> it=Heros.iterator();it.hasNext();) {
//			Hero h=it.next();
//			String s[]=h.toString().split(" ");
//			if(Integer.parseInt(s[1])%8==0)Heros.remove(h);
//		}
		//以上两种迭代器删除元素方法有问题！
		//迭代器与长度不同步。迭代器是单独线程。
		
		List<Hero> deleteGo=new ArrayList<>();//准备一个保存要被删除数据的List
		for(Iterator<Hero> it=Heros.iterator();it.hasNext();) {
			Hero h=it.next();
			String s[]=h.toString().split(" ");
			if(Integer.parseInt(s[1])%8==0)deleteGo.add(h);
		}
	//	Heros.removeAll(deleteGo);
		for(Hero x:deleteGo)Heros.remove(x);
		
		for(Hero x:Heros)System.out.println(x);
		System.out.println("List的大小为："+Heros.size());
	}

}
