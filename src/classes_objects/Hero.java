package classes_objects;
//import text1.Ttt1;
public class Hero implements Mortal{
	String name; //����
    float hp; //Ѫ��     
    float armor; //����
    int moveSpeed; //�ƶ��ٶ�     
    static String copyright="��Ȩ��ȭͷ��˾����";
    public Hero() {
    }
    public Hero(String a) {
    	name=a;
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
    
    public static void main(String[] args) {
//        //����һ������
//        new Hero();        
//        //ʹ��һ��������ָ���������
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
        
        Hero h5=new Hero("ţţ",555,30,300);
        System.out.println(h5.copyright);
        System.out.println(h4.copyright);
        h5.copyright="��������";
        System.out.println(h4.copyright);
        System.out.println(h5.copyright);
    }  
}
