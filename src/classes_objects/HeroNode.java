package classes_objects;

import java.util.ArrayList;
import java.util.List;

public class HeroNode extends Hero{
	public HeroNode leftNode;
	public HeroNode rightNode;
	public Hero value;
	public HeroNode() {
	}
	public HeroNode(String s,int a) {
		hp=a;name=s;
	}
	public void add(Hero v) {
		if(value==null) {//��ֻ�Ǹ���־�����дname==nullһ���ԣ�
						//������һ����ⲻ��֣�Ҫ�йؼ��ֵĸ������
						//����ͬ����˵����
	//	if(name==null) {
			value=v;
	//		hp=h.hp;name=h.name;
		}
		else {
			
			if((float)v.hp-(float)value.hp>=0) {
				if(leftNode==null) {
					leftNode=new HeroNode();
					//����Ҳ������ֱ�ӹ���new Node(v);
					//������һ��Ҫ��һ�εݹ���ȥ���Ҵ��������
					//�͵÷���else����
					// if(leftNode==null) leftNode=new Node(v);
					// else leftNode.add(v)
					//���ַ������ɡ�
				}
				
					leftNode.add(v);
				
			}
			else {
				if(rightNode==null) {
					rightNode=new HeroNode();
				}
				
					rightNode.add(v);
				
			}
		}
	}
	public void midGo(HeroNode t) {//�ݹ�������� ������̵�˼άϰ��
							   //�ڹ�����ֱ�����
		if(t.leftNode!=null)midGo(t.leftNode);
		System.out.println(t.value);
		if(t.rightNode!=null)midGo(t.rightNode);
		//�ڷ���һ���вη�����ʱ�򣬼ǵ�һ��Ҫ�ȼ�����ʵ���Ƿ���ڣ�
		//��Ϊ�ڵ��÷�����ʱ�����ù��죬����һ���µ�ʵ����
		//�������ʵ�α���Ͳ����ڣ�����ͻ�ʧ�ܣ��׳��쳣��
	}
	public List<Hero> dataMidGo(){//�����б�ĵݹ��������
									//��������˼άϰ�ߣ��ڵݹ����ʱ�������
		List<Hero> values=new ArrayList<>();
		if(leftNode!=null)values.addAll(leftNode.dataMidGo());
		values.add(value);
		if(rightNode!=null)values.addAll(rightNode.dataMidGo());
	//	System.out.println(values);
		return values;
	}
	public static void main(String[] args) {
		HeroNode hn=new HeroNode();
		for (int i = 0; i < 10; i++) {
			int p=(int)(Math.random()*1000);
			Hero h=new Hero("Hero "+i,p);
	//		System.out.println(h.name+" "+h.hp);
			hn.add(h);
		}
//		System.out.println(hn.name+" "+hn.leftNode.name);
		hn.midGo(hn);System.out.println();
		List<Hero> ans=new ArrayList<>();
		ans=hn.dataMidGo();
		System.out.println(ans);
		
	}
}
