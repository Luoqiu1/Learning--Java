package classes_objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class TestException {
	public static int f1(){
		return 1;
	}
	public static int f2(){
		return 2;
	}
	public static int f3(){
		return 3;
	}
	public static int method() {
		File f=new File("c:/Data/LOL.exe");
		try {
			new FileInputStream(f);
			System.out.println("�ɹ���");
			return f1();
		}
		catch(Exception e){
			System.out.println("��ʧ��");
			return f2();
		}
		finally {
			return f3();
		}
	}
	public static void main(String[] args) {
		System.out.println(method());
	}
}
