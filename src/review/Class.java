package review;

import java.util.Vector;

public class Class {
	public String className;
	public int score;
	public int learnTime;
	public Class(String className,int score,int learnTime){
		this.className=className;
		this.score=score;
		this.learnTime=learnTime;
	}
	public static void main(String[] args) {
		Class c1=new Class("高数",90,80);
		Class c2=new Class("离散数学",80,80);
		Class c3=new Class("英语",85,96);
		Class c4=new Class("C语言",56,80);
		Class c5=new Class("数据结构",56,80);
		Class c6=new Class("人工智能",87,48);
		Vector<Class> classList=new Vector<>();
		classList.add(c1);classList.add(c2);
		classList.add(c3);classList.add(c4);
		classList.add(c5);classList.add(c6);
		System.out.printf("名称\t\t得分\t\t学分\n");
		int scoreAll=0;
		for(Class c:classList) {
			System.out.printf(c.className);
			int score=c.score>=60?c.learnTime/16:0;
			scoreAll+=score;
			System.out.printf("\t\t%d\t\t%d\n",c.score,score);
		}
		System.out.printf("总学分为：%d\n",scoreAll);
	}
}
