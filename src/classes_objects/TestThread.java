package classes_objects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class TestThread {
	class HurtThread extends Thread{
		private Hero h;
		public HurtThread(Hero h) {
			this.h=h;
		}
		public void run() {
			while(true) {
				 h.hurt();
				 try {
					 Thread.sleep(10);
				 }
				 catch(Exception e) {
					 e.printStackTrace();
				 }
			}
		}
	}
    
    public static void main(String[] args) {
  
//        final Hero gareen = new Hero();
//        gareen.name = "盖伦";
//        gareen.hp = 616;
//           
//        Thread t1 = new Thread(){
//            public void run(){
//                while(true){
//                    gareen.hurt();
//                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
// 
//            }
//        };
//        t1.start();
// 
//        Thread t2 = new Thread(){
//            public void run(){
//                while(true){
//                    gareen.recover();
//                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
// 
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
// 
//            }
//        };
//        t2.start();
//        System.out.println("hero");  
    	
    	
    	
    	
//    	final Hero gareen = new Hero();
//        gareen.name = "盖伦";
//        gareen.hp = 616;
//        HurtThread tHurt[]=new HurtThread[5];
//        RecoverThread rHurt[]=new RecoverThread[2];
//        for(HurtThread t:tHurt) {
//        	t=new HurtThread(gareen);
//        	t.start();
//        }
//        for(RecoverThread t:rHurt) {
//        	t=new RecoverThread(gareen);
//        	t.start();
//        }
    	
    	Hero test=new Hero("tttt");
    	test.hp=100;
    	Thread t=new Thread() {
    		public void run() {
    			while(true) {
    				test.hurt();
    				try {
    					Thread.sleep(100);
    				}
    				catch(Exception e) {
    					e.printStackTrace();
    				}
    			}
    		}
    	};
    	t.start();
    	
    }
        
}