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
        // �����ļ��ַ���
        // ���������뽨����һ�����ڵ����Ļ�����
        int wordCnt=0;
        int lineCnt=0;
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
            )
        {
            while (true) {
                // һ�ζ�һ��
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
                // �����ļ��ַ���
                FileWriter fw = new FileWriter(f2);
                // ���������뽨����һ�����ڵ����Ļ�����              
                PrintWriter pw = new PrintWriter(fw);              
        ) {
            pw.printf("ͳ�Ƶĵ��ʸ���Ϊ��%d\n",wordCnt);
            pw.printf("ͳ�Ƶľ��Ӹ���Ϊ��%d\n",lineCnt);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }
}
