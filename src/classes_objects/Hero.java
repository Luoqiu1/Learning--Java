package classes_objects;
//import text1.Ttt1;
public class Hero implements Mortal{
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
    	Hero garen=new Hero("����");
    	Hero Teemo=new Hero("��Ī");
    	Teemo.hp=0;
    	try {
    		garen.attack(Teemo);
    	}
    	catch(EnemyHeroIsDeadException e) {
    		e.printStackTrace();
    		String str=e.getMessage();
    		System.out.println(str);
//    		System.out.println("�쳣�ľ���ԭ��"+e.getMessage());
//    		e.printStackTrace();
    	}
    }  
}
