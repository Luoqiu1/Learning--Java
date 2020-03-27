package classes_objects;
import java.util.Date;
public class TextDate {
	public static void main(String[] args) {
		long second=1000;long minute=60*second;long hour=60*minute;
		long day=24*hour;long year=365*day;long leapday=(1995-1970)/4*day;
		long leaphour=8*hour;
		long year1995start=(1995-1970)*year+leapday-leaphour;
		Date d0=new Date(year1995start);
		System.out.println(d0);
		Date d1=new Date(year1995start+year-1);
		System.out.println(d1);
		Date d=new Date((long) (Math.random()*(year-1)+year1995start));
		System.out.println(d);
		Date dd=new Date();
		System.out.println(dd.toString());
		Date ddd=new Date(0);
		System.out.println(ddd);
	}
}
