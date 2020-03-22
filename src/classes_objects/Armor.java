package classes_objects;

public class Armor extends Item {
	int ac;
	public boolean disposable() {
		return false;
	}
	public void Print() {
		System.out.println("不试试了呀");
	}
	public void PPPPPrint() {
		System.out.println("能看的见吗？");
	}
	public static void main(String[] args) {
		Armor A1=new Armor();
		Armor A2=new Armor();
		A1.name="布甲";A1.ac=15;A1.price=300;
		A2.name="锁子甲";A2.ac=40;A2.price=500;
		int a[]=new int[4];
		//int []a
		a[3]=1;
		System.out.println(a[3]);
		System.out.println();
		Item A=new Armor();
		A.Print();
//		A.PPPPPrint();这条语句未通过编译！ 
		//一定程度上理解多态了！：    
		//21行中另一个Item父类指向了一个子类Armor
		//这一个Item实例能使用的方法、属性等局限于Item父类中所声明的
		//而如果使用了与子类中同名的方法
		//因为是指向子类，相当于在使用子类中的方法！
		//其实通俗点讲就是：定义域为父类（偏小），而具体函数为子类！
	}
}
