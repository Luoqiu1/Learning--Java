package classes_objects;

import java.io.File;
import java.io.IOException;
  
public class TestFile {
	public static File Maxfile=null;
	public static File Minfile=null;
	public static long Maxsize=0;
	public static long Minsize=Integer.MAX_VALUE;
	
	public static void jg(File f) {
		if(f.length()>Maxsize) {
			Maxfile=f;
			Maxsize=f.length();
		}
		if(f.length()<Minsize&&f.length()>0) {
			Minfile=f;
			Minsize=f.length();
		}
	}
	public static void dfs(File f) {
		if(f.isDirectory()) {
			File f0[]=f.listFiles();
//			for(int i=0;i<f0.length;++i) {
//				File x=f0[0].getAbsoluteFile();
//				dfs(x);
//			}
			for(File x:f0)dfs(x);
		}
		if(f.isFile()) jg(f);
		if(f==null);
	}
    public static void main(String[] args) {
        File f=new File("C:\\��Ϸ");
//        File f0[]=f.listFiles();
////        for(File x:f1) {
////        	dfs(x);
////        }
//        for(int i=0;i<f0.length;++i) {
//			File x=new File(f0[0].getAbsolutePath());
//			dfs(x);
//		}
        dfs(f);
        System.out.printf("�����ļ���%s�����С��%,d�ֽ�%n",Maxfile.getAbsolutePath(),Maxfile.length());
        System.out.printf("��С���ļ���%s�����С��%,d�ֽ�%n",Minfile.getAbsolutePath(),Minfile.length());
    }
}