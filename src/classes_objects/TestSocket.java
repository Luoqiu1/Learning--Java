package classes_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSocket {
	public static void main(String[] args) throws IOException {
		String ip=InetAddress.getLocalHost().getHostAddress();
//		System.out.println(ip);
		int start=ip.lastIndexOf(".");
		int end=ip.length();
		StringBuffer sb=new StringBuffer(ip);
		sb.delete(start, end);
//		System.out.println(sb);
		List<String> ips=new ArrayList<String>();
		AtomicInteger number = new AtomicInteger();
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(255, 270, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
		
		for (int i = 1; i < 256; i++) {
			String currentHost=new String(sb+"."+i);
			System.out.println(currentHost);
			threadPool.execute(new Runnable() {
				public void run() {
//					System.out.println(currentHost);
					Process p;
					try {
						p = Runtime.getRuntime().exec("ping " + currentHost);
						InputStreamReader isr=new InputStreamReader(p.getInputStream());
						BufferedReader br=new BufferedReader(isr);
						String line;
						StringBuffer currentString = new StringBuffer("");
						try {
							while((line=br.readLine())!=null) {
								currentString.append(line);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						System.out.println(currentString);
						
//						除了无法访问之外，还有其他的导致ip地址无法连接的错误
//						例如请求超时
//						int flag=currentString.indexOf("无法访问");
//						if(flag==-1) {
//							ips.add(new String(currentString));
//						}
						int flag=currentString.indexOf("TTL");
						if(flag!=-1) {
							ips.add(currentHost);
						}
						
						System.out.println("已完成："+number.incrementAndGet()+" 个ip测试");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		}
		threadPool.shutdown();
		try {
			if(threadPool.awaitTermination(1, TimeUnit.HOURS)) {
				System.out.println("如下ip地址可以连接");
				for(String s:ips)System.out.println(s);
				System.out.println("总共有："+ips.size()+"个地址");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
