package classes_objects;

import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
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
				System.out.println(name+" ѹ�룺"+c);
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
	    		System.out.println(name+" ������"+c);
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
    	
    	Lock lock_ahri = new ReentrantLock();
        Lock lock_annie = new ReentrantLock();
  
        Thread t1 = new Thread() {
            public void run() {
                // ռ�о�β����
                boolean ahriLocked = false;
                boolean annieLocked = false;
                  
                try {
                    ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
                    if (ahriLocked) {
                        System.out.println("t1 ��ռ�о�β����");
                        // ͣ��1000�룬��һ���߳����㹻��ʱ��ռ�а���
                        Thread.sleep(1000);
                        System.out.println("t1 ��ͼ��10����ռ�а���");
                        try {
                            annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
                            if (annieLocked)
                                System.out.println("t1 �ɹ�ռ�а��ݣ���ʼžžž");
                            else{
                                System.out.println("t1 ����ռ�ò��˰��ݣ�����");
                            }
  
                        } finally {
                            if (annieLocked){
                                System.out.println("t1 �ͷŰ���");
                                lock_annie.unlock();
                            }
                        }
  
                    }
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    if (ahriLocked){
                        System.out.println("t1 �ͷž�β��");
                        lock_ahri.unlock();
                    }
                }
  
            }
        };
        t1.start();
          
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
        Thread t2 = new Thread() {
            public void run() {
                boolean annieLocked = false;
                boolean ahriLocked = false;
                                  
                try {annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
                  
                if (annieLocked){
                      
                        System.out.println("t2 ��ռ�а���");
                        // ͣ��1000�룬��һ���߳����㹻��ʱ��ռ�а���
                        Thread.sleep(1000);
                        System.out.println("t2 ��ͼ��10����ռ�о�β����");
                        try {
                            ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
                            if (ahriLocked)
                                System.out.println("t2 �ɹ�ռ�о�β��������ʼžžž");
                            else{
                                System.out.println("t2 ����ռ�ò��˾�β����������");
                            }
                        }
                        finally {
                            if (ahriLocked){
                                System.out.println("t2 �ͷž�β��");
                                lock_ahri.unlock();
                            }
                                  
                        }
  
                    }
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    if (annieLocked){
                        System.out.println("t2 �ͷŰ���");
                        lock_annie.unlock();
                    }
                          
                }
            }
        };
        t2.start();
      
    }
    
}