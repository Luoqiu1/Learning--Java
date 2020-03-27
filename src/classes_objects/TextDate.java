package classes_objects;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class TextDate {
	public static void main(String[] args) {
//		long second=1000;long minute=60*second;long hour=60*minute;
//		long day=24*hour;long year=365*day;long leapday=(2000-1970)/4*day;
//		long leaphour=8*hour;
//		long year2000start=(2000-1970)*year+leapday-leaphour;
//		Date dt[]=new Date[9];
//		for(int i=0;i<dt.length;++i) {
//			long time=(long)((Math.random()*year2000start));
//			dt[i]=new Date(time);
//		}
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		for(Date d:dt) {
//			String str=sdf.format(d);
//			System.out.println(str);
//		}
//		System.out.println();
//	//	Date text=new Date(50000);
//	//	System.out.println(text.getTime());
//		for(int i=0;i<dt.length-1;++i) {
//			for(int j=0;j<dt.length-1-i;++j) {
//				SimpleDateFormat sdf0=new SimpleDateFormat("HHmmss");
//				String s1=sdf0.format(dt[j]);
//				String s2=sdf0.format(dt[j+1]);
//			//	System.out.println(s1);System.out.println(s2);
//				int d1=Integer.parseInt(s1);
//				int d2=Integer.parseInt(s2);
//		//		System.out.println(d1);System.out.println(d2);
////				long d3=dt[j].getTime()%day;
////				long d4=dt[j+1].getTime()%day;
//				//不知道错哪里。。。
//			//	System.out.println(d3);System.out.println(d4);System.out.println();
//				if(d1>d2) {
//					Date d=new Date();
//					d=dt[j];dt[j]=dt[j+1];dt[j+1]=d;
//				}
//			}
//		}
//		for(Date d:dt) {
//			String str=sdf.format(d);
//			System.out.println(str);
//		}
		Date now=new Date();SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-"
				+ "dd HH:mm:ss");
		Calendar c=Calendar.getInstance();
		c.setTime(now);
		String s=sdf.format(now);
		System.out.println("现在是 "+s);
		System.out.println("几月 "+Calendar.MONTH);
		c.add(Calendar.MONTH, 2);
		System.out.println("几月 "+Calendar.MONTH);
		now=c.getTime();
		s=sdf.format(now);
		System.out.println("现在是 "+s);
		System.out.println("几月 "+Calendar.MONTH);
		c.set(Calendar.DATE, 1);
		int start=Calendar.MONTH;
		now=c.getTime();
		s=sdf.format(now);
		System.out.println("现在是 "+s);
		System.out.println("几月 "+Calendar.MONTH);
		c.add(Calendar.DATE, -3);
		now=c.getTime();
		s=sdf.format(now);
		System.out.println("现在是 "+s);
		System.out.println("几月 "+Calendar.MONTH);
//		while(true) {
//			c.add(Calendar.DATE, 1);
//			System.out.println(Calendar.MONTH);
//			if(Calendar.MONTH!=start) {
//				c.add(Calendar.DATE, -3);
//				break;
//			}
//		}
		now=c.getTime();
		s=sdf.format(now);
		System.out.println("这个月的倒数第三天是 "+s);
	}
}