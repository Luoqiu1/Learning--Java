package classes_objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestJDBC{
	public static void main(String args[]) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
//				"how2java?characterEncoding=UTF-8","root","admin");
//				Statement s=c.createStatement()){
//			
//			
////			Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
////			"how2java?characterEncoding=UTF-8","root","admin");
////			Statement s=c.createStatement();
//	//		System.out.println("获取Statement对象+"+s);
////			String sql = 
////					"insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
//			//		"insert into hero values(null,'提莫',313.0f,50)";--这条编译错误
//			//		"insert into hero values(null,"+'提莫'+","+313.0f+","+50+")";错误
////					"insert into hero values(null,'提莫',313.0,50)";
//					//发现小错误......
////			System.out.println(sql);
////			s.execute(sql);
////			s.close();
////			c.close();
////			
////			for(int i=0;i<100;++i) {
////				int temp=1+i;
////				int tempNumber=i+1;
////				String sql1="insert into hero values("+temp+","
////			+"'英雄"+tempNumber+"',"+Math.random()*100+","+Math.random()*50+100+")";
////				s.execute(sql1);
////				System.out.println("成功插入sql:"+sql1);
////			}
////			
////			for(int i=100;i<300;++i) {
////				String sql1="delete from hero where id="+i;
////				System.out.println("成功删除:"+sql1);
////				s.execute(sql1);
////			}
//			
//			String sql="select * from hero";
//			ResultSet rs=s.executeQuery(sql);
//			while(rs.next()) {
//				int id=rs.getInt("id");
//				String name=rs.getString("name");
//				double hp=rs.getFloat(3);
//				int damage=rs.getInt("damage");
//				System.out.printf("查询到了，该数据为：%nid:%d\tname:%s\thp:%f\tdamage:%d%n",id,name,hp,damage);
//			}
//			String name="dashen";String password="thisispassword";
//			String sql2="select * from user where name='"+name+"'and password='"+password+"';";
//			ResultSet rs2=s.executeQuery(sql2);
//			if(rs2.next()) {
//				System.out.println("账号密码正确！");
//			}
//			else {
//				System.out.println("账号密码错误！");
//			}
//			String sql3="select count(*) from hero";
//			ResultSet rs3=s.executeQuery(sql3);
//			if(rs3.next()) {
//				System.out.println("总共有 "+rs3.getInt(1)+" 个数据");
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			if(e instanceof SQLException)
//			e.printStackTrace();
//		}
		
		
//		list(6,10);
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
////		String sql="insert into hero values(?,'牛牛',?,?)";
//		String sql="select * from user where name=? and password=?";
////		String sql="delete from hero where id=?";
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
//				"how2java?characterEncoding=UTF-8","root","admin");
//				PreparedStatement ps=c.prepareStatement(sql)){
//		//	for(int i=20;i<=100;++i) {
////				ps.setInt(1, 26);
////				ps.setFloat(2,2.33f);
////				ps.setInt(3,66);
//		//		ps.execute();
//				
//				ps.setString(1,"dashen");
//				ps.setString(2, "thisispassword;delete from user;");
//				//这两行的测试很好说明了
//				//PreparedStatement对sql注入式攻击的安全处理！
//				//是把参数看成一个整体
//				//而不是直接原封不动地像Statement那样把语句写上去执行！
//				System.out.println(ps.toString());
		//	}
		
		
//		Thread T1=new Thread() {
//			public void run() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		long t1=System.currentTimeMillis();
//		String sql="insert into user values(?,?,?)";
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
//				"how2java?characterEncoding=UTF-8","root","admin");
//				PreparedStatement ps=c.prepareStatement(sql);){
//			for (int i = 1; i <= 10000; i++) {
//				ps.setInt(1, i);
//				ps.setString(2, "Hero"+i);
//				ps.setString(3, "h"+i);
//				ps.execute();
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		long t2=System.currentTimeMillis();
//		System.out.println("使用预编译Statement处理时间为："+(t2-t1));
//			}
//		};
//		
//		Thread T2=new Thread() {
//			public void run() {
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				long t2=System.currentTimeMillis();
//		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
//				"how2java?characterEncoding=UTF-8","root","admin");
//				Statement s=c.createStatement()){
//			for (int i = 10001; i <= 20000; i++) {
//				String temp="insert into user values("
//						+ i+",'Hero"+i+"','h"+i+"')";
////				System.out.println(temp);
//				s.execute(temp);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		long t3=System.currentTimeMillis();
//		System.out.println("使用Statement处理时间为："+(t3-t2));
//		
//			}
//		};
//		T1.start();
//		T2.start();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String sql="insert into hero values(null,?,40,40)";
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
				"how2java?characterEncoding=UTF-8","root","admin");
				PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, "哦牛");
			ps.execute();
			ResultSet rs=ps.getGeneratedKeys();
			//注意这里！！必须要有 rs.next()
			//就如同迭代器iterator中，使用if(it.next())一样
			//首先判断是否存在这个东西，防止非法访问
			//其次就是rs自增一步后，正式走到第一个可以访问的元素！
			//一开始这类像指针一样的东西都是在可能出现第一个可以访问的元素
			//的前一个位置！
			if(rs.next()) {
				int i=rs.getInt(1);
		//		System.out.println(rs);
				while(true) {
					--i;
					if(i==0)break;
					String sqltemp="select * from hero where id="+i;
					boolean flag=ps.execute(sqltemp);
					//可以将PrepareStatement当成Statement来用
					//参数位置放入一个String sql来执行！
					//就不用重新再创建一个Statement了
					if(flag) {
						sqltemp="delete from hero where id="+i;
						ps.execute(sqltemp);
						break;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void list(int start,int count) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection c=DriverManager.getConnection("jdbc:mysql:"
				+ "//127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","admin");
				Statement s=c.createStatement()){
			String database="hero";
			String sql="select * from "+database+" limit "+start+","+count;
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				double hp=rs.getFloat(3);
				int damage=rs.getInt("damage");
				System.out.printf("查询到了，该数据为：%nid:%d\tname:%s\thp:%f\tdamage:%d%n",id,name,hp,damage);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
