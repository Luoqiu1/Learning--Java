package classes_objects;

public class TestBase2 extends TestBase{
	public void print() {
		System.out.println("Base2");
	}
	public static void main(String[] args) {
		TestBase2 t2=new TestBase2();
		TestBase t1=new TestBase();
		t2.print();//Base2
		t1.print();//Base1
		test(t2);//���н��ΪBase2����c++�У�����������н��ΪBase1��
		test(t1);//Base1
		//c++��java�У���ͨ������ת���ࣨc++�г�Ϊ�̳���ת���ࣩ��
		//����ͬ���ĳ�Ա����ʱ�����Ų�ͬ����ʽ��
		//c++��ʹ�þ���ģ���ת�����������ĺ���
		//��java��ʹ�þ��屻���õ��Ǹ������������ĺ�����
	}
	static public void test(TestBase t) {
		t.print();
	}
}

