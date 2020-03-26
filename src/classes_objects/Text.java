package classes_objects;

public class Text {
	public static void main(String[] args) {
		String s1=new String("let there be light");
		String str[]=s1.split(" ");
		for(int i=0;i<str.length;++i) {
//			System.out.println(str[i]);
//			str[i].replaceFirst("l","L");
//			System.out.println(str[i]);
//			System.out.println(String.valueOf(Character.toUpperCase(str[i].charAt(0))));
			//注意！！要str[i]=str[i].replace......
			//因为replace方法不会直接替换str的值，只是会返回一个替换后的新字符串！
			str[i]=str[i].replaceFirst(String.valueOf(str[i].charAt(0)),String.valueOf(Character.toUpperCase(str[i].charAt(0))));
		}
		String s2="";
		for(int i=0;i<str.length-1;++i)s2+=str[i]+" ";
		s2+=str[str.length-1];
		System.out.println(s2);
	}
}
