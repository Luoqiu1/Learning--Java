package classes_objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

public class TestCollection {
	public static int n=20;
	public static int m=3000000;
	public static void main(String[] args) {
		String ss[]=new String[100];
		 // 初始化
        for (int i = 0; i < ss.length; i++) {
            ss[i] = randomString(2);
        }
        // 打印
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i] + " ");
            if (19 == i % 20)
                System.out.println();
        }
        HashSet<String> hashSet=new HashSet<>();
        for(String s1:ss) {
        	int cnt=0;
        	for(String s2:ss) {
        		if(s1.equals(s2)) {
        			++cnt;
        			if(cnt==2)break;
        		}
        	}
        	if(cnt==2)hashSet.add(s1);
        }
        
//        for (String s1 : ss) {
//            int repeat = 0;
//            for (String s2 : ss) {
//                if (s1.equalsIgnoreCase(s2)) {
//                    repeat++;
//                    if (2 == repeat) {
//                        // 当repeat==2的时候，就找打了一个非己的重复字符串
// 
//                        putIntoDuplicatedArray(s1);
//                        break;
//                    }
//                }
//            }
//        }
// 
//        System.out.printf("总共有 %d种重复的字符串%n", pos);
//        if (pos != 0) {
//            System.out.println("分别是：");
//            for (int i = 0; i < pos; i++) {
//                System.out.print(foundDuplicated[i] + " ");
//            }
//        }
//    }
// 
//    static String[] foundDuplicated = new String[100];
//    static int pos;
// 
//    private static void putIntoDuplicatedArray(String s) {
//        for (int i = 0; i < pos; i++){
//            if (foundDuplicated[i].equalsIgnoreCase(s))
//                return;
//        }
// 
//        foundDuplicated[pos++] = s;
//    }
        
        //上面注释的是用数组的做法来的！
        //与使用HashSet来比较
        //数组要额外考虑是否重复输出！
        //而HashSet不用！因为当键字相同的时候
        //HashSet会自动覆盖掉！自动解决了重复的问题！
        
        if(hashSet.size()!=0) {
        	System.out.println("重复的有：");
        	for(String s:hashSet)System.out.println(s);
        }
        else System.out.println("没有重复的");
       
	}
	private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
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
