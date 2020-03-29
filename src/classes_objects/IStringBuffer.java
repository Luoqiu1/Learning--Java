package classes_objects;

import classes_objects.MyStringBuffer.IndexIsoutofRangeException;
import classes_objects.MyStringBuffer.IndexIsNagetiveException;

public interface IStringBuffer {
	public void append(String str)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException; //追加字符串
    public void append(char c)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException;  //追加字符
    public void insert(int pos,char b)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException; //指定位置插入字符
    public void insert(int pos,String b)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException; //指定位置插入字符串
    public void delete(int start) throws IndexIsNagetiveException, IndexIsoutofRangeException; //从开始位置删除剩下的
    public void delete(int start,int end)throws IndexIsNagetiveException
	,IndexIsoutofRangeException; //从开始位置删除结束位置-1
    public void reverse(); //反转
    public int length(); //返回长度
}
