package review;



public class Student {
	int sno;//ѧ��
	String name;//����
	String sex;//�Ա�
	String phone;//�绰
	
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

