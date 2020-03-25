package classes_objects;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		String xx="";
		for(short k='0';k<='9';++k) {
			xx+=(char)k;
		}
		for(short k='a';k<='z';++k) {
			xx+=(char)k;
		}
		for(short k='A';k<='Z';++k) {
			xx+=(char)k;
		}
		String s5="";
		s5+='0'+'0';
//		s5+='0';			
		System.out.println(s5);
		char str[]=new char[3];
		for(int i=0;i<3;++i) {
			str[i]=xx.charAt((int)(Math.random()*xx.length()));
		}
		String s1=new String(str);System.out.println(s1);
		boolean flag=false;
		for(int i=0;i<xx.length();++i) {
			for(int j=0;j<xx.length();++j) {
				for(int k=0;k<xx.length();++k) {
					String s2="";
					s2+=xx.charAt(i);
					s2+=xx.charAt(j);
					s2+=xx.charAt(k);
					if(s1.equals(s2)) {
						System.out.println(s2);
						flag=true;break;
					}
				}
				if(flag)break;
			}
			if(flag)break;
		}
	}
}
