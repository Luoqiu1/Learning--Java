package school_works;

public class Bingren {
	private String name;
	private Class[] sel=new Class[5];
	public String selClass() {
		int k=0;
		for(int i=0;i<5;++i) {
			if(sel[i]!=null&&sel[i].yes==1) {
				k++;
				System.out.println("���� "+name+" ȥ�˵� "+i+" ����");
			}
		}
		return "���� "+name+" ���� "+k+" �����ҵ�ҽ������";
	}
	public void Sel(int i) {
		sel[i]=new Class();
		sel[i].yes=1;
	}
	public Bingren(String a) {
		name=a;
	}
	public static void main(String[] args) {
		Bingren a=new Bingren("���");
		a.Sel(3);
		a.Sel(1);
		System.out.println(a.selClass());
	}
}
