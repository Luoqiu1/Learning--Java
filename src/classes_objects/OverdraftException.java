package classes_objects;

public class OverdraftException extends Exception{
	private double deficit;
	public OverdraftException(){
	}
	public double getDeficit() {
		return deficit;
	}
	public OverdraftException(String msg) {
		super(msg);
	}
	public OverdraftException(double a,String msg) {
		super(msg);
		deficit=a;
	}
}
