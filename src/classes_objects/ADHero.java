package classes_objects;

public class ADHero extends Hero {
	public void attack() {
		this.physicAttack();
	}
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
  
}