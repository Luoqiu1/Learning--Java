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
		
		//但其实上述是基于，c++中，基类中的同名函数没有采用virtual虚函数
		//只是重写！没有构成覆盖（c++中的重写、覆盖好像同java中不太一样）
		//c++中重写与覆盖是两个概念
		//java中重写等同于覆盖！
		//倘若c++中，在基类的同名函数前面加上virtual构成虚函数
		//就会跟java以上测试得到相同的结果了！
		
	}
	static public void test(TestBase t) {
		t.print();
	}
}

