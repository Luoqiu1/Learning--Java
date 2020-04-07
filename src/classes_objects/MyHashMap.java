package classes_objects;
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
			//һ��ʼ�һ�����������һ�����ɷ�ɾ��
			//��Ϊ�ǻ������Ͷ�������
			//������֮��ʵ����˵��һ�д����Ǳ���Ҫ��
			//��ϸ˼��������Ϊ���������if����У�list==null
			//˵�����õ����ǿյģ�����new���¶��󲻻�ֱ����ϵ��hashMap[hash]�
			//����Ҫ�ٶ����������ã�����һ�в���ɾ������
		}
//		else {
//			((List<Entry>)hashMap[hash]).add(entry);
//		}
		//HashMap���ص���ͬһkeyֻ��һ��ֵ���������ˣ�
		//Ҫ�ж��Ƿ���Ҫ���ǣ�
		//���ظ�ֵ��Ҫɾ������
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
//			System.out.println("�����"+list.isEmpty()+" "+entry);
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
		MyHashMap hashMap=new MyHashMap();
		hashMap.put("Hero:2", "garen");
		hashMap.put("Hero:2", "garen");
		hashMap.put("Hero:2", "garen");
		hashMap.put("Hero:2387", "garen3");
		hashMap.put("Hero:5555", "garen3");
		Object s=hashMap.get("Hero:1");
		System.out.println(hashMap);
        System.out.println(hashMap.hashcode("name=hero-2387"));
        System.out.println(hashMap.hashcode("name=hero-5555"));
//        List<Integer> test=new LinkedList<>();
//        Integer i=4;
//        test.add(i);System.out.println(test+" �գ�"+test.isEmpty());
//        System.out.println(System.identityHashCode(test));
//        test.removeAll(test);System.out.println(test+" �գ�"+test.isEmpty());
//        System.out.println(System.identityHashCode(test));
//        test.add(i);System.out.println(test+" �գ�"+test.isEmpty());
//        test.add(6);System.out.println(test+" �գ�"+test.isEmpty());
//        System.out.println(System.identityHashCode(test));
	}
}
