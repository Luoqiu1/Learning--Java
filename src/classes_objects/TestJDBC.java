package classes_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC{
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
				"how2java?characterEncoding=UTF-8","root","admin");
				Statement s=c.createStatement()){
			
			
//			Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
//			"how2java?characterEncoding=UTF-8","root","admin");
//			Statement s=c.createStatement();
	//		System.out.println("��ȡStatement����+"+s);
//			String sql = 
//					"insert into hero values(null,"+"'��Ī'"+","+313.0f+","+50+")";
			//		"insert into hero values(null,'��Ī',313.0f,50)";--�����������
			//		"insert into hero values(null,"+'��Ī'+","+313.0f+","+50+")";����
//					"insert into hero values(null,'��Ī',313.0,50)";
					//����С����......
//			System.out.println(sql);
//			s.execute(sql);
//			s.close();
//			c.close();
			
			for(int i=0;i<100;++i) {
				int temp=100+i;
				int tempNumber=i+1;
				String sql1="insert into hero values("+temp+","
			+"'Ӣ��"+tempNumber+"',"+Math.random()*100+","+Math.random()*50+100+")";
				s.execute(sql1);
				System.out.println("�ɹ�����sql:"+sql1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(e instanceof SQLException)
			e.printStackTrace();
		}
	}
}
