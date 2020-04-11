package classes_objects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class TestThread {
 
    /**
     * @param file 查找的目录
     * @param search 查找的字符串
     */
    public static void search(File file, String search) {
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
//                String fileContent = readFileConent(file);
//                if(fileContent.contains(search)){
//                    System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
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
    public static boolean found = false;
    public static void main(String[] args) {
        String password = randomString(3);
        System.out.println("密码是:" + password);
        char[] guessPassword = new char[password.length()];
        List<String> midAns=new ArrayList<>();
        GeneratePasswordLog tLog=new GeneratePasswordLog(midAns);
//        tLog.setDaemon(true);
        tLog.start();
        Thread t=new Thread(new GeneratePasswordThread(guessPassword,password,midAns));
//        t.setDaemon(true);
        t.start();
//        generatePassword(guessPassword,password);
        
    }
     
    public static void generatePassword(char[] guessPassword,String password){
        generatePassword(guessPassword,0,password);
    }
     
    public static void generatePassword(char[] guessPassword,int index,String password){
        if(found)
            return;
        for (short i = '0'; i <= 'z'; i++) {
            char c = (char)i;
            if(!Character.isLetterOrDigit(c))
                continue;
            guessPassword[index] = c;
            if(index!=guessPassword.length-1){
                generatePassword(guessPassword,index+1,password);
            }
            else{
                String guess = new String(guessPassword);
//              System.out.println("穷举出来的密码是：" + guess);
                if(guess.equals(password)){
                    System.out.println("找到了，密码是" + guess);
                    found =true;
                    return;
                }
            }
        }
    }
 
    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }
}
