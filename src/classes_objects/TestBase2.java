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
		test(t2);//运行结果为Base2；而c++中，该条语句运行结果为Base1！
		test(t1);//Base1
		//c++与java中，对通过子类转父类（c++中成为继承类转基类）后
		//调用同名的成员函数时，有着不同处理方式！
		//c++会使用具体的，被转化后的类里面的函数
		//而java会使用具体被引用的那个对象的类里面的函数！
	}
	static public void test(TestBase t) {
		t.print();
	}
}

