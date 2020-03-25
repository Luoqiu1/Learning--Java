package classes_objects;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
//		HeroType h=HeroType.FARMING;
//		switch(h) {
////		case 8:  //这样不行，java不同于c，c的enum与对应的数字字面值可以互换！
//		case FARMING:
//			System.out.println("打野");
//		}
//		Hero garen=new Hero("盖伦");
//		ADHero vn=new ADHero("薇恩");
//		APHero bn=new APHero("冰鸟");
//		ADAPHero akl=new ADAPHero("阿卡丽");
//		garen.killHero(vn);
//		garen.killHero(bn);
//		garen.killHero(akl);
//		byte b0=6;
//		Byte b1=new Byte(b0);
//		byte b2=b1.byteValue();
//		System.out.println(Byte.MIN_VALUE);
//		double d1=3.14;
//		String s1=String.valueOf(d1);
//		Double d=d1;
//		String s2=Double.toString(d);
//		System.out.println(s1);
//		System.out.println(s2);
//		String s="3.14";
////		String s0="3.1a4";
//		double d2=Double.parseDouble(s);
////		double d3=Double.parseDouble(s0);
//		System.out.println(d2);
////		System.out.println(d3);
//		double f1=3.46;
//		System.out.println(Math.round(a));
//		int n=0;
//		for(int i=2;i<10000000;++i) {
//			boolean flag=true;
//			for(int j=2;j*j<=i;++j) {
//				if(i%j==0) {
//					flag=false;break;
//				}
//			}
//			for(int j=2;j<=Math.sqrt(i);++j) {
//				if(i%j==0) {
//					flag=false;break;
//				}
//			}
//			for (int j = 2; j <= Math.sqrt(i); j++) {
//	            if(0==i%j) {
//	                flag=false;break;
//	            }
//	        }
//		if (flag)
//			++n;
//		}
//		System.out.println(n);
//		String x = "%d%n%d";
//		System.out.printf(x, 5, 45);
//		System.out.println();
//		char a='v';
//		Character a1=a;
//		if(Character.isLetter(a1))System.out.println("yes");
//		String s1;Scanner s=new Scanner(System.in);
//		s1=s.next();
//		char cs[]=s1.toCharArray();
//		
//		System.out.println(s1.toUpperCase());
//		for(char a:cs) {
//			if(Character.isUpperCase(a)||
//					Character.isDigit(a))
//				System.out.print(a);
//		String s1="盖伦";
//		char []str=new char[] {'呃','呃'
//	};
//		String s2=new String();
//		Scanner s=new Scanner(System.in);
//		s2=s.next();
//		System.out.println(s2);
//		s1="nihao";
//		System.out.println(s1);
		
//		s2[0]='c';
		
//		System.out.println(s2);
		
		String s[]=new String[8];
		for(int i=0;i<8;++i) {
			char str[]=new char[5];
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
			for(int j=0;j<5;++j) {
//				while(true) {
//					char c;
//					c=(char)(Math.random()*120+48);
//					if(Character.isLetter(c)||
//							Character.isDigit(c)) {
//						str[j]=c;break;
//					}
//				}		
				
				str[j]=xx.charAt((int)(Math.random()*xx.length()));
			}
			s[i]=String.valueOf(str);
		}
		for(int i=0;i<7;++i) {
			for(int j=i+1;j<8;++j) {
				if(Character.isDigit(s[i].charAt(0))) {
					if(Character.isDigit(s[j].charAt(0))) {
						if(s[i].charAt(0)>s[j].charAt(0)) {
							String mid=s[i];
							s[i]=s[j];
							s[j]=mid;
						}
					}
				}
				else if(Character.isLetter(s[i].charAt(0))) {
					if(Character.isLetter(s[j].charAt(0))) {
						char c1,c2;
						c1=Character.toLowerCase(s[i].charAt(0));
						c2=Character.toLowerCase(s[j].charAt(0));
						if(c1>c2) {
							String mid=s[i];
							s[i]=s[j];
							s[j]=mid;
						}
					}
					else {
						String mid=s[i];
						s[i]=s[j];
						s[j]=mid;
					}
				}
			}
		}
		for(String x:s)System.out.println(x);
	}
}
