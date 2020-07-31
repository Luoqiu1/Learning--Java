package classes_objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Server {
	public static int cnt=0;
	public static List<String> ans=new ArrayList<>();
	static {
		ans.add("啊这");
		ans.add("不错");
		ans.add("听8懂");
	}
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(8888);
			Connection c=initDataBase();
			Socket s=ss.accept();
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			Scanner sc=new Scanner(System.in);
			while(true) {
				String putInfo=null;
				String getInfo=null;
				getInfo=dis.readUTF();
//				if(getInfo!=null)
					System.out.println("服务端收到消息："+getInfo);
				try {
					String sql="select response from dictionary where receive="
							+"'"+getInfo+"'";
					Statement st=c.createStatement();
					st.execute(sql);
					ResultSet rs=st.getResultSet();
					if(rs.next()) {
						putInfo=rs.getString(1);
					}
					else {
						Collections.shuffle(ans);
						putInfo=ans.get(0);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//				putInfo=sc.nextLine();
				dos.writeUTF(putInfo);
				System.out.println("第 "+(++cnt)+" 次消息传输");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection initDataBase() {
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			c=DriverManager.getConnection
			("jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8"
					, "root","admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
