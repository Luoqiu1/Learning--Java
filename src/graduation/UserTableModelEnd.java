package graduation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModelEnd extends AbstractTableModel {
	String[] columnNames = new String[] { "������", "��������","�������" };
	List<CU> listCU;
	DAO<CU> CU;
	List<CT> listCT;
	DAO<CT> CT;
	User u;
	public UserTableModelEnd(DAO<CU> CU,DAO<CT> CT,User u) {
		this.CU=CU;
		listCU=CU.list();
		this.CT=CT;
		listCT=CT.list();
		this.u=u;
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
 
    // ��ͨ��heros.get(rowIndex)��ȡ�ж�Ӧ��Hero����
    // Ȼ�����columnIndex���ض�Ӧ������
    public Object getValueAt(int rowIndex, int columnIndex) {
        CT ct = listCT.get(rowIndex);
        CU cu = CU.get(ct.id,u.adm);
        if(cu==null)return null;
        if (0 == columnIndex)
            return ct.id;
        if (1 == columnIndex)
            return ct.cname;
        if (2 == columnIndex)
        		return cu.idea;
        return null;
    }
}
