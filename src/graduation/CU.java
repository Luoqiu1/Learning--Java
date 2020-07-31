package graduation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CU implements ValueAvailable<CU>{
	private static final String tableName="CU";
	String id;
	String adm;
	String idea;
	public CU() {
		
	}
	public CU(String id,String adm,String idea) {
		this.id=id;this.adm=adm;this.idea=idea;
	}
	@Override
	public String getAddValues() {
		// TODO Auto-generated method stub
		String sql;
		sql="insert into "+tableName+" values("
				+id+","+adm+",'"+idea+"')";
		return sql;
	}

	@Override
	public String setUpdateValues(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="update "+tableName+" set id="
				+id+",adm="+adm+",idea='"+idea+"'"+" where id="+keys[0]+" and adm="+keys[1];
		return sql;
	}

	@Override
	public String delete(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from "+tableName+" where id="+keys[0]+" and adm="+keys[1];
		return sql;
	}

	@Override
	public String get(String... keys) {
		// TODO Auto-generated method stub
		String sql;
		sql="select * from "+tableName+" where id="+keys[0]+" and adm="+keys[1];
		return sql;
	}

	@Override
	public CU query(ResultSet rs) {
		// TODO Auto-generated method stub
		CU t=null;
		try {
			if(rs.next()) {
				t=new CU(rs.getString(1),rs.getString(2),
						rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<CU> queryList(ResultSet rs) {
		// TODO Auto-generated method stub
		List<CU> list=new ArrayList<>();
		try {
			while(rs.next()) {
				list.add(new CU(rs.getString(1),rs.getString(2),
						rs.getString(3)));
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
				+id+",adm="+adm+",idea="+idea;
	}
}
