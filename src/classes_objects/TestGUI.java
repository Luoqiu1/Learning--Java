package classes_objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		
		JFrame f=new JFrame("LOL");
		f.setSize(400,300);
		f.setLocation(580,200);
		f.setLayout(null);
	//	JLabel l=new JLabel("C:\\Data/shana.png");
		//��Ȼ��һ��ע�ʹ�Ҳ����������
		//���������Ͳ��������ͼƬ�Ŀ��ߵȲ�����
		//��һ��ImageIcon���󣬵�����getIconWidth������
		JLabel l=new JLabel();
		ImageIcon i=new ImageIcon("C:\\Data/shana.png");
		l.setIcon(i);
		l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
		
		
		JButton b=new JButton("����ͼƬ");
	//	b.setName("����ͼƬ");
		b.setBounds(150,200,100,30);
		f.add(b);
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	//	System.out.println(b.getName());
	//	System.out.println(b.toString());
		ActionListener l1=new ActionListener() {
				boolean flag=true;
				public void actionPerformed(ActionEvent e){
//					if(b.getName().equals("����ͼƬ")) {
//						b.setText("��ʾͼƬ");
//						b.setName("��ʾͼƬ");
//						l.setVisible(false);
//						//���һ�¡���Ҫ�����ݣ�������ݱ��������˱�ǩ�У���ʾ
//						//������Ӧ�ö԰�����������ݵĶ�����в�����
//						//��ť��������˵Ļ�������ô�����¼������أ�
//					}
//					else {
//						b.setText("����ͼƬ");
//						b.setName("����ͼƬ");
//						l.setVisible(true);
//					}
					//��ע�������Լ�ͨ��setName,getName��������ɵģ�
					//������һ�ַ����ǻ���
					//ÿ��һ�ΰ�ť���ض������仯������˼��������򻯣�
					
					
					flag=!flag;
					l.setVisible(flag);
					String temp=flag?"����ͼƬ":"��ʾͼƬ";
					b.setText(temp);
					//���Ǹ��࣬������
					//�����������ԣ�ֱ��ͨ���������������ܷ��㣡
				}
			};
		b.addActionListener(l1);
	}
}
