package graduation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO<T extends ValueAvailable<T>> {
	private String className;
	public DAO(String className) {
		this.className=className;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		try {
			return DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/graduation?characterEncoding=UTF-8"
							, "root","admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Statement executeSql(String sql) throws SQLException{
		Connection c=getConnection();Statement s=null;
//		try{
			s=c.createStatement();
			s.execute(sql);
			return s;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return s;
	}
	public void close(Statement s) {
		try {
			s.getConnection().close();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add(T t) throws SQLException{
		String sql=t.getAddValues();
		Statement s=executeSql(sql);
		close(s);
	}
	public void update(T afterUpdate,String...keys) throws SQLException{
		String sql=afterUpdate.setUpdateValues(keys);
		Statement s=executeSql(sql);
		close(s);
	}
	public void delete(String ...keys) throws Exception{
//		try {
			Class cls=Class.forName(className);
			Constructor c=cls.getConstructor();
			T t=(T)c.newInstance();
			String sql=t.delete(keys);
			Statement s=executeSql(sql);
			close(s);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	public T get(String...keys) {
		try {
			Class cls=Class.forName(className);
			Constructor c=cls.getConstructor();
			T t=(T)c.newInstance();
			String sql=t.get(keys);
			Statement s=executeSql(sql);
			ResultSet rs=s.getResultSet();
			t=t.query(rs);
			close(s);
			return t;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<T> list(){
		return list(0,Short.MAX_VALUE);
	}
	public List<T> list(int start,int count){
		List<T> list=null;
		try {
			Class cls=Class.forName(className);
			Constructor c=cls.getConstructor();
			T t=(T)c.newInstance();
			String sql=t.getList(start,count);
			Statement s=executeSql(sql);
			ResultSet rs=s.getResultSet();
			list=t.queryList(rs);
			close(s);
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		/*
//			DAO<User> UserDAO=new DAO<>("graduation.User");
////			UserDAO.add(new User("1000","233333"));
////			UserDAO.update(new User("6666","666666"),"1000");
////			UserDAO.delete("1001");
////			UserDAO.delete("6666666");
////			System.out.println(UserDAO.get("1002"));
//			List<User>	list=UserDAO.list();
//			for(User u:list)System.out.println(u);
//			System.out.println();
//			UserDAO.add(new User("6666666","888888"));
//			list=UserDAO.list();
//			for(User u:list)System.out.println(u);
//			System.out.println();
			
//			DAO<Teacher> TeacherDAO=new DAO<>("graduation.Teacher");
////			TeacherDAO.add(new Teacher("180666","552123"));
////			List<Teacher> list=TeacherDAO.list();
////			for(Teacher t:list)System.out.println(t);
//			Teacher t=TeacherDAO.get("18051");
//			System.out.println(t);
//			TeacherDAO.update(new Teacher("1806123","456"), "1806");
			
//		DAO<Student> StudentDAO=new DAO<>("graduation.Student");
//		StudentDAO.add(new Student("1033180530","何纪芃","男","计科","1805","null","233333"));
//		List<Student> list=StudentDAO.list();
//		for(Student t:list)System.out.println(t);
//		System.out.println();
////		StudentDAO.add(new Student("1033180530","何纪芃","男","计科","1805","null","233333"));
//		StudentDAO.update(new Student("1033180530","何纪芃","男","计算机科学与技术","1805","null","233333"), "1033180530");
//		StudentDAO.delete("1033180530");
//		list=StudentDAO.list();
//		for(Student t:list)System.out.println(t);
////		Teacher t=TeacherDAO.get("18051");
////		System.out.println(t);
////		TeacherDAO.update(new Teacher("1806123","456"), "1806");
		
//		DAO<CS> CSDAO=new DAO<>("graduation.CS");
//		CS cs=CSDAO.get("1","1033180635");
//		System.out.println(cs);
////		CSDAO.add(new CS("1","1033180631"));
////		List<CS> list=CSDAO.list();
////		for(CS t:list)System.out.println(t);
////		System.out.println();
////		try {
////			Thread.sleep(5000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		CSDAO.delete("1","1033180631");
////		list=CSDAO.list();
////		for(CS t:list)System.out.println(t);
		
//		DAO<CT> CTDAO=new DAO<>("graduation.CT");
//		CT ct=CTDAO.get("1","18061");
//		System.out.println(ct);
////		CSDAO.add(new CS("1","1033180631"));
////		List<CS> list=CSDAO.list();
////		for(CS t:list)System.out.println(t);
////		System.out.println();
////		try {
////			Thread.sleep(5000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		CSDAO.delete("1","1033180631");
////		list=CSDAO.list();
////		for(CS t:list)System.out.println(t);
		
		DAO<CU> CUDAO=new DAO<>("graduation.CU");
		CU cu=CUDAO.get("1","1001");
		System.out.println(cu);
		List<CU> list=CUDAO.list();
		System.out.println();
		for(CU t:list)System.out.println(t);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAO<User> UserDAO=new DAO<>("graduation.User");
//		UserDAO.add(new User("1999","0"));
//		CU newCU=new CU("1","1001","中期合格");
//		CUDAO.update(newCU, "1","1999");
		UserDAO.delete("1999");
		list=CUDAO.list();
		for(CU t:list)System.out.println(t);
		
		*/
	}
}
