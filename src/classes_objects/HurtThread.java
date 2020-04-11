package classes_objects;

public class HurtThread extends Thread{
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
