package review;


public class Node {
	private Student data;//数据域
	private Node lchild;//左孩子
	private Node rchild;//右孩子
	
	//构造器
	public Node(Student val,Node lp,Node rp) {
		this.data = val;
		this.lchild = lp;
		this.rchild = rp;
	}
	//构造器
	public Node(Student val) {
		this(val,null,null);
	}
	//构造器
	public Node() {
		this(null);
	}
	
	//数据属性
	public Student getData() {
		return this.data;
	}
	public void setData(Student data) {
		this.data = data;
	}
	

	//左孩子
	public Node getLchild() {
		return this.lchild;
	}
	public void setLchild(Node lchild) {
		this.lchild = lchild;
	}
	//右孩子
	public Node getRchild() {
		return this.rchild;
	}
	public void setRchild(Node rchild) {
		this.rchild = rchild;
	}
}

