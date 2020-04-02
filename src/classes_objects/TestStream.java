package classes_objects;
import java.io.File;
import java.io.InputStream;
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
		 public static void main(String[] args) {
			File f=new File("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\classes_objects/Class.java");
			StringBuffer s=new StringBuffer();
//			try(FileReader fr=new FileReader(f);BufferedReader br=new BufferedReader(fr)){
//				while(true) {
//					String str=br.readLine();
//					if(str==null)break;
//					s.append(str+"\r\n");
//				}
//			}
			String sx = null;
			try(FileReader fr=new FileReader(f);){
				char c[]=new char[(int)f.length()];
				fr.read(c);
				sx=new String(c);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			Scanner in=new Scanner(System.in);
			System.out.println("请输入类的名称：");
			String Class;Class=in.next();
			System.out.println("请输入属性的类型");
			String Type;Type=in.next();
			System.out.println("请输入属性的名称");
			String Name;Name=in.next();
			char Mid[]=Name.toCharArray();
			Mid[0]=Character.toUpperCase(Mid[0]);
			String UName=new String(Mid);
			
			sx=sx.replaceAll("@class@", Class);
			sx=sx.replaceAll("@type@", Type);
			sx=sx.replaceAll("@property@", Name);
			sx=sx.replaceAll("@Uproperty@", UName);
			
//			File f2=new File("C:\\\\Users\\\\57195\\\\Desktop\\\\Learning--Java\\\\src\\\\classes_objects/"+Class+".java");
			File f2=new File(f.getParentFile().getAbsolutePath(),Class+".java");
//			try(FileWriter fw=new FileWriter(f2);PrintWriter pw=new PrintWriter(fw)){
//				String mid=new String(s);
//				String s0[]=mid.split("@");
//				for (int i = 0; i < s0.length; i++) {
//					if(s0[i].startsWith("class"))s0[i]=s0[i].replaceFirst("class", Class);
//					else if(s0[i].startsWith("type"))s0[i]=s0[i].replaceFirst("type", Type);
//					else if(s0[i].startsWith("property"))s0[i]=s0[i].replaceFirst("property",Name);
//					else if(s0[i].startsWith("Uproperty"))s0[i]=s0[i].replaceFirst("Uproperty",UName);
//				}
//				for (int i = 0; i < s0.length; i++) {
//					pw.print(s0[i]);
//				}
//			}
			try(FileWriter fw=new FileWriter(f2);){
				fw.write(sx);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("替换后的内容：");
//			try(FileReader fr=new FileReader(f2);BufferedReader br=new BufferedReader(fr)){
//				while(true) {
//					String s3;
//					s3=br.readLine();
//					if(s3==null)break;
//					System.out.println(s3);
//				}
//			}
			try(FileReader fr=new FileReader(f2);){
				char c[]=new char[(int)f2.length()];
				fr.read(c);
				System.out.println(c);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("文件保存在："+f2);
		}
	}

