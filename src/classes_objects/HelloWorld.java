package classes_objects;

public class HelloWorld {
	public static String matchPassword(String Password,int depth) {
		if(depth==Password.length())return "";//����ݹ�����������ؿմ�
		while(true) {
			//��֤random��Χ�ڸ��ǵ��������ֺ���ĸ�Ϳ�����
			//������ȡ�˸�������168��һ���ܹ����ǵ�
			char c=(char)((int)(Math.random()*120+48));
			if(c==Password.charAt(depth)) {
				return c+matchPassword(Password,depth+1);
			}
		}
	}
	public static void main(String[] args) {
		String xx="";//�洢�������ֺ���ĸ
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
		//��������ַ���
		for(int i=0;i<3;++i) {
			str[i]=xx.charAt((int)(Math.random()*xx.length()));
		}
		String s1=new String(str);
		System.out.println(matchPassword(s1,0));
	}
}
