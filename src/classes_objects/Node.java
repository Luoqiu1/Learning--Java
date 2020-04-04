package classes_objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


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
					leftNode=new Node();
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
					rightNode=new Node();
				}
				
					rightNode.add(v);
				
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
	public void midGo(Node t) {//�ݹ�������� ������̵�˼άϰ��
							   //�ڹ�����ֱ�����
		if(t.leftNode!=null)midGo(t.leftNode);
		System.out.print(t.value+" ");
		if(t.rightNode!=null)midGo(t.rightNode);
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	public List<Object> dataMidGo(){//�����б�ĵݹ��������
									//��������˼άϰ�ߣ��ڵݹ����ʱ�������
		List<Object> values=new ArrayList<>();
		if(leftNode!=null)values.addAll(leftNode.dataMidGo());
		values.add(value);
		if(rightNode!=null)values.addAll(rightNode.dataMidGo());
		System.out.println(values);
		return values;
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
		List<Object> it=Tree.dataMidGo();
		System.out.println(it);
	}
}
