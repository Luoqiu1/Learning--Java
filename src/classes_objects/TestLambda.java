package classes_objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
 
public class TestLambda {
    public static void main(String[] args) {
    	Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(1000)));
        }
        heros.stream().forEach(h->System.out.println(h));
//        Object hs[]=heros.stream().filter(h->h.hp<100&&h.damage>100).toArray();
        String h3=heros.stream()
        		.sorted((h1,h2)->h1.hp>h2.hp?-1:1)
        		.skip(2)
        		.map(h->h.name)
        		.findFirst()
        		.get();
        System.out.println("hp第三高的Hero:");
        System.out.println(h3);
        Collections.sort(heros,(h1,h2)->h1.hp>h2.hp?-1:1);
        System.out.println(heros.get(2).name);
    }
       
    public static boolean testHero(Hero h) {
        return h.hp>100 && h.damage<50;
    }
       
    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }
   
}