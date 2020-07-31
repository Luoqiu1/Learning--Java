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
////		不能使用关键字！
//		class2:
//			for(int i=0;i<10;++i) {
//				for(int j=0;j<10;++j) {
//					++cnt;
//					if(i==4&&j==2) {
////						continue class2;
////						用continue+标签的语法
////						做到了跳过这整一个子循环
////						以下一个i开始新的子循环！
//						
////						而普通的continue只会跳出
////						子循环的这一次j！
////						也就是说continue+标签
////						让循环重新从标签处开始！
//						
//						break class2;
//						
//					}
//				}
//			}
//		System.out.println(cnt);
		
//		该条语句有问题。编译器认为int是一种class类型了。
//		因为我们使用括号，是构造函数初始化的方法。
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
////		int d[]=new int[3] {1,2,3};这条语句不可以。
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
//		System.out.println("数组a的内容：");
////		for(int x:a)System.out.printf("%d ",x);System.out.println();
//		System.out.println(Arrays.toString(a));
//		System.out.println("数组b的内容：");
////		for(int x:b)System.out.printf("%d ",x);System.out.println();
//		System.out.println(Arrays.toString(b));
//		int c[]=new int[lenA+lenB];
//		System.arraycopy(a, 0, c, 0, lenA);
//		System.arraycopy(b, 0, c, lenA, lenB);
//		System.out.println("数组c的内容：");
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