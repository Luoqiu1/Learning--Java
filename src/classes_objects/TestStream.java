package classes_objects;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestStream {
	public static void encodeFile(File encodingFile, File encodedFile) {
		int n=(int)encodingFile.length();
		char str[]=new char[n];
		try(FileReader fr=new FileReader(encodingFile)){
			fr.read(str);
			for(int i=0;i<n;++i) {
				if(Character.isDigit(str[i])) {
					if(str[i]!=9) {
						++str[i];
					}
					else str[i]=0;
				}
				else if(Character.isLetter(str[i])) {
					if(str[i]=='z'||str[i]=='Z') {
						str[i]-='z'-'a';
					}
					else ++str[i];
				}
				else continue;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		try(FileWriter fw=new FileWriter(encodedFile)){
			fw.write(str);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void decodeFile(File decodingFile, File decodedFile) {
		int n=(int)decodingFile.length();
		char str[]=new char[n];
		try(FileReader fr=new FileReader(decodingFile)){
			fr.read(str);
			for(int i=0;i<n;++i) {
				if(Character.isDigit(str[i])) {
					if(str[i]!=0) {
						--str[i];
					}
					else str[i]=9;
				}
				else if(Character.isLetter(str[i])) {
					if(str[i]=='a'||str[i]=='A') {
						str[i]+='z'-'a';
					}
					else --str[i];
				}
				else continue;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		try(FileWriter fw=new FileWriter(decodedFile)){
			fw.write(str);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		StringBuffer s=new StringBuffer();
		int n=(int)(Math.random()*100);
		for(int i=0;i<n;++i) {
			char c=(char)((int)(Math.random()*(126-33)+33));
			s.append(c);
		}
		String s2=new String(s);
		char str[]=s2.toCharArray();
		File encodingFile=new File("c:/Data/encodingFile.txt");
		if(!encodingFile.getParentFile().exists()) {
			encodingFile.getParentFile().mkdirs();
		}
		try(FileWriter fr=new FileWriter(encodingFile)){
			fr.write(str);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		File encodedFile=new File("c:"+encodingFile.separator+"Data"+encodingFile.separator+"encodedFile.txt");
		encodeFile(encodingFile,encodedFile);
		File decodedFile=new File("c:"+encodingFile.separator+"Data"+encodingFile.separator+"dcodedFile.txt");
		decodeFile(encodedFile,decodedFile);
	}
}
