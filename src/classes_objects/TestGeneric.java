package classes_objects;
import java.util.ArrayList;

public class TestGeneric {
	 
    public static void iterate(ArrayList<? extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }
 
 
    public static void iterateAD(ArrayList<ADHero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }
 
    public static void main(String[] args) {
        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<ADHero> adh=new ArrayList<>();
        hs.add(new ADHero());
        hs=adh;
        adh=hs;
        //�������о�����ת��
        //�����෺�Ͳ���ת���ɸ��෺��
        //���෺��Ҳ����ת�������෺��
    }
 
}
