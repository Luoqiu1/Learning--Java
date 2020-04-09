package classes_objects;

public class ADHero extends Hero implements Mortal{
	public ADHero() {
		System.out.println("ADHero构造方法");
	}
	public void win() {
    	System.out.println("ADHero win");
    }
	public ADHero(String a) {
	//	super(a);
		this(a,"aa");
		System.out.println("ADHero构造方法");
	}
	public ADHero(String a,String b) {
		System.out.println("ADHero构造方法");
	}
	public void die() {
		System.out.println("ADC死掉惹，，");
	}
	public static void main(String[] args) {
		Hero h=new ADHero();
		h.win();
	}
}
