package review;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test5 {
    static int t1Cnt=0;
    static int t2Cnt=0;
    public static void main (String[] args){
 	   JLabel lf=new JLabel();
    	JFrame f=new JFrame("Test");
        // ���������ô�С
        f.setSize(400, 300);
 
        // ����������λ��
        f.setLocation(200, 200);
 
        // �������е��������Ϊ���Զ�λ
        f.setLayout(null);

        Thread t1=new Thread() {
	    	   public void run() {
	    		   try {
	    			while(true) {
	    				Thread.sleep(2000);
	    			}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	   }
        };
        Thread t2=new Thread() {
	    	   public void run() {
	    		   try {
	       			while(true) {
	    				Thread.sleep(5000);
	    				switch(t1Cnt%5) {
	    				case 0:
	    					lf.setBackground(Color.BLACK);break;
	    				}
	    				String time=Integer.toString(t2Cnt*5);
	    				lf.setText(time);
	    			}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	   }
	       };

       t1.start();t2.start();
    }
}
