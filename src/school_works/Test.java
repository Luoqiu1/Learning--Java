package school_works;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test {
	String[] words;
	String s;
	int i=0;
	public Test(String s)
	{
		this.s=new String(s);
		this.words=s.split("\\n|\\t|\\r| ");
	}
	public int counts()
	{
		return words.length;
	}
	public boolean hasMoreWords()
	{
		if(i<words.length)
			return true;
		else
			return false;
	}
	public String nextWord()
	{
		String cut=words[i];
		i=i+1;
		return cut;
	}
}
class StringTest extends JFrame
{
	private JLabel promeptLabel;
	private JTextField inputField;
	private JTextArea outputArea;
	public StringTest()
	{
		super("测试MyStringTokenizer类");
		Container container=getContentPane();
		container.setLayout(new FlowLayout());
		container.add(new JLabel("输入一个句子，然后回车"));
		inputField=new JTextField(20);
		inputField.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						MyStringTokenizer Sentences=new MyStringTokenizer(
							event.getActionCommand());
							outputArea.setText("Number of words:"+
							Sentences.counts()+"\nThe Tokenizing words:\n");
						while(Sentences.hasMoreWords())
							outputArea.append(Sentences.nextWord()+"\n");
				
					}
				}
		);
		container.add(inputField);
		outputArea=new JTextArea(10,20);
		outputArea.setEditable(false);
		
		container.add(new JScrollPane(outputArea));
		setSize(275,240);
		setVisible(true);
	}
	public static void main(String args[])
	{
		StringTest application=new StringTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}