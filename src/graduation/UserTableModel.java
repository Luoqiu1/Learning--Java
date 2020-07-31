package graduation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel{
	List<CT> listCT;
	DAO<CT> CTDAO;
	List<User> listUser;
	DAO<User> UserDAO;
	public UserTableModel(DAO<User> UserDAO,DAO<CT> CTDAO) {
		this.UserDAO=UserDAO;
		this.CTDAO=CTDAO;
		listUser=UserDAO.list();
		listCT=CTDAO.list();
	}
	@Override
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
