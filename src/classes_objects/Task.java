package classes_objects;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class Task extends JFrame{
	
	private String[] students = {"1001	����	�ƿ�1806	18",
			"1002	����	�ƿ�1806	18",
			"1003	����	�ƿ�1806	18",
			"1004	����	�ƿ�1806	18",};
	private String info = "ѧ��	����	�༶	����";
	private JPanel infoShow;
	JTextField m = new JTextField(info,30);
	private ArrayList<JTextField> datas = new ArrayList<JTextField>();
	
	public Task() {
		Container container = getContentPane();
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu fileMenu = new JMenu("ѡ��");
		JMenuItem delete = new JMenuItem("ɾ��");
		JMenuItem add = new JMenuItem("����");
		JMenuItem search = new JMenuItem("��ѯ");
		Listener listener = new Listener();
		delete.addActionListener(listener);
		add.addActionListener(listener);
		search.addActionListener(listener);
		fileMenu.add(delete);
		fileMenu.add(add);
		fileMenu.add(search);
		bar.add(fileMenu);
		infoShow = new JPanel();
		infoShow.add(m);
		for(int i = 0; i < students.length; i++) {
			datas.add(new JTextField(students[i],30));
			infoShow.add(datas.get(i));
		}
		container.add(infoShow);
		setSize(500,500);
		setVisible(true);
	}
	
	void delete() {
		String string = JOptionPane.showInputDialog("������Ҫɾ��ѧ��������:");
		for (JTextField jTextField : datas) {
			try {
				String text = jTextField.getText(0, 4);
				if(text.equals(string)) {
					datas.remove(jTextField);
					infoShow.remove(jTextField);
					infoShow.updateUI();
					break;
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	void add() {
		String string = JOptionPane.showInputDialog("������Ҫ����ѧ������Ϣ:");
		String[] lines = string.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < lines.length; i++) {
			if(i==lines.length-1) {
				sb.append(lines[i]);
				break;
			}
			sb.append(lines[i]+"\t");
		}
		JTextField j = new JTextField(sb.toString(),30);
		datas.add(j);
		infoShow.add(j);
		infoShow.updateUI();
	}
	
	void search() {
		String string = JOptionPane.showInputDialog("������Ҫ����ѧ����ѧ��:");
		for (JTextField jTextField : datas) {
			try {
				String text = jTextField.getText(0, 4);
				if(text.equals(string)) {
					JOptionPane.showMessageDialog(null, jTextField.getText(), "ѧ����Ϣ����:", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("ɾ��")) {
				delete();
			}else if(e.getActionCommand().equals("����")) {
				add();
			}else if(e.getActionCommand().equals("��ѯ")) {
				search();
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new Task().setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}