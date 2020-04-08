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
					rightNode=new Node<>();
				}
				
					rightNode.add(v);
				
			}
		}
	}
	public void preGo(Node<T> t) {//递归前序遍历
		System.out.print(t.value+" ");
		if(t.leftNode!=null)preGo(t.leftNode);
		if(t.rightNode!=null)preGo(t.rightNode);
		//在访问一个有参方法的时候，记得一定要先检查这个实参是否存在！
		//因为在调用方法的时候会调用构造，构造一个新的实例！
		//倘若这个实参本身就不存在，构造就会失败，抛出异常！
	}
	public void midGo(Node<T> t) {//递归中序遍历 面向过程的思维习惯
							   //在过程中直接输出
		if(t.leftNode!=null)midGo(t.leftNode);
		System.out.print(t.value+" ");
		if(t.rightNode!=null)midGo(t.rightNode);
		//在访问一个有参方法的时候，记得一定要先检查这个实参是否存在！
		//因为在调用方法的时候会调用构造，构造一个新的实例！
		//倘若这个实参本身就不存在，构造就会失败，抛出异常！
	}
	public List<T> dataMidGo(){//返回列表的递归中序遍历
									//面向对象的思维习惯，在递归结束时输出对象
		List<T> values=new ArrayList<>();
		if(leftNode!=null)values.addAll(leftNode.dataMidGo());
		values.add(value);
		if(rightNode!=null)values.addAll(rightNode.dataMidGo());
	//	System.out.println(values);
		return values;
	}
	public void lastGo(Node<T> t) {//递归后序遍历
		if(t.leftNode!=null)lastGo(t.leftNode);
		if(t.rightNode!=null)lastGo(t.rightNode);
		System.out.print(t.value+" ");
		//在访问一个有参方法的时候，记得一定要先检查这个实参是否存在！
		//因为在调用方法的时候会调用构造，构造一个新的实例！
		//倘若这个实参本身就不存在，构造就会失败，抛出异常！
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
