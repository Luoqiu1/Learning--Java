package classes_objects;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
//import text1.Ttt1;
public class Hero extends Thread implements Mortal,Serializable,LOL,Runnable{
	private static final long serialVersionUID=1l;
	String name; //����
    float hp; //Ѫ��     
    float armor; //����
    int moveSpeed; //�ƶ��ٶ�     
    int damage;
    int cnt;
    static String copyright="��Ȩ��ȭͷ��˾����";
    public synchronized void hurt() {
    	hp-=1;
//    	if(hp<=1)try {
    	while(hp<=50)try {
    		//�ظ��鿴
    		//��Ϊ���̱߳����Ѻ�����Ǽ�Ѫ�߳̾ͻ���ɸ������
    		this.wait();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	this.notify();
    	System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
    }
    public synchronized void recover() {
    	
//    	if(hp==1000) {
//    		try {
//				this.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	}
    	hp+=1;
		System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
    	this.notify();
    }
    public void run() {
    	cnt=1;
    	while(true) {
    		try {
    		if(skill())Thread.sleep(1000);
    		else Thread.sleep(5000);
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
//    		System.out.println(cnt);
//    		if(cnt==15)break;
    	}
    }
    public boolean skill() {
    	boolean flag=true;
    	int k=cnt%4;
    	if(k==0) {
    		System.out.println("��ʼΪʱ5��ĳ���");
    		flag=false;
    	}
    	else System.out.printf("����ȭ��%d��%n",k);
    	++cnt;
    	return flag;
    }
    public void attackHero(Hero h) {
        //����ͣʱ��ȥ���������̸߳��Իᾡ��ȥռ��CPU��Դ
        //�̵߳����ȼ�Ч���ſ��Կ��ó���
//        try {
//           
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        h.hp-=damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
          
        if(h.isDead())
            System.out.println(h.name +"���ˣ�");
    }
  
    public boolean isDead() {
        return 0>=hp?true:false;
    }
    public int compareHero(Hero h) {
    	return (int)(hp-h.hp);
    }
    public void win() {
    	System.out.println("Hero win");
    }
    public Hero() {
//    	System.out.println("Hero���췽��");
    }
    
    public Hero(String a) {
    	name=a;
   // 	System.out.println("Hero���췽��");
    }
    public String toString() {
    	return String.format("[name %s,hp %s,damage %s]", name,hp,damage);
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
    public Hero(String name,float hp,int damage) {
    	this.name=name;
    	this.hp=hp;
    	this.damage=damage;
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
