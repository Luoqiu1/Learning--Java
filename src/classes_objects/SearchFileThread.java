package classes_objects;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//public class SearchFileThread extends Thread{
public class SearchFileThread implements Runnable{
	private File f;
	private String target;
	public SearchFileThread(File f,String target) {
		this.f=f;
		this.target=target;
	}
	public void run() {
      String fileContent = readFileConent(f);
      if(fileContent.contains(target)){
          System.out.printf("找到子目标字符串%s,在文件:%s%n",target,f);
      }
	}
	private String readFileConent(File f) {
		try (FileReader fr = new FileReader(f)) {
            char[] all = new char[(int) f.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
}
