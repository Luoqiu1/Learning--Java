package classes_objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestGUI {
	public static void main(String[] args) {
		JFrame jf=new JFrame("LOL");
		File f=new File("C:\\Data/location.txt");
		String x="200",y="200";
		if(f.exists()) {
			if(f.length()!=0) {
				try(FileInputStream fis=new FileInputStream(f)) {
					byte b[]=new byte[(int)f.length()];
					fis.read(b);
					String s=new String(b);
					String s2[]=s.split(" ");
					x=s2[0];y=s2[1];
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		jf.setSize(400,300);
		jf.setLocation(Integer.parseInt(x),Integer.parseInt(y));
		jf.setLayout(null);
		JButton jb=new JButton("一键秒杀地方基地挂");
		jb.setBounds(50,50,280,30);
		jf.add(jb);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Object o=new Object();
		Thread t=new Thread() {
			public void run() {
				synchronized(o) {
					while(true) {
						try {
							o.wait(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						File f=new File("C:\\Data/location.txt");
			//			FileOutputStream fos=new FileOutputStream(f);
						try(FileWriter w= new FileWriter(f);) {
							String x=String.valueOf(jf.getX());
							String y=String.valueOf(jf.getY());
							String temp=x+" "+y;
							w.write(temp);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		t.setDaemon(true);
		t.start();
	}
}
