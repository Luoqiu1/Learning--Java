package classes_objects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
public class TestThread {
 
    /**
     * @param file ���ҵ�Ŀ¼
     * @param search ���ҵ��ַ���
     */
    public static void search(File file, String search) {
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
//                String fileContent = readFileConent(file);
//                if(fileContent.contains(search)){
//                    System.out.printf("�ҵ���Ŀ���ַ���%s,���ļ�:%s%n",search,file);
//                }
//            	SearchFileThread sft=new SearchFileThread(file,search);
//            	sft.start();
//            	new SearchFileThread(file,search).start();
            	SearchFileThread sft=new SearchFileThread(file,search);
            	new Thread(sft).start();
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }
     
    public static String readFileConent(File file){
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
 
    }
 
    public static void main(String[] args) {
        File folder =new File("C:\\\\Users\\\\57195\\\\Desktop\\\\Learning--Java");
        search(folder,"Hero");
    }
}
