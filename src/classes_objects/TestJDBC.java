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
//	//		System.out.println("��ȡStatement����+"+s);
////			String sql = 
////					"insert into hero values(null,"+"'��Ī'"+","+313.0f+","+50+")";
//			//		"insert into hero values(null,'��Ī',313.0f,50)";--�����������
//			//		"insert into hero values(null,"+'��Ī'+","+313.0f+","+50+")";����
////					"insert into hero values(null,'��Ī',313.0,50)";
//					//����С����......
////			System.out.println(sql);
////			s.execute(sql);
////			s.close();
////			c.close();
////			
////			for(int i=0;i<100;++i) {
////				int temp=1+i;
////				int tempNumber=i+1;
////				String sql1="insert into hero values("+temp+","
////			+"'Ӣ��"+tempNumber+"',"+Math.random()*100+","+Math.random()*50+100+")";
////				s.execute(sql1);
////				System.out.println("�ɹ�����sql:"+sql1);
////			}
////			
////			for(int i=100;i<300;++i) {
////				String sql1="delete from hero where id="+i;
////				System.out.println("�ɹ�ɾ��:"+sql1);
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
//				System.out.printf("��ѯ���ˣ�������Ϊ��%nid:%d\tname:%s\thp:%f\tdamage:%d%n",id,name,hp,damage);
//			}
//			String name="dashen";String password="thisispassword";
//			String sql2="select * from user where name='"+name+"'and password='"+password+"';";
//			ResultSet rs2=s.executeQuery(sql2);
//			if(rs2.next()) {
//				System.out.println("�˺�������ȷ��");
//			}
//			else {
//				System.out.println("�˺��������");
//			}
//			String sql3="select count(*) from hero";
//			ResultSet rs3=s.executeQuery(sql3);
//			if(rs3.next()) {
//				System.out.println("�ܹ��� "+rs3.getInt(1)+" ������");
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
////		String sql="insert into hero values(?,'ţţ',?,?)";
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
//				//�����еĲ��Ժܺ�˵����
//				//PreparedStatement��sqlע��ʽ�����İ�ȫ����
//				//�ǰѲ�������һ������
//				//������ֱ��ԭ�ⲻ������Statement���������д��ȥִ�У�
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
//		System.out.println("ʹ��Ԥ����Statement����ʱ��Ϊ��"+(t2-t1));
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
//		System.out.println("ʹ��Statement����ʱ��Ϊ��"+(t3-t2));
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
			ps.setString(1, "Ŷţ");
			ps.execute();
			ResultSet rs=ps.getGeneratedKeys();
			//ע�����������Ҫ�� rs.next()
			//����ͬ������iterator�У�ʹ��if(it.next())һ��
			//�����ж��Ƿ���������������ֹ�Ƿ�����
			//��ξ���rs����һ������ʽ�ߵ���һ�����Է��ʵ�Ԫ�أ�
			//һ��ʼ������ָ��һ���Ķ��������ڿ��ܳ��ֵ�һ�����Է��ʵ�Ԫ��
			//��ǰһ��λ�ã�
			if(rs.next()) {
				int i=rs.getInt(1);
		//		System.out.println(rs);
				while(true) {
					--i;
					if(i==0)break;
					String sqltemp="select * from hero where id="+i;
					boolean flag=ps.execute(sqltemp);
					//���Խ�PrepareStatement����Statement����
					//����λ�÷���һ��String sql��ִ�У�
					//�Ͳ��������ٴ���һ��Statement��
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
				System.out.printf("��ѯ���ˣ�������Ϊ��%nid:%d\tname:%s\thp:%f\tdamage:%d%n",id,name,hp,damage);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
