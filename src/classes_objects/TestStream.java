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
	//	copyFile("C:\\Data/test.txt","C:\\Data/test2.txt");
	//	copyFolder("C:/Data","c:/Data2");
		File f=new File("C:\\Users\\57195\\Desktop\\Learning--Java");
		search(f,"Hero");
	}
	public static void copyFile(String srcFile, String destFile) {
		File f1=new File(srcFile);
		File f2=new File(destFile);
//		char cs[]=new char[(int)f1.length()];
		byte buffer[]=new byte[1024];
//		try(FileReader fr=new FileReader(f1);FileWriter fw=new FileWriter(f2)){
//			fr.read(cs);
//			fw.write(cs);
//		}
		try(FileInputStream fis=new FileInputStream(f1);FileOutputStream fos=new FileOutputStream(f2)) {
			while(true) {
				int actuallyReaded=fis.read(buffer);
				if(actuallyReaded==-1)break;
				fos.write(buffer,0,actuallyReaded);
				//如果不取实际的直接全部写上，会有多出来的0！
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void copyFolder(String srcFolder, String destFolder){
		File f1=new File(srcFolder);
		File f2=new File(destFolder);
		if(!f1.isDirectory())return;
		if(!f1.exists())return;
		if(f2.isFile())return;
		if(!f2.exists())f2.mkdirs();
		File f[]=f1.listFiles();
		for (int i = 0; i < f.length; i++) {
			File copyf=new File(f2,f[i].getName());
			if(f[i].isDirectory()) {
				copyFolder(f[i].getAbsolutePath(),copyf.getAbsolutePath());
			}
			else {
				copyFile(f[i].getAbsolutePath(),copyf.getAbsolutePath());
			}
		}
	}
	public static void search(File folder, String search) {
		if(folder.isFile())return;
		if(!folder.exists())return;
		File f[]=folder.listFiles();
		for (int i = 0; i < f.length; i++) {
			String s=f[i].getAbsolutePath();
			if(s.toLowerCase().endsWith(".java")) {
				try(FileInputStream fis=new FileInputStream(f[i])){
					byte cs[]=new byte[(int)f[i].length()];
					fis.read(cs);
					String s1=new String(cs);
				//	if(-1!=s1.indexOf(search)) {
					if(s1.contains(search)) {
						System.out.printf("找到子目标字符串%s,在文件：%s%n",search,f[i].getAbsolutePath());
					}
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			else if(f[i].isDirectory()) {
				search(f[i],search);
			}
		}
	}
}

