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
//		JButton jb=new JButton("һ����ɱ�ط����ع�");
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
//		//��Ȼ��һ��ע�ʹ�Ҳ����������
//		//���������Ͳ��������ͼƬ�Ŀ��ߵȲ�����
//		//��һ��ImageIcon���󣬵�����getIconWidth������
//		JLabel l=new JLabel();
//		ImageIcon i=new ImageIcon("C:\\Data/shana.png");
//		l.setIcon(i);
//		l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
//		
//		
//		JButton b=new JButton("����ͼƬ");
//	//	b.setName("����ͼƬ");
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
////					if(b.getName().equals("����ͼƬ")) {
////						b.setText("��ʾͼƬ");
////						b.setName("��ʾͼƬ");
////						l.setVisible(false);
////						//���һ�¡���Ҫ�����ݣ�������ݱ��������˱�ǩ�У���ʾ
////						//������Ӧ�ö԰�����������ݵĶ�����в�����
////						//��ť��������˵Ļ�������ô�����¼������أ�
////					}
////					else {
////						b.setText("����ͼƬ");
////						b.setName("����ͼƬ");
////						l.setVisible(true);
////					}
//					//��ע�������Լ�ͨ��setName,getName��������ɵģ�
//					//������һ�ַ����ǻ���
//					//ÿ��һ�ΰ�ť���ض������仯������˼��������򻯣�
//					
//					
//					flag=!flag;
//					l.setVisible(flag);
//					String temp=flag?"����ͼƬ":"��ʾͼƬ";
//					b.setText(temp);
//					//���Ǹ��࣬������
//					//�����������ԣ�ֱ��ͨ���������������ܷ��㣡
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
//		System.out.println("ͼƬ�Ŀ�Ϊ��"+i.getIconWidth()+" ��Ϊ��"+i.getIconHeight());
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
//		JButton b=new JButton("��һ��ģ̬����");
//		b.setBounds(50,50,280,30);
//		f.add(b);
//		ActionListener listener1=new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JDialog d=new JDialog(f,"ģ̬����");
//			//	d.setTitle("ģ̬����");
//				
//			//	d.setLocation(f.getX()+120,f.getY()+130);
//				d.setLocationRelativeTo(f);
//				//���ô��������ָ�������λ�á�
//				
//				d.setSize(200,150);
//			//	d.setLayout(null);
//				d.setModal(true);
//				JButton b=new JButton("������С");
//			//	b.setBounds(50,50,280,30);
//				//������û�б�����Ϊ���Բ���ʱ
//				//��ť�ᱻ�������������
//				//������һ����û�ж���Ӱ������Ч��
//				//���߼�����˵Ҳû��Ҫд
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
//				//ֻ��һ��������Ҫ�������
//				//�����õĴ��������رգ�����������
//			}
//		};
//		b.addActionListener(listener1);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
//		JFrame f=new JFrame("����������");
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
//        JButton b1 = new JButton("Ӣ��1");
//        JButton b2 = new JButton("Ӣ��2");
//        JButton b3 = new JButton("Ӣ��3");
// 
//        // ���� ʹ�� ������ ��Ҳ���� ͨ��setPreferredSize���򲼾�������������ʾ�Ĵ�С
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
//		String s=new String("������");
//		cb.setBounds(50, 50, 130, 30);
//		cb.setSelected(true);
//		//һ��Ҫ�ǵ����÷�Χ��
//		//���ĸ������ֱ���λ��x,λ��y,��ȣ��߶�
//		//û�����ÿ�ȡ��߶��൱������Ϊ0��
//		//���Ծͻῴ����������ʾ��
		
		//�൱��setSize��setLocation��
//		
//		cb.setText(s);
//		f.add(cb);
//		JCheckBox cb2=new JCheckBox("ţţ");
//		cb2.setBounds(50, 100, 130, 30);
//		f.add(cb2);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		init(f);
//		JRadioButton rb=new JRadioButton("������");
//		rb.setSelected(true);
//		rb.setBounds(50,50,130,30);
//		JRadioButton rb2=new JRadioButton();
//		rb2.setSize(130,30);
//		rb2.setLocation(50,100);
//	//	rb2.setBounds(50, 100, 130, 30);
//		rb2.setText("ţţ");
//		ButtonGroup bg=new ButtonGroup();
//		bg.add(rb);bg.add(rb2);
//		f.add(rb);f.add(rb2);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		init(f);
//		String s[]=new String[] {"?e","������","ţţ"};
//		JComboBox cbox=new JComboBox(s);
//		cbox.setBounds(50,50,130,30);
//		f.add(cbox);
//		finish(f);
		
		/*
		 * JFrame f=new JFrame("LOL"); init(f); finish(f);
		 */
//		int ok=JOptionPane.showConfirmDialog(f, "�Ƿ�Ҫ������");
//		if(JOptionPane.OK_OPTION==ok) {
//			System.out.println(ok);
//			String s=JOptionPane.showInputDialog(f,"����������");
//			if(s.equals("������")) {
//				JOptionPane.showMessageDialog(f, "��������");	
//			}
//		}
////		else System.out.println(ok);
//		else if(1==ok) {
//			JOptionPane.showMessageDialog(f, "�õΣ���");
//		}
		
//		JFrame f=new JFrame("LOL");
//		initFlow(f);
//		JTextField tf1=new JTextField("�������˺�");
////		tf1.setPreferredSize(new Dimension(130,40));
//	//	tf1.setSize(130,40);
//		JTextField tf2=new JTextField("����������");
//	//	tf2.setPreferredSize(new Dimension(130,40));
//		JLabel l1=new JLabel("�˺�");
//	//	l1.setSize(100,100);
//		JLabel l2=new JLabel("����");
//	//	l2.setSize(50,50);
//		f.add(l1);f.add(tf1);
//		f.add(l2);f.add(tf2);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		initFlow(f);
//		JPasswordField pd=new JPasswordField();
//		pd.setText("�ҷ������666");
//		JLabel l=new JLabel("���룺");
//		pd.grabFocus();
//		pd.setPreferredSize(new Dimension(130,40));
//		f.add(l);f.add(pd);
//		finish(f);
//		char s[]=pd.getPassword();
//	//	String xx=pd.getText();
//		//��ȫ�����⡣JPasswordFieldӦ����getPassword����
//		String x=new String(s);
//		System.out.println("�����ǣ�"+x);
//	//	System.out.println("�����ǣ�"+xx);
		
//		JFrame f=new JFrame("LOL");
//		initFlow(f);
//		JLabel l=new JLabel("�ı���");
//		JTextArea ta=new JTextArea();
//		ta.setText("������\n����\r\nŶţ����,,,,,,,,,");
//		ta.setPreferredSize(new Dimension(50,100));
//		f.add(l);f.add(ta);
//		ta.setLineWrap(true);
//		finish(f);
		
//		JFrame f=new JFrame("LOL");
//		f.setSize(400,300);
//		f.setLocation(200,200);
//		f.setLayout(null);
//		//����һ��Ҫ���ð�����Ȼ���������������ڣ�
//		JPanel p1=new JPanel();
//		p1.setBounds(50,50,300,60);
////		p1.setLayout(new FlowLayout());
//		// ��һ�����û�У���ΪJPanelĬ�Ͼ��ǲ��õ�FlowLayout
//		
//		JButton pb1=new JButton("Ӣ��1");
//		JButton pb2=new JButton("Ӣ��2");
//		JButton pb3=new JButton("Ӣ��3");
//		p1.setBackground(Color.BLUE);
//		p1.add(pb1);p1.add(pb2);p1.add(pb3);
//		
//		JPanel p2=new JPanel();
//		p2.setBounds(10,150,300,60);
//		p2.setBackground(Color.green);;
////		p2.setLayout(new GridLayout(3,1));
//	//	p2.setSize(100,100);
//		JButton p2b1=new JButton("Ӣ��4");
//		JButton p2b2=new JButton("Ӣ��5");
//		JButton p2b3=new JButton("Ӣ��6");
//		p2.add(p2b1);p2.add(p2b2);p2.add(p2b3);
//		f.getContentPane().add(p1);
//		//Frame���š������ȵĿ�ܣ�������һ�㶫����������--Pane��
//		//���Ժ����󡣾���ContentPane ���ݲ�����
//		//f.add()��ʵ������Pane���������
//		//����f.getContentPane.add()��
//		System.out.println(p2b3.getParent());//�ڻ������JPanel��
//		JButton test=new JButton("����");
//		test.setSize(80,80);
//		f.add(test);System.out.println(test.getParent());
//		//��ӡ���Կ�����Parent��contentPane��
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
//		//���������pane������contentPane���ƺ�Frame������LayoutҲ����ʾ����
//		//�ƺ��е������
//		//��Ϊ����Frame��Ϊһ�������������
//		//�����ϴ���һ��Pane�����Pane�϶����ǿյ�
//		//�Ա����������������
//		//��ֱ�ӽ�����Pane�滻������յ�contentPane
//		//��������滻��Pane����������ݣ���Ȼ��Ȼ�ͻ���ʾ��
//		
//		//ȱ����ǲ�����ͨ�����contentPane�ﵽ���ֵ������ˣ�
//		//ֱ��Frame.add����contentPane��add��
//		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		
		
		
		//CardLayout��show���������ɻ󡣡���
		
//		JFrame f=new JFrame("LOL");
//		f.setBounds(200,200,400,300);
//		f.setLayout(null);
//		JPanel p1=new JPanel();
//	//	p1.setLayout(new FlowLayout());//���п��ޡ�Ĭ������ʽ����
//		JButton h1=new JButton("����");
//		JButton h2=new JButton("��Ī");
//		JButton h3=new JButton("����");
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
	//	p1.setLayout(new FlowLayout());//���п��ޡ�Ĭ������ʽ����
		JButton h1=new JButton("����");
		JButton h2=new JButton("��Ī");
		JButton h3=new JButton("����");
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
