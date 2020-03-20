package school_works;

public class Box {
	private double a,b,c;
	public Box(double x,double y, double z) {
		a=x;b=y;c=z;
	}
	public double V() {
		return a*b*c;
	}
	public static void main(String[] args) {
		Box a=new Box(3,6,10);
		System.out.println(a.V());
	}
}
