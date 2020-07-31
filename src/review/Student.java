package review;



public class Student {
	int sno;//学号
	String name;//姓名
	String sex;//性别
	String phone;//电话
	
	public Student(int sno,String name,String sex,String phone) {
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}
	
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

