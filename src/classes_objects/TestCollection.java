package classes_objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

public class TestCollection {
	public static int n=20;
	public static int m=3000000;
	public static void main(String[] args) {
//		List<Integer> list=new ArrayList<>();
//		for(int i=0;i<n;++i) {
//			list.add((int)(Math.random()*40000));
//		}
//		List<Integer> listCopy=new ArrayList<>(list);
////		System.out.println(list);
////		System.out.println(listCopy);
//		List<Integer> listCopy2=new ArrayList<>(list);
//		System.out.println(listCopy);
//		System.out.println(listCopy2);
//		System.out.println(list);	
//		listCopy2=binarySort(listCopy2);
//	//	binarySort(listCopy2);
//		bubbleSort(list);
////		System.out.println(list);
////		System.out.println(listCopy);
//		selectionSort(listCopy);
////		System.out.println(list);
//		System.out.println("比较选择法跟冒泡法数组是否相同："+list.equals(listCopy));
//		System.out.println("比较选择法跟二叉树数组是否相同："+listCopy.equals(listCopy2));
//		System.out.println("选择法："+listCopy);
//		System.out.println("二叉树法："+listCopy2);
//		System.out.println("冒泡法："+list);	
		
		List<Hero> lst=new ArrayList<>();
		for(int i=0;i<m;++i) {
		//	lst.add(new Hero("Hero-"+(int)(Math.random())*9000+1000));
			//草啊。。仔细一点。如果不稳的话就分设多个变量来
			//括号太多容易看不清
			//上面注释这里，其实就是恒等于1000了...
			//(int)(Math.random())*9000这里恒等于0！。。
			lst.add(new Hero("Hero-"+(int)(Math.random()*9000+1000)));
		}
		HashMap<String,List<Hero>> hashmap=new HashMap<>();
//		List<Hero> hee=hashmap.get("ss");
//		if(hee==null)System.out.println("yesss");
		for(Hero h:lst) {
			List<Hero> hs=hashmap.get(h.name);
			if(hs==null) {
				hs=new ArrayList<>();
				hashmap.put(h.name,hs);
			}
			hs.add(h);
		}
		List<Hero> h1=//hashmap.get("Hero-5555");
		searchHashMap(hashmap,"Hero-5555");
		List<Hero> h2=
		searchNotHashMap(lst,"Hero-5555");
		System.out.println("大小："+h1.size());
		System.out.println("大小："+h2.size());
		System.out.println("两操作得到结果是否相同："+(h2.equals(h1)));
	//	System.out.println(h1);System.out.println(h2);
		
	}
	public static List<Hero> searchHashMap(HashMap<String,List<Hero>> hm,String name) {
		List<Hero> hs;
		long ss1=System.currentTimeMillis();
		hs=hm.get(name);
		long ss2=System.currentTimeMillis();
		System.out.printf("哈希表花费：%dss%n",ss2-ss1);
		return hs;
	}
	public static List<Hero> searchNotHashMap(List<Hero> list,String name) {
		List<Hero> hs=new ArrayList<>();
		long ss1=System.currentTimeMillis();
		for(Hero h:list) {
		//	if(h.name=="Hero-5555")hs.add(h);
			//怎么又是这个经典错误......==与equals！
			if(h.name.equals(name))hs.add(h);
		}
		long ss2=System.currentTimeMillis();
		System.out.printf("迭代花费：%dss%n",ss2-ss1);
		return hs;
	}
	public static void searchNotHasMap(List<Integer> list) {
		
	}
	public static void bubbleSort(List<Integer> list) {
	//	List<int> list=new ArrayList<>();
		//泛型只能代表引用类型，8种基本类型保存的是实际值，不能使用！
		
//		for(int x:list)System.out.println(x);
		long ss1=System.currentTimeMillis();
		for(int i=0;i<n-1;++i) {
		//	for(int j=i;j<n-1-i;++j)
			//冒泡还没有深刻理解吗。。？
			//冒泡，形象地形容这个排序方法的词
			//就像泡泡一样，一个个浮上去
			//最大（最小）的先在最后
			//其他都是从最低（即从0）开始！
			
			//选择法才是j=i开始！
			for(int j=0;j<n-1-i;++j) {
				if(list.get(j)>list.get(j+1)) {
					int mid=list.get(j);
					list.set(j, list.get(j+1));
				//	list.set(list.get(j+1), mid);
					//我在想什么啊。。。。。
					//第一个参数是坐标。。！怎么搞到值去了
					list.set(j+1, mid);
					
				}
			}
		}
		long ss2=System.currentTimeMillis();
		System.out.println(ss2-ss1);
//		System.out.println();
	//	for(int x:list)System.out.println(x);
	}
	public static void selectionSort(List<Integer> list) {
		long ss1=System.currentTimeMillis();
		for(int i=0;i<n-1;++i) {
		//	for(int j=i;j<n-1;++j) {
			//选择法是，选择i为某一次要确定的元素位置！
			//不同于冒泡法！冒泡法的i是确定总共的循环次数！
			//全部交给j来处理大小比较！
			//而选择法是i,j一起来处理大小比较！
			//选定一个位置i，对所有的在i后面的j找到满足条件的位置交换！
//				if(list.get(j)>list.get(j+1)) {
//					int mid=list.get(j);
//					list.set(j, list.get(j+1));
//					list.set(j+1, mid);
//				}
			for(int j=i+1;j<n;++j) {
				if(list.get(i)>list.get(j)) {
					int mid=list.get(j);
					list.set(j, list.get(i));
					list.set(i, mid);
				}
			}
		}
		long ss2=System.currentTimeMillis();
		System.out.println(ss2-ss1);
	}
	public static List<Integer> binarySort(List<Integer> list) {
		long ss1=System.currentTimeMillis();
		Node tree=new Node();
		for(int x:list)tree.add(x);
		list=tree.dataMidGo();
		System.out.println();
		System.out.println(tree.dataMidGo());
		System.out.println(list);
		System.out.println();
		long ss2=System.currentTimeMillis();
		System.out.println(ss2-ss1);
		return list;
	}
}
