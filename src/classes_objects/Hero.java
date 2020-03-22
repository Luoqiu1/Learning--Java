package classes_objects;
//import text1.Ttt1;
public class Hero implements Mortal{
	String name; //姓名
    float hp; //血量     
    float armor; //护甲
    int moveSpeed; //移动速度     
    static String copyright="版权由拳头公司所有";
    public Hero() {
    }
    public Hero(String a) {
    	name=a;
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
    
    public static void main(String[] args) {
//        //创建一个对象
//        new Hero();        
//        //使用一个引用来指向这个对象
        Hero h = new Hero();     
        Hero h4=new Hero();
//        h.hp=3.333f;
//        Hero h2=h;
//        Hero h3=h2;
//        System.out.println(h3.hp);
//        h3.hp=2.222f;
//        System.out.println(h2.hp);
//        System.out.println(h3.hp);
//        System.out.println(h.hp);
        
        Hero h5=new Hero("牛牛",555,30,300);
        System.out.println(h5.copyright);
        System.out.println(h4.copyright);
        h5.copyright="哈哈哈哈";
        System.out.println(h4.copyright);
        System.out.println(h5.copyright);
    }  
}
