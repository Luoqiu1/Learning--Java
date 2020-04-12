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
			System.out.println("����200����������Ϣ��");
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
		//ͬpull����һ������notifyҪ���ھ������֮��
		
		//notifyAll�����Ҳ������һ�㣡
		//����һ������ʹ����notifyAll�Ļ�
		//�൱������ȫ������������
		//����һ��������notify��һ����notifyAll�Ļ�
		//�����notify������notifyAll�Ǳߵķ���ʱ
		//��һ���߳��������е�notifyAll
		//Ҳ���൱����ǰ���notify����notifyAll��Ч���ˣ�
		//�����Ҳ��룬notifyAll��notifyAll������
		//notify��notify�����ã�
		//ֻҪ����һ��notifyAll������ȫ��notifyAll�ľ���Ч����
	}
	public synchronized T pull(){
		while(list.isEmpty()) {
			System.out.println("�ջ����������������Եȣ���");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	//	this.notify();
	//	return list.remove(list.size()-1);
		//��������������еĴ�����Ƹ�ʽ
		//�ᵼ�´�peek������notify��һ��poll������
		//���poll��������������notify����һ��poll
		//����notify�����poll�ֽ���notify��һ��...
		//����Щ��notify��������ܿ����˳�whileѭ����
		//��Ϊremove����notify����ģ�
		//Ҳ������ζ�ţ��ڵ�һ��pull��notify��
		//remove��δ���ʱ���ڣ����ܻ��Ѷ��pull��
		//���������벻���Ľ������List�Ѿ�����ȴ����remove��
		
		//�����������ģʽ�Ǵ���ϵͳȱ�ݵģ�
		//��Ϊthis.notify�޷�����return���棡
		//����return���Ҫ��
		T temp=list.remove(list.size()-1);
		this.notify();//notifyҪ����remove֮��
		//�����ͱ�֤���㻽�ѵ���pull������Ҳ����Ϊ��������ն�����������while�У�
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
