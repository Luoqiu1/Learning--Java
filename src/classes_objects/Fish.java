package classes_objects;

public class Fish extends Animal implements Pet{
	private String name;
	public Fish() {
		super(0);
	}
	public void eat() {
		System.out.println("���ڳԶ�������");		
	}
	public void walk() {
		System.out.println("o no����û���Ȳ�����Ŷ����");
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void play() {
		System.out.println(name+" ���ں�����Ŷ����");
	}
}
