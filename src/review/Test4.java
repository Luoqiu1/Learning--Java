package review;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Test4 {
	public static void main(String[] args) {
        File f = new File("fileA.txt");
        // 创建文件字符流
        // 缓存流必须建立在一个存在的流的基础上
        int wordCnt=0;
        int lineCnt=0;
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
            )
        {
            while (true) {
                // 一次读一行
                String line = br.readLine();
                if (null == line)
                    break;
//                System.out.println(line);
                char cs[]=line.toCharArray();
                for(char c:cs) {
                	if(c==' '|c=='.'|c=='\n'|c==-1)++wordCnt;
                	if(c=='.')++lineCnt;
//                	System.out.println("Here");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        File f2 = new File("fileB.txt");
        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(f2);
                // 缓存流必须建立在一个存在的流的基础上              
                PrintWriter pw = new PrintWriter(fw);              
        ) {
            pw.printf("统计的单词个数为：%d\n",wordCnt);
            pw.printf("统计的句子个数为：%d\n",lineCnt);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }
}
