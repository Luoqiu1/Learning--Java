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

int x;
for (int i = 0; i < str.length; i++) {
	do {
		x=(int)(Math.random()*200);
	}while(x<48&&x>57&&x<65&&x>90&&x>97&&x>122);
	
}
