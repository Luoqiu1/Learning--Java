package classes_objects;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class MyStack implements Stack{
//	private LinkedList<Hero> Heros=null;
	private List<Hero> Heros;
	public MyStack() {
		Heros=new ArrayList<>();
//		Heros=(List<Hero>)Collections.synchronizedList(Heros);
		Heros=Collections.synchronizedList(Heros);
	}
	public synchronized void push(Hero h) {
//		Heros.addLast(h);
//		Heros.offer(h);
		Heros.add(h);
	}
	public synchronized Hero poll(){
//		Hero x=Heros.getFirst();
//		Heros.removeFirst();
//		return x;
//		return Heros.removeLast();
		return Heros.remove(Heros.size()-1);
	}
	public Hero peek(){
//		return Heros.getLast();
		return Heros.get(Heros.size()-1);
	}
	public static void main(String[] args) {
		Collection<Integer> test=new ArrayList<>();
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
