package classes_objects;

public class ADHero extends Hero implements Mortal{
	public ADHero(String a) {
		name=a;
	}
	public void die() {
		System.out.println("ADCÀ¿µÙ»«£¨£¨");
	}
}
