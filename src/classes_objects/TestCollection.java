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
		//���������з��գ���Ϊ��ɾ�����ʱ��ArrayList�ĳ�������С
//		��iһֱ������û����Ӧ����С��
		
//		for (int i = 0; i < Heros.size(); i++) {
//		String s[]=Heros.get(i).toString().split(" ");
//		if(Integer.parseInt(s[1])%8==0)Heros.remove(i);
//	}
		
//		Iterator<Hero> it=Heros.iterator();//�õ���Iterator��
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
		//�������ֵ�����ɾ��Ԫ�ط��������⣡
		//�������볤�Ȳ�ͬ�����������ǵ����̡߳�
		
		List<Hero> deleteGo=new ArrayList<>();//׼��һ������Ҫ��ɾ�����ݵ�List
		for(Iterator<Hero> it=Heros.iterator();it.hasNext();) {
			Hero h=it.next();
			String s[]=h.toString().split(" ");
			if(Integer.parseInt(s[1])%8==0)deleteGo.add(h);
		}
	//	Heros.removeAll(deleteGo);
		for(Hero x:deleteGo)Heros.remove(x);
		
		for(Hero x:Heros)System.out.println(x);
		System.out.println("List�Ĵ�СΪ��"+Heros.size());
	}

}
