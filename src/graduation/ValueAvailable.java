package graduation;

import java.sql.ResultSet;
import java.util.List;

public interface ValueAvailable<T> {
	public String toString();
	public String getAddValues();
	public String setUpdateValues(String...keys);
	public String delete(String...keys);
	public String get(String...keys);
	public T query(ResultSet rs);
	public List<T> queryList(ResultSet rs);
	public String getList(int start,int count);
}
