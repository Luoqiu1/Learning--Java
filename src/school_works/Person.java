package school_works;

abstract class Person {
	protected String name;
	public Person(String name) {
		this.name=name;
	}
	abstract public double pay();
	public String toString() {
		return "姓名："+this.name+"\t工资支出："+this.pay()+"\n";
		
	}
}
