package classes_objects;
import java.util.Scanner;


public class Node {
	public Node leftNode;
	public Node rightNode;
	public Object value;
	public Node() {
	}
	public Node(Object v) {
		value=v;
	}
	public void add(Object v) {
		if(value==null) {
			value=v;
		}
		else {
			
			if((int)v-(int)value<=0) {
				if(leftNode==null) {
					leftNode=new Node(v);
				}
				else {
					leftNode.add(v);
				}
			}
			else {
				if(rightNode==null) {
					rightNode=new Node(v);
				}
				else {
					rightNode.add(v);
				}
			}
		}
	}
	public void preGo(Node t) {//�ݹ�ǰ�����
		System.out.print(t.value+" ");
		if(t.leftNode!=null)preGo(t.leftNode);
		if(t.rightNode!=null)preGo(t.rightNode);
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	public void midGo(Node t) {//�ݹ��������
		if(t.leftNode!=null)midGo(t.leftNode);
		System.out.print(t.value+" ");
		if(t.rightNode!=null)midGo(t.rightNode);
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	public void lastGo(Node t) {//�ݹ�������
		if(t.leftNode!=null)lastGo(t.leftNode);
		if(t.rightNode!=null)lastGo(t.rightNode);
		System.out.print(t.value+" ");
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	public static void main(String[] args) {
		Node Tree=new Node();
		Scanner s=new Scanner(System.in);
		for(int i=0;i<5;++i) {
			int n=s.nextInt();
			Tree.add(n);
		}
		Tree.midGo(Tree);System.out.println();
	}
}
