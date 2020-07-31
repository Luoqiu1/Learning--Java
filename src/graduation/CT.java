package graduation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CT implements ValueAvailable<CT>{
	private static final String tableName="CT";
	String id;
	String cname;
	String ctype;
	String tno;
	int climit;
	String ctno;
	public CT() {
		
	}
	public CT(String id,String cname,String ctype,String tno,int climit,String ctno) {
		this.id=id;this.cname=cname;this.ctype=ctype;
		this.tno=tno;this.climit=climit;this.ctno=ctno;
	}
	@Override
	public String getAddValues() {
		// TODO Auto-generated method stub
		String sql;
		sql="insert into "+tableName+" values("
				+id+",'"+cname+"','"+ctype+"',"+tno+","+climit
				+","+ctno+")";
		return sql;
	}

	@Override
	public String setUpdateValues(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="update "+tableName+" set id="
				+id+",cname='"+cname+"',ctype='"+ctype+"',tno="+tno+",climit="+climit
				+",ctno="+ctno+" where id="+keys[0]+" and tno="+keys[1];
		return sql;
	}

	@Override
	public String delete(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from "+tableName+" where id="+keys[0]+" and tno="+keys[1];
		return sql;
	}

	@Override
	public String get(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="select * from "+tableName+" where id="+keys[0]+" and tno="+keys[1];
		return sql;
	}

	@Override
	public CT query(ResultSet rs) {
		// TODO Auto-generated method stub
		CT t=null;
		try {
			if(rs.next()) {
				t=new CT(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<CT> queryList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<CT> list=new ArrayList<>();
		try {
			while(rs.next()) {
				list.add(new CT(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getString(6)));
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
		return "该条数据为 表"+tableName+" 中的数据："+"id="
				+id+",cname="+cname+",ctype="+ctype+",tno="+tno+",climit="+climit
				+",ctno="+ctno;
	}
}
