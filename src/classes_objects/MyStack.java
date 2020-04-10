package classes_objects;
import java.util.LinkedList;

public class MyStack implements Stack{
	private LinkedList<Hero> Heros=null;
	public MyStack() {
		Heros=new LinkedList<>();
	}
	public synchronized void push(Hero h) {
//		Heros.addLast(h);
		Heros.offer(h);
	}
	public synchronized Hero poll(){
//		Hero x=Heros.getFirst();
//		Heros.removeFirst();
//		return x;
		return Heros.removeLast();
	}
	public Hero peek(){
		return Heros.getLast();
	}
	public static void main(String[] args) {
		MyStack ms=new MyStack();
		for (int i = 0; i < 5; i++) {
			ms.push(new Hero("Hero "+i));
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(ms.peek());
			Hero h=ms.poll();
			System.out.println(h);
		}
	}
}
