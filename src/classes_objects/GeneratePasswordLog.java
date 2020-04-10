package classes_objects;
import java.util.ArrayList;
import java.util.List;

public class GeneratePasswordLog extends Thread{
	List<String> midAns;
	public GeneratePasswordLog(List<String> midAns) {
		this.setDaemon(true);
		this.midAns=midAns;
	}
	public void run() {
		while(true) {
			if(midAns.isEmpty()) {
				try {
					Thread.sleep(100);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
//				while(!midAns.isEmpty()) {
					String value=midAns.remove(0);
					System.out.println("ø…ƒ‹√‹¬Î£∫"+value);
//				}
			}
		}
	}
}
