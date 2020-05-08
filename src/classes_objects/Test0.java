package classes_objects;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Test0 extends JFrame{

	private int x=50,y=50;
	private int size = 20;
	private int dist = 10;
	private boolean flah = true;
	
	@Override
	public void paint(Graphics g) {
		
		for(int i = 1; i <=8; i++) {
			if(i%2==0) {
				y+=size+dist;
			}else {
				x+=size+dist;
			}
			g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
			g.drawOval(x, y, size, size);
		}
	}
	
	public Test0() {
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test0();
	}
}
