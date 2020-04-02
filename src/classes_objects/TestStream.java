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
		copyFile("C:\\Data/test.txt","C:\\Data/test2.txt");
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
}

