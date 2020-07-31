package classes_objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestReflection {
	public static int cnt=0;
	public static void main(String[] args) {
        File f=new File("C:\\Users\\57195\\Desktop\\Learning--Java\\src\\classes_objects\\hero.config");
        try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String className=null;
			String methodName=null;
			List<Hero> heros=new ArrayList<>();
			while((className=br.readLine())!=null) {
				methodName=br.readLine();
				System.out.println(className);
				System.out.println(methodName);
				System.out.println();
				Class clz=Class.forName(className);
				Constructor c=clz.getConstructor();
				Hero h=(Hero)c.newInstance();
//				Method m=h.getClass().getMethod("setName",String.class);
//				m.invoke(h, "Hero "+cnt);
				Field heroField=clz.getField("name");
				heroField.set(h, "hero "+cnt);
				heros.add(h);
				++cnt;
			}
//			Hero h=heros.get(0);
//			Method m=h.getClass().getMethod("attackHero", Hero.class);
//			m.invoke(h, heros.get(1));
			Hero h=heros.get(0);
			Method m=h.getClass().getMethod("attack");
			m.invoke(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}
}
