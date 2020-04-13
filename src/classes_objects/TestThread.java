package classes_objects;

import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class TestThread {
	static class HurtThread extends Thread{
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
    static class Producer implements Runnable{
    	private MyStack<Character> stack;
    	private String name;
    	public Producer(String name,MyStack<Character>  stack) {
    		this.stack=stack;
    		this.name=name;
    	}
    	private char randomChar() {
    		while(true) {
    			char c=(char)((int)(Math.random()*100+50));
    			if(Character.isLetter(c)&&c==Character.toUpperCase((char)c))return c;
    		}
    	}
		public void run() {
			while(true) {
				char c=this.randomChar();
				stack.push(c);
				System.out.println(name+" 压入："+c);
				try {
					Thread.sleep(1000);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
    	
    }
    static class Consumer extends Thread{
    	private MyStack<Character>  stack;
    	private String name;
    	public Consumer(String name,MyStack<Character>  stack) {
    		this.stack=stack;
    		this.name=name;
    	}
    	public void run() {
    		while(true) {
	    		char c=(char)stack.pull();
	    		System.out.println(name+" 弹出："+c);
	    		try {
					Thread.sleep(1000);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
    		}
    	}
    }
    public static void main(String[] args) {
//    	MyStack<Character> stack=new MyStack<>();
////    	Producer producer[]=new Producer[20];
//    	List<Producer> producer=new ArrayList<>();
//    	int n=35;
//    	
//    	Thread consumer[]=new Consumer[20];
////    	for(int i=1;i<=producer.length;++i) {
////    		producer[i-1]=new Producer("Producer"+i,stack);
////    		new Thread(producer[i-1]).start();
////    	}
//    	for(int i=1;i<=n;++i) {
//    		Producer p=new Producer("Producer"+i,stack);
//    		producer.add(p);
//    		new Thread(producer.get(i-1)).start();
//    	}
//    	for(int i=1;i<=consumer.length;++i) {
//    		consumer[i-1]=new Consumer("Producer"+i,stack);
//    		consumer[i-1].start();
//    	}
    	
//    	Lock lock_ahri = new ReentrantLock();
//        Lock lock_annie = new ReentrantLock();
//  
//        Thread t1 = new Thread() {
//            public void run() {
//                // 占有九尾妖狐
//                boolean ahriLocked = false;
//                boolean annieLocked = false;
//                  
//                try {
//                    ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
//                    if (ahriLocked) {
//                        System.out.println("t1 已占有九尾妖狐");
//                        // 停顿1000秒，另一个线程有足够的时间占有安妮
//                        Thread.sleep(1000);
//                        System.out.println("t1 试图在10秒内占有安妮");
//                        try {
//                            annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
//                            if (annieLocked)
//                                System.out.println("t1 成功占有安妮，开始啪啪啪");
//                            else{
//                                System.out.println("t1 老是占用不了安妮，放弃");
//                            }
//  
//                        } finally {
//                            if (annieLocked){
//                                System.out.println("t1 释放安妮");
//                                lock_annie.unlock();
//                            }
//                        }
//  
//                    }
//                } catch (InterruptedException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                } finally {
//                    if (ahriLocked){
//                        System.out.println("t1 释放九尾狐");
//                        lock_ahri.unlock();
//                    }
//                }
//  
//            }
//        };
//        t1.start();
//        //能够理解用lock的设计思路了！
//        //每一个lock都需要单独的一个try
//        //因为这样的话每一个lock都可以分配到一个finally！
//        //也就是说每一个lock都可以保证能够被unlock！
//        
//        //而不是之前的那种想法说
//        //一个try就够了，不会报错
//        //不是为了不报错而写的try！这点思想要转变！
//        //而是为了保证每一个lock都能解锁unlock！！
//        try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//          
//        Thread t2 = new Thread() {
//            public void run() {
//                boolean annieLocked = false;
//                boolean ahriLocked = false;
//                                  
//                try {annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
//                  
//                if (annieLocked){
//                      
//                        System.out.println("t2 已占有安妮");
//                        // 停顿1000秒，另一个线程有足够的时间占有安妮
//                        Thread.sleep(1000);
//                        System.out.println("t2 试图在10秒内占有九尾妖狐");
//                        try {
//                            ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
//                            if (ahriLocked)
//                                System.out.println("t2 成功占有九尾妖狐，开始啪啪啪");
//                            else{
//                                System.out.println("t2 老是占用不了九尾妖狐，放弃");
//                            }
//                        }
//                        finally {
//                            if (ahriLocked){
//                                System.out.println("t2 释放九尾狐");
//                                lock_ahri.unlock();
//                            }
//                                  
//                        }
//  
//                    }
//                } catch (InterruptedException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                } finally {
//                    if (annieLocked){
//                        System.out.println("t2 释放安妮");
//                        lock_annie.unlock();
//                    }
//                          
//                }
//            }
//        };
//        t2.start();
//      
    	
    	
    	final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp.set(10000);
        int n = 10000;
   
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
           
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                      
                    //recover自带synchronized
                    gareen.recover();
                      
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
               
        }
           
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                    //hurt自带synchronized
                    gareen.hurt();
                      
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
           
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
           
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n,n,gareen.hp.floatValue());
           
    }
    
}