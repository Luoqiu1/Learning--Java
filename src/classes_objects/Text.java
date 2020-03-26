package classes_objects;

public class Text {
	public static void main(String[] args) {
		String s="lengendary";
		char s1[]=s.toCharArray();
			for (int i = 0; i < s1.length; i++) {
		//	System.out.println(s1);
//			char x1=s1.charAt(i);
//			char x2=Character.toUpperCase(s1.charAt(i));
//			char x3=Character.toLowerCase(s1.charAt(i));
			char x1=s1[i];
			char x2=Character.toUpperCase(x1);
			char x3=Character.toLowerCase(x1);
			if(i%2==0) {
		//		System.out.printf("Å¼Êý %d %c %c%n",i,x1,x2);
			//	s1=s1.replaceFirst(String.valueOf(x1),String.valueOf(x2));
				s1[i]=x2;
			}
			else {
		//		System.out.printf("ÆæÊý %d %c %c%n",i,x1,x3);
			//	s1=s1.replaceFirst(String.valueOf(x1),String.valueOf(x3));
				s1[i]=x3;
			}
		//	System.out.println();
		}
		System.out.println(String.valueOf(s1));
	}
}
