package classes_objects;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import classes_objects.MyStringBuffer.IndexIsNagetiveException;
import classes_objects.MyStringBuffer.IndexIsoutofRangeException;

public class MyStringBuffer implements IStringBuffer {
//	private String s;
	private int length=0;
	private int capacity=16;
	private char value[];
	public MyStringBuffer() {
//		s="";
		value=new char[capacity];
	}
	public MyStringBuffer(String s) {
//		this.s=s;
		if(s.length()>capacity) {
			capacity=(int)((capacity+s.length())*1.5);
		}
		value=new char[capacity];
		System.arraycopy(s.toCharArray(), 0, value, 0, s.length());
		length=s.length();
	}
	public void value() {
	//	System.out.println(String.valueOf(value));
		
		for(int i=0;i<length;++i)System.out.print(value[i]);
		System.out.println();
	}
	public void append(String str)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException {
		insert(length,str);
	}
	public void append(char c)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException {
		append(String.valueOf(c));
	}
	public void insert(int pos,char b)throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException {
		insert(pos,String.valueOf(b));
	}
	public void insert(int pos,String b) throws IndexIsNagetiveException
	,IndexIsoutofRangeException,NullPointerException{
		if(pos<0||pos>length||null==b)return;
		if(b.length()+length>capacity) {
			capacity=(int)((b.length()+length)*1.5);
			char str[]=new char[capacity];
			str=Arrays.copyOf(value, length);
			value=str;
		}		
		System.arraycopy(value,pos,value,pos+b.length(),length-pos);
		System.arraycopy(b.toCharArray(), 0, value, pos, b.length());
		length+=b.length();
	}
	public void delete(int start) throws IndexIsNagetiveException, IndexIsoutofRangeException {
		delete(start,length);
	}
	public void delete(int start,int end) throws IndexIsNagetiveException
	,IndexIsoutofRangeException{
		if(start<0||start>=length||end<0||end>length||start>=end)return;
		System.arraycopy(value, end, value, start, length-end);
		length-=end-start;
	}
	public void reverse() {
		for(int i=0;i<length/2;++i) {
			char c=value[i];
			value[i]=value[length-i-1];
			value[length-i-1]=c;
		}
	}
	public int length() {
		return length;
	}
	class IndexIsNagetiveException extends Exception{
		public IndexIsNagetiveException(){
			
		}
		public IndexIsNagetiveException(String msg) {
			super(msg);
		}
	}
	class IndexIsoutofRangeException extends Exception{
		public IndexIsoutofRangeException(){
			
		}
		public IndexIsoutofRangeException(String msg) {
			super(msg);
		}
	}
}