package review.src;
public class Node {
	Student data;//������
	Node lchild;//����
	Node rchild;//�Һ���
	
	//������
	public Node(Student val,Node lp,Node rp) {
		this(val);
		lchild = lp;
		rchild = rp;
	}
	//������
	public Node(Student val) {
		data=val;
	}
}
