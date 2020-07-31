package review;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String rq;
		rq=s.next();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d=sdf.parse(rq);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			int day=c.get(c.DAY_OF_YEAR);
			System.out.println(day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
