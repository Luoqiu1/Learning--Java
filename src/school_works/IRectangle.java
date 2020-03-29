package school_works;
public class IRectangle {

	double len,wid,area;
	
	public double getLen() {
		return len;
	}

	public void setLen(double len) {
		this.len = len;
	}

	public double getWid() {
		return wid;
	}

	public void setWid(double wid) {
		this.wid = wid;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public IRectangle(double len,double wid) {
		this.len = len;
		this.wid = wid;
		area = len*wid;
	}
	
	public String toString() {
		return "该举行的属性为:\n"+"长:"+len+"\n宽:"+wid+"\n面积:"+area;
	}
	
	public static void main(String[] args) {
		IRectangle rectangle = new IRectangle(5, 6);
		System.out.println(rectangle.toString());
		MySquare square = new MySquare(5, 5);
		System.out.println(square.toString());
	}
}


class MySquare extends IRectangle{

	public MySquare(double len, double wid) {
		super(len, wid);
	}
	public double getArea() {
		return super.getArea();
	}
	public String toString() {
		return "该正方形的属性为:\n"+"长:"+len+"\n宽:"+wid+"\n面积:"+area;
	}
}
