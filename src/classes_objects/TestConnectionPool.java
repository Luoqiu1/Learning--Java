package classes_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionPool {
	public static void main(String[] args) {
		Thread t1=new Thread() {//传统方式100个线程每个都创建新的连接
			public void run() {
				long t1=System.currentTimeMillis();
				for(int i=0;i<100;++i) {
					Thread t=new Thread() {
						public void run() {
							try {
								Class.forName("com.mysql.jdbc.Driver");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String sql="jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8";
							try {
								Connection c=DriverManager.getConnection(sql,"root","admin");
								try {
									Statement s=c.createStatement();
									String sql2="insert into item values(null,'normal',66)";
									s.execute(sql2);
									System.out.println("一条数据通过传统方式被插入");
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					};
					t.start();
					try {
						t.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				long t2=System.currentTimeMillis();
				System.out.println("使用100个线程均重新连接数据库的传统方式");
				System.out.println("插入100条数据所需要的时间为:"+(t2-t1));
			}
		};
		Thread t2=new Thread() {//使用数据库连接池创建100个对象
			public void run() {
				long t1=System.currentTimeMillis();
				ConnectionPool cp=new ConnectionPool(10);
				for (int i = 0; i < 100; i++) {
					Thread t=new WorkingThread(cp);
					t.start();
					try {
						t.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				long t2=System.currentTimeMillis();
				System.out.println("使用100个线程通过数据库连接池进行连接的方式");
				System.out.println("插入100条数据所需要的时间为:"+(t2-t1));
			}
		};
		t1.start();
		t2.start();
	}
}
class WorkingThread extends Thread{
	ConnectionPool cp;
	public WorkingThread(ConnectionPool cp) {
		this.cp=cp;
	}
	public void run() {
		Connection c=cp.getConnection();
		try {
			Statement s=c.createStatement();
			String sql="insert into item values(null,'Unnormal',66)";
			s.execute(sql);
			System.out.println("一条数据通过数据库连接池方式被插入");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cp.returnConnection(c);
	}
}