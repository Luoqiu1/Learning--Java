package classes_objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

public class TestCollection {
	public static int n=20;
	public static int m=3000000;
	public static void main(String[] args) {
//		List<Integer> list=new ArrayList<>();
//		for(int i=0;i<n;++i) {
//			list.add((int)(Math.random()*40000));
//		}
//		List<Integer> listCopy=new ArrayList<>(list);
////		System.out.println(list);
////		System.out.println(listCopy);
//		List<Integer> listCopy2=new ArrayList<>(list);
//		System.out.println(listCopy);
//		System.out.println(listCopy2);
//		System.out.println(list);	
//		listCopy2=binarySort(listCopy2);
//	//	binarySort(listCopy2);
//		bubbleSort(list);
////		System.out.println(list);
////		System.out.println(listCopy);
//		selectionSort(listCopy);
////		System.out.println(list);
//		System.out.println("�Ƚ�ѡ�񷨸�ð�ݷ������Ƿ���ͬ��"+list.equals(listCopy));
//		System.out.println("�Ƚ�ѡ�񷨸������������Ƿ���ͬ��"+listCopy.equals(listCopy2));
//		System.out.println("ѡ�񷨣�"+listCopy);
//		System.out.println("����������"+listCopy2);
//		System.out.println("ð�ݷ���"+list);	
		
		List<Hero> lst=new ArrayList<>();
		for(int i=0;i<m;++i) {
		//	lst.add(new Hero("Hero-"+(int)(Math.random())*9000+1000));
			//�ݰ�������ϸһ�㡣������ȵĻ��ͷ�����������
			//����̫�����׿�����
			//����ע�������ʵ���Ǻ����1000��...
			//(int)(Math.random())*9000��������0������
			lst.add(new Hero("Hero-"+(int)(Math.random()*9000+1000)));
		}
		HashMap<String,List<Hero>> hashmap=new HashMap<>();
//		List<Hero> hee=hashmap.get("ss");
//		if(hee==null)System.out.println("yesss");
		for(Hero h:lst) {
			List<Hero> hs=hashmap.get(h.name);
			if(hs==null) {
				hs=new ArrayList<>();
				hashmap.put(h.name,hs);
			}
			hs.add(h);
		}
		List<Hero> h1=//hashmap.get("Hero-5555");
		searchHashMap(hashmap,"Hero-5555");
		List<Hero> h2=
		searchNotHashMap(lst,"Hero-5555");
		System.out.println("��С��"+h1.size());
		System.out.println("��С��"+h2.size());
		System.out.println("�������õ�����Ƿ���ͬ��"+(h2.equals(h1)));
	//	System.out.println(h1);System.out.println(h2);
		
	}
	public static List<Hero> searchHashMap(HashMap<String,List<Hero>> hm,String name) {
		List<Hero> hs;
		long ss1=System.currentTimeMillis();
		hs=hm.get(name);
		long ss2=System.currentTimeMillis();
		System.out.printf("��ϣ���ѣ�%dss%n",ss2-ss1);
		return hs;
	}
	public static List<Hero> searchNotHashMap(List<Hero> list,String name) {
		List<Hero> hs=new ArrayList<>();
		long ss1=System.currentTimeMillis();
		for(Hero h:list) {
		//	if(h.name=="Hero-5555")hs.add(h);
			//��ô��������������......==��equals��
			if(h.name.equals(name))hs.add(h);
		}
		long ss2=System.currentTimeMillis();
		System.out.printf("�������ѣ�%dss%n",ss2-ss1);
		return hs;
	}
	public static void searchNotHasMap(List<Integer> list) {
		
	}
	public static void bubbleSort(List<Integer> list) {
	//	List<int> list=new ArrayList<>();
		//����ֻ�ܴ����������ͣ�8�ֻ������ͱ������ʵ��ֵ������ʹ�ã�
		
//		for(int x:list)System.out.println(x);
		long ss1=System.currentTimeMillis();
		for(int i=0;i<n-1;++i) {
		//	for(int j=i;j<n-1-i;++j)
			//ð�ݻ�û���������𡣡���
			//ð�ݣ����������������򷽷��Ĵ�
			//��������һ����һ��������ȥ
			//�����С�����������
			//�������Ǵ���ͣ�����0����ʼ��
			
			//ѡ�񷨲���j=i��ʼ��
			for(int j=0;j<n-1-i;++j) {
				if(list.get(j)>list.get(j+1)) {
					int mid=list.get(j);
					list.set(j, list.get(j+1));
				//	list.set(list.get(j+1), mid);
					//������ʲô������������
					//��һ�����������ꡣ������ô�㵽ֵȥ��
					list.set(j+1, mid);
					
				}
			}
		}
		long ss2=System.currentTimeMillis();
		System.out.println(ss2-ss1);
//		System.out.println();
	//	for(int x:list)System.out.println(x);
	}
	public static void selectionSort(List<Integer> list) {
		long ss1=System.currentTimeMillis();
		for(int i=0;i<n-1;++i) {
		//	for(int j=i;j<n-1;++j) {
			//ѡ���ǣ�ѡ��iΪĳһ��Ҫȷ����Ԫ��λ�ã�
			//��ͬ��ð�ݷ���ð�ݷ���i��ȷ���ܹ���ѭ��������
			//ȫ������j�������С�Ƚϣ�
			//��ѡ����i,jһ���������С�Ƚϣ�
			//ѡ��һ��λ��i�������е���i�����j�ҵ�����������λ�ý�����
//				if(list.get(j)>list.get(j+1)) {
//					int mid=list.get(j);
//					list.set(j, list.get(j+1));
//					list.set(j+1, mid);
//				}
			for(int j=i+1;j<n;++j) {
				if(list.get(i)>list.get(j)) {
					int mid=list.get(j);
					list.set(j, list.get(i));
					list.set(i, mid);
				}
			}
		}
		long ss2=System.currentTimeMillis();
		System.out.println(ss2-ss1);
	}
	public static List<Integer> binarySort(List<Integer> list) {
		long ss1=System.currentTimeMillis();
		Node tree=new Node();
		for(int x:list)tree.add(x);
		list=tree.dataMidGo();
		System.out.println();
		System.out.println(tree.dataMidGo());
		System.out.println(list);
		System.out.println();
		long ss2=System.currentTimeMillis();
		System.out.println(ss2-ss1);
		return list;
	}
}
