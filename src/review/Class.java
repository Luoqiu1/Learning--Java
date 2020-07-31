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
		Class c1=new Class("����",90,80);
		Class c2=new Class("��ɢ��ѧ",80,80);
		Class c3=new Class("Ӣ��",85,96);
		Class c4=new Class("C����",56,80);
		Class c5=new Class("���ݽṹ",56,80);
		Class c6=new Class("�˹�����",87,48);
		Vector<Class> classList=new Vector<>();
		classList.add(c1);classList.add(c2);
		classList.add(c3);classList.add(c4);
		classList.add(c5);classList.add(c6);
		System.out.printf("����\t\t�÷�\t\tѧ��\n");
		int scoreAll=0;
		for(Class c:classList) {
			System.out.printf(c.className);
			int score=c.score>=60?c.learnTime/16:0;
			scoreAll+=score;
			System.out.printf("\t\t%d\t\t%d\n",c.score,score);
		}
		System.out.printf("��ѧ��Ϊ��%d\n",scoreAll);
	}
}
