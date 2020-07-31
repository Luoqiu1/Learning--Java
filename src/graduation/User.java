package graduation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User implements ValueAvailable<User>{
	String adm;
	String pwd;
	private static final String tableName="U";
	public User() {
		
	}
	public User(String adm,String pwd) {
		this.adm=adm;
		this.pwd=pwd;
	}
//	public String getAdm() {
//		return adm;
//	}
	public String getPwd() {
		return pwd;
	}
//	public void setAdm(String adm) {
//		this.adm=adm;
//	}
//	public void setPwd(String pwd) {
//		this.pwd=pwd;
//	}
	public String getAddValues() {
		String sql;
		sql="insert into "+tableName+" values("
				+adm+","+pwd+")";
		return sql;
	}
	public String setUpdateValues(String...keys) {
		String sql;
		sql="update "+tableName+" set adm="
				+adm+", pwd="+pwd+
				" where adm="+keys[0];
		return sql;
	}
	public String delete(String...keys) {
		String sql;
		sql="delete from "+tableName+" where adm="+keys[0];
		return sql;
	}
	@Override
	public String get(String... keys) {
		String sql;
		//	仔细！！sql语句不要输入错了。。！
		sql="select * from "+tableName+" where adm="+keys[0]+"";
		return sql;
	}
	public String getList(int start,int count) {
		String sql;
		sql="select * from "+tableName+" limit "+start+","+count;
		return sql;
	}
	public User query(ResultSet rs) {
		User u=null;
		try {
			if(rs.next()) {
				String newAdm=rs.getString(1);
				String newPwd=rs.getString(2);
				u=new User(newAdm,newPwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public List<User> queryList(ResultSet rs) {
		List<User> list=new ArrayList<>();
		try {
			while(rs.next()) {
				String newAdm=rs.getString(1);
				String newPwd=rs.getString(2);
				list.add(new User(newAdm,newPwd));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String toString() {
		return "该条数据为 表"+tableName+" 中的数据："+"adm="+adm+",pwd="+pwd;
	}
}
