package classes_objects;

public class Fish extends Animal implements Pet{
	private String name;
	public Fish() {
		super(0);
	}
	public void eat() {
		System.out.println("正在吃东西。。");		
	}
	public void walk() {
		System.out.println("o no，鱼没有腿不能走哦。。");
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void play() {
		System.out.println(name+" 正在和你玩哦。。");
	}
}

int x;
for (int i = 0; i < str.length; i++) {
	do {
		x=(int)(Math.random()*200);
	}while(x<48&&x>57&&x<65&&x>90&&x>97&&x>122);
	
}

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
//for(int i=0;i<8;++i) {
//	char str[]=new char[5];
//	for(int j=0;j<5;++j) {
////		while(true) {
////			char c;
////			c=(char)(Math.random()*120+48);
////			if(Character.isLetter(c)||
////					Character.isDigit(c)) {
////				str[j]=c;break;
////			}
////		}		
//		
//		str[j]=xx.charAt((int)(Math.random()*xx.length()));
//	}
////	s[i]=String.valueOf(str);
//	s[i]=new String(str);
//}
//for(int i=0;i<7;++i) {
//	for(int j=i+1;j<8;++j) {
//		if(Character.isDigit(s[i].charAt(0))) {
//			if(Character.isDigit(s[j].charAt(0))) {
//				if(s[i].charAt(0)>s[j].charAt(0)) {
//					String mid=s[i];
//					s[i]=s[j];
//					s[j]=mid;
//				}
//			}
//		}
//		else if(Character.isLetter(s[i].charAt(0))) {
//			if(Character.isLetter(s[j].charAt(0))) {
//				char c1,c2;
//				c1=Character.toLowerCase(s[i].charAt(0));
//				c2=Character.toLowerCase(s[j].charAt(0));
//				if(c1>c2) {
//					String mid=s[i];
//					s[i]=s[j];
//					s[j]=mid;
//				}
//			}
//			else {
//				String mid=s[i];
//				s[i]=s[j];
//				s[j]=mid;
//			}
//		}
//	}
//}
//for(String x:s)System.out.println(x);

		

