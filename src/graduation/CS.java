package graduation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CS implements ValueAvailable<CS>{
	private static final String tableName="CS";
	String id;
	String sno;
	public CS() {
		
	}
	public CS(String id,String sno) {
		this.id=id;this.sno=sno;
	}
	@Override
	public String getAddValues() {
		// TODO Auto-generated method stub
		String sql;
			sql="insert into "+tableName+" values("
				+id+","+sno+")";
		return sql;
	}

	@Override
	public String setUpdateValues(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="update "+tableName+" set id="
				+id+",sno="+sno+" where id="+keys[0]+" and sno="+keys[1];
		return sql;
	}

	@Override
	public String delete(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from "+tableName+" where id="+keys[0]+" and sno="+keys[1];
		return sql;
	}

	@Override
	public String get(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="select * from "+tableName+" where id="+keys[0]+" and sno="+keys[1];
		return sql;
	}

	@Override
	public CS query(ResultSet rs) {
		// TODO Auto-generated method stub
		CS t=null;
		try {
			if(rs.next()) {
				t=new CS(rs.getString(1),rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<CS> queryList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<CS> list=new ArrayList<>();
		try {
			while(rs.next()) {
				list.add(new CS(rs.getString(1),rs.getString(2)));
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
				+id+",sno="+sno;
	}
}
