package school_works;

public class Student {
	public Class[] sel=new Class[5];
	private int id,classid,age;
	private String name,sex;
	private static int count=0;
	public Student() {
		count++;
	}
	public String selClass() {
		int k=0;
		for(int i=0;i<5;++i) {
			if(sel[i]!=null&&sel[i].yes==1)k++;
		}
		return name+" 选了 "+k+" 门课";
	}
	public void Sel(int i) {
		sel[i]=new Class();
		sel[i].yes=1;
	}
	public Student(int a,int b,int c
			,String d,String e) {
		id=a;classid=b;age=c;
		name=d;sex=e;
		count++;
	}
	public int getId() {
		return id;
	}
	public int getClassid() {
		return classid;
	}
	public int getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getName() {
		return name;
	}
	public void changeId(int a) {
		id=a;
	}
	public void changeClassid(int a) {
		classid=a;
	}
	public void changeAge(int a) {
		age=a;
	}
	public void changeName(String a) {
		name=a;
	}
	public void changeSex(String a) {
		sex=a;
	}
	public String toString() {
		return "学号："+String.valueOf(id)+" 班号："+String.valueOf(classid)+" 姓名："+name+
				" 性别："+sex+" 年龄："+String.valueOf(age);
	}
	public int people() {
		return count;
	}
	public static void main(String[] args) {
		Student s1=new Student(13,1,20,"张三","男");
//		Student s2=new Student(6,3,19,"佳爱琉","女");
//		System.out.println(s1.toString());System.out.println(s2.toString());
//		s1.changeName("张四");s2.changeName("京津冀");
//		System.out.println(s1.getName());System.out.println(s2.getName());
//		if(s1.getAge()>s2.getAge())System.out.println(s1.toString());
//		else System.out.println(s2.toString());
		s1.Sel(3);s1.Sel(1);
		System.out.println(s1.selClass());
	}
}
