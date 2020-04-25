package classes_objects;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestGUI {
	public static void main(String[] args) {
//		JFrame jf=new JFrame("LOL");
//		File f=new File("C:\\Data/location.txt");
//		String x="200",y="200";
//		if(f.exists()) {
//			if(f.length()!=0) {
//				try(FileInputStream fis=new FileInputStream(f)) {
//					byte b[]=new byte[(int)f.length()];
//					fis.read(b);
//					String s=new String(b);
//					String s2[]=s.split(" ");
//					x=s2[0];y=s2[1];
//				}
//				catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		jf.setSize(400,300);
//		jf.setLocation(Integer.parseInt(x),Integer.parseInt(y));
//		jf.setLayout(null);
//		JButton jb=new JButton("一键秒杀地方基地挂");
//		jb.setBounds(50,50,280,30);
//		jf.add(jb);
//		jf.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Object o=new Object();
//		Thread t=new Thread() {
//			public void run() {
//			//	synchronized(o) {
//					while(true) {
//						try {
//						//	o.wait(100);
//							Thread.sleep(100);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						File f=new File("C:\\Data/location.txt");
//			//			FileOutputStream fos=new FileOutputStream(f);
//						try(FileWriter w= new FileWriter(f);) {
//							String x=String.valueOf(jf.getX());
//							String y=String.valueOf(jf.getY());
//							String temp=x+" "+y;
//							w.write(temp);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//			//	}
//			}
//		};
//		t.setDaemon(true);
//		t.start();
		
//		
//		JFrame f=new JFrame("LOL");
//		f.setSize(400,300);
//		f.setLocation(580,200);
//		f.setLayout(null);
//	//	JLabel l=new JLabel("C:\\Data/shana.png");
//		//虽然上一行注释处也可以这样做
//		//但是这样就不方便调用图片的宽、高等参数了
//		//整一个ImageIcon对象，调用其getIconWidth方法！
//		JLabel l=new JLabel();
//		ImageIcon i=new ImageIcon("C:\\Data/shana.png");
//		l.setIcon(i);
//		l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
//		
//		
//		JButton b=new JButton("隐藏图片");
//	//	b.setName("隐藏图片");
//		b.setBounds(150,200,100,30);
//		f.add(b);
//		f.add(l);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
//	//	System.out.println(b.getName());
//	//	System.out.println(b.toString());
//		ActionListener l1=new ActionListener() {
//				boolean flag=true;
//				public void actionPerformed(ActionEvent e){
////					if(b.getName().equals("隐藏图片")) {
////						b.setText("显示图片");
////						b.setName("显示图片");
////						l.setVisible(false);
////						//理解一下。是要对内容（这个内容被设置在了标签中）显示
////						//所以是应该对包含了这个内容的对象进行操作！
////						//按钮如果隐藏了的话，那怎么进行事件操作呢？
////					}
////					else {
////						b.setText("隐藏图片");
////						b.setName("隐藏图片");
////						l.setVisible(true);
////					}
//					//上注释是我自己通过setName,getName方法来完成的！
//					//还有另一种方法是基于
//					//每点一次按钮，必定发生变化。这种思想来处理简化：
//					
//					
//					flag=!flag;
//					l.setVisible(flag);
//					String temp=flag?"隐藏图片":"显示图片";
//					b.setText(temp);
//					//这是个类，匿名类
//					//所以有类属性，直接通过类属性来操作很方便！
//				}
//			};
//		b.addActionListener(l1);
		
//		JFrame f=new JFrame("LOL");
//		f.setSize(400,300);
//		f.setLocation(580,200);
//		f.setLayout(null);
//		JLabel l=new JLabel();
//		ImageIcon i=new ImageIcon("C:\\Data/shana.png");
//		l.setIcon(i);
//	//	l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
//		l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
//		System.out.println("图片的宽为："+i.getIconWidth()+" 高为："+i.getIconHeight());
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.add(l);
//		f.setVisible(true);
//		f.addKeyListener(new KeyListener() {
//			public void keyPressed(KeyEvent e) {
//				switch(e.getKeyCode()) {	
//				case 38:
//					l.setLocation(l.getX(),l.getY()-10);break;
//				case 40:
//					l.setLocation(l.getX(),l.getY()+10);break;
//				case 37:
//					l.setLocation(l.getX()-10,l.getY());break;
//				case 39:
//					l.setLocation(l.getX()+10,l.getY());break;
//				}
//				System.out.println(e.getKeyCode()+" "+l.getX()+" "+l.getY());
//			}
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
//		JFrame f=new JFrame("LOL");
//		f.setSize(400,300);
//		f.setLocation(200,200);
//		f.setLayout(null);
//		JButton b=new JButton("打开一个模态窗口");
//		b.setBounds(50,50,280,30);
//		f.add(b);
//		ActionListener listener1=new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JDialog d=new JDialog(f,"模态窗口");
//			//	d.setTitle("模态窗口");
//				
//			//	d.setLocation(f.getX()+120,f.getY()+130);
//				d.setLocationRelativeTo(f);
//				//设置窗口相对于指定组件的位置。
//				
//				d.setSize(200,150);
//			//	d.setLayout(null);
//				d.setModal(true);
//				JButton b=new JButton("锁定大小");
//			//	b.setBounds(50,50,280,30);
//				//当窗口没有被设置为绝对布局时
//				//按钮会被填充完整个窗口
//				//所以这一行有没有都不影响最终效果
//				//从逻辑上来说也没必要写
//				
//				d.add(b);
//				ActionListener listener=new ActionListener() {
//					boolean flag=false;
//					public void actionPerformed(ActionEvent e) {
//						flag=!flag;
//						d.setResizable(flag);
//					}
//				};
//				b.addActionListener(listener);
//				d.setVisible(true);
//		//		d.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
//				//只有一个窗口需要设置这个
//				//被设置的窗口若被关闭，则程序结束！
//			}
//		};
//		b.addActionListener(listener1);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
//		JFrame f=new JFrame("计算器呃呃");
//		f.setSize(400,300);
//		f.setLocation(200,200);
//		int gap=10;
//		f.setLayout(new GridLayout(4,5,gap,gap));
////		f.setLayout(new FlowLayout(100,100,100));
//		JButton b;
//		
//		String set[]=new String[] {"7","8","9","/","sq","4","5","6","*","%"
//				,"1","2","3","-","1/x","0","+/-",".","+","="};
//		for(String s:set) {
//			b=new JButton(s);
////			b.setPreferredSize(new Dimension(180,40));
//			b.setPreferredSize(new Dimension(80,80));
//			f.add(b);
//		}
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		
//		JFrame f = new JFrame("LoL");
//        f.setSize(400, 300);
//        f.setLocation(200, 200);
//        f.setLayout(new FlowLayout());
// 
//        JButton b1 = new JButton("英雄1");
//        JButton b2 = new JButton("英雄2");
//        JButton b3 = new JButton("英雄3");
// 
//        // 即便 使用 布局器 ，也可以 通过setPreferredSize，向布局器建议该组件显示的大小
//        b3.setPreferredSize(new Dimension(180, 40));
// 
//        f.add(b1);
//        f.add(b2);
//        f.add(b3);
// 
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        f.setVisible(true);
		
//		JFrame f=new JFrame("LOL");
//		init(f);
//		JCheckBox cb=new JCheckBox();
//		String s=new String("我呃呃");
//		cb.setBounds(50, 50, 130, 30);
//		cb.setSelected(true);
//		//一定要记得设置范围！
//		//这四个参数分别是位置x,位置y,宽度，高度
//		//没有设置宽度、高度相当于设置为0！
//		//所以就会看不见，不显示！
		
		//相当于setSize、setLocation！
//		
//		cb.setText(s);
//		f.add(cb);
//		JCheckBox cb2=new JCheckBox("牛牛");
//		cb2.setBounds(50, 100, 130, 30);
//		f.add(cb2);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		init(f);
//		JRadioButton rb=new JRadioButton("我呃呃");
//		rb.setSelected(true);
//		rb.setBounds(50,50,130,30);
//		JRadioButton rb2=new JRadioButton();
//		rb2.setSize(130,30);
//		rb2.setLocation(50,100);
//	//	rb2.setBounds(50, 100, 130, 30);
//		rb2.setText("牛牛");
//		ButtonGroup bg=new ButtonGroup();
//		bg.add(rb);bg.add(rb2);
//		f.add(rb);f.add(rb2);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		init(f);
//		String s[]=new String[] {"?e","我呃呃","牛牛"};
//		JComboBox cbox=new JComboBox(s);
//		cbox.setBounds(50,50,130,30);
//		f.add(cbox);
//		finish(f);
		
		/*
		 * JFrame f=new JFrame("LOL"); init(f); finish(f);
		 */
//		int ok=JOptionPane.showConfirmDialog(f, "是否要呃呃？");
//		if(JOptionPane.OK_OPTION==ok) {
//			System.out.println(ok);
//			String s=JOptionPane.showInputDialog(f,"请输入呃呃");
//			if(s.equals("我呃呃")) {
//				JOptionPane.showMessageDialog(f, "不许呃呃");	
//			}
//		}
////		else System.out.println(ok);
//		else if(1==ok) {
//			JOptionPane.showMessageDialog(f, "好滴，，");
//		}
		
//		JFrame f=new JFrame("LOL");
//		initFlow(f);
//		JTextField tf1=new JTextField("请输入账号");
////		tf1.setPreferredSize(new Dimension(130,40));
//	//	tf1.setSize(130,40);
//		JTextField tf2=new JTextField("请输入密码");
//	//	tf2.setPreferredSize(new Dimension(130,40));
//		JLabel l1=new JLabel("账号");
//	//	l1.setSize(100,100);
//		JLabel l2=new JLabel("密码");
//	//	l2.setSize(50,50);
//		f.add(l1);f.add(tf1);
//		f.add(l2);f.add(tf2);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		initFlow(f);
//		JPasswordField pd=new JPasswordField();
//		pd.setText("我疯狂呃呃666");
//		JLabel l=new JLabel("密码：");
//		pd.grabFocus();
//		pd.setPreferredSize(new Dimension(130,40));
//		f.add(l);f.add(pd);
//		finish(f);
//		char s[]=pd.getPassword();
//	//	String xx=pd.getText();
//		//安全性问题。JPasswordField应该用getPassword方法
//		String x=new String(s);
//		System.out.println("密码是："+x);
//	//	System.out.println("密码是："+xx);
		
//		JFrame f=new JFrame("LOL");
//		initFlow(f);
//		JLabel l=new JLabel("文本域：");
//		JTextArea ta=new JTextArea();
//		ta.setText("我呃呃\n哽哽\r\n哦牛，，,,,,,,,,,");
//		ta.setPreferredSize(new Dimension(50,100));
//		f.add(l);f.add(ta);
//		ta.setLineWrap(true);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		f.setSize(400,300);
//		f.setLocation(200,200);
//		f.setLayout(null);
//		//布局一定要设置啊！不然就是铺满整个窗口！
//		JPanel p1=new JPanel();
//		p1.setBounds(50,50,300,60);
////		p1.setLayout(new FlowLayout());
//		// 这一句可以没有，因为JPanel默认就是采用的FlowLayout
//		
//		JButton pb1=new JButton("英雄1");
//		JButton pb2=new JButton("英雄2");
//		JButton pb3=new JButton("英雄3");
//		p1.setBackground(Color.BLUE);
//		p1.add(pb1);p1.add(pb2);p1.add(pb3);
//		
//		JPanel p2=new JPanel();
//		p2.setBounds(10,150,300,60);
//		p2.setBackground(Color.green);;
////		p2.setLayout(new GridLayout(3,1));
//	//	p2.setSize(100,100);
//		JButton p2b1=new JButton("英雄4");
//		JButton p2b2=new JButton("英雄5");
//		JButton p2b3=new JButton("英雄6");
//		p2.add(p2b1);p2.add(p2b2);p2.add(p2b3);
//		f.getContentPane().add(p1);
//		//Frame（门、玻璃等的框架）上面有一层东西，窗玻璃--Pane。
//		//所以很形象。就是ContentPane 内容玻璃。
//		//f.add()其实就是在Pane上添加内容
//		//就是f.getContentPane.add()。
//		System.out.println(p2b3.getParent());//在基本面板JPanel上
//		JButton test=new JButton("呃呃");
//		test.setSize(80,80);
//		f.add(test);System.out.println(test.getParent());
//		//打印可以看出，Parent是contentPane！
//	//	f.add(p1);
//		f.add(p2);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		f.setBounds(200,200,400,300);
//		f.setLayout(null);
//		JTextArea ta=new JTextArea();
////		ta.setSize(500,100);
//		ta.setLineWrap(true);
//		for (int i = 0; i < 100; i++) {
//			ta.append("dfaoewanoc");
//		}
//	//	f.add(ta);
//		JTextArea ta2=new JTextArea();
////		ta.setSize(500,100);
//		ta.setLineWrap(true);
//		for (int i = 0; i < 100; i++) {
//			ta2.append("d123415");
//		}
//		ta2.setLineWrap(true);
//		JScrollPane sp=new JScrollPane(ta);
//		sp.setSize(200,200);
//	//	sp.setViewportView(ta2);
//		f.add(sp);
////		f.setContentPane(sp);
////		f.setContentPane(ta);
//		//如果用其他pane代替了contentPane，似乎Frame不设置Layout也可显示内容
//		//似乎有点理解了
//		//因为本身Frame作为一个最基本的容器
//		//自身上带有一层Pane，这个Pane肯定得是空的
//		//以便来放其他的组件！
//		//若直接将其他Pane替换掉这个空的contentPane
//		//这个用来替换的Pane上如果有内容，自然而然就会显示！
//		
//		//缺点就是不能起到通过这个contentPane达到布局的作用了！
//		//直接Frame.add是在contentPane上add！
//		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		
		
		
		//CardLayout的show方法等有疑惑。。。
		
//		JFrame f=new JFrame("LOL");
//		f.setBounds(200,200,400,300);
//		f.setLayout(null);
//		JPanel p1=new JPanel();
//	//	p1.setLayout(new FlowLayout());//可有可无。默认是流式布局
//		JButton h1=new JButton("盖伦");
//		JButton h2=new JButton("提莫");
//		JButton h3=new JButton("安妮");
//		p1.add(h1);p1.add(h2);p1.add(h3);
//		JPanel card1=new JPanel();
//		JPanel card2=new JPanel();
//		JPanel card3=new JPanel();
////		JLabel l1=new JLabel("gareen");
////		JLabel l2=new JLabel("annie");
////		JLabel l3=new JLabel("teemo");
//		JLabel l1=new JLabel();
//		JLabel l2=new JLabel();
//		JLabel l3=new JLabel();
//		ImageIcon i1=new ImageIcon("C:\\Data\\pics/gareen.jpg");
//		ImageIcon i2=new ImageIcon("C:\\Data\\pics/annie.jpg");
//		ImageIcon i3=new ImageIcon("C:\\Data\\pics/teemo.jpg");
//		l1.setIcon(i1);l3.setIcon(i3);l2.setIcon(i2);
//		l1.setSize(i1.getIconWidth(),i1.getIconHeight());
//		l3.setSize(i3.getIconWidth(),i3.getIconHeight());
//		l2.setSize(i2.getIconWidth(),i2.getIconHeight());
//		card1.add(l1);card3.add(l3);card2.add(l2);
//		JPanel cards=new JPanel();
//		CardLayout cl=new CardLayout();
//		cards.setLayout(cl);
//		cards.add(card1,"gareen");cards.add(card2,"annie");cards.add(card3,"teemo");
//		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,cards);
//		sp.setDividerLocation(80);
//	//	f.add(sp);
//		f.setContentPane(sp);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
//		ActionListener al1=new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String name=h1.getText();
//				cl.show(cards, name);
//			}
//		};
//		
//		
//		ActionListener al2=new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("Here");
//				String name=h2.getText();
//				cl.show(cards, name);
//			}
//		};
//		ActionListener al3=new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//			//	String name=h3.getText();
//				String name=e.getActionCommand();
//				CardLayout cl=(CardLayout) cards.getLayout();
//				cl.show(cards, name);
//			}
//		};
//		h1.addActionListener(al1);
//		h2.addActionListener(al2);
//		h3.addActionListener(al3);
		
		
		
		JFrame f=new JFrame("LOL");
		f.setBounds(200,200,400,300);
		f.setLayout(null);
		JPanel p1=new JPanel();
	//	p1.setLayout(new FlowLayout());//可有可无。默认是流式布局
		JButton h1=new JButton("盖伦");
		JButton h2=new JButton("提莫");
		JButton h3=new JButton("安妮");
		p1.add(h1);p1.add(h2);p1.add(h3);
		JPanel card=new JPanel();
		JLabel l=new JLabel();
		ImageIcon i1=new ImageIcon("C:\\Data\\pics/gareen.jpg");
		ImageIcon i2=new ImageIcon("C:\\Data\\pics/annie.jpg");
		ImageIcon i3=new ImageIcon("C:\\Data\\pics/teemo.jpg");
		l.setIcon(i1);
		l.setSize(i1.getIconWidth(),i1.getIconHeight());
		card.add(l);
		CardLayout cl=new CardLayout();
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,card);
		sp.setDividerLocation(80);
	//	f.add(sp);
		f.setContentPane(sp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		ActionListener al1=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l.setIcon(i1);
				l.setSize(i1.getIconWidth(),i1.getIconHeight());
			}
		};
		
		
		ActionListener al2=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l.setIcon(i2);
				l.setSize(i2.getIconWidth(),i2.getIconHeight());
			}
		};
		ActionListener al3=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	String name=h3.getText();
				l.setIcon(i3);
				l.setSize(i3.getIconWidth(),i3.getIconHeight());
			}
		};
		h1.addActionListener(al1);
		h2.addActionListener(al2);
		h3.addActionListener(al3);
	}
	public static void init(JFrame f) {
//		f.setSize(400,300);
//		f.setLocation(200,200);
		f.setBounds(200,200,400,300);
		f.setLayout(null);
	}
	public static void initFlow(JFrame f) {
//		f.setSize(400,300);
//		f.setLocation(200,200);
		f.setBounds(200,200,400,300);
		f.setLayout(new FlowLayout());
	}
	public static void finish(JFrame f) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
