package classes_objects;
public class Support extends Hero {
	 public void heal() {
		 System.out.println(name+" 进行了一次治疗，但是对象忘记惹");
	 }
	 public void heal(Hero h1) {
		 System.out.println(name+" 为 "+h1.name+" 进行了一次治疗，但是治疗量忘记惹");
	 }
	 public void heal(Hero h1,int hp) {
		 System.out.println(name+" 为 "+h1.name+" 进行了一次治疗量为 "+hp+" 的治疗");
		 h1.hp+=hp;
	 }
	 
	 public void swap1(int a,int b) {
		 int mid=a;a=b;b=mid;
	 }
	 
	 public static void main(String[] args) {
		 Support h=new Support();
		 Hero t=new Hero();
		 h.name="星妈";
		 t.name="大树";t.hp=300;
		 System.out.println("现在"+t.name+"的血量为"+t.hp);
		 h.heal(t,66);
		 System.out.println("现在"+t.name+"的血量为"+t.hp);
		 Hero t2=new Hero();
		 t2.name="战士";
		 h.heal();
		 h.heal(t2);
		 
		 System.out.println();
		 
		 int a=3;int b=4;
		 System.out.println(a+" "+b);
		 h.swap1(a,b);
		 System.out.println(a+" "+b);
		 
	 }
    
}