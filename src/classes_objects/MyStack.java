package classes_objects;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class MyStack<T> implements Stack<T>{
//	private LinkedList<Hero> Heros=null;
	private List<T> list;
	public MyStack() {
		list=new ArrayList<>();
//		Heros=(List<Hero>)Collections.synchronizedList(Heros);
//		Heros=Collections.synchronizedList(Heros);
	}
	public synchronized void push(T v) {
		while(list.size()==200) {
			System.out.println("货满200啦！！！休息下");
			try {
				this.wait();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
//		Heros.addLast(h);
//		Heros.offer(h);
		list.add(v);
		this.notify();
		//同pull方法一个道理。notify要放在具体操作之后！
		
		//notifyAll的理解也加深了一层！
		//当有一个方法使用了notifyAll的话
		//相当于两边全部开启竞争！
		//假如一个方法是notify另一个是notifyAll的话
		//当这个notify唤醒了notifyAll那边的方法时
		//这一个线程马上运行到notifyAll
		//也就相当于是前面的notify起到了notifyAll的效果了！
		//所以我猜想，notifyAll跟notifyAll成套用
		//notify跟notify成套用！
		//只要出现一个notifyAll即起到了全部notifyAll的竞争效果！
	}
	public synchronized T pull(){
		while(list.isEmpty()) {
			System.out.println("空货啦！！！客人请稍等！！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	//	this.notify();
	//	return list.remove(list.size()-1);
		//如果是上面这两行的代码设计格式
		//会导致从peek方法中notify了一个poll方法后
		//这个poll方法连续接着又notify了另一个poll
		//而被notify的这个poll又接着notify另一个...
		//而这些被notify的醒来后很可能退出while循环！
		//因为remove是在notify后面的！
		//也就是意味着，在第一个pull的notify到
		//remove这段代码时间内，可能唤醒多个pull！
		//导致了意想不到的结果——List已经空了却还在remove！
		
		//所以这种设计模式是存在系统缺陷的！
		//因为this.notify无法放在return后面！
		//所以return语句要拆开
		T temp=list.remove(list.size()-1);
		this.notify();//notify要放在remove之后！
		//这样就保证就算唤醒的是pull方法，也会因为条件满足空而继续保留在while中！
		return temp;
	}
	public T peek(){
//		return Heros.getLast();
		return list.get(list.size()-1);
	}
	public static void main(String[] args) {
		Collection<Integer> test=new ArrayList<>();
		MyStack<Hero> ms=new MyStack<>();
		for (int i = 0; i < 5; i++) {
			ms.push(new Hero("Hero "+i));
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(ms.peek());
			Hero h=ms.pull();
			System.out.println(h);
		}
	}
}
