package classes_objects;

public class RecoverThread extends Thread{
	private Hero h;
	public RecoverThread(Hero h) {
		this.h=h;
	}
	public void run() {
		while(true) {
			 h.recover();
			 try {
				 Thread.sleep(100);
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
		}
	}
}
