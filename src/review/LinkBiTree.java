package review;

import java.util.Scanner;

import review.src.Node;
import review.src.Student;

public class LinkBiTree {
	private Node head;

	public Node getHead() {
		return head;
	}

	// ���캯��������һ�ö�����
	public LinkBiTree(Student val, Node lp, Node rp) {
		Node p = new Node(val, lp, rp);
		head = p;
	}

	public LinkBiTree(Student val) {
		this(val, null, null);
	}

	// ����һ�ÿն�����
	public LinkBiTree() {
		head = null;
	}

	// �ж��Ƿ�Ϊ�յĶ�����
	public boolean isEmpty() {
		return head == null;
	}

	// ��ȡ�����
	public Node getRoot() {
		return head;
	}

	// ��ȡ�������ӽ��
	public Node getLchild(Node p) {
		return p.getLchild();
	}

	// ��ȡ�����Һ��ӽ��
	public Node getRchild(Node p) {
		return p.getRchild();
	}

	// ����������
	public void create(Student val, Node left, Node right) {
		Node p = new Node(val, left, right);
		head = p;
	}

	// �����p������������ֵΪval���½�㣬
	// ԭ������������Ϊ�½���������
	public void insertL(Student val, Node p) {
		Node temp = new Node(val);
		temp.setLchild(p.getLchild());
		p.setLchild(temp);
	}

	// �����p������������ֵΪval���½�㣬
	// ԭ������������Ϊ�½���������
	public void insertR(Student val, Node p) {
		Node temp = new Node(val);
		temp.setRchild(p.getRchild());
		p.setRchild(temp);
	}

	// �������������롢��ӽ�����
	public void insert(Student stu) {
		head = insert(stu, head);
	}

	public Node insert(Student stu, Node t) {
		if (t == null) {
			return new Node(stu);
		} else if (stu.sno < t.getData().sno) {
			t.setLchild(insert(stu, t.getLchild()));
		} else if (stu.sno > t.getData().sno) {
			t.setRchild(insert(stu, t.getRchild()));
		} 
		else if(stu.sno == t.getData().sno) {
			t.setData(stu);
		}
		else {
			System.out.println("������ʧ�ܣ�������Ϣ�ظ���");
		}
		return t;
	}

	// �������н��
	public static void Preorder(Node root) {
		Node p = root;
		if (p == null) {
			return;
		} else {
			Student s = p.getData();

			System.out.println(s.sno + "\t" + s.name + "\t" + s.sex + "\t" + s.phone);
			Preorder(p.getLchild());
			Preorder(p.getRchild());
		}
	}

	// ɾ��ָ��ѧ��sno��ѧ��
	public Node DeleteBySno(Node root, int sno) {
		if (root == null) {
			return null;
		}
		if(sno == root.getData().sno) {
			if(root.getLchild() != null) {
				Node leftMax = root.getLchild();
				while (leftMax.getRchild() != null) {
					leftMax = leftMax.getRchild();
				}
				root.setData(leftMax.getData());
			}
			else if(root.getRchild() != null) {
				Node rightMin = root.getRchild();
				while (rightMin.getLchild() != null) {
					rightMin = rightMin.getLchild();
				}
				root.setData(rightMin.getData());
				root.setRchild(DeleteBySno(root.getRchild(), rightMin.getData().sno));
			}
			
		}
		if (sno < root.getData().sno) {
			root.setLchild(DeleteBySno(root.getLchild(), sno));
		} else if (sno > root.getData().sno) {
			root.setRchild(DeleteBySno(root.getRchild(), sno));
		} 
		else {
			if (root.getLchild() == null && root.getRchild() == null) {
				return null;
			} else if (root.getLchild() != null && root.getRchild() != null) {
				Node leftMax = root.getLchild();
				while (leftMax.getRchild() != null) {
					leftMax = leftMax.getRchild();
				}
				root.setData(leftMax.getData());
				root.setLchild(DeleteBySno(root.getLchild(), leftMax.getData().sno));
			} else {
				return root.getLchild() != null ? root.getLchild() : root.getRchild();
			}
		}
		
		return root;
	}
	

	//�޸�ͬѧ¼��Ϣ/ͨ��ѧ��sno
	public void UpdateBySno(Node root) {
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		int sno = input.nextInt();
		DeleteBySno(root, sno);
		System.out.println("��������ĺ��ѧ����Ϣ��");
		System.out.println("ѧ��\t����\t�Ա�\t�绰����");
		sno = input.nextInt();
		String name = input.next();
		String sex = input.next();
		String phone = input.next();
		Student stu = new Student(sno, name, sex, phone);
		insert(stu);	
	}
	
	

	// �ڶ������в���ѧ��Ϊsno��ѧ��
	public boolean SearchBySno(Node root, int sno) {
		Node p = root;
		int flag = 0;
		if (p == null) {
			System.out.println("not found");
			return false;
		}
		if (p.getData().sno == sno) {
			flag = 1;
			Student s = p.getData();
			
			System.out.println(s.sno + "\t" + s.name + "\t" + s.sex + "\t" + s.phone);
			return true;
		}
		if (p.getData().sno > sno) {
			return SearchBySno(p.getLchild(), sno);
		}
		if (p.getData().sno < sno) {
			return SearchBySno(p.getRchild(), sno);
		}
		if (flag == 0)
			System.out.println("û���ҵ���ѧ����");
		return false;

	}

	// �ڶ������в�������Ϊname��ѧ��
	public boolean SearchByName(Node root, String name) {
		Node p = root;
		int flag = 0;
		if (p == null) {
			System.out.println("not found");
			return false;
		}
		if (p.getData().name.equals(name)) {
			flag = 1;
			Student s = p.getData();
			System.out.println(s.sno + "\t" + s.name + "\t" + s.sex + "\t" + s.phone);
			return true;
		}
		if (p.getLchild() != null) {
			return SearchByName(p.getLchild(), name);
		}
		if (p.getRchild() != null) {
			return SearchByName(p.getRchild(), name);
		}
		if (flag == 0)
			System.out.println("û���ҵ���ѧ����");
		return false;
	}

	// �ڶ������в����Ա�Ϊsex��ѧ��
	public boolean SearchBySex(Node root, String sex) {
		Node p = root;
		int flag = 0;
		if (p == null) {
//			System.out.println("not found");
			return false;
		}
		if (p.getData().sex.equals(sex)) {
			flag = 1;
			Student s = p.getData();
			System.out.println(s.sno + "\t" + s.name + "\t" + s.sex + "\t" + s.phone);
			SearchBySex(p.getLchild(), sex);
			SearchBySex(p.getRchild(), sex);
			return true;
		}
		if (p.getLchild() != null) {
			return SearchBySex(p.getLchild(), sex);
		}
		if (p.getRchild() != null) {
			return SearchBySex(p.getRchild(), sex);
		}
//		if (flag == 0)
//			System.out.println("û���ҵ���ѧ����");
		return false;
	}

	// �ڶ������в��ҵ绰����Ϊphone��ѧ��
	public boolean SearchByPhone(Node root, String phone) {
		Node p = root;
		int flag = 0;
		if (p == null) {
//			System.out.println("not found");
			return false;
		}
		if (p.getData().phone.equals(phone)) {
			flag = 1;
			Student s = p.getData();
			System.out.println(s.sno + "\t" + s.name + "\t" + s.sex + "\t" + s.phone);
			SearchByPhone(p.getLchild(), phone);
			SearchByPhone(p.getRchild(), phone);
			return true;
		}
		if (p.getLchild() != null) {
			return SearchByPhone(p.getLchild(), phone);
		}
		if (p.getRchild() != null) {
			return SearchByPhone(p.getRchild(), phone);
		}
//		if (flag == 0)
//			System.out.println("û���ҵ���ѧ����");
		return false;
	}

