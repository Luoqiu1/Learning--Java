package school_works;

abstract class Person {
	protected String name;
	public Person(String name) {
		this.name=name;
	}
	abstract public double pay();
	public String toString() {
		return "������"+this.name+"\t����֧����"+this.pay()+"\n";
		
	}
}
