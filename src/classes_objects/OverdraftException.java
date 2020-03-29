package classes_objects;

public class OverdraftException extends Exception{
	double deficit;
	public OverdraftException(){
	}
	public OverdraftException(String msg) {
		super(msg);
	}
	public OverdraftException(double a,String msg) {
		super(msg);
		deficit=a;
	}
}
