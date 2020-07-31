package review.src;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TestLinkBiTree {
	
	public static String getRandomString(int n) {
		String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool+=(char)i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool+=(char)i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool+=(char)i;
        }
        char cs2[] = new char[n];
        for (int i = 0; i < cs2.length; i++) {
            int index = (int) (Math.random()*pool.length());
            cs2[i] =  pool.charAt( index );
        }
        String result = new String(cs2);
        return result;
	}
	
	public static String getRandomDigit(int n) {
		String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool+=(char)i;
        }
        char cs2[] = new char[n];
        for (int i = 0; i < cs2.length; i++) {
            int index = (int) (Math.random()*pool.length());
            cs2[i] =  pool.charAt( index );
        }
        String result = new String(cs2);
        return result;
	}
	
	public static List<Student> initStudents(int n){
		List<Student> s=new ArrayList<>();
		String sex[]= {"��","Ů"};
		int start=101;
		for(int i=0;i<n;++i) {
			int k=start+i;
			String sName=getRandomString((int)(Math.random()*2+2));
			String sSex=sex[(int)(Math.random()*2)];
			String sTel=getRandomDigit(10);
			Student temp=new Student(k,sName,sSex,sTel);
			s.add(temp);
		}
		return s;
	}
	public static void main(String[] args) {
		
		List<Student> students=new ArrayList<>();
		int n=(int)(Math.random()*20);
		students=initStudents(n);

		// ����һ�ö�����
		LinkBiTree bt = new LinkBiTree(students.get(0));
		Node root = bt.head;
		for(int i=1;i<students.size();++i) {
			bt.insert(students.get(i),root);
		}
		Menu(bt, root);

	}

	
	public static void initPrint() {
		System.out.println("********ͬѧ¼����ϵͳ********");
		System.out.println("******************************");
		System.out.println("\t1-->>��ʾ����ͬѧ����Ϣ");
		System.out.println("\t2-->>����ͬѧ����Ϣ");
		System.out.println("\t3-->>�޸�ͬѧ����Ϣ");
		System.out.println("\t4-->>���ͬѧ����Ϣ");
		System.out.println("\t5-->>ɾ��ͬѧ����Ϣ");
		System.out.println("\t6-->>�������˵�");
		System.out.println("\t0-->>�˳�ϵͳ");
		System.out.println("******************************");
		System.out.println("<<--�밴��ʾ(0-6)ѡ������Ҫ���еĲ���-->>");
	}
	// �˵���
	public static void Menu(LinkBiTree tree, Node root) {
		initPrint();
		Scanner s = new Scanner(System.in);
		int key = 0;
		key = s.nextInt();
		systemStartWork(key,tree,root);
	}
	public static void print(int k) {
		switch(k) {
		case 0:
			System.out.println("\n�Ƿ����(1->�������˵�/0->�˳�)");break;
		case 1:
			System.out.println("\n����ѧ����ϢΪ��");
			System.out.println("ѧ��\t����\t�Ա�\t�绰����");break;
		}
	}
	public static void systemStartWork(int key,LinkBiTree tree, Node root) {
		Scanner input=new Scanner(System.in);
		int flag=key%2;
		if(flag==1) {
			if(key==flag+0) {
				print(1);
				tree.Preorder(root);
				print(0);
				int f = input.nextInt();
				if (f == 1) {
					Menu(tree, root);
				}
			}
			else if(key==flag+2) {
				int h = 2;
				while (h == 2) {
					tree.UpdateBySno(root);
					print(0);
					int s = input.nextInt();
					if (s == 1) {
						Menu(tree, root);
					}
				}
			}
			else if(key==flag+4) {
				int j = 2;
				while (j == 2) {
					System.out.println("\n��������Ҫɾ��ѧ����ѧ��");
					int sno = input.nextInt();
					tree.DeleteBySno(root, sno);
					print(0);
					j = input.nextInt();
					if (j == 1) {
						Menu(tree, root);
					}
				}
			}
		}
		else if(key==6)Menu(tree, root);
		else {
			switch(key) {
			case 2:
				int s = 2;
				while (s == 2) {
					System.out.println();
					System.out.println("��ѡ��(1->ѧ��  2->����  3->�Ա�  4->�绰����)����");
					int f1 = input.nextInt();
					if (f1 == 1) {
						System.out.println("\n��������Ҫ���ҵ�ѧ�ţ�");
						int sno = input.nextInt();
						System.out.println("ѧ��\t����\t�Ա�\t�绰����");
						System.out.println("--------------------------------");
						tree.SearchBySno(root, sno);

					} else if (f1 == 2) {
						System.out.println("\n��������Ҫ���ҵ�������");
						String name = input.next();
						System.out.println("ѧ��\t����\t�Ա�\t�绰����");
						System.out.println("--------------------------------");
						tree.SearchByName(root, name);

					} else if (f1 == 3) {
						System.out.println("\n��������Ҫ���ҵ��Ա�");
						String sex = input.next();
						System.out.println("ѧ��\t����\t�Ա�\t�绰����");
						System.out.println("--------------------------------");
						tree.SearchBySex(root, sex);

					} else if (f1 == 4) {
						System.out.println("\n��������Ҫ���ҵĵ绰���룺");
						String phone = input.next();
						System.out.println("ѧ��\t����\t�Ա�\t�绰����");
						System.out.println("--------------------------------");
						tree.SearchByPhone(root, phone);

					} else {
						System.out.println("\n�������!");
						Menu(tree, root);
						break;
					}
					print(0);
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
					System.out.println("\n��������Ҫ��ӵ�ѧ����Ϣ");
					System.out.println("ѧ��\t����\t�Ա�\t�绰����");
					int sno = input.nextInt();
					String name = input.next();
					String sex = input.next();
					String phone = input.next();
					Student stu = new Student(sno, name, sex, phone);
					tree.insert(stu);
					print(0);
					g = input.nextInt();
					if (g == 1) {
						Menu(tree, root);
						break;
					} else if (g == 0)
						break;
				}
				break;
			}
		}
	}
	
	
}
