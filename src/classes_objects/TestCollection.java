package classes_objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

public class TestCollection {
	public static int n=20;
	public static int m=3000000;
	public static int k=1000000;
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		int cnt=0;
		for(int i=0;i<k;++i) {
			Collections.shuffle(list);
			if(list.get(0)==3&&list.get(1)==1
					&&list.get(2)==4)++cnt;
		}
		System.out.println("3 1 4 ������ "+cnt+"�Σ�������"+(double)cnt/k);
	}
	private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
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
