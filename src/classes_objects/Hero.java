package classes_objects;
//import text1.Ttt1;
public class Hero implements Mortal{
	String name; //姓名
    float hp; //血量     
    float armor; //护甲
    int moveSpeed; //移动速度     
    static String copyright="版权由拳头公司所有";
    public Hero() {
//    	System.out.println("Hero构造方法");
    }
    public Hero(String a) {
    	name=a;
   // 	System.out.println("Hero构造方法");
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
    	Hero garen=new Hero("盖伦");
    	Hero Teemo=new Hero("提莫");
    	Teemo.hp=0;
    	try {
    		garen.attack(Teemo);
    	}
    	catch(EnemyHeroIsDeadException e) {
    		e.printStackTrace();
    		String str=e.getMessage();
    		System.out.println(str);
//    		System.out.println("异常的具体原因："+e.getMessage());
//    		e.printStackTrace();
    	}
    }  
}
