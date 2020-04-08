package classes_objects;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
//import text1.Ttt1;
public class Hero implements Mortal,Serializable,LOL{
	private static final long serialVersionUID=1l;
	String name; //����
    float hp; //Ѫ��     
    float armor; //����
    int moveSpeed; //�ƶ��ٶ�     
    static String copyright="��Ȩ��ȭͷ��˾����";
    public Hero() {
//    	System.out.println("Hero���췽��");
    }
    public Hero(String a) {
    	name=a;
   // 	System.out.println("Hero���췽��");
    }
    public String toString() {
    	return String.format("%s %s", name,hp);
    }
    public static void battleWin(){
        System.out.println("hero battle win");
    }
     
    private void Print() {
    	System.out.println("����һ��ʵ��");
    }
    public void die() {
    	System.out.println("������������");
    }
    public void killHero(Hero x) {
    	System.out.print(name+" ɱ���� "+
    			x.name+",");
    	x.die();
    }
//    private static Hero instance=new Hero();
//    public static Hero getInstance() {
//    	return instance;
//    }
    public Hero(String name,float hp) {
    	this.name=name;
    	this.hp=hp;
    }
    public Hero(String name,float hp,float ac) {
    	this.name=name;
    	this.hp=hp;
    	this.armor=ac;
    }
    public Hero(String name,float hp,float armor,int moveSpeed) {
    	this(name,hp);
    	this.armor=armor;
    	this.moveSpeed=moveSpeed;
    }
    public void finalize() {
    	System.out.println("��������ڱ�����Ŷ");
    }
    public void attack(Hero h) throws EnemyHeroIsDeadException {
    	if(h.hp==0) {
    		throw new EnemyHeroIsDeadException(h.name+"�Ѿ����ˣ�����Ҫ�ͷż���");
    	}
    	else {
    		System.out.println(h.name+" �ܵ��� "+name+" �Ĺ���");
    	}
    }
    class EnemyHeroIsDeadException extends Exception {
    	public EnemyHeroIsDeadException() {
    	}
    	public EnemyHeroIsDeadException(String msg) {
    		super(msg);
    	}
    }
	
	    public static void main(String[] args) {
	    	Hero h[]=new Hero[10];
	    	for (int i = 0; i < h.length; i++) {
				h[i]=new Hero();
				h[i].name="Hero "+i;
			}
	    	File f=new File("c:/Data/heros");
	    	try(FileOutputStream fos=new FileOutputStream(f);
	    			ObjectOutputStream oos=new ObjectOutputStream(fos);
	    			FileInputStream fis=new FileInputStream(f);
	    			ObjectInputStream ois=new ObjectInputStream(fis);){
//	    		for (int i = 0; i < h.length; i++) {
//					oos.writeObject(h[i]);
//				}
	    		oos.writeObject(h);
	    		oos.flush();
//	    		Hero h2[]=new Hero[h.length];
	    		Hero h2[]=(Hero[])ois.readObject();
//	    		for (int i = 0; i < h2.length; i++) {
//					Hero h0=new Hero();
//					h2=(Hero[])ois.readObject();
//					h2[i]=h0;
//				}
	    		boolean flag=true;
	    		for (int i = 0; i < h2.length; i++) {
	    			System.out.println(h[i].name);
					if(!h[i].name.equals(h2[i].name)) {
						flag=false;break;
					}
				}
	    		if(flag) {
	    			System.out.println("�ɹ���");
	    		}
	    	}
	    	catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	catch(ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    }
}
