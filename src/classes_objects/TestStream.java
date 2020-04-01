package classes_objects;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class TestStream {
	public static void main(String[] args) {
		File f=new File("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\classes_objects\\TestFile.java");
		removeContents(f);
	}
	public static void removeContents(File f) {
		StringBuffer sb=new StringBuffer();
		try(FileReader fr=new FileReader(f);BufferedReader br=new BufferedReader(fr);){
			while(true) {
				String s=br.readLine();
				if(s!=null) {
					if(!s.trim().startsWith("//"))
						sb.append(s+"\r\n");
				}
				else break;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		try(FileWriter fw=new FileWriter(f);PrintWriter pw=new PrintWriter(fw)){
			pw.print(sb);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
