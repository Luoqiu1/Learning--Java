package school_works;
import java.util.Calendar;

public class Stopwatch {
	private static int minute;
	private static int second;
	private static Calendar curdate,date1;
	private static double totalSeconds,totalSeconds2;
	public static void startCount() {
		date1=Calendar.getInstance();
		totalSeconds2=date1.MINUTE*60+date1.SECOND;
	}
	public static int getTotalTime() {//×ÜµÄºÁÃëÊý
		return (int)(totalSeconds*1000);
	}
	public static void reset() {
		startCount();
	}
	public static int getMinute() {
		return minute;
	}
	public static int getSecond() {	
		return second;
	}
	public static void stopSount() {
		Calendar curdate=Calendar.getInstance();
		double s2=curdate.MINUTE*60+curdate.SECOND;
		totalSeconds=s2-totalSeconds2;
		minute=(int)(totalSeconds)/60;
		second=(int)(totalSeconds)-60*minute;
//		System.out.println(totalSeconds+" "+totalSeconds2);
//		System.out.println(date1.SECOND+" "+curdate.SECOND);
	}
	public static String ToString() {
		return String.valueOf(minute)+":"+String.valueOf(second)+":"+String.valueOf((int)((totalSeconds-(int)(totalSeconds)))*1000);
	}
	
	public static void main(String[] args) {
		Stopwatch.startCount();
		for(int i=2;i<10000;++i) {
			boolean flag=true;
			for(int j=2;j<i;++j) {
				if(i%j==0) {
					flag=false;break;
				}
			}
	//		if(flag)System.out.println(i);
		}
		Stopwatch.stopSount();
		String s=Stopwatch.ToString();
		System.out.println(s);
		System.out.println(Stopwatch.getSecond());
		System.out.println(Stopwatch.getMinute());
	}
}
