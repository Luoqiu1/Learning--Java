package classes_objects;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.sql.Time;
//import java.util.ThreadPoolExecutor;
//import java.util.Concurrent;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	ArrayList<Runnable> tasks = new ArrayList<>();
	int threadPoolSize;

	public ThreadPool(int size) {
		this.threadPoolSize = size;
		for (int i = 0; i < threadPoolSize; i++) {
//			synchronized(tasks) {
			//这里的synchronized没必要！
			//追踪下面的new之后的start方法去探究
			//如果是synchronized了tasks的话
			//会使全部的线程都等在任务消耗线程的synchronized外面
			//当有一个任务被add进入pool并notify之后
			//全部的线程一起进入开始竞争第一个任务
			//之后只有一个线程竞争到，其他线程全部wait
			
			//倘若去掉了这里的synchronized
			// 那么每new一个任务消耗线程时，因为tasks尚未被占据
			//这个线程可以将其占领进入到run中，然后wait等待！
			//等全部线程启动完毕时，就已经全部进入wait状态了！
			//对比有synchronized，可以提高一部分的运行速度！
			
				new TaskConsumeThread("TaskConsumewThread："+i).start();
				System.out.println("TaskConsumewThread："+i+" 已启动！");
				
//			}
		}
	}
	public void add(Runnable r) {
		synchronized(tasks) {
			tasks.add(r);
			tasks.notify();
		}
	}
	class TaskConsumeThread extends Thread {
		public TaskConsumeThread(String name) {
			super(name);
		}

		Runnable task;

		public void run() {
			while(true) {
				synchronized (tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task=tasks.remove(tasks.size()-1);
	//				tasks.notify();
					//这里没必要再唤醒其他线程
					//添加一个任务就在添加的地方唤醒即可！
					//这里多余了
				}
				System.out.println("任务已被 "+this.getName()+" 接到进行处理！");
				task.run();
			}
		}
	}
	public static void main(String[] args) {
//		ThreadPool threadPool=new ThreadPool(5);
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		int gap=1000;
//		while(true) {
//			threadPool.add(new Runnable() {
//				public void run() {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			});
//			try {
//				Thread.sleep(gap);
//				gap=gap>100?gap-100:100;
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
//		ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10,15,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
				ThreadPool threadPool=new ThreadPool(10);
		long s1=System.currentTimeMillis();
		File folder =new File("C:\\Users\\57195\\Desktop\\Learning--Java");
        search(folder,"Hero",threadPool);
        long s2=System.currentTimeMillis();
        System.out.println("查找完毕经过了："+(s2-s1)+"ss");
	}
//	public static void search(File file, String search,ThreadPoolExecutor threadPool) {
	public static void search(File file, String search,ThreadPool threadPool) {
		if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                //当找到.java文件的时候，就启动一个线程，进行专门的查找
                Runnable r=new Runnable() {
                	public void run() {
                		String fileContent = readFileConent(file);
                        if(fileContent.contains(search)){
                            System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
                        }
                	}
                };
            threadPool.add(r);
//            threadPool.execute(r);
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search, threadPool);
            }
        }
    }
    static public String readFileConent(File file){
            try (FileReader fr = new FileReader(file)) {
                char[] all = new char[(int) file.length()];
                fr.read(all);
                return new String(all);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } 
}
