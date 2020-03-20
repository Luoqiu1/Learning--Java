package school_works;

public class Complex {
	double a,b;
	public Complex() {
	}
	public Complex(double a,double b) {
		this.a=a;this.b=b;
	}
	public void add(Complex c) {
		double x=a+c.a;double y=b+c.b;
		System.out.print(x);
		if(y>0)System.out.println("+"+y+"i");
		else System.out.println(y+"i");
	}
	public void min(Complex c) {
		double x=a-c.a;double y=b-c.b;
		System.out.print(x);
		if(y>0)System.out.println("+"+y+"i");
		else System.out.println(y+"i");
	}
	public void mul(Complex c) {
		double x=a*c.a-b*c.b;double y=b*c.a+a*c.b;
		System.out.print(x);
		if(y>0)System.out.println("+"+y+"i");
		else System.out.println(y+"i");
	}
	public static void main(String[] args) {
		Complex a=new Complex(3,-1);
		Complex b=new Complex(5,5);
		a.add(b);
		a.min(b);
		a.mul(b);
	}
}
