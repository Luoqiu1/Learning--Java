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
    
    public static void main(String[] args) {
 
    	final Hero gareen = new Hero();
        gareen.name = "¸ÇÂ×";
        gareen.hp = 616;
        HurtThread tHurt[]=new HurtThread[5];
        RecoverThread rHurt[]=new RecoverThread[2];
        for(HurtThread t:tHurt) {
        	t=new HurtThread(gareen);
        	t.start();
        }
        for(RecoverThread t:rHurt) {
        	t=new RecoverThread(gareen);
        	t.start();
        }
    	
    	
    }
        
}