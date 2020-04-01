package classes_objects;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class TestStream {
	static int x=66;
	static int y=77;
	public static void main(String[] args) {
		bufferWriteAndRead();
		System.out.println();
		dataWriteAndRead();
	}
	public static void bufferWriteAndRead() {
		File f=new File("c:/data/lol.txt");
		try(FileWriter fw=new FileWriter(f);PrintWriter pw=new PrintWriter(fw)
				;FileReader fr=new FileReader(f);BufferedReader br=new BufferedReader(fr)){
			pw.print(x);pw.print('@');pw.print(y);
			pw.flush();//这句话记得一定要有！
			String s=br.readLine();
			String str[]=s.split("@");
			System.out.println(Integer.parseInt(str[0]));
			System.out.println(Integer.parseInt(str[1]));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
//		try(FileReader fr=new FileReader(f);BufferedReader br=new BufferedReader(fr)){
//		//	String s=br.readLine();
//			String s=br.readLine();
//			String str[]=s.split("@");
//			System.out.println(Integer.parseInt(str[0]));
//			System.out.println(Integer.parseInt(str[1]));
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
	}
	public static void dataWriteAndRead() {
		File f=new File("c:/data/lol.txt");
		try(FileOutputStream fos=new FileOutputStream(f);DataOutputStream dos=new DataOutputStream(fos)){
			dos.writeInt(x);dos.writeUTF("Hello!");dos.writeInt(y);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		try(FileInputStream fis=new FileInputStream(f);DataInputStream dis=new DataInputStream(fis)){
			int a=dis.readInt();
			String s=dis.readUTF();
			int b=dis.readInt();
			System.out.println(s);
			System.out.println(a);System.out.println(b);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
