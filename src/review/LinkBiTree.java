package review;

import java.util.Scanner;

import review.src.Node;
import review.src.Student;

public class LinkBiTree {
	private Node head;

	public Node getHead() {
		return head;
	}

	// 构造函数，生成一棵二叉树
	public LinkBiTree(Student val, Node lp, Node rp) {
		Node p = new Node(val, lp, rp);
		head = p;
	}

	public LinkBiTree(Student val) {
		this(val, null, null);
	}

	// 生成一棵空二叉树
	public LinkBiTree() {
		head = null;
	}

	// 判断是否为空的二叉树
	public boolean isEmpty() {
		return head == null;
	}

	// 获取根结点
	public Node getRoot() {
		return head;
	}

	// 获取结点的左孩子结点
	public Node getLchild(Node p) {
		return p.getLchild();
	}

	// 获取结点的右孩子结点
	public Node getRchild(Node p) {
		return p.getRchild();
	}

	// 创建二叉树
	public void create(Student val, Node left, Node right) {
		Node p = new Node(val, left, right);
		head = p;
	}

	// 将结点p的左子树插入值为val的新结点，
	// 原来的左子树成为新结点的左子树
	public void insertL(Student val, Node p) {
		Node temp = new Node(val);
		temp.setLchild(p.getLchild());
		p.setLchild(temp);
	}

	// 将结点p的右子树插入值为val的新结点，
	// 原来的右子树成为新结点的右子树
	public void insertR(Student val, Node p) {
		Node temp = new Node(val);
		temp.setRchild(p.getRchild());
		p.setRchild(temp);
	}

	// 二叉排序树插入、添加结点操作
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
			System.out.println("插入结点失败，插入信息重复。");
		}
		return t;
	}

	// 遍历所有结点
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

	// 删除指定学号sno的学生
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
	

	//修改同学录信息/通过学号sno
	public void UpdateBySno(Node root) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要修改的学生学号：");
		int sno = input.nextInt();
		DeleteBySno(root, sno);
		System.out.println("请输入更改后的学生信息：");
		System.out.println("学号\t姓名\t性别\t电话号码");
		sno = input.nextInt();
		String name = input.next();
		String sex = input.next();
		String phone = input.next();
		Student stu = new Student(sno, name, sex, phone);
		insert(stu);	
	}
	
	

	// 在二叉树中查找学号为sno的学生
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
			System.out.println("没有找到此学生！");
		return false;

	}

	// 在二叉树中查找姓名为name的学生
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
			System.out.println("没有找到此学生！");
		return false;
	}

	// 在二叉树中查找性别为sex的学生
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
//			System.out.println("没有找到此学生！");
		return false;
	}

	// 在二叉树中查找电话号码为phone的学生
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
//			System.out.println("没有找到此学生！");
		return false;
	}

