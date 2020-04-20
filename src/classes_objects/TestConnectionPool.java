package classes_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionPool {
	public static void main(String[] args) {
		Thread t1=new Thread() {//��ͳ��ʽ100���߳�ÿ���������µ�����
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
									System.out.println("һ������ͨ����ͳ��ʽ������");
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
				System.out.println("ʹ��100���߳̾������������ݿ�Ĵ�ͳ��ʽ");
				System.out.println("����100����������Ҫ��ʱ��Ϊ:"+(t2-t1));
			}
		};
		Thread t2=new Thread() {//ʹ�����ݿ����ӳش���100������
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
				System.out.println("ʹ��100���߳�ͨ�����ݿ����ӳؽ������ӵķ�ʽ");
				System.out.println("����100����������Ҫ��ʱ��Ϊ:"+(t2-t1));
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
			System.out.println("һ������ͨ�����ݿ����ӳط�ʽ������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cp.returnConnection(c);
	}
}