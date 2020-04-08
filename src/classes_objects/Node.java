package classes_objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Node<T extends Comparable<T>> {
	public Node<T> leftNode;
	public Node<T> rightNode;
	public T value;
	public Node() {
	}
	public Node(T v) {
		value=v;
	}
	public void add(T v) {
		if(value==null) {
			value=v;
		}
		else {
			
		//	if((double)v-(double)value<=0) {
			if(v.compareTo(value)<=0) {
				if(leftNode==null) {
					leftNode=new Node<>();
					//����Ҳ������ֱ�ӹ���new Node(v);
					//������һ��Ҫ��һ�εݹ���ȥ���Ҵ��������
					//�͵÷���else����
					// if(leftNode==null) leftNode=new Node(v);
					// else leftNode.add(v)
					//���ַ������ɡ�
				}
				
					leftNode.add(v);
				
			}
			else {
				if(rightNode==null) {
					rightNode=new Node<>();
				}
				
					rightNode.add(v);
				
			}
		}
	}
	public void preGo(Node<T> t) {//�ݹ�ǰ�����
		System.out.print(t.value+" ");
		if(t.leftNode!=null)preGo(t.leftNode);
		if(t.rightNode!=null)preGo(t.rightNode);
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	public void midGo(Node<T> t) {//�ݹ�������� ������̵�˼άϰ��
							   //�ڹ�����ֱ�����
		if(t.leftNode!=null)midGo(t.leftNode);
		System.out.print(t.value+" ");
		if(t.rightNode!=null)midGo(t.rightNode);
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	public List<T> dataMidGo(){//�����б�ĵݹ��������
									//��������˼άϰ�ߣ��ڵݹ����ʱ�������
		List<T> values=new ArrayList<>();
		if(leftNode!=null)values.addAll(leftNode.dataMidGo());
		values.add(value);
		if(rightNode!=null)values.addAll(rightNode.dataMidGo());
	//	System.out.println(values);
		return values;
	}
	public void lastGo(Node<T> t) {//�ݹ�������
		if(t.leftNode!=null)lastGo(t.leftNode);
		if(t.rightNode!=null)lastGo(t.rightNode);
		System.out.print(t.value+" ");
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	
	public static void main(String[] args) {
		Node<Integer> Tree=new Node<>();
		for(int i=0;i<10;++i) {
			int n=(int)(Math.random()*100);
		//	double n=Math.random()*100;
			Tree.add(n);
		}
		Tree.midGo(Tree);System.out.println();
		List<Integer> it=Tree.dataMidGo();
		System.out.println(it);
	}
}
