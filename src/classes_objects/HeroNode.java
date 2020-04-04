package classes_objects;

import java.util.ArrayList;
import java.util.List;

public class HeroNode extends Hero{
	public HeroNode leftNode;
	public HeroNode rightNode;
	public Hero value;
	public HeroNode() {
	}
	public HeroNode(String s,int a) {
		hp=a;name=s;
	}
	public void add(Hero v) {
		if(value==null) {//这只是个标志，如果写name==null一样对！
						//上面这一行理解不充分！要有关键字的概念。。。
						//这里同样在说下面
	//	if(name==null) {
			value=v;
	//		hp=h.hp;name=h.name;
		}
		else {
			
			if((float)v.hp-(float)value.hp>=0) {
				if(leftNode==null) {
					leftNode=new HeroNode();
					//这里也可以是直接构造new Node(v);
					//但这样一来要再一次递归下去查找创建的情况
					//就得放在else里了
					// if(leftNode==null) leftNode=new Node(v);
					// else leftNode.add(v)
					//两种方法均可。
				}
				
					leftNode.add(v);
				
			}
			else {
				if(rightNode==null) {
					rightNode=new HeroNode();
				}
				
					rightNode.add(v);
				
			}
		}
	}
	public void midGo(HeroNode t) {//递归中序遍历 面向过程的思维习惯
							   //在过程中直接输出
		if(t.leftNode!=null)midGo(t.leftNode);
		System.out.println(t.value);
		if(t.rightNode!=null)midGo(t.rightNode);
		//在访问一个有参方法的时候，记得一定要先检查这个实参是否存在！
		//因为在调用方法的时候会调用构造，构造一个新的实例！
		//倘若这个实参本身就不存在，构造就会失败，抛出异常！
	}
	public List<Hero> dataMidGo(){//返回列表的递归中序遍历
									//面向对象的思维习惯，在递归结束时输出对象
		List<Hero> values=new ArrayList<>();
		if(leftNode!=null)values.addAll(leftNode.dataMidGo());
		values.add(value);
		if(rightNode!=null)values.addAll(rightNode.dataMidGo());
	//	System.out.println(values);
		return values;
	}
	public static void main(String[] args) {
		HeroNode hn=new HeroNode();
		for (int i = 0; i < 10; i++) {
			int p=(int)(Math.random()*1000);
			Hero h=new Hero("Hero "+i,p);
	//		System.out.println(h.name+" "+h.hp);
			hn.add(h);
		}
//		System.out.println(hn.name+" "+hn.leftNode.name);
		hn.midGo(hn);System.out.println();
		List<Hero> ans=new ArrayList<>();
		ans=hn.dataMidGo();
		System.out.println(ans);
		
	}
}
