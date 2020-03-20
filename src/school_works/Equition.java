package school_works;
import javax.swing.JOptionPane;
public class Equition {
	double a,b,c;
	double x1,x2;
	boolean realFlag;
	public Equition(double a,double b,double c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	boolean computeRoots() {
		realFlag=false;
		double dd=b*b-4*a*c;
		if(dd>=0) {
			realFlag=true;
			dd=Math.sqrt(dd);
			x1=(-b+dd)/(2*a);
			x2=(-b-+dd)/(2*a);
		}
		return realFlag;
	}
	public void dispaly() {
		if(realFlag)System.out.println("x1="+x1+",x2="+x2);
		else System.out.println("ÎÞÊµ¸ù£¡");
	}
	public static void main(String[] args) {
		Equition e1=new Equition(1,4,4);
		e1.computeRoots();
		e1.dispaly();
		Equition e2=new Equition(5,7,3);
		e2.computeRoots();
		e2.dispaly();
		Equition e3=new Equition(1,7,3);
		e3.computeRoots();
		e3.dispaly();
	}
}
