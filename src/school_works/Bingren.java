package school_works;

public class Bingren {
	private String name;
	private Class[] sel=new Class[5];
	public String selClass() {
		int k=0;
		for(int i=0;i<5;++i) {
			if(sel[i]!=null&&sel[i].yes==1) {
				k++;
				System.out.println("病人 "+name+" 去了第 "+i+" 科室");
			}
		}
		return "病人 "+name+" 找了 "+k+" 个科室的医生看病";
	}
	public void Sel(int i) {
		sel[i]=new Class();
		sel[i].yes=1;
	}
	public Bingren(String a) {
		name=a;
	}
	public static void main(String[] args) {
		Bingren a=new Bingren("李二");
		a.Sel(3);
		a.Sel(1);
		System.out.println(a.selClass());
	}
}
