package review.src;
public class Student {
	int sno;//ѧ��
	String name;//����
	String sex;//�Ա�
	String phone;//�绰
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
