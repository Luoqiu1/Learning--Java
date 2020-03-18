package classes_objects;

public class Hero {
	String name; //姓名
    float hp; //血量     
    float armor; //护甲
    int moveSpeed; //移动速度     
    public Hero() {
    }
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
//        h.hp=3.333f;
//        Hero h2=h;
//        Hero h3=h2;
//        System.out.println(h3.hp);
//        h3.hp=2.222f;
//        System.out.println(h2.hp);
//        System.out.println(h3.hp);
//        System.out.println(h.hp);
        
        Hero h5=new Hero("牛牛",555,30,300);
    }  
}
