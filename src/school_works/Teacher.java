package school_works;

public class Teacher extends Person {
	private double price;
	private double baseWage;
	private double teachingHours;
	public Teacher(String name,double baseWage,double price,int teacheringHours) {
		super(name);
		this.baseWage=baseWage;
		this.price=price;
		this.teachingHours=teachingHours;
	}
	public double pay() {
		return baseWage+teachingHours*price;
	}
}
