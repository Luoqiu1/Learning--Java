package graduation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TeacherTableModelEnd extends AbstractTableModel {
	String[] columnNames = new String[] { "姓名","学号","课题编号","专业","班级" };
	List<CS> listCS;
	DAO<CS> CS;
	List<CT> listCT;
	DAO<CT> CT;
	List<Student> listS;
	DAO<Student> S;
	Teacher t;
	public TeacherTableModelEnd(DAO<CT> CT,DAO<CS> CS,DAO<Student> S,Teacher t) {
		this.CS=CS;
		listCS=CS.list();
		this.CT=CT;
		listCT=CT.list();
		this.S=S;
		listS=S.list();
		this.t=t;
	}
	@Override
	
	public int getRowCount() {
        // TODO Auto-generated method stub
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
        CT ct = CT.get(cs.id,t.tno);
        Student s=S.get(cs.sno);
        if(ct==null||s==null||!cs.id.equals(ct.id)||!ct.tno.equals(t.tno))return null;
        if (1 == columnIndex)
            return s.sno;
        if (0 == columnIndex)
            return s.sn;
        if (2 == columnIndex)
            return cs.id;
        if (3 == columnIndex)
            return s.sdept;
        if (4 == columnIndex)
            return s.sclass;
        return null;
    }
}
