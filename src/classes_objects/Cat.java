package classes_objects;

public class Cat extends Animal implements Pet{
	private String name;
	public Cat(String name) {
		//���û��������һ���Ǳ���ģ�
		//��Ϊ���๹�����У���Ĭ�ϵ��ø����
		//Ĭ�Ϲ���������super()��
		//����������й�������û�����������޲ι�����
		//������ʧ�ܣ�
		super(4);
		//
		this.name=name;
		
	}
	public Cat() {
		this("");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void play() {
		System.out.println(name+" ���ں�����Ŷ����");
	}
	public void eat() {
		System.out.println(name+" ���ڳԡ���");
	}
}
