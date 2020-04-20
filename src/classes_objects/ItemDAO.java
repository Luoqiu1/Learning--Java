package classes_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements DAO{

	public ItemDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Connection getConnection() {
		Connection c=null;
		String sql="jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8";
		try {
			c=DriverManager.getConnection(sql,"root","admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	//id name price
	public void add(Item it) {
		// TODO Auto-generated method stub
		String sql="insert into item values(null,?,?)";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql);) {
			ps.setString(1,it.name);
			ps.setInt(2, it.price);
			ps.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Item it) {
		// TODO Auto-generated method stub
		String sql="update item set name=?,price=? where id=?";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql);) {
			ps.setString(1,it.name);
			ps.setInt(2, it.price);
			ps.setInt(3, it.id);
			ps.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(Connection c=getConnection();Statement s=c.createStatement()) {
			String sql="delete from item where id="+id;
			s.execute(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Item get(int id) {
		// TODO Auto-generated method stub
		Item it=null;
		String sql="select name,price from item where id="+id;
		try(Connection c=getConnection();Statement s=c.createStatement();) {
			s.execute(sql);
			ResultSet rs=s.getResultSet();
			if(rs.next()) {
				it.price=rs.getInt(2);
				it.name=rs.getString(1);
				it.id=id;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return it;
	}

	public int getTotal() {
		String sql="select count(*) from item";
		int total = 0;
		try(Connection c=getConnection();Statement s=c.createStatement();) {
			ResultSet rs=s.executeQuery(sql);
			if(rs.next()) {
				total=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
	
	@Override
	public List<Item> list() {
		// TODO Auto-generated method stub
		return list(0,getTotal());
	}

	@Override
	public List<Item> list(int start, int count) {
		// TODO Auto-generated method stub
		List<Item> its=new ArrayList<>();
		String sql="select id,name,price from item order by id asc limit ?,?";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ps.execute();
			ResultSet rs=ps.getResultSet();
			while(rs.next()) {
				Item temp=new Item();
				temp.id=rs.getInt(1);
				temp.name=rs.getString(2);
				temp.price=rs.getInt(3);
				its.add(temp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return its;
	}
	public static void main(String[] args) {
		ItemDAO DAO1=new ItemDAO();
		for(int i=20;i<25;++i) {
			Item it=new Item();
			it.name="Item "+i;
			it.price=(int)(Math.random()*100);
			DAO1.add(it);
		}
		List<Item> its=DAO1.list();
		System.out.println("获取现在的表格：");
		for(Item it:its)System.out.println(it);
		DAO1.delete(6);
		DAO1.delete(3);
		its=DAO1.list(2,4);
		System.out.println("获取现在的表格：");
		for(Item it:its)System.out.println(it);
		System.out.println("现在表里有 "+DAO1.getTotal()+" 条数据");
	}
}
