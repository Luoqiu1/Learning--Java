package classes_objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		
		try {
			File f=new File("c:/xyz/abc/def/lol2.txt");
			f.mkdir();
//			if(!f.getParentFile().exists()) {
//				f.getParentFile().mkdirs();
//				f.mkdirs();
//			}
			FileOutputStream fos=new FileOutputStream(f);
//			byte a[]= {41,23};
//			fos.write(a);
//			fos.close();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}