package classes_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectionPool {
	List<Connection> cp=new ArrayList<>();
	public ConnectionPool(int n) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8";
		for (int i = 0; i < n; i++) {
			try {
				//不能自动关闭！
				//所以不能放在try后面的括号里使用
				Connection c=DriverManager.getConnection(sql,"root","admin");
				cp.add(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized Connection getConnection() {
		while(cp.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Connection c=cp.remove(0);
		return c;
	}
	public synchronized void returnConnection(Connection c) {
		cp.add(c);
		this.notify();
	}
}
