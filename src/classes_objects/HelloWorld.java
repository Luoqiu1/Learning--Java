package classes_objects;

public class HelloWorld {
	public static void main(String[] args) {
		HeroType h=HeroType.FARMING;
		switch(h) {
//		case 8:  //这样不行，java不同于c，c的enum与对应的数字字面值可以互换！
		case FARMING:
			System.out.println("打野");
		}
	}
}
