package classes_objects;
import java.util.Arrays;
import java.util.Scanner;
public class Test{
//	public static class main(String[] argv) {
//		
//	}
	public static void main(String[] args) {
//		int cnt=0;
////		class:
////		����ʹ�ùؼ��֣�
//		class2:
//			for(int i=0;i<10;++i) {
//				for(int j=0;j<10;++j) {
//					++cnt;
//					if(i==4&&j==2) {
////						continue class2;
////						��continue+��ǩ���﷨
////						��������������һ����ѭ��
////						����һ��i��ʼ�µ���ѭ����
//						
////						����ͨ��continueֻ������
////						��ѭ������һ��j��
////						Ҳ����˵continue+��ǩ
////						��ѭ�����´ӱ�ǩ����ʼ��
//						
//						break class2;
//						
//					}
//				}
//			}
//		System.out.println(cnt);
		
//		������������⡣��������Ϊint��һ��class�����ˡ�
//		��Ϊ����ʹ�����ţ��ǹ��캯����ʼ���ķ�����
//		int a[]=new int(5);
		
//		int b[]=new int[5];
		
//		int a[]=new int[5];
//		for (int i = 0; i < a.length; i++) {
//			a[i]=(int)(Math.random()*100);
//		}
////		for(int x:a)System.out.println(x);
//		for (int i = 0; i < a.length-1; i++) {
//			int min=100;
//			int k=0;
//			for (int j = i; j < a.length; j++) {
//				if(a[j]<min) {
//					k=j;min=a[j];
//				}
//			}
//			int temp=a[i];
//			a[i]=a[k];
//			a[k]=temp;
//		}
//		for(int x:a)System.out.println(x);
//		for (int i = 0; i < a.length-1; i++) {
//			for (int j = 0; j < a.length-1-i; j++) {
//				if(a[j+1]>a[j]) {
//					int temp=a[j];
//					a[j]=a[j+1];
//					a[j+1]=temp;
//				}
//			}
//		}
//		for(int x:a)System.out.println(x);System.out.println();
//		
//		int b[]=new int[] {1,2};
//		int c[]= {3,4};
////		int d[]=new int[3] {1,2,3};������䲻���ԡ�
//		System.arraycopy(a, 4, b, 0, 2);
//		for(int x:b)System.out.println(x);
	
//		int lenA=(int)(Math.random()*5+5);
//		int lenB=(int)(Math.random()*5+5);
//		int a[]=new int[lenA];
//		int b[]=new int[lenB];
//		for (int i = 0; i < b.length; i++) {
//			b[i]=(int)(Math.random()*100);
//		}
//		for (int i = 0; i < a.length; i++) {
//			a[i]=(int)(Math.random()*100);
//		}
//		Arrays.sort(a);Arrays.sort(b);
//		System.out.println("����a�����ݣ�");
////		for(int x:a)System.out.printf("%d ",x);System.out.println();
//		System.out.println(Arrays.toString(a));
//		System.out.println("����b�����ݣ�");
////		for(int x:b)System.out.printf("%d ",x);System.out.println();
//		System.out.println(Arrays.toString(b));
//		int c[]=new int[lenA+lenB];
//		System.arraycopy(a, 0, c, 0, lenA);
//		System.arraycopy(b, 0, c, lenA, lenB);
//		System.out.println("����c�����ݣ�");
////		for(int x:c)System.out.printf("%d ",x);System.out.println();
//		System.out.println(Arrays.toString(c));
		
//		int lenA=(int)(Math.random()*5+5);
//		int a[]=new int[lenA];
//		for (int i = 0; i < a.length; i++) {
//			a[i]=(int)(Math.random()*100);
//		}
//		int b[]=Arrays.copyOfRange(a, lenA-4, lenA);
//		for(int x:a)System.out.println(x);System.out.println();
//		for(int x:b)System.out.println(x);
		
		int a[][]=new int[5][8];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j]=(int)(Math.random()*100);
			}
		}
		int temp[]=new int[40];
		for (int i = 0; i < a.length; i++) {
			System.arraycopy(a[i], 0, temp, a[i].length*i, a[i].length);
		}
		Arrays.sort(temp);
		for (int i = 0; i < a.length; i++) {
			System.arraycopy(temp, a[i].length*i, a[i], 0, a[i].length);
		}
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(Arrays.toString(a[i]));
//		}
		for(int i[]:a)System.out.println(Arrays.toString(i));
	}
	
}