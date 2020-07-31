package classes_objects;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class TestGUI{
	public static void main(String[] args) {
//
//		JFrame f=new JFrame("LOL");
//		JButton b=new JButton("一键秒对方基地挂");
//		
//		f.setLayout(null);
//		f.add(b);
//		b.setBounds(50, 50, 280, 30);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		File ff=new File("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\classes_objects\\location.txt");
//		if(ff.exists()) {
//			try(FileInputStream fis= new FileInputStream(ff);
//					DataInputStream dis=new DataInputStream(fis)) {
//				int x=dis.readInt();int y=dis.readInt();
//				f.setBounds(x, y, 400, 300);
//			} catch (FileNotFoundException e3) {
//				// TODO Auto-generated catch block
//				e3.printStackTrace();
//			} catch (IOException e4) {
//				// TODO Auto-generated catch block
//				e4.printStackTrace();
//			}
//		}
//		else {
//			try {
//				ff.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			f.setBounds(200, 200, 400, 300);
//		}
//		Thread t1=new Thread() {
//			public void run() {
//				File ff=new File("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\classes_objects\\location.txt");
//				while(true) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//					try(FileOutputStream fos= new FileOutputStream(ff);
//							DataOutputStream dos=new DataOutputStream(fos)) {
//						int x=f.getX();int y=f.getY();
//						dos.writeInt(x);
//						dos.writeInt(y);
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//		};
//		t1.start();
//		JFrame f=new JFrame("LOL");
//		f.setBounds(580, 200, 400, 300);
//		f.setLayout(null);
//		JLabel l=new JLabel();
//		ImageIcon i=new ImageIcon("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\shana.png");
//		l.setIcon(i);
//		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
//		JButton b=new JButton("隐藏图片");
//		b.setBounds(150, 200, 100, 30);
//		
//		ActionListener listener=new ActionListener() {
//			boolean flag=false;
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				l.setVisible(flag);
//				flag=!flag;
//				if(flag)
//					b.setText("显示图片");
//				else
//					b.setText("隐藏图片");
//			}
//		};
//		b.addActionListener(listener);
//		f.add(l);f.add(b);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JFrame f = new JFrame("LoL");
//        f.setSize(400, 300);
//        f.setLocation(580, 200);
//        f.setLayout(null);
//  
//        final JLabel l = new JLabel();
//  
//        ImageIcon i = new ImageIcon("C:\\\\Users\\\\57195\\\\Desktop\\\\Learning--Java\\\\src\\\\pic\\\\shana.png");
//        l.setIcon(i);
//        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
//  
//        // 增加键盘监听
//        f.addKeyListener(new KeyListener() {
//  
//            // 键被弹起
//            public void keyReleased(KeyEvent e) {
//            	System.out.println(e.getKeyCode());
//                // 39代表按下了 “右键”
//            	switch(e.getKeyCode()) {
//            		case 37:
//            			l.setLocation(l.getX() - 10, l.getY());break;
//            		case 38:
//            			l.setLocation(l.getX() , l.getY() - 10);break;
//            		case 39:
//            			l.setLocation(l.getX() + 10, l.getY());break;
//            		case 40:
//            			l.setLocation(l.getX() , l.getY() + 10);break;
//            	}
//            }
//  
//            //键被按下
//            public void keyPressed(KeyEvent e) {
//                // TODO Auto-generated method stub
//  
//            }
//  
//            // 一个按下弹起的组合动作
//            public void keyTyped(KeyEvent e) {
//  
//            }
//        });
//  
//        f.add(l);
//        
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  
//        f.setVisible(true);
//		
		
//		JFrame f=new JFrame("LoL");
//		f.setLocationRelativeTo(null);
//		f.setSize(400, 300);
////		f.setBounds(200, 200, 400, 300);
//		f.setLayout(null);
//		String name1="annie";
//		String name2="gareen";
//		String name3="teemo";
//		JPanel card1=init(name1);
//		JPanel card2=init(name2);
//		JPanel card3=init(name3);
//		//	splitpane的右边
//		JPanel cards=new JPanel();
//		cards.setLayout(new CardLayout());
//		cards.add(card1,name1);
//		cards.add(card2,name2);
//		cards.add(card3,name3);
//		//	splitpane的左边
//		JPanel leftPane=new JPanel();
//		leftPane.setBounds(50, 50, 300, 60);
//		leftPane.setLayout(new FlowLayout());
//		JButton b1=initButton(name1,cards);
//		JButton b2=initButton(name2,cards);
//		JButton b3=initButton(name3,cards);
//		leftPane.add(b1);
//		leftPane.add(b2);
//		leftPane.add(b3);
//		
//		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPane,cards);
//		sp.setDividerLocation(80);
////		sp.setBounds(0, 0, 500, 300);
////		f.add(sp);
//		f.setContentPane(sp);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);	
		
//		JFrame f=new JFrame("LOL");
//		f.setLocationRelativeTo(null);
//		f.setSize(400,300);
//		f.setLayout(null);
////		JPanel默认采用流式布局
//		JPanel pane=new JPanel();
//		JTextField tf=new JTextField();
//		tf.setPreferredSize(new Dimension(80,30));
//		JButton b=new JButton("检测");
//		b.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String get=tf.getText();
//				try {
//					Integer.parseInt(get);
//				}
//				catch(Exception e2) {
//					JOptionPane.showMessageDialog(f, "输入框内容不是整数");
//				}
//				tf.grabFocus();
//			}
//		});
//		pane.add(tf);pane.add(b);
//		f.setContentPane(pane);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		
////		前后端交互（JDBC）
//		
//		JFrame f=new JFrame("LOL");
//		f.setLocationRelativeTo(null);
//		f.setSize(400,300);
//		f.setLayout(new BorderLayout());
////		JPanel默认采用流式布局
//		JPanel pNorth=new JPanel();
//		JPanel pCenter=new JPanel();
//		JLabel l1=new JLabel("账号：");
//		JTextField tf1=new JTextField(); 
//		tf1.setPreferredSize(new Dimension(80,30));
//		JLabel l2=new JLabel("密码：");
//		JPasswordField tf2=new JPasswordField(); 
//		tf2.setPreferredSize(new Dimension(80,30));
//		pNorth.add(l1);pNorth.add(tf1);pNorth.add(l2);pNorth.add(tf2);
//		JButton b=new JButton("登录");
//		pCenter.add(b);
//		f.add(pNorth,BorderLayout.NORTH);
//		f.add(pCenter,BorderLayout.CENTER);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
//		ActionListener al=new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String s1=tf1.getText();String s2=tf2.getText();
//				if(s1.length()!=0&&s2.length()!=0) {
//					try {
//			            Class.forName("com.mysql.jdbc.Driver");
//			        } catch (ClassNotFoundException e1) {
//			            e1.printStackTrace();
//			        }
//					try(Connection c=DriverManager.getConnection("jdbc:mysql:"
//							+ "//127.0.0.1:3306/graduation?characterEncoding=UTF-8"
//							,"root","admin");
//							Statement s=c.createStatement()){
//						String sql="select pwd from U where adm="+s1+" and pwd="+s2;
////						ResultSet rs = s.executeQuery(sql);
//						
//						s.execute(sql);
//						ResultSet rs=s.getResultSet();
//						
//						boolean flag=false;
////						if(rs.next()) {
////							String pwd=rs.getString(1);
////							System.out.println(s2);
////							System.out.println(pwd);
////							if(pwd.equals(s2)) {
////								flag=true;
////								System.out.println("Yes!");
////							}
////						}
//						if(rs.next()) {
//							flag=true;
//						}
//						if(flag) {
//							JOptionPane.showMessageDialog(f, "登录成功！");
//						}
//						else {
//							JOptionPane.showMessageDialog(f, "登录失败！");
//						}
//						
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//				else {
//					JOptionPane.showMessageDialog(f, "请完整输入账号密码！");
//					if(s1.length()!=0&&s2.length()==0)tf2.grabFocus();
//					else tf1.grabFocus();
//				}
//			}
//		};
//		b.addActionListener(al);
		
		
//		JFrame f=new JFrame("LoL");
//		f.setSize(400,300);
//		f.setLocationRelativeTo(null);
//		JPanel p=new JPanel();
//		JProgressBar pb=new JProgressBar();
//		pb.setMaximum(100);
//		pb.setStringPainted(true);
//		p.add(pb);
//		f.setContentPane(p);
//		Thread t=new Thread() {
//			int gap=0;
//			public void run() {
//				try {
//					while(pb.getValue()<100) {
//						Thread.sleep(10+gap);
//						gap+=5;
//						pb.setValue(pb.getValue()+1);
//					}
//					if(pb.getValue()>=100) {
//						JOptionPane.showMessageDialog(f, "加载完成！");
//					}
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		t.start();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
//		JFrame f=new JFrame("记事本");
//		f.setSize(400,300);
//		f.setLocationRelativeTo(null);
////		f.setLayout(null);
//		JMenuBar mb=new JMenuBar();
//		JMenu m1=new JMenu("文件(A)");
//		JMenu m2=new JMenu("编辑(E)");
//		JMenu m3=new JMenu("格式(O)");
//		JMenu m4=new JMenu("查看(V)");
//		JMenu m5=new JMenu("帮助(H)");
//		mb.add(m1);mb.add(m2);mb.add(m3);mb.add(m4);mb.add(m5);
//		JMenuItem i1=new JMenuItem("撤销(U)                         Ctrl+Z");
//		
//		JMenuItem i2=new JMenuItem("剪切(T)\t\tCtrl+X");
//		JMenuItem i3=new JMenuItem("撤销(U)\t\tCtrl+C");
//		JMenuItem i4=new JMenuItem("撤销(U)\t\tCtrl+V");
//		JMenuItem i5=new JMenuItem("撤销(U)\t\t  Del");
//		
//		JMenuItem i6=new JMenuItem("撤销(U)\t\tCtrl+F");
//		JMenuItem i7=new JMenuItem("撤销(U)\t\t     F3");
//		JMenuItem i8=new JMenuItem("撤销(U)\t\tCtrl+H");
//		JMenuItem i9=new JMenuItem("撤销(U)\t\tCtrl+G");
//		
//		JMenuItem i10=new JMenuItem("撤销(U)\t\tCtrl+A");
//		JMenuItem i11=new JMenuItem("撤销(U)\t\t     F5");
//		
//		m2.add(i1);m2.addSeparator();
//		m2.add(i2);m2.add(i3);m2.add(i4);m2.add(i5);m2.addSeparator();
//		m2.add(i6);m2.add(i7);m2.add(i8);m2.add(i9);m2.addSeparator();
//		m2.add(i10);m2.add(i11);
//		
//		JTextArea ta=new JTextArea();
////		f.add(ta);
//		ta.setLineWrap(true);
//		JScrollPane sp=new JScrollPane(ta);
//		f.add(sp);
//		
//		
//		f.setJMenuBar(mb);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
//		JFrame f = new JFrame("LoL");
//        f.setSize(400, 300);
//        f.setLocation(200, 200);
//        // 菜单
//        addMenu(f);
// 
//        // 工具栏
//        JToolBar tb = new JToolBar();
//        // 为工具栏增加按钮
//        JButton b1 = new JButton();
//        JButton b2 = new JButton(new ImageIcon("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\2.jpg"));
//        JButton b3 = new JButton(new ImageIcon("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\3.jpg"));
//        JButton b4 = new JButton(new ImageIcon("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\4.jpg"));
//        JButton b5 = new JButton(new ImageIcon("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\5.jpg"));
//        JButton b6 = new JButton(new ImageIcon("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\6.jpg"));
//        tb.add(b1);
//        ImageIcon i=new ImageIcon("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\1.jpg");
//        b1.setIcon(i);
//        b1.setToolTipText("牛牛英雄");
//        tb.add(b2);
//        tb.add(b3);
//        tb.add(b4);
//        tb.add(b5);
//        tb.add(b6);
//        
//        tb.setFloatable(false);
// 
//        // 把工具栏放在north的位置
//        f.setLayout(new BorderLayout());
//        f.add(tb, BorderLayout.NORTH);
// 
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        f.setVisible(true);
		
		JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        // 表格上的title
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        // 表格中的内容，是一个二维数组
        String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
        JTable t = new JTable(heros, columnNames);
        
        
        
        JScrollPane sp=new JScrollPane(t);
        f.add(sp,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
		
	}
	private static void addMenu(JFrame f) {
        JMenuBar mb = new JMenuBar();
 
        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        JMenu mSummon = new JMenu("召唤师");
        JMenu mTalent = new JMenu("天赋树");
 
        // 菜单项
        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));
 
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        f.setJMenuBar(mb);
    }
	public static JButton initButton(String name,JPanel cards) {
		JButton b=new JButton(name);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl=(CardLayout)cards.getLayout();
				cl.show(cards, name);
			}
		});
		return b;
	}
	public static JPanel init(String name) {
		String target="C:\\Users\\57195\\Desktop\\Learning--Java\\src\\pic\\"+name+".jpg";
//		System.out.println(target);
		JPanel Pane=new JPanel();
		JLabel l=new JLabel();
		ImageIcon i=new ImageIcon(target);
		l.setIcon(i);
		l.setBounds(50 , 50, i.getIconWidth(), i.getIconHeight());
		Pane.add(l);
		return Pane;
	}
}