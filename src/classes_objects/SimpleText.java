package classes_objects;

public class SimpleText {
	static int test;
	static boolean finala() {
		test++;
		return true;
	}
	public static void main(String[] args) {
		test=0;
		if((SimpleText.finala()|SimpleText.finala())||SimpleText.finala())
			test++;
	}
}
