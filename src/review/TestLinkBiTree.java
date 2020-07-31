package review;
import review.LinkBiTree;

import java.awt.Toolkit;
import java.util.Scanner;

public class TestLinkBiTree {

	public static void main(String[] args) {

		Student s1 = new Student(101, "zs", "男", "123456");
		Student s2 = new Student(102, "ls", "女", "123456");
		Student s3 = new Student(103, "ww", "男", "123456");
		Student s4 = new Student(104, "zl", "女", "123456");
		Student s5 = new Student(105, "xm", "男", "123456");

		// 创建一棵二叉树
		LinkBiTree bt = new LinkBiTree(s1);
		Node root = bt.getHead();
		bt.insert(s2, root);
		bt.insert(s3, root);
		bt.insert(s4, root);
		bt.insert(s5, root);
		Menu(bt, root);

	}

	// 菜单项
	static void Menu(LinkBiTree tree, Node root) {
		System.out.println("********同学录管理系统********");
		System.out.println("******************************");
		System.out.println("\t1-->>显示所有同学的信息");
		System.out.println("\t2-->>查找同学的信息");
		System.out.println("\t3-->>修改同学的信息");
		System.out.println("\t4-->>添加同学的信息");
		System.out.println("\t5-->>删除同学的信息");
		System.out.println("\t6-->>返回主菜单");
		System.out.println("\t0-->>退出系统");
		System.out.println("******************************");
		System.out.println("<<--请按提示(0-6)选择您需要进行的操作-->>");
		Scanner input = new Scanner(System.in);
		int key = 0;
		key = input.nextInt();
		switch (key) {
		case 1:// 遍历所有信息
			System.out.println();
			System.out.println("所有学生信息为：");
			System.out.println("学号\t姓名\t性别\t电话号码");
			tree.Preorder(root);
			System.out.println();
			System.out.println("是否继续(1->返回主菜单/0->退出)");
			int f = input.nextInt();
			if (f == 1) {
				Menu(tree, root);
				break;
			} else
				break;
		case 2:
			int s = 2;
			while (s == 2) {
				System.out.println();
				System.out.println("请选择按(1->学号  2->姓名  3->性别  4->电话号码)查找");
				int f1 = input.nextInt();
				if (f1 == 1) {
					System.out.println();
					System.out.println("请输入需要查找的学号：");
					int sno = input.nextInt();
					System.out.println("学号\t姓名\t性别\t电话号码");
					System.out.println("--------------------------------");
					tree.SearchBySno(root, sno);

				} else if (f1 == 2) {
					System.out.println();
					System.out.println("请输入需要查找的姓名：");
					String name = input.next();
					System.out.println("学号\t姓名\t性别\t电话号码");
					System.out.println("--------------------------------");
					tree.SearchByName(root, name);

				} else if (f1 == 3) {
					System.out.println();
					System.out.println("请输入需要查找的性别：");
					String sex = input.next();
					System.out.println("学号\t姓名\t性别\t电话号码");
					System.out.println("--------------------------------");
					tree.SearchBySex(root, sex);

				} else if (f1 == 4) {
					System.out.println();
					System.out.println("请输入需要查找的电话号码：");
					String phone = input.next();
					System.out.println("学号\t姓名\t性别\t电话号码");
					System.out.println("--------------------------------");
					tree.SearchByPhone(root, phone);

				} else {
					System.out.println();
					System.out.println("输入错误!");
					Menu(tree, root);
					break;
				}
				System.out.println();
				System.out.println("是否继续(1->返回主菜单/2->继续查询/0->退出)");
				s = input.nextInt();
				if (s == 1) {
					Menu(tree, root);
					break;
				} else if (s == 0)
					break;
			}
			break;
		case 3:
			int h = 2;
			while (h == 2) {
				tree.UpdateBySno(root);
				System.out.println();
				System.out.println("是否继续(1->返回主菜单/2->继续修改/0->退出)");
				s = input.nextInt();
				if (s == 1) {
					Menu(tree, root);
					break;
				} else if (s == 0)
					break;
			}
			break;
		case 4:
			int g = 2;
			while (g == 2) {
				System.out.println();
				System.out.println("请输入需要添加的学生信息");
				System.out.println("学号\t姓名\t性别\t电话号码");
				int sno = input.nextInt();
				String name = input.next();
				String sex = input.next();
				String phone = input.next();
				Student stu = new Student(sno, name, sex, phone);
				tree.insert(stu);
				System.out.println();
				System.out.println("是否继续(1->返回主菜单/2->继续添加/0->退出)");
				g = input.nextInt();
				if (g == 1) {
					Menu(tree, root);
					break;
				} else if (g == 0)
					break;
			}
			break;
		case 5:
			int j = 2;
			while (j == 2) {
				System.out.println();
				System.out.println("请输入需要删除学生的学号");
				int sno = input.nextInt();
				tree.DeleteBySno(root, sno);
				System.out.println();
				System.out.println("是否继续(1->返回主菜单/2->继续删除/0->退出)");
				j = input.nextInt();
				if (j == 1) {
					Menu(tree, root);
					break;
				} else if (j == 0)
					break;
			}
			break;
		case 6:
			Menu(tree, root);
			break;
		case 0:
			break;
		}

	}

}

