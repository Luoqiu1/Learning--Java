package graduation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModelStart extends AbstractTableModel{
	String[] columnNames = new String[] { "������", "��������", "��������", "������ʦ","ָ����ʦ","��ѡ����" };
	List<CT> listCT;
	DAO<CT> CT;
	List<CU> listCU;
	DAO<CU> CU;
	DAO<Teacher> T;
	User u;
	public UserTableModelStart(DAO<CT> CT,DAO<CU> CU,DAO<Teacher> T,User u) {
		this.CT=CT;
		listCT=CT.list();
		this.CU=CU;
		listCU=CU.list();
		this.T=T;
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
        if(cu!=null)return null;
        if (0 == columnIndex)
            return ct.id;
        if (1 == columnIndex)
            return ct.cname;
        if (2 == columnIndex)
            return ct.ctype;
        if (3 == columnIndex)
        {
        	Teacher t=T.get(ct.tno);
        	if(t==null)return null;
        	else return t.tn;
        }
        if (4 == columnIndex)
        {
        	Teacher t=T.get(ct.ctno);
        	if(t==null)return null;
        	else return t.tn;
        }
        if (5 == columnIndex)
            return ct.climit;
        return null;
    }

}
