package classes_objects;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
	public static int cnt=0;
	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8888);
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			Scanner sc=new Scanner(System.in);
			while(true) {
				String putInfo;
				String getInfo;
				putInfo=sc.nextLine();
				dos.writeUTF(putInfo);
				getInfo=dis.readUTF();
//				if(getInfo!=null)
					System.out.println("客户端收到消息："+getInfo);
				System.out.println("第 "+(++cnt)+" 次消息传输");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
