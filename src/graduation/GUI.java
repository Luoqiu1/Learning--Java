package graduation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI {
//	��ʼ��DAO
	public static DAO<User> U=new DAO<>("graduation.User");
	public static DAO<Teacher> T=new DAO<>("graduation.Teacher");
	public static DAO<Student> S=new DAO<>("graduation.Student");
	public static DAO<CS> CS=new DAO<>("graduation.CS");
	public static DAO<CT> CT=new DAO<>("graduation.CT");
	public static DAO<CU> CU=new DAO<>("graduation.CU");
	
	public static void main(String[] args) {
		
		JFrame f=new JFrame("��ҵ��ƹ���ϵͳ");
//		��ʼ���˵�
		initMenu(f);
		f.setLocation(330, 190);
		f.setSize(650,380);
		f.setLayout(new FlowLayout());
		f.setResizable(false);
//		��ʼ������Ľ��棨��¼��ע�ᣩ
		initLogin(f);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void initLogin(JFrame f) {
//		�ʼ�Ľ�����ƣ���ӭ���棬��¼��ť��ע�ᰴť��
		JPanel login=new JPanel();
		login.setLayout(new BorderLayout());
//		BorderLayout�ı���Pane
		JPanel pUp=new JPanel();
		pUp.setLayout(new BorderLayout());
		JLabel word1=new JLabel("��ӭʹ��",JLabel.CENTER);
		JLabel word2=new JLabel("��ҵ��ƹ���ϵͳ",JLabel.CENTER);
		word1.setFont(new Font("����",1,40));
		word2.setFont(new Font("����",1,40));
		pUp.add(word1,BorderLayout.CENTER);pUp.add(word2,BorderLayout.SOUTH);
//		��ӭ������ע�ᰴť��ͬһ��Pane�ϣ���������
		login.add(pUp,BorderLayout.NORTH);
		
//		BorderLayout���ϱ�Pane
		JPanel pDown=new JPanel(new BorderLayout());
//		���ֿ��ϵ�Pane��������
		JPanel pDownUpPane=new JPanel();
		String[] s= {"����Ա","��ʦ","ѧ��"};
		JComboBox cb=new JComboBox(s);
		JLabel l=new JLabel("��ѡ���¼���ͣ�");
		l.setFont(new Font("����",1,20));
		cb.setPreferredSize(new Dimension(100,30));
		pDownUpPane.add(l);pDownUpPane.add(cb);
//		���ֿ��µ�Pane��ʵ�ֵ�¼���ܵ�һ�����
		JPanel pDownDownPane=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel l1=new JLabel("�˺ţ�");
		JTextField tf1=new JTextField();
		tf1.setPreferredSize(new Dimension(100,30));
		JLabel l2=new JLabel("���룺");
		JPasswordField tf2=new JPasswordField();
		tf2.setPreferredSize(new Dimension(100,30));
		JButton b=new JButton("��¼");
		pDownDownPane.add(l1);pDownDownPane.add(tf1);
		pDownDownPane.add(l2);pDownDownPane.add(tf2);
		pDownDownPane.add(b);
//		���µ�¼��������Ӧ
		ActionListener al=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				type��¼��¼���û�����
//				1������Ա	2����ʦ	3��ѧ��
//				0: ��¼ʧ�ܣ���������
				int type=startAction(f,cb,tf1,tf2);
				switch(type) {
				case 1:
					goUser(f,tf1.getText());
					break;
				case 2:
					goTeacher(f,tf1.getText());
					break;
				case 3:
					goStudent(f,tf1.getText());
					break;
				}
			}
		};
		b.addActionListener(al);
		
		pDown.add(pDownUpPane,BorderLayout.NORTH);
		pDown.add(pDownDownPane,BorderLayout.CENTER);

		login.add(pDown,BorderLayout.SOUTH);
		
		JPanel pCenter=new JPanel();
		JButton b4=new JButton("�û�ע��");
		b4.setPreferredSize(new Dimension(90,50));
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog d=new JDialog(f);
				d.setModal(true);
				d.setTitle("�û�ע��");
				d.setSize(350,200);
				int gap=10;
				d.setLayout(new BorderLayout());
				d.setLocationRelativeTo(f);
				
				JPanel p=new JPanel(new GridLayout(4,2,gap,gap));
				JLabel l=new JLabel("                ��ѡ��ע�����ͣ�");
				l.setSize(200,200);
				String[] s= {"����Ա","��ʦ","ѧ��"};
				JComboBox cb=new JComboBox(s);
				cb.setFocusable(false);
				cb.setSize(80,30);
				JLabel l1=new JLabel("                        �˺ţ�");
				JTextField tf1=new JTextField();
				JLabel l2=new JLabel("                        ���룺");
				JPasswordField tf2=new JPasswordField();
				JButton b=new JButton("ע��");
				tf1.grabFocus();
				p.add(l);p.add(cb);
				p.add(l1);p.add(tf1);p.add(l2);p.add(tf2);
				
				ActionListener al=new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						startAction(d,cb,tf1,tf2);
					}
				};
				b.addActionListener(al);
				
				d.add(b,BorderLayout.SOUTH);
				d.add(p,BorderLayout.NORTH);
				d.setVisible(true);
			}
		});
		
		pCenter.add(b4);
		login.add(pCenter,BorderLayout.CENTER);
		f.add(login);
	}
	
	public static void startAction(JDialog d,JComboBox cb,JTextField tf1,JPasswordField tf2) {
		String id=tf1.getText();
		String pwd=tf2.getText();
		if(id.length()!=0)tf2.grabFocus();
		else tf1.grabFocus();
		if(id.length()==0&&pwd.length()==0) {
			JOptionPane.showMessageDialog(d, "�û��������벻��Ϊ�գ�");
		}
		else if(id.length()==0)JOptionPane.showMessageDialog(d, "�û�������Ϊ�գ�");
		else if(pwd.length()==0)JOptionPane.showMessageDialog(d, "���벻��Ϊ�գ�");
		else if(pwd.length()!=6)JOptionPane.showMessageDialog(d, "�����������Ϊ��λ���֣�");
		else {
			String s=(String)cb.getSelectedItem();
			switch(s) {
			case "����Ա":
				try {
					U.add(new User(id,pwd));
					JOptionPane.showMessageDialog(d, "�ɹ���������Ա�û���");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(d, "�˹���Ա�û��Ѵ��ڣ�");
				}finally {
					break;
				}
			case "ѧ��":
				try {
					S.add(new Student(id,pwd));
					JOptionPane.showMessageDialog(d, "�ɹ�����ѧ���û���");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(d, "��ѧ���û��Ѵ��ڣ�");
				}finally {
					break;
				}
			case "��ʦ":
				try {
					T.add(new Teacher(id,pwd));
					JOptionPane.showMessageDialog(d, "�ɹ�������ʦ�û���");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(d, "�˽�ʦ�û��Ѵ��ڣ�");
				}finally {
					break;
				}
			}
		}
	}
	
	public static int startAction(JFrame f,JComboBox cb,JTextField tf1,JPasswordField tf2) {
		String id=tf1.getText();
		String pwd=tf2.getText();
		if(id.length()!=0)tf2.grabFocus();
		else tf1.grabFocus();
		if(id.length()==0&&pwd.length()==0) {
			JOptionPane.showMessageDialog(f, "�û��������벻��Ϊ�գ�");
		}
		else if(id.length()==0)JOptionPane.showMessageDialog(f, "�û�������Ϊ�գ�");
		else if(pwd.length()==0)JOptionPane.showMessageDialog(f, "���벻��Ϊ�գ�");
		else if(pwd.length()!=6)JOptionPane.showMessageDialog(f, "�������Ϊ��λ���֣�");
		else {
			String type=(String)cb.getSelectedItem();
			switch(type) {
			case "����Ա":
				User u=U.get(id);
				if(u==null)	
					JOptionPane.showMessageDialog(f, "�û������ڣ�");
				else if(u.getPwd().equals(pwd)) {
					JOptionPane.showMessageDialog(f, "��¼����Ա�û��ɹ���");
					return 1;
				}
				else
					JOptionPane.showMessageDialog(f, "�������");
				break;
			case "��ʦ":
				Teacher t=T.get(id);
				if(t==null)
					JOptionPane.showMessageDialog(f, "�û������ڣ�");
				else if(t.getPwd().equals(pwd)) {
					JOptionPane.showMessageDialog(f, "��¼��ʦ�û��ɹ���");
					return 2;
				}
				else
					JOptionPane.showMessageDialog(f, "�������");
				break;
			case "ѧ��":
				Student s=S.get(id);
				if(s==null)
					JOptionPane.showMessageDialog(f, "�û������ڣ�");
				else if(s.getPwd().equals(pwd)) {
					JOptionPane.showMessageDialog(f, "��¼ѧ���û��ɹ���");
					return 3;
				}
				else
					JOptionPane.showMessageDialog(f, "�������");
				break;	
			}
		}
		return 0;
	}
	
	public static void initMenu(JFrame f) {
		JMenuBar mb=new JMenuBar();
		JMenu help=new JMenu("ʹ��˵��(H)");
		JMenuItem h1=new JMenuItem("ע��");
		JMenuItem h2=new JMenuItem("��¼");
		JMenuItem h3=new JMenuItem("��Ϣ˵��");
		h1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(f, "��δע����û����Ƚ���ע��֮���¼���ܹ�ʹ�ñ�ϵͳ��");
			}
		});
		h2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(f, "����ע��֮��������ȷ���˺�������е�¼��");
			}
		});
		h3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(f, "��Ϣ��Ϊnull˵��Ϊ��ֵ��ͬ����������null����ʾ���գ�");
			}
		});
		help.add(h1);help.add(h2);help.add(h3);
		mb.add(help);
        f.setJMenuBar(mb);
	}
	
//	ѧ��������ʵ��
	public static void goStudent(JFrame f,String id) {
		Student v=S.get(id);
//		System.out.println(v);
		JDialog d=new JDialog(f);
		d.setModal(true);
		d.setTitle("ѧ�����˹���");
		d.setSize(450,250);
		d.setResizable(false);
		int gap=5;
		d.setLayout(new BorderLayout());
		d.setLocationRelativeTo(f);
		
		JTabbedPane tp=new JTabbedPane();
		String nameList[]= {"������Ϣ","ѡ����Ϣ","ѡ����"};
		JPanel p1=new JPanel();JPanel p2=new JPanel(new BorderLayout());JPanel p3=new JPanel(new BorderLayout());
		tp.add(p1);tp.add(p2);tp.add(p3);
		tp.setTitleAt(0, nameList[0]);tp.setTitleAt(1, nameList[1]);tp.setTitleAt(2, nameList[2]);
		d.add(tp);
//		p1.setLayout(new GridLayout(3,5,gap,gap));
		Dimension d110=new Dimension(110,30);
		Dimension d100=new Dimension(100,30);
		Dimension d90=new Dimension(90,30);
		Dimension d80=new Dimension(80,30);
		Dimension d50=new Dimension(50,30);
		Dimension d40=new Dimension(40,30);
		Dimension d20=new Dimension(20,30);
		JLabel l1=new JLabel("ѧ�ţ�");JTextField tf1=new JTextField(v.sno);tf1.setPreferredSize(d80);
		JLabel l2=new JLabel("������");JTextField tf2=new JTextField(v.sn);tf2.setPreferredSize(d50);
		JLabel l3=new JLabel("�Ա�");JTextField tf3=new JTextField(v.ssex);tf3.setPreferredSize(d20);
		JLabel l4=new JLabel("���룺");JTextField tf4=new JTextField(v.spwd);tf4.setPreferredSize(d50);
		JLabel l5=new JLabel("רҵ��");JTextField tf5=new JTextField(v.sdept);tf5.setPreferredSize(d110);
		JLabel l6=new JLabel("�༶��");JTextField tf6=new JTextField(v.sclass);tf6.setPreferredSize(d40);
		JLabel l7=new JLabel("��ϵ�绰��");JTextField tf7=new JTextField(v.stel);tf7.setPreferredSize(d90);
		p1.add(l1);p1.add(tf1);p1.add(l2);p1.add(tf2);p1.add(l3);p1.add(tf3);
		p1.add(l4);p1.add(tf4);p1.add(l5);p1.add(tf5);p1.add(l6);p1.add(tf6);
		p1.add(l7);p1.add(tf7);
		JButton b1=new JButton("�޸���Ϣ");
		p1.add(b1);
		ActionListener al1=new ActionListener() {
			String sno=id;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student newStudent=new Student(tf1.getText(),tf2.getText(),tf3.getText(),
						tf5.getText(),tf6.getText(),tf7.getText(),tf4.getText());
				boolean flag=false;
				if(tf4.getText().length()!=6)JOptionPane.showMessageDialog(d, "�������Ϊ��λ���֣�");
				else {
					try {
						S.update(newStudent, sno);
						JOptionPane.showMessageDialog(d, "�û���Ϣ���³ɹ���");
						flag=true;
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(d, "����ʧ�ܣ�������Ϣ����ȷ�ԣ�");
					}
				}
				if(!flag) {
					sno=newStudent.sno;
					v.sno=sno;
				}
			}
		};
		b1.addActionListener(al1);
		
		StudentTableModelStart tableModel2=new StudentTableModelStart(CT,T);
		JTable table2=new JTable(tableModel2);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.getColumnModel().getColumn(1).setPreferredWidth(150);
		CT ct=new CT();
		table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
			public void valueChanged(ListSelectionEvent e) {
            // ��ȡ��һ�б�ѡ����
			int row = table2.getSelectedRow();
            // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
			ct.id = tableModel2.listCT.get(row).id;
			ct.tno=	tableModel2.listCT.get(row).tno;
			}
		});
		JScrollPane sp2=new JScrollPane(table2);
		sp2.setPreferredSize(new Dimension(100,71));
		p2.add(sp2,BorderLayout.NORTH);
		JPanel mid2=new JPanel();
		JButton b2=new JButton("ѡ�����");
		mid2.add(b2);
		p2.add(mid2,BorderLayout.CENTER);

		
		StudentTableModelEnd tableModel3=new StudentTableModelEnd(CS,S,v);
		JTable table3=new JTable(tableModel3);
		table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CS cs=new CS();
		table3.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
			CS temp;
			public void valueChanged(ListSelectionEvent e) {
            // ��ȡ��һ�б�ѡ����
			int row = table3.getSelectedRow();
            // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
			cs.id = tableModel3.listCS.get(row).id;
			cs.sno=	tableModel3.listCS.get(row).sno;
			}
		});
		JScrollPane sp3=new JScrollPane(table3);
		sp3.setPreferredSize(new Dimension(100,120));
		p3.add(sp3,BorderLayout.NORTH);
		JPanel mid3=new JPanel();
		JButton b3=new JButton("ɾ������");
		mid3.add(b3);
		p3.add(mid3,BorderLayout.CENTER);

		ActionListener al2=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				try {
					CS.add(new CS(ct.id,v.sno));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(d, "ѡ�����ʧ�ܣ��ÿ����ѱ�ѡ���ѡ�������Ѵ����ޣ�������ѡ��");
					flag=false;
				}
				if(flag)JOptionPane.showMessageDialog(d, "ѡ�����ɹ���");
				tableModel3.listCS=CS.list();
			}
		};
		b2.addActionListener(al2);
		
		ActionListener al3=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean flag=true;
				try {
					CS.delete(cs.id,cs.sno);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(d, "ɾ������ʧ�ܣ�");
					flag=false;
				}
				if(flag)JOptionPane.showMessageDialog(d, "ɾ������ɹ���");
				tableModel3.listCS=CS.list();
				table3.updateUI();
			}
		};
		b3.addActionListener(al3);
		
		d.setVisible(true);
	}
	
//	��ʦ������ʵ��
	public static void goTeacher(JFrame f,String id) {
		Teacher v=T.get(id);
//		System.out.println(v);
		JDialog d=new JDialog(f);
		d.setModal(true);
		d.setTitle("��ʦ���˹���");
		d.setSize(450,250);
		d.setResizable(false);
		int gap=5;
		d.setLayout(new BorderLayout());
		d.setLocationRelativeTo(f);
		
		JTabbedPane tp=new JTabbedPane();
		String nameList[]= {"������Ϣ","������Ϣ","ѡ����"};
		JPanel p1=new JPanel();JPanel p2=new JPanel(new BorderLayout());JPanel p3=new JPanel(new BorderLayout());
		tp.add(p1);tp.add(p2);tp.add(p3);
		tp.setTitleAt(0, nameList[0]);tp.setTitleAt(1, nameList[1]);tp.setTitleAt(2, nameList[2]);
		d.add(tp);
//		p1.setLayout(new GridLayout(3,5,gap,gap));
		Dimension d120=new Dimension(120,30);
		Dimension d110=new Dimension(110,30);
		Dimension d100=new Dimension(100,30);
		Dimension d90=new Dimension(90,30);
		Dimension d80=new Dimension(80,30);
		Dimension d60=new Dimension(60,30);
		Dimension d50=new Dimension(50,30);
		Dimension d40=new Dimension(40,30);
		Dimension d20=new Dimension(20,30);
		JLabel l1=new JLabel("��ʦ�ţ�");JTextField tf1=new JTextField(v.tno);tf1.setPreferredSize(d80);
		JLabel l2=new JLabel("������");JTextField tf2=new JTextField(v.tn);tf2.setPreferredSize(d50);
		JLabel l3=new JLabel("�Ա�");JTextField tf3=new JTextField(v.tsex);tf3.setPreferredSize(d20);
		JLabel l4=new JLabel("���룺");JTextField tf4=new JTextField(v.tpwd);tf4.setPreferredSize(d50);
		JLabel l5=new JLabel("ְ�ƣ�");JTextField tf5=new JTextField(v.ttitle);tf5.setPreferredSize(d110);
//		JLabel l6=new JLabel("�༶��");JTextField tf6=new JTextField(v.sclass);tf6.setPreferredSize(d40);
		JLabel l7=new JLabel("��ϵ�绰��");JTextField tf7=new JTextField(v.ttel);tf7.setPreferredSize(d90);
		p1.add(l1);p1.add(tf1);p1.add(l2);p1.add(tf2);p1.add(l3);p1.add(tf3);
		p1.add(l4);p1.add(tf4);p1.add(l5);p1.add(tf5);
		//p1.add(l6);p1.add(tf6);
		p1.add(l7);p1.add(tf7);
		JButton b1=new JButton("�޸���Ϣ");
		p1.add(b1);
		ActionListener al1=new ActionListener() {
			String tno=id;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Teacher newTeacher=new Teacher(tf1.getText(),tf2.getText(),tf3.getText(),
						tf5.getText(),tf7.getText(),tf4.getText());
				boolean flag=false;
				if(tf4.getText().length()!=6)JOptionPane.showMessageDialog(d, "�������Ϊ��λ���֣�");
				else {
					try {
						T.update(newTeacher, tno);
						JOptionPane.showMessageDialog(d, "�û���Ϣ���³ɹ���");
						flag=true;
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(d, "����ʧ�ܣ�������Ϣ����ȷ�ԣ�");
					}
				}
				if(!flag) {
					tno=newTeacher.tno;
					v.tno=tno;
				}
			}
		};
		b1.addActionListener(al1);
		
		TeacherTableModelStart tableModel2=new TeacherTableModelStart(CT,T,v);
		JTable table2=new JTable(tableModel2);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.getColumnModel().getColumn(1).setPreferredWidth(150);
		CT ct=new CT();
		
		JScrollPane sp2=new JScrollPane(table2);
		sp2.setPreferredSize(new Dimension(100,71));
		p2.add(sp2,BorderLayout.NORTH);
		
		//	��Ҫ�Ľ�
		JPanel mid1=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel l21=new JLabel("��ţ�");JTextField tf21=new JTextField();tf21.setPreferredSize(d40);
		JLabel l22=new JLabel("���ƣ�");JTextField tf22=new JTextField();tf22.setPreferredSize(d120);
		JLabel l23=new JLabel("���ͣ�");JTextField tf23=new JTextField();tf23.setPreferredSize(d60);
		JLabel l24=new JLabel("������ʦ(���)��");JTextField tf24=new JTextField();tf24.setPreferredSize(d60);
		JLabel l25=new JLabel("ָ����ʦ��");JTextField tf25=new JTextField();tf25.setPreferredSize(d60);
		JLabel l26=new JLabel("��ѡ��");JTextField tf26=new JTextField();tf26.setPreferredSize(d40);
		mid1.add(l21);mid1.add(tf21);mid1.add(l22);mid1.add(tf22);
		mid1.add(l23);mid1.add(tf23);mid1.add(l24);mid1.add(tf24);
		mid1.add(l25);mid1.add(tf25);mid1.add(l26);mid1.add(tf26);
		p2.add(mid1,BorderLayout.CENTER);
		
		table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
			public void valueChanged(ListSelectionEvent e) {
            // ��ȡ��һ�б�ѡ����
			int row = table2.getSelectedRow();
            // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
			ct.id = tableModel2.listCT.get(row).id;
			ct.tno=	tableModel2.listCT.get(row).tno;
			ct.ctype=tableModel2.listCT.get(row).ctype;
			ct.cname=tableModel2.listCT.get(row).cname;
			ct.ctno=tableModel2.listCT.get(row).ctno;
			ct.climit=tableModel2.listCT.get(row).climit;
			tf21.setText(ct.id);tf22.setText(ct.cname);tf23.setText(ct.ctype);
			tf24.setText(ct.tno);tf25.setText(ct.ctno);tf26.setText(String.valueOf(ct.climit));
//			System.out.println(ct);
			}
		});
		
		JPanel mid2=new JPanel();
		JButton b21=new JButton("��������");
		JButton b22=new JButton("�޸Ŀ���");
		JButton b23=new JButton("ɾ������");
		mid2.add(b21);mid2.add(b22);mid2.add(b23);
		p2.add(mid2,BorderLayout.SOUTH);
		ActionListener al21=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CT newCT=new CT(tf21.getText(),tf22.getText(),tf23.getText(),v.tno,Integer.parseInt(tf26.getText()),tf25.getText());
				if(!tf24.getText().equals(ct.tno)) {
					JOptionPane.showMessageDialog(d, "ֻ�ܷ����Լ��Ŀ��⣡");return;
				}
				try {
					System.out.println(newCT);
					CT.add(newCT);
					tableModel2.listCT=CT.list();
					table2.updateUI();
					JOptionPane.showMessageDialog(d, "�½�����ɹ���");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "�½�����ʧ�ܣ��ÿ������Ѵ��ڣ�");				}
			}
		};
		b21.addActionListener(al21);
		
		ActionListener al22=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CT.update(new CT(tf21.getText(),tf22.getText(),tf23.getText(),tf24.getText(),Integer.parseInt(tf26.getText()),tf25.getText()),ct.id,ct.tno);
					tableModel2.listCT=CT.list();
					table2.updateUI();
					JOptionPane.showMessageDialog(d, "�޸Ŀ���ɹ���");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "�޸Ŀ���ʧ�ܣ�");
				}
			}
		};
		b22.addActionListener(al22);
		
		ActionListener al23=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CT.delete(ct.id,ct.tno);
					tableModel2.listCT=CT.list();
					table2.updateUI();
					JOptionPane.showMessageDialog(d, "ɾ������ɹ���");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "ɾ������ʧ�ܣ�");
				}
			}
		};
		b23.addActionListener(al23);
		
//		�Ľ�
		TeacherTableModelEnd tableModel3=new TeacherTableModelEnd(CT,CS,S,v);
		JTable table3=new JTable(tableModel3);
		table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table3.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		JScrollPane sp3=new JScrollPane(table3);
		sp3.setPreferredSize(new Dimension(100,120));
		p3.add(sp3,BorderLayout.NORTH);

		
		d.setVisible(true);
	}
	
	public static void goUser(JFrame f,String id) {
		User v=U.get(id);
		JDialog d=new JDialog(f);
		d.setModal(true);
		d.setTitle("����Ա���˹���");
		d.setSize(450,250);
		d.setResizable(false);
		int gap=5;
		d.setLayout(new BorderLayout());
		d.setLocationRelativeTo(f);
		
		JTabbedPane tp=new JTabbedPane();
		String nameList[]= {"�������","������Ϣ"};
		JPanel p1=new JPanel(new BorderLayout());JPanel p2=new JPanel(new BorderLayout());
		tp.add(p1);tp.add(p2);
		tp.setTitleAt(0, nameList[0]);tp.setTitleAt(1, nameList[1]);
		d.add(tp);
//		p1.setLayout(new GridLayout(3,5,gap,gap));
		Dimension d120=new Dimension(120,30);
		Dimension d110=new Dimension(110,30);
		Dimension d100=new Dimension(100,30);
		Dimension d90=new Dimension(90,30);
		Dimension d80=new Dimension(80,30);
		Dimension d60=new Dimension(60,30);
		Dimension d50=new Dimension(50,30);
		Dimension d40=new Dimension(40,30);
		Dimension d20=new Dimension(20,30);
		
		
		UserTableModelStart tableModel1=new UserTableModelStart(CT,CU,T,v);
		JTable table1=new JTable(tableModel1);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.getColumnModel().getColumn(1).setPreferredWidth(150);
		CT ct=new CT();
		table1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
			public void valueChanged(ListSelectionEvent e) {
            // ��ȡ��һ�б�ѡ����
			int row = table1.getSelectedRow();
            // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
			ct.id = tableModel1.listCT.get(row).id;
			ct.tno=	tableModel1.listCT.get(row).tno;
			ct.ctype=tableModel1.listCT.get(row).ctype;
			ct.cname=tableModel1.listCT.get(row).cname;
			ct.ctno=tableModel1.listCT.get(row).ctno;
			ct.climit=tableModel1.listCT.get(row).climit;
			}
		});
		
		JScrollPane sp1=new JScrollPane(table1);
		sp1.setPreferredSize(new Dimension(100,71));
		p1.add(sp1,BorderLayout.NORTH);
		
		JPanel mid1=new JPanel();
		JLabel l1=new JLabel("���������");
		JTextField tf1=new JTextField();
		tf1.setPreferredSize(new Dimension(100,30));
		mid1.add(l1);mid1.add(tf1);
		p1.add(mid1,BorderLayout.CENTER);
		
		JPanel mid2=new JPanel();
		JButton b1=new JButton("����ͨ��");
		b1.setPreferredSize(new Dimension(100,30));
		mid2.add(b1);
		p1.add(mid2,BorderLayout.SOUTH);
		
		ActionListener al1=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tf1.getText().length()==0) {
					JOptionPane.showMessageDialog(d, "�����������Ϊ�գ�");
					return ;
				}
				try {
					CU.add(new CU(ct.id,v.adm,tf1.getText()));
					tableModel1.listCU=CU.list();
					table1.updateUI();
					JOptionPane.showMessageDialog(d, "����ɹ���");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "����ʧ�ܣ�");
				}
			}
		};
		b1.addActionListener(al1);
		
//		�Ľ�
		UserTableModelEnd tableModel2=new UserTableModelEnd(CU,CT,v);
		JTable table2=new JTable(tableModel2);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
			public void valueChanged(ListSelectionEvent e) {
            // ��ȡ��һ�б�ѡ����
			int row = table2.getSelectedRow();
            // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
			ct.id = tableModel2.listCT.get(row).id;
			}
		});
		
		JScrollPane sp2=new JScrollPane(table2);
		sp2.setPreferredSize(new Dimension(100,120));
		p2.add(sp2,BorderLayout.NORTH);
		JPanel mid3=new JPanel();
		JButton b2=new JButton("ɾ��");
		mid3.add(b2);
		p2.add(mid3,BorderLayout.SOUTH);
		//
				
		ActionListener al2=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CU.delete(ct.id,v.adm);
					tableModel2.listCU=CU.list();
					table2.updateUI();
					JOptionPane.showMessageDialog(d, "ɾ������ɹ���");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(d, "ɾ������ʧ�ܣ�");
				}
			}
		};
		b2.addActionListener(al2);

		
		d.setVisible(true);
	}
}
