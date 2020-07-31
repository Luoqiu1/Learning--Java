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
	
	private String[] students = {"1001	张三	计科1806	18",
			"1002	李四	计科1806	18",
			"1003	王五	计科1806	18",
			"1004	赵六	计科1806	18",};
	private String info = "学号	姓名	班级	年龄";
	private JPanel infoShow;
	JTextField m = new JTextField(info,30);
	private ArrayList<JTextField> datas = new ArrayList<JTextField>();
	
	public Task() {
		Container container = getContentPane();
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu fileMenu = new JMenu("选项");
		JMenuItem delete = new JMenuItem("删除");
		JMenuItem add = new JMenuItem("增添");
		JMenuItem search = new JMenuItem("查询");
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
		String string = JOptionPane.showInputDialog("请输入要删除学生的姓名:");
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
		String string = JOptionPane.showInputDialog("请输入要增加学生的信息:");
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
		String string = JOptionPane.showInputDialog("请输入要查找学生的学号:");
		for (JTextField jTextField : datas) {
			try {
				String text = jTextField.getText(0, 4);
				if(text.equals(string)) {
					JOptionPane.showMessageDialog(null, jTextField.getText(), "学生信息如下:", JOptionPane.INFORMATION_MESSAGE);
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
			if(e.getActionCommand().equals("删除")) {
				delete();
			}else if(e.getActionCommand().equals("增添")) {
				add();
			}else if(e.getActionCommand().equals("查询")) {
				search();
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new Task().setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}