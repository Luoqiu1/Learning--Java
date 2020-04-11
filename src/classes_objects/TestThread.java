package classes_objects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class TestThread {
    
    public static void main(String[] args) {
    	Hero h1=new Hero("盖伦");
    	Hero h2=new Hero("VN");
    	Hero h3=new Hero("冰鸟");
    	Thread t1=new Thread() {
    		public void run() {
    			synchronized(h1) {
    				System.out.println("t1已占领对象 "+h1.name);
//    				try {
//        				Thread.sleep(1000);
//        			}
//    				catch(Exception e) {
//    					e.printStackTrace();
//    				}
    				System.out.println("t1试图占领对象 "+h2.name);
    				System.out.println("t1等待中。。。");
    				synchronized(h2) {
    					System.out.println("t1已成功占领对象 "+h2.name);
    				}
    			}
    		}
    	};
    	t1.start();
    	Thread t2=new Thread() {
    		public void run() {
    			synchronized(h2) {
    				System.out.println("t2已占领对象 "+h3.name);
//    				try {
//        				Thread.sleep(1000);
//        			}
//    				catch(Exception e) {
//    					e.printStackTrace();
//    				}
    				System.out.println("t2试图占领对象 "+h3.name);
    				System.out.println("t2等待中。。。");
    				synchronized(h3) {
    					System.out.println("t2已成功占领对象 "+h3.name);
    				}
    			}
    		}
    	};
    	t2.start();
    	Thread t3=new Thread() {
    		public void run() {
    			synchronized(h3) {
    				System.out.println("t3已占领对象 "+h3.name);
//    				try {
//        				Thread.sleep(1000);
//        			}
//    				catch(Exception e) {
//    					e.printStackTrace();
//    				}
    				System.out.println("t3试图占领对象 "+h1.name);
    				System.out.println("t3等待中。。。");
    				synchronized(h1) {
    					System.out.println("t3已成功占领对象 "+h1.name);
    				}
    			}
    		}
    	};
    	t3.start();
    }
}