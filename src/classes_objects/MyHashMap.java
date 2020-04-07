package classes_objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap implements IHashMap {
	private static Object hashMap[]=new Object[2000];
	public void put(String key, Object object) {
		int hash=hashcode(key);
		Entry entry=new Entry(key,object);
		List<Entry> list=(List<Entry>)hashMap[hash];
		if(list==null) {
			list=new LinkedList<>();
			list.add(entry);
			hashMap[hash]=list;
			//一开始我还在想上面这一行语句可否删除
			//因为非基本类型都是引用
			//但测试之后，实际来说上一行代码是必须要的
			//仔细思考后是因为，进入这个if语句中，list==null
			//说明引用到的是空的！所以new的新对象不会直接联系到hashMap[hash]里！
			//必须要再对其重新引用（即这一行不能删除！）
		}
//		else {
//			((List<Entry>)hashMap[hash]).add(entry);
//		}
		//HashMap的特点是同一key只有一个值！这点别忘了！
		//要判断是否需要覆盖！
		//有重复值需要删除掉！
		else {
			boolean flag=true;
			for(Entry x:list) {
				if(x.equals(entry)) {
					System.out.println(entry+" "+x);
					list.remove(x);
					list.add(entry);
					flag=false;
					break;
				}
			}
//			System.out.println("表空吗？"+list.isEmpty()+" "+entry);
			if(flag)list.add(entry);;
		}
	}
	public Object get(String key) {
		int hash=hashcode(key);
		if(hashMap[hash]==null)return null;
		else {
			List<Entry> list=((List<Entry>)hashMap[hash]);
			for(Entry x:list) {
				if(x.key.equals(key))return x.value;
			}
			return null;
		}
	}
	public String toString() {
		List<Entry> list=new LinkedList<>();
		for(Object lst:hashMap) {
			List<Entry> x=(List<Entry>)lst;
			if(x!=null) {
				for(Entry y:x) {
					list.add(y);
				}
			}
		}
		return list.toString();
	}
	private static int hashcode(String s) {
		if(s.length()==0)return 0;
		char str[]=s.toCharArray();
		int k=0;
		for(char c:str) {
			k+=c;
		}
		return k<0?-k*23%2000:k*23%2000;
	}
	public static void main(String[] args) {
//		MyHashMap hashMap=new MyHashMap();
//		hashMap.put("Hero:2", "garen");
//		hashMap.put("Hero:2", "garen");
//		hashMap.put("Hero:2", "garen");
//		hashMap.put("Hero:2387", "garen3");
//		hashMap.put("Hero:5555", "garen3");
//		Object s=hashMap.get("Hero:1");
//		System.out.println(hashMap);
//        System.out.println(hashMap.hashcode("name=hero-2387"));
//        System.out.println(hashMap.hashcode("name=hero-5555"));
////        List<Integer> test=new LinkedList<>();
////        Integer i=4;
////        test.add(i);System.out.println(test+" 空？"+test.isEmpty());
////        System.out.println(System.identityHashCode(test));
////        test.removeAll(test);System.out.println(test+" 空？"+test.isEmpty());
////        System.out.println(System.identityHashCode(test));
////        test.add(i);System.out.println(test+" 空？"+test.isEmpty());
////        test.add(6);System.out.println(test+" 空？"+test.isEmpty());
////        System.out.println(System.identityHashCode(test));
		MyHashMap heros=new MyHashMap();
		List<Hero> hs=new ArrayList<Hero>();
		for(int i=0;i<100000;++i) {
			hs.add(new Hero("hero-"+random()));
		}
		for(Hero h:hs) {
			List<Hero> Heros=(List<Hero>)heros.get(h.name);
			if(Heros==null) {
				Heros=new ArrayList<>();
				heros.put(h.name, Heros);
				//上面两行同样不能够交换顺序！
				//参见17行注释！
			}
			Heros.add(h);
			
		}
		System.out.println(searchHashMap(heros,"hero-5555"));
		System.out.println(searchNotHashMap(hs,"hero-5555"));
	}
	public static String random() {
		return String.valueOf((int)(Math.random()*10000));
	}
	public static List<Hero> searchHashMap(MyHashMap hm,String name) {
		List<Hero> hs;
		long ss1=System.currentTimeMillis();
		hs=(List<Hero>)hm.get(name);
		long ss2=System.currentTimeMillis();
		System.out.printf("哈希表花费：%dss%n",ss2-ss1);
		return hs;
	}
	public static List<Hero> searchNotHashMap(List<Hero> list,String name) {
		List<Hero> hs=new ArrayList<>();
		long ss1=System.currentTimeMillis();
		for(Hero h:list) {
		//	if(h.name=="Hero-5555")hs.add(h);
			//怎么又是这个经典错误......==与equals！
			if(h.name.equals(name))hs.add(h);
		}
		long ss2=System.currentTimeMillis();
		System.out.printf("迭代花费：%dss%n",ss2-ss1);
		return hs;
	}
}
