package review;

import java.util.Scanner;
import java.util.Arrays;

public class Test3 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a[]=new int[6];
		for(int i=0;i<6;++i) {
			int temp;temp=s.nextInt();
			a[i]=temp;
		}
		Arrays.sort(a);
		for(int i=0;i<6/2;++i) {
			int temp=a[i];
			a[i]=a[6-1-i];
			a[6-1-i]=temp;
		}
		for(int i:a) {
			System.out.println(i);
		}
		Arrays.sort(a);
		int search;search=s.nextInt();
		int local=Arrays.binarySearch(a, search);
		if(local<0) {
			System.out.printf("没有找到数 %d\n",search);
		}
		else {
			System.out.printf("找到了这个数,位置是 %d\n",local);
		}
	}
}
