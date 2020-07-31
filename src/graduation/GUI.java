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
//	初始化DAO
	public static DAO<User> U=new DAO<>("graduation.User");
	public static DAO<Teacher> T=new DAO<>("graduation.Teacher");
	public static DAO<Student> S=new DAO<>("graduation.Student");
	public static DAO<CS> CS=new DAO<>("graduation.CS");
	public static DAO<CT> CT=new DAO<>("graduation.CT");
	public static DAO<CU> CU=new DAO<>("graduation.CU");
	
	public static void main(String[] args) {
		
		JFrame f=new JFrame("毕业设计管理系统");
//		初始化菜单
		initMenu(f);
		f.setLocation(330, 190);
		f.setSize(650,380);
		f.setLayout(new FlowLayout());
		f.setResizable(false);
//		初始化最初的界面（登录、注册）
		initLogin(f);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void initLogin(JFrame f) {
//		最开始的界面设计（欢迎界面，登录按钮，注册按钮）
		JPanel login=new JPanel();
		login.setLayout(new BorderLayout());
//		BorderLayout的北边Pane
		JPanel pUp=new JPanel();
		pUp.setLayout(new BorderLayout());
		JLabel word1=new JLabel("欢迎使用",JLabel.CENTER);
		JLabel word2=new JLabel("毕业设计管理系统",JLabel.CENTER);
		word1.setFont(new Font("宋体",1,40));
		word2.setFont(new Font("宋体",1,40));
		pUp.add(word1,BorderLayout.CENTER);pUp.add(word2,BorderLayout.SOUTH);
//		欢迎字样和注册按钮在同一个Pane上，北边排列
		login.add(pUp,BorderLayout.NORTH);
		
//		BorderLayout的南边Pane
		JPanel pDown=new JPanel(new BorderLayout());
//		布局靠上的Pane，下拉框
		JPanel pDownUpPane=new JPanel();
		String[] s= {"管理员","教师","学生"};
		JComboBox cb=new JComboBox(s);
		JLabel l=new JLabel("请选择登录类型：");
		l.setFont(new Font("黑体",1,20));
		cb.setPreferredSize(new Dimension(100,30));
		pDownUpPane.add(l);pDownUpPane.add(cb);
//		布局靠下的Pane，实现登录功能的一堆组件
		JPanel pDownDownPane=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel l1=new JLabel("账号：");
		JTextField tf1=new JTextField();
		tf1.setPreferredSize(new Dimension(100,30));
		JLabel l2=new JLabel("密码：");
		JPasswordField tf2=new JPasswordField();
		tf2.setPreferredSize(new Dimension(100,30));
		JButton b=new JButton("登录");
		pDownDownPane.add(l1);pDownDownPane.add(tf1);
		pDownDownPane.add(l2);pDownDownPane.add(tf2);
		pDownDownPane.add(b);
//		按下登录，进行响应
		ActionListener al=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				type记录登录的用户类型
//				1：管理员	2：教师	3：学生
//				0: 登录失败，不作处理
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
		JButton b4=new JButton("用户注册");
		b4.setPreferredSize(new Dimension(90,50));
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog d=new JDialog(f);
				d.setModal(true);
				d.setTitle("用户注册");
				d.setSize(350,200);
				int gap=10;
				d.setLayout(new BorderLayout());
				d.setLocationRelativeTo(f);
				
				JPanel p=new JPanel(new GridLayout(4,2,gap,gap));
				JLabel l=new JLabel("                请选择注册类型：");
				l.setSize(200,200);
				String[] s= {"管理员","教师","学生"};
				JComboBox cb=new JComboBox(s);
				cb.setFocusable(false);
				cb.setSize(80,30);
				JLabel l1=new JLabel("                        账号：");
				JTextField tf1=new JTextField();
				JLabel l2=new JLabel("                        密码：");
				JPasswordField tf2=new JPasswordField();
				JButton b=new JButton("注册");
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
			JOptionPane.showMessageDialog(d, "用户名和密码不能为空！");
		}
		else if(id.length()==0)JOptionPane.showMessageDialog(d, "用户名不能为空！");
		else if(pwd.length()==0)JOptionPane.showMessageDialog(d, "密码不能为空！");
		else if(pwd.length()!=6)JOptionPane.showMessageDialog(d, "密码必须设置为六位数字！");
		else {
			String s=(String)cb.getSelectedItem();
			switch(s) {
			case "管理员":
				try {
					U.add(new User(id,pwd));
					JOptionPane.showMessageDialog(d, "成功创建管理员用户！");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(d, "此管理员用户已存在！");
				}finally {
					break;
				}
			case "学生":
				try {
					S.add(new Student(id,pwd));
					JOptionPane.showMessageDialog(d, "成功创建学生用户！");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(d, "此学生用户已存在！");
				}finally {
					break;
				}
			case "教师":
				try {
					T.add(new Teacher(id,pwd));
					JOptionPane.showMessageDialog(d, "成功创建教师用户！");
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(d, "此教师用户已存在！");
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
			JOptionPane.showMessageDialog(f, "用户名和密码不能为空！");
		}
		else if(id.length()==0)JOptionPane.showMessageDialog(f, "用户名不能为空！");
		else if(pwd.length()==0)JOptionPane.showMessageDialog(f, "密码不能为空！");
		else if(pwd.length()!=6)JOptionPane.showMessageDialog(f, "密码必须为六位数字！");
		else {
			String type=(String)cb.getSelectedItem();
			switch(type) {
			case "管理员":
				User u=U.get(id);
				if(u==null)	
					JOptionPane.showMessageDialog(f, "用户不存在！");
				else if(u.getPwd().equals(pwd)) {
					JOptionPane.showMessageDialog(f, "登录管理员用户成功！");
					return 1;
				}
				else
					JOptionPane.showMessageDialog(f, "密码错误！");
				break;
			case "教师":
				Teacher t=T.get(id);
				if(t==null)
					JOptionPane.showMessageDialog(f, "用户不存在！");
				else if(t.getPwd().equals(pwd)) {
					JOptionPane.showMessageDialog(f, "登录教师用户成功！");
					return 2;
				}
				else
					JOptionPane.showMessageDialog(f, "密码错误！");
				break;
			case "学生":
				Student s=S.get(id);
				if(s==null)
					JOptionPane.showMessageDialog(f, "用户不存在！");
				else if(s.getPwd().equals(pwd)) {
					JOptionPane.showMessageDialog(f, "登录学生用户成功！");
					return 3;
				}
				else
					JOptionPane.showMessageDialog(f, "密码错误！");
				break;	
			}
		}
		return 0;
	}
	
	public static void initMenu(JFrame f) {
		JMenuBar mb=new JMenuBar();
		JMenu help=new JMenu("使用说明(H)");
		JMenuItem h1=new JMenuItem("注册");
		JMenuItem h2=new JMenuItem("登录");
		JMenuItem h3=new JMenuItem("信息说明");
		h1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(f, "尚未注册的用户请先进行注册之后登录才能够使用本系统！");
			}
		});
		h2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(f, "请在注册之后输入正确的账号密码进行登录！");
			}
		});
		h3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(f, "信息框为null说明为空值，同样可以输入null来表示留空！");
			}
		});
		help.add(h1);help.add(h2);help.add(h3);
		mb.add(help);
        f.setJMenuBar(mb);
	}
	
//	学生管理功能实现
	public static void goStudent(JFrame f,String id) {
		Student v=S.get(id);
//		System.out.println(v);
		JDialog d=new JDialog(f);
		d.setModal(true);
		d.setTitle("学生个人管理");
		d.setSize(450,250);
		d.setResizable(false);
		int gap=5;
		d.setLayout(new BorderLayout());
		d.setLocationRelativeTo(f);
		
		JTabbedPane tp=new JTabbedPane();
		String nameList[]= {"个人信息","选题信息","选题结果"};
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
		JLabel l1=new JLabel("学号：");JTextField tf1=new JTextField(v.sno);tf1.setPreferredSize(d80);
		JLabel l2=new JLabel("姓名：");JTextField tf2=new JTextField(v.sn);tf2.setPreferredSize(d50);
		JLabel l3=new JLabel("性别：");JTextField tf3=new JTextField(v.ssex);tf3.setPreferredSize(d20);
		JLabel l4=new JLabel("密码：");JTextField tf4=new JTextField(v.spwd);tf4.setPreferredSize(d50);
		JLabel l5=new JLabel("专业：");JTextField tf5=new JTextField(v.sdept);tf5.setPreferredSize(d110);
		JLabel l6=new JLabel("班级：");JTextField tf6=new JTextField(v.sclass);tf6.setPreferredSize(d40);
		JLabel l7=new JLabel("联系电话：");JTextField tf7=new JTextField(v.stel);tf7.setPreferredSize(d90);
		p1.add(l1);p1.add(tf1);p1.add(l2);p1.add(tf2);p1.add(l3);p1.add(tf3);
		p1.add(l4);p1.add(tf4);p1.add(l5);p1.add(tf5);p1.add(l6);p1.add(tf6);
		p1.add(l7);p1.add(tf7);
		JButton b1=new JButton("修改信息");
		p1.add(b1);
		ActionListener al1=new ActionListener() {
			String sno=id;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student newStudent=new Student(tf1.getText(),tf2.getText(),tf3.getText(),
						tf5.getText(),tf6.getText(),tf7.getText(),tf4.getText());
				boolean flag=false;
				if(tf4.getText().length()!=6)JOptionPane.showMessageDialog(d, "密码必须为六位数字！");
				else {
					try {
						S.update(newStudent, sno);
						JOptionPane.showMessageDialog(d, "用户信息更新成功！");
						flag=true;
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(d, "更新失败，请检查信息的正确性！");
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
            // 当选择了某一行的时候触发该事件
			public void valueChanged(ListSelectionEvent e) {
            // 获取哪一行被选中了
			int row = table2.getSelectedRow();
            // 根据选中的行，到HeroTableModel中获取对应的对象
			ct.id = tableModel2.listCT.get(row).id;
			ct.tno=	tableModel2.listCT.get(row).tno;
			}
		});
		JScrollPane sp2=new JScrollPane(table2);
		sp2.setPreferredSize(new Dimension(100,71));
		p2.add(sp2,BorderLayout.NORTH);
		JPanel mid2=new JPanel();
		JButton b2=new JButton("选择课题");
		mid2.add(b2);
		p2.add(mid2,BorderLayout.CENTER);

		
		StudentTableModelEnd tableModel3=new StudentTableModelEnd(CS,S,v);
		JTable table3=new JTable(tableModel3);
		table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CS cs=new CS();
		table3.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // 当选择了某一行的时候触发该事件
			CS temp;
			public void valueChanged(ListSelectionEvent e) {
            // 获取哪一行被选中了
			int row = table3.getSelectedRow();
            // 根据选中的行，到HeroTableModel中获取对应的对象
			cs.id = tableModel3.listCS.get(row).id;
			cs.sno=	tableModel3.listCS.get(row).sno;
			}
		});
		JScrollPane sp3=new JScrollPane(table3);
		sp3.setPreferredSize(new Dimension(100,120));
		p3.add(sp3,BorderLayout.NORTH);
		JPanel mid3=new JPanel();
		JButton b3=new JButton("删除课题");
		mid3.add(b3);
		p3.add(mid3,BorderLayout.CENTER);

		ActionListener al2=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				try {
					CS.add(new CS(ct.id,v.sno));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(d, "选择课题失败！该课题已被选择或选择人数已达上限，请重新选择！");
					flag=false;
				}
				if(flag)JOptionPane.showMessageDialog(d, "选择课题成功！");
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
					JOptionPane.showMessageDialog(d, "删除课题失败！");
					flag=false;
				}
				if(flag)JOptionPane.showMessageDialog(d, "删除课题成功！");
				tableModel3.listCS=CS.list();
				table3.updateUI();
			}
		};
		b3.addActionListener(al3);
		
		d.setVisible(true);
	}
	
//	教师管理功能实现
	public static void goTeacher(JFrame f,String id) {
		Teacher v=T.get(id);
//		System.out.println(v);
		JDialog d=new JDialog(f);
		d.setModal(true);
		d.setTitle("教师个人管理");
		d.setSize(450,250);
		d.setResizable(false);
		int gap=5;
		d.setLayout(new BorderLayout());
		d.setLocationRelativeTo(f);
		
		JTabbedPane tp=new JTabbedPane();
		String nameList[]= {"个人信息","课题信息","选题结果"};
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
		JLabel l1=new JLabel("教师号：");JTextField tf1=new JTextField(v.tno);tf1.setPreferredSize(d80);
		JLabel l2=new JLabel("姓名：");JTextField tf2=new JTextField(v.tn);tf2.setPreferredSize(d50);
		JLabel l3=new JLabel("性别：");JTextField tf3=new JTextField(v.tsex);tf3.setPreferredSize(d20);
		JLabel l4=new JLabel("密码：");JTextField tf4=new JTextField(v.tpwd);tf4.setPreferredSize(d50);
		JLabel l5=new JLabel("职称：");JTextField tf5=new JTextField(v.ttitle);tf5.setPreferredSize(d110);
//		JLabel l6=new JLabel("班级：");JTextField tf6=new JTextField(v.sclass);tf6.setPreferredSize(d40);
		JLabel l7=new JLabel("联系电话：");JTextField tf7=new JTextField(v.ttel);tf7.setPreferredSize(d90);
		p1.add(l1);p1.add(tf1);p1.add(l2);p1.add(tf2);p1.add(l3);p1.add(tf3);
		p1.add(l4);p1.add(tf4);p1.add(l5);p1.add(tf5);
		//p1.add(l6);p1.add(tf6);
		p1.add(l7);p1.add(tf7);
		JButton b1=new JButton("修改信息");
		p1.add(b1);
		ActionListener al1=new ActionListener() {
			String tno=id;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Teacher newTeacher=new Teacher(tf1.getText(),tf2.getText(),tf3.getText(),
						tf5.getText(),tf7.getText(),tf4.getText());
				boolean flag=false;
				if(tf4.getText().length()!=6)JOptionPane.showMessageDialog(d, "密码必须为六位数字！");
				else {
					try {
						T.update(newTeacher, tno);
						JOptionPane.showMessageDialog(d, "用户信息更新成功！");
						flag=true;
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(d, "更新失败，请检查信息的正确性！");
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
		
		//	需要改进
		JPanel mid1=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel l21=new JLabel("编号：");JTextField tf21=new JTextField();tf21.setPreferredSize(d40);
		JLabel l22=new JLabel("名称：");JTextField tf22=new JTextField();tf22.setPreferredSize(d120);
		JLabel l23=new JLabel("类型：");JTextField tf23=new JTextField();tf23.setPreferredSize(d60);
		JLabel l24=new JLabel("发布教师(编号)：");JTextField tf24=new JTextField();tf24.setPreferredSize(d60);
		JLabel l25=new JLabel("指导教师：");JTextField tf25=new JTextField();tf25.setPreferredSize(d60);
		JLabel l26=new JLabel("限选：");JTextField tf26=new JTextField();tf26.setPreferredSize(d40);
		mid1.add(l21);mid1.add(tf21);mid1.add(l22);mid1.add(tf22);
		mid1.add(l23);mid1.add(tf23);mid1.add(l24);mid1.add(tf24);
		mid1.add(l25);mid1.add(tf25);mid1.add(l26);mid1.add(tf26);
		p2.add(mid1,BorderLayout.CENTER);
		
		table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // 当选择了某一行的时候触发该事件
			public void valueChanged(ListSelectionEvent e) {
            // 获取哪一行被选中了
			int row = table2.getSelectedRow();
            // 根据选中的行，到HeroTableModel中获取对应的对象
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
		JButton b21=new JButton("新增课题");
		JButton b22=new JButton("修改课题");
		JButton b23=new JButton("删除课题");
		mid2.add(b21);mid2.add(b22);mid2.add(b23);
		p2.add(mid2,BorderLayout.SOUTH);
		ActionListener al21=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CT newCT=new CT(tf21.getText(),tf22.getText(),tf23.getText(),v.tno,Integer.parseInt(tf26.getText()),tf25.getText());
				if(!tf24.getText().equals(ct.tno)) {
					JOptionPane.showMessageDialog(d, "只能发布自己的课题！");return;
				}
				try {
					System.out.println(newCT);
					CT.add(newCT);
					tableModel2.listCT=CT.list();
					table2.updateUI();
					JOptionPane.showMessageDialog(d, "新建课题成功！");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "新建课题失败，该课题编号已存在！");				}
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
					JOptionPane.showMessageDialog(d, "修改课题成功！");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "修改课题失败！");
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
					JOptionPane.showMessageDialog(d, "删除课题成功！");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "删除课题失败！");
				}
			}
		};
		b23.addActionListener(al23);
		
//		改进
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
		d.setTitle("管理员个人管理");
		d.setSize(450,250);
		d.setResizable(false);
		int gap=5;
		d.setLayout(new BorderLayout());
		d.setLocationRelativeTo(f);
		
		JTabbedPane tp=new JTabbedPane();
		String nameList[]= {"待审课题","评审信息"};
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
            // 当选择了某一行的时候触发该事件
			public void valueChanged(ListSelectionEvent e) {
            // 获取哪一行被选中了
			int row = table1.getSelectedRow();
            // 根据选中的行，到HeroTableModel中获取对应的对象
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
		JLabel l1=new JLabel("评审意见：");
		JTextField tf1=new JTextField();
		tf1.setPreferredSize(new Dimension(100,30));
		mid1.add(l1);mid1.add(tf1);
		p1.add(mid1,BorderLayout.CENTER);
		
		JPanel mid2=new JPanel();
		JButton b1=new JButton("评审通过");
		b1.setPreferredSize(new Dimension(100,30));
		mid2.add(b1);
		p1.add(mid2,BorderLayout.SOUTH);
		
		ActionListener al1=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tf1.getText().length()==0) {
					JOptionPane.showMessageDialog(d, "评审意见不能为空！");
					return ;
				}
				try {
					CU.add(new CU(ct.id,v.adm,tf1.getText()));
					tableModel1.listCU=CU.list();
					table1.updateUI();
					JOptionPane.showMessageDialog(d, "评审成功！");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(d, "评审失败！");
				}
			}
		};
		b1.addActionListener(al1);
		
//		改进
		UserTableModelEnd tableModel2=new UserTableModelEnd(CU,CT,v);
		JTable table2=new JTable(tableModel2);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            // 当选择了某一行的时候触发该事件
			public void valueChanged(ListSelectionEvent e) {
            // 获取哪一行被选中了
			int row = table2.getSelectedRow();
            // 根据选中的行，到HeroTableModel中获取对应的对象
			ct.id = tableModel2.listCT.get(row).id;
			}
		});
		
		JScrollPane sp2=new JScrollPane(table2);
		sp2.setPreferredSize(new Dimension(100,120));
		p2.add(sp2,BorderLayout.NORTH);
		JPanel mid3=new JPanel();
		JButton b2=new JButton("删除");
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
					JOptionPane.showMessageDialog(d, "删除评审成功！");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(d, "删除评审失败！");
				}
			}
		};
		b2.addActionListener(al2);

		
		d.setVisible(true);
	}
}
