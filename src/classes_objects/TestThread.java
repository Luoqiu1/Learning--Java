package classes_objects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class TestThread {
    
    public static void main(String[] args) {
    	Hero h1=new Hero("����");
    	Hero h2=new Hero("VN");
    	Hero h3=new Hero("����");
    	Thread t1=new Thread() {
    		public void run() {
    			synchronized(h1) {
    				System.out.println("t1��ռ����� "+h1.name);
//    				try {
//        				Thread.sleep(1000);
//        			}
//    				catch(Exception e) {
//    					e.printStackTrace();
//    				}
    				System.out.println("t1��ͼռ����� "+h2.name);
    				System.out.println("t1�ȴ��С�����");
    				synchronized(h2) {
    					System.out.println("t1�ѳɹ�ռ����� "+h2.name);
    				}
    			}
    		}
    	};
    	t1.start();
    	Thread t2=new Thread() {
    		public void run() {
    			synchronized(h2) {
    				System.out.println("t2��ռ����� "+h3.name);
//    				try {
//        				Thread.sleep(1000);
//        			}
//    				catch(Exception e) {
//    					e.printStackTrace();
//    				}
    				System.out.println("t2��ͼռ����� "+h3.name);
    				System.out.println("t2�ȴ��С�����");
    				synchronized(h3) {
    					System.out.println("t2�ѳɹ�ռ����� "+h3.name);
    				}
    			}
    		}
    	};
    	t2.start();
    	Thread t3=new Thread() {
    		public void run() {
    			synchronized(h3) {
    				System.out.println("t3��ռ����� "+h3.name);
//    				try {
//        				Thread.sleep(1000);
//        			}
//    				catch(Exception e) {
//    					e.printStackTrace();
//    				}
    				System.out.println("t3��ͼռ����� "+h1.name);
    				System.out.println("t3�ȴ��С�����");
    				synchronized(h1) {
    					System.out.println("t3�ѳɹ�ռ����� "+h1.name);
    				}
    			}
    		}
    	};
    	t3.start();
    }
}