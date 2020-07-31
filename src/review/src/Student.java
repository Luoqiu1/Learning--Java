package review.src;
public class Student {
	int sno;//学号
	String name;//姓名
	String sex;//性别
	String phone;//电话
	public Student(int sno) {
		this.sno=sno;
	}
	public Student(int sno,String name) {
		this(sno);
		this.name=name;
	}
	public Student(int sno,String name,String sex) {
		this(sno,name);
		this.sex=sex;
	}
	public Student(int sno,String name,String sex,String phone) {
		this(sno,name,sex);
		this.phone = phone;
	}
	
}
