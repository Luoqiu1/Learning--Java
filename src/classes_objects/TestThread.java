package classes_objects;

import java.io.File;
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
				System.out.println(name+" Ñ¹Èë£º"+c);
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
	    		System.out.println(name+" µ¯³ö£º"+c);
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
    	MyStack<Character> stack=new MyStack<>();
//    	Producer producer[]=new Producer[20];
    	List<Producer> producer=new ArrayList<>();
    	int n=35;
    	
    	Thread consumer[]=new Consumer[20];
//    	for(int i=1;i<=producer.length;++i) {
//    		producer[i-1]=new Producer("Producer"+i,stack);
//    		new Thread(producer[i-1]).start();
//    	}
    	for(int i=1;i<=n;++i) {
    		Producer p=new Producer("Producer"+i,stack);
    		producer.add(p);
    		new Thread(producer.get(i-1)).start();
    	}
    	for(int i=1;i<=consumer.length;++i) {
    		consumer[i-1]=new Consumer("Producer"+i,stack);
    		consumer[i-1].start();
    	}
    }
    
}