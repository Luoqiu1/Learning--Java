package review.src;
import java.util.Scanner;

public class LinkBiTree {
	Node head=null;

	// 构造函数，生成一棵二叉树
	public LinkBiTree(Student val, Node lp, Node rp) {
		head = new Node(val, lp, rp);
	}

	public LinkBiTree(Student val) {
		head = new Node(val,null,null);
	}

	// 二叉排序树插入、添加结点操作
	public void insert(Student stu) {
		head = insert(stu, head);
	}

	public Node insert(Student stu, Node t) {
		if (t == null) {
			return new Node(stu);
		} 
		if (stu.sno < t.data.sno) {
			t.lchild=(insert(stu, t.lchild));
		} 
		else if (stu.sno > t.data.sno) {
			t.rchild=(insert(stu, t.rchild));
		} 
		else{
			t.data=(stu);
		}
		return t;
	}

	public static void studentPrint(int sno,String name,String sex,String phone) {
		String s=sno+"\t"+name+"\t"+sex+"\t"+phone;
		System.out.println(s);
	}
	// 遍历所有结点
	public static void Preorder(Node root) {
		Node p = root;
		if(p==null)return;
		Student s = p.data;
		studentPrint(s.sno,s.name,s.sex,s.phone);
		Preorder(p.lchild);
		Preorder(p.rchild);
	}

	// 删除指定学号sno的学生
	public Node DeleteBySno(Node root, int sno) {
		if (root == null) {
			return null;
		}
		if(sno == root.data.sno) {
			if(root.lchild != null) {
				Node leftMax = root.lchild;
				while (leftMax.rchild != null) {
					leftMax = leftMax.rchild;
				}
				root.data=(leftMax.data);
			}
			else if(root.rchild != null) {
				Node rightMin = root.rchild;
				while (rightMin.lchild != null) {
					rightMin = rightMin.lchild;
				}
				root.data=(rightMin.data);
				root.rchild=(DeleteBySno(root.rchild, rightMin.data.sno));
			}
			
		}
		if (sno < root.data.sno) {
			root.lchild=(DeleteBySno(root.lchild, sno));
		} else if (sno > root.data.sno) {
			root.rchild=(DeleteBySno(root.rchild, sno));
		} 
		else {
			if (root.lchild == null && root.rchild == null) {
				return null;
			} else if (root.lchild != null && root.rchild != null) {
				Node leftMax = root.lchild;
				while (leftMax.rchild != null) {
					leftMax = leftMax.rchild;
				}
				root.data=(leftMax.data);
				root.lchild=(DeleteBySno(root.lchild, leftMax.data.sno));
			} else {
				return root.lchild != null ? root.lchild : root.rchild;
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
		if (p.data.sno == sno) {
			flag = 1;
			Student s = p.data;
			studentPrint(s.sno,s.name,s.sex,s.phone);
			return true;
		}
		if (p.data.sno > sno) {
			return SearchBySno(p.lchild, sno);
		}
		if (p.data.sno < sno) {
			return SearchBySno(p.rchild, sno);
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
		if (p.data.name.equals(name)) {
			flag = 1;
			Student s = p.data;
			studentPrint(s.sno,s.name,s.sex,s.phone);
			return true;
		}
		if (p.lchild != null) {
			return SearchByName(p.lchild, name);
		}
		if (p.rchild != null) {
			return SearchByName(p.rchild, name);
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
		if (p.data.sex.equals(sex)) {
			flag = 1;
			Student s = p.data;
			studentPrint(s.sno,s.name,s.sex,s.phone);
			SearchBySex(p.lchild, sex);
			SearchBySex(p.rchild, sex);
			return true;
		}
		if (p.lchild != null) {
			return SearchBySex(p.lchild, sex);
		}
		if (p.rchild != null) {
			return SearchBySex(p.rchild, sex);
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
		if (p.data.phone.equals(phone)) {
			flag = 1;
			Student s = p.data;
			studentPrint(s.sno,s.name,s.sex,s.phone);
			SearchByPhone(p.lchild, phone);
			SearchByPhone(p.rchild, phone);
			return true;
		}
		if (p.lchild != null) {
			return SearchByPhone(p.lchild, phone);
		}
		if (p.rchild != null) {
			return SearchByPhone(p.rchild, phone);
		}
//		if (flag == 0)
//			System.out.println("没有找到此学生！");
		return false;
	}

	
}
