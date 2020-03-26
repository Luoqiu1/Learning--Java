package classes_objects;

public class HelloWorld {
	public static String matchPassword(String Password,int depth) {
		if(depth==Password.length())return "";//满足递归结束条件返回空串
		while(true) {
			//保证random范围内覆盖到所有数字和字母就可以了
			//这里大概取了个上限是168，一定能够覆盖到
			char c=(char)((int)(Math.random()*120+48));
			if(c==Password.charAt(depth)) {
				return c+matchPassword(Password,depth+1);
			}
		}
	}
	public static void main(String[] args) {
		String xx="";//存储所有数字和字母
		for(short k='0';k<='9';++k) {
			xx+=(char)k;
		}
		for(short k='a';k<='z';++k) {
			xx+=(char)k;
		}
		for(short k='A';k<='Z';++k) {
			xx+=(char)k;
		}
		char str[]=new char[3];
		//生成随机字符串
		for(int i=0;i<3;++i) {
			str[i]=xx.charAt((int)(Math.random()*xx.length()));
		}
		String s1=new String(str);
		System.out.println(matchPassword(s1,0));
	}
}
