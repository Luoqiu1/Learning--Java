package classes_objects;

public class HelloWorld {
	public static void main(String[] args) {
//		HeroType h=HeroType.FARMING;
//		switch(h) {
////		case 8:  //�������У�java��ͬ��c��c��enum���Ӧ����������ֵ���Ի�����
//		case FARMING:
//			System.out.println("��Ұ");
//		}
		Hero garen=new Hero("����");
		ADHero vn=new ADHero("ޱ��");
		APHero bn=new APHero("����");
		ADAPHero akl=new ADAPHero("������");
		garen.killHero(vn);
		garen.killHero(bn);
		garen.killHero(akl);
	}
}
