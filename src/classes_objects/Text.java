package classes_objects;

public class Text extends MyStringBuffer {
	public static void main(String[] args) {
//		String s="hello!";System.out.println(s);
//		String s1=s.substring(0,5);
//		String s2=s.substring(5,6);
//		s=s2+s2;
//		
//		System.out.println(s1);System.out.println(s2);System.out.println(s);
//		System.out.println();
		MyStringBuffer s0=new MyStringBuffer
				("hello!");
		s0.append('A');
		s0.value();
		s0.append("³æ");
		s0.value();
		s0.delete(6);
		s0.value();
		s0.delete(5, 6);
		s0.value();
		System.out.println(s0.length());
		s0.reverse();
		s0.value();
		s0.insert(5, '!');
		s0.value();
		s0.insert(6, "GoGo!");
		s0.value();
	}
}
