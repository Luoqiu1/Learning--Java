package review.src;
public class Node {
	Student data;//数据域
	Node lchild;//左孩子
	Node rchild;//右孩子
	
	//构造器
	public Node(Student val,Node lp,Node rp) {
		this(val);
		lchild = lp;
		rchild = rp;
	}
	//构造器
	public Node(Student val) {
		data=val;
	}
}
