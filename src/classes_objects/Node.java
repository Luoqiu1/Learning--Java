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
					//这里也可以是直接构造new Node(v);
					//但这样一来要再一次递归下去查找创建的情况
					//就得放在else里了
					// if(leftNode==null) leftNode=new Node(v);
					// else leftNode.add(v)
					//两种方法均可。
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
	public void preGo(Node t) {//递归前序遍历
		System.out.print(t.value+" ");
		if(t.leftNode!=null)preGo(t.leftNode);
		if(t.rightNode!=null)preGo(t.rightNode);
		//在访问一个有参方法的时候，记得一定要先检查这个实参是否存在！
		//因为在调用方法的时候会调用构造，构造一个新的实例！
		//倘若这个实参本身就不存在，构造就会失败，抛出异常！
	}
	public void midGo(Node t) {//递归中序遍历 面向过程的思维习惯
							   //在过程中直接输出
		if(t.leftNode!=null)midGo(t.leftNode);
		System.out.print(t.value+" ");
		if(t.rightNode!=null)midGo(t.rightNode);
		//在访问一个有参方法的时候，记得一定要先检查这个实参是否存在！
		//因为在调用方法的时候会调用构造，构造一个新的实例！
		//倘若这个实参本身就不存在，构造就会失败，抛出异常！
	}
	public List<Object> dataMidGo(){//返回列表的递归中序遍历
									//面向对象的思维习惯，在递归结束时输出对象
		List<Object> values=new ArrayList<>();
		if(leftNode!=null)values.addAll(leftNode.dataMidGo());
		values.add(value);
		if(rightNode!=null)values.addAll(rightNode.dataMidGo());
		System.out.println(values);
		return values;
	}
	public void lastGo(Node t) {//递归后序遍历
		if(t.leftNode!=null)lastGo(t.leftNode);
		if(t.rightNode!=null)lastGo(t.rightNode);
		System.out.print(t.value+" ");
		//在访问一个有参方法的时候，记得一定要先检查这个实参是否存在！
		//因为在调用方法的时候会调用构造，构造一个新的实例！
		//倘若这个实参本身就不存在，构造就会失败，抛出异常！
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
