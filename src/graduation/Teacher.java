package graduation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teacher implements ValueAvailable<Teacher>{
	private static final String tableName="T";
	String tno;
	String tn;
	String tsex;
	String ttitle;
	String ttel;
	String tpwd;
	public Teacher() {
		
	}
	public Teacher(String tno,String tpwd) {
		this.tno=tno;this.tpwd=tpwd;
		this.tn="null";this.tsex="null";this.ttitle="null";
		this.ttel="null";
	}
	public Teacher(String tno,String tn,String tsex,String 
			ttitle,String ttel,String tpwd) {
		this.tno=tno;this.tpwd=tpwd;
		this.tn=tn==null?"null":tn;
		this.tsex=tsex==null?"null":tsex;
		this.ttitle=ttitle==null?"null":ttitle;
		this.ttel=ttel==null?"null":ttel;
	}
	public String getPwd() {
		return tpwd;
	}
	@Override
	public String getAddValues() {
		// TODO Auto-generated method stub
		String sql;
		if(tn=="null") {
			sql="insert into "+tableName+" values("
				+tno+",null,null,null,null,"+tpwd+")";
		}
		else {
			sql="insert into "+tableName+" values("
					+tno+",'"+tn+"','"+tsex+"','"+ttitle
					+"',"+ttel+","+tpwd+")";
		}
		return sql;
	}

	@Override
	public String setUpdateValues(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="update "+tableName+" set tno="
				+tno+",tn='"+tn+"',tsex='"+tsex+"',ttitle='"+ttitle
				+"',ttel="+ttel+",tpwd="+tpwd+" where tno="+keys[0];
		return sql;
	}

	@Override
	public String delete(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from "+tableName+" where tno="+keys[0];
		return sql;
	}

	@Override
	public String get(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="select * from "+tableName+" where tno="+keys[0]+"";
		return sql;
	}

	@Override
	public Teacher query(ResultSet rs) {
		// TODO Auto-generated method stub
		Teacher t=null;
		try {
			if(rs.next()) {
				t=new Teacher(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<Teacher> queryList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<Teacher> list=new ArrayList<>();
		try {
			while(rs.next()) {
				list.add(new Teacher(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getList(int start, int count) {
		// TODO Auto-generated method stub
		String sql;
		sql="select * from "+tableName+" limit "+start+","+count;
		return sql;
	}
	public String toString() {
		return "该条数据为 表"+tableName+" 中的数据："+"tno="
				+tno+",tn="+tn+",tsex="+tsex+",ttitle="+ttitle
				+",ttel="+ttel+",tpwd="+tpwd;
	}
}
