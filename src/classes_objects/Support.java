package classes_objects;
public class Support extends Hero {
	 public void heal() {
		 System.out.println(name+" ������һ�����ƣ����Ƕ���������");
	 }
	 public void heal(Hero h1) {
		 System.out.println(name+" Ϊ "+h1.name+" ������һ�����ƣ�����������������");
	 }
	 public void heal(Hero h1,int hp) {
		 System.out.println(name+" Ϊ "+h1.name+" ������һ��������Ϊ "+hp+" ������");
		 h1.hp+=hp;
	 }
	 
	 public void swap1(int a,int b) {
		 int mid=a;a=b;b=mid;
	 }
	 
	 public static void main(String[] args) {
		 Support h=new Support();
		 Hero t=new Hero();
		 h.name="����";
		 t.name="����";t.hp=300;
		 System.out.println("����"+t.name+"��Ѫ��Ϊ"+t.hp);
		 h.heal(t,66);
		 System.out.println("����"+t.name+"��Ѫ��Ϊ"+t.hp);
		 Hero t2=new Hero();
		 t2.name="սʿ";
		 h.heal();
		 h.heal(t2);
		 
		 System.out.println();
		 
		 int a=3;int b=4;
		 System.out.println(a+" "+b);
		 h.swap1(a,b);
		 System.out.println(a+" "+b);
		 
	 }
    
}