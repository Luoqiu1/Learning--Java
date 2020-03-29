package classes_objects;

import classes_objects.MyStringBuffer.IndexIsoutofRangeException;
import classes_objects.MyStringBuffer.IndexIsNagetiveException;

public interface IStringBuffer {
	public void append(String str)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException; //׷���ַ���
    public void append(char c)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException;  //׷���ַ�
    public void insert(int pos,char b)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException; //ָ��λ�ò����ַ�
    public void insert(int pos,String b)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException; //ָ��λ�ò����ַ���
    public void delete(int start) throws IndexIsNagetiveException, IndexIsoutofRangeException; //�ӿ�ʼλ��ɾ��ʣ�µ�
    public void delete(int start,int end)throws IndexIsNagetiveException
	,IndexIsoutofRangeException; //�ӿ�ʼλ��ɾ������λ��-1
    public void reverse(); //��ת
    public int length(); //���س���
}
