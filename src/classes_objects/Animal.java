package classes_objects;

public abstract class Animal {
	protected int legs;
	protected Animal(int legs) {
		this.legs=legs;
	}
	public abstract void eat();
	public void walk() {
		System.out.printf("�������������ߵģ�����  %d ����\n",legs);
	}
	public static void main(String[] args) {
//		Animal a=new Animal(4){
//			public void eat() {
//			}
//		};
//		a.walk();
	}
}
