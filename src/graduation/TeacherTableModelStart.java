package graduation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TeacherTableModelStart extends AbstractTableModel{
	String[] columnNames = new String[] { "课题编号", "课题名称", "课题类型", "发布教师","指导教师","限选人数" };
	List<CT> listCT;
	DAO<CT> CT;
	List<Teacher> listT;
	DAO<Teacher> T;
	Teacher t;
	public TeacherTableModelStart(DAO<CT> CT,DAO<Teacher> T,Teacher t) {
		this.CT=CT;
		listCT=CT.list();
		this.T=T;
		listT=T.list();
		this.t=t;
	}
	@Override
	
	public int getRowCount() {
        // TODO Auto-generated method stub
        return listCT.size();
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
        return true;
    }
 
    // 先通过heros.get(rowIndex)获取行对应的Hero对象
    // 然后根据columnIndex返回对应的属性
    public Object getValueAt(int rowIndex, int columnIndex) {
        CT ct = listCT.get(rowIndex);
        if(!ct.tno.equals(t.tno))return null;
        if (0 == columnIndex)
            return ct.id;
        if (1 == columnIndex)
            return ct.cname;
        if (2 == columnIndex)
            return ct.ctype;
        if (3 == columnIndex)
        	for(Teacher t:listT)if(t.tno.equals(ct.tno))
        		return t.tn;  
        if (4 == columnIndex)
        	for(Teacher t:listT)if(t.tno.equals(ct.ctno))
        		return t.tn;
        if (5 == columnIndex)
            return ct.climit;
        return null;
    }

}
