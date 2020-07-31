package graduation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student implements ValueAvailable<Student>{
	private static final String tableName="S";
	String sno;
	String sn;
	String ssex;
	String sdept;
	String sclass;
	String stel;
	String spwd;
	public Student() {
		
	}
	public Student(String sno,String spwd) {
		this.sno=sno;this.spwd=spwd;
		this.sn="null";this.ssex="null";this.sdept="null";
		this.sclass="null";this.stel="null";
	}
	public Student(String sno,String sn,String ssex,String 
			sdept,String sclass,String stel,String spwd) {
		this.sno=sno;this.spwd=spwd;
		this.sn=sn==null?"null":sn;
		;this.ssex=ssex==null?"null":ssex;
		this.sdept=sdept==null?"null":sdept;
		this.sclass=sclass==null?"null":sclass;
		this.stel=stel==null?"null":stel;
	}
	public String getPwd() {
		return spwd;
	}
	@Override
	public String getAddValues() {
		// TODO Auto-generated method stub
		String sql;
		if(sn=="null") {
			sql="insert into "+tableName+" values("
				+sno+",null,null,null,null,null,"+spwd+")";
//			System.out.println(sql);
		}
		else {
			
			sql="insert into "+tableName+" values("
					+sno+",'"+sn+"','"+ssex+"','"+sdept+"',"+sclass
					+","+stel+","+spwd+")";
//			System.out.println(sql);
		}
		return sql;
	}

	@Override
	public String setUpdateValues(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="update "+tableName+" set sno="
				+sno+",sn='"+sn+"',ssex='"+ssex+"',sdept='"+sdept+"',sclass="+sclass
				+",stel="+stel+",spwd="+spwd+" where sno="+keys[0];
		return sql;
	}

	@Override
	public String delete(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from "+tableName+" where sno="+keys[0];
		return sql;
	}

	@Override
	public String get(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="select * from "+tableName+" where sno="+keys[0]+"";
		return sql;
	}

	@Override
	public Student query(ResultSet rs) {
		// TODO Auto-generated method stub
		Student t=null;
		try {
			if(rs.next()) {
				t=new Student(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<Student> queryList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<>();
		try {
			while(rs.next()) {
				list.add(new Student(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7)));
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
		return "该条数据为 表"+tableName+" 中的数据："+"sno="
				+sno+",sn="+sn+",ssex="+ssex+",sdept="+sdept+",sclass="+sclass
				+",stel="+stel+",spwd="+spwd;
	}
}
