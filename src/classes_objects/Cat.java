package classes_objects;

public class Cat extends Animal implements Pet{
	private String name;
	public Cat(String name) {
		//如果没有下面这一行是报错的！
		//因为子类构造器中，先默认调用父类的
		//默认构造器！即super()！
		//如果父类中有构造器而没有另外声明无参构造器
		//则会编译失败！
		super(4);
		//
		this.name=name;
		
	}
	public Cat() {
		this("");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void play() {
		System.out.println(name+" 正在和你玩哦。。");
	}
	public void eat() {
		System.out.println(name+" 正在吃。。");
	}
}
