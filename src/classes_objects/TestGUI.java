package classes_objects;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		JFrame f=new JFrame("LOL");
		init(f);
		JRadioButton rb=new JRadioButton("我呃呃");
		rb.setSelected(true);
		rb.setBounds(50,50,130,30);
		JRadioButton rb2=new JRadioButton();
		rb2.setSize(130,30);
		rb2.setLocation(50,100);
	//	rb2.setBounds(50, 100, 130, 30);
		rb2.setText("牛牛");
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb);bg.add(rb2);
		f.add(rb);f.add(rb2);
		finish(f);
	}
	public static void init(JFrame f) {
//		f.setSize(400,300);
//		f.setLocation(200,200);
		f.setBounds(200,200,400,300);
		f.setLayout(null);
	}
	public static void finish(JFrame f) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
