package classes_objects;

public class Armor extends Item {
	int ac;
	public boolean disposable() {
		return false;
	}
	public void Print() {
		System.out.println("��������ѽ");
	}
	public void PPPPPrint() {
		System.out.println("�ܿ��ļ���");
	}
	public static void main(String[] args) {
		Armor A1=new Armor();
		Armor A2=new Armor();
		A1.name="����";A1.ac=15;A1.price=300;
		A2.name="���Ӽ�";A2.ac=40;A2.price=500;
		int a[]=new int[4];
		//int []a
		a[3]=1;
		System.out.println(a[3]);
		System.out.println();
		Item A=new Armor();
		A.Print();
//		A.PPPPPrint();�������δͨ�����룡 
		//һ���̶�������̬�ˣ���    
		//21������һ��Item����ָ����һ������Armor
		//��һ��Itemʵ����ʹ�õķ��������ԵȾ�����Item��������������
		//�����ʹ������������ͬ���ķ���
		//��Ϊ��ָ�����࣬�൱����ʹ�������еķ�����
		//��ʵͨ�׵㽲���ǣ�������Ϊ���ࣨƫС���������庯��Ϊ���࣡
	}
}
