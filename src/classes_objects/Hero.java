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
	String name; //姓名
    float hp; //血量     
    float armor; //护甲
    int moveSpeed; //移动速度     
    int damage;
    int cnt;
    static String copyright="版权由拳头公司所有";
    public synchronized void hurt() {
    	hp-=1;
//    	if(hp<=1)try {
    	while(hp<=50)try {
    		//重复查看
    		//因为当线程被唤醒后如果是减血线程就会造成负数情况
    		this.wait();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	this.notify();
    	System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
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
		System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
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
    		System.out.println("开始为时5秒的充能");
    		flag=false;
    	}
    	else System.out.printf("波动拳第%d发%n",k);
    	++cnt;
    	return flag;
    }
    public void attackHero(Hero h) {
        //把暂停时间去掉，多条线程各自会尽力去占有CPU资源
        //线程的优先级效果才可以看得出来
//        try {
//           
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
          
        if(h.isDead())
            System.out.println(h.name +"死了！");
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
//    	System.out.println("Hero构造方法");
    }
    
    public Hero(String a) {
    	name=a;
   // 	System.out.println("Hero构造方法");
    }
    public String toString() {
    	return String.format("[name %s,hp %s,damage %s]", name,hp,damage);
    }
    public static void battleWin(){
        System.out.println("hero battle win");
    }
     
    private void Print() {
    	System.out.println("这是一个实验");
    }
    public void die() {
    	System.out.println("我死掉了呃呃");
    }
    public void killHero(Hero x) {
    	System.out.print(name+" 杀掉了 "+
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
    	System.out.println("这个东西在被回收哦");
    }
    public void attack(Hero h) throws EnemyHeroIsDeadException {
    	if(h.hp==0) {
    		throw new EnemyHeroIsDeadException(h.name+"已经挂了，不需要释放技能");
    	}
    	else {
    		System.out.println(h.name+" 受到了 "+name+" 的攻击");
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
	    			System.out.println("成功！");
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
