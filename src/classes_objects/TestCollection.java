package classes_objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TestCollection {
	public static int n=20;
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;++i) {
			list.add((int)(Math.random()*40000));
		}
		List<Integer> listCopy=new ArrayList<>(list);
//		System.out.println(list);
//		System.out.println(listCopy);
		List<Integer> listCopy2=new ArrayList<>(list);
		System.out.println(listCopy);
		System.out.println(listCopy2);
		System.out.println(list);	
		listCopy2=binarySort(listCopy2);
	//	binarySort(listCopy2);
		bubbleSort(list);
//		System.out.println(list);
//		System.out.println(listCopy);
		selectionSort(listCopy);
//		System.out.println(list);
		System.out.println("�Ƚ�ѡ�񷨸�ð�ݷ������Ƿ���ͬ��"+list.equals(listCopy));
		System.out.println("�Ƚ�ѡ�񷨸������������Ƿ���ͬ��"+listCopy.equals(listCopy2));
		System.out.println("ѡ�񷨣�"+listCopy);
		System.out.println("����������"+listCopy2);
		System.out.println("ð�ݷ���"+list);	
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
