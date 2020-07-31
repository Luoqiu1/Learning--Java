package graduation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class StudentTableModelEnd extends AbstractTableModel {
	String[] columnNames = new String[] { "姓名","学号","课题编号" };
	List<CS> listCS;
	DAO<CS> CS;
	List<Student> listS;
	DAO<Student> S;
	Student s;
	public StudentTableModelEnd(DAO<CS> CS,DAO<Student> S,Student s) {
		this.CS=CS;
		listCS=CS.list();
		this.S=S;
		listS=S.list();
		this.s=s;
	}
	@Override
	
	public int getRowCount() {
        // TODO Auto-generated method stub
		
//		int count=0;
//		for(CS cs:listCS)if(cs.sno.equals(s.sno))++count;
//        return count;
		return listCS.size();
    }
 
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }
 
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    // 先通过heros.get(rowIndex)获取行对应的Hero对象
    // 然后根据columnIndex返回对应的属性
    public Object getValueAt(int rowIndex, int columnIndex) {
        CS cs = listCS.get(rowIndex);
        if(!cs.sno.equals(s.sno))return null;
        if (1 == columnIndex)
            return s.sno;
        if (0 == columnIndex)
            return s.sn;
        if (2 == columnIndex)
            return cs.id;
        return null;
    }
}
