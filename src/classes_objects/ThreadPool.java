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
			//�����synchronizedû��Ҫ��
			//׷�������new֮���start����ȥ̽��
			//�����synchronized��tasks�Ļ�
			//��ʹȫ�����̶߳��������������̵߳�synchronized����
			//����һ������add����pool��notify֮��
			//ȫ�����߳�һ����뿪ʼ������һ������
			//֮��ֻ��һ���߳̾������������߳�ȫ��wait
			
			//����ȥ���������synchronized
			// ��ôÿnewһ�����������߳�ʱ����Ϊtasks��δ��ռ��
			//����߳̿��Խ���ռ����뵽run�У�Ȼ��wait�ȴ���
			//��ȫ���߳��������ʱ�����Ѿ�ȫ������wait״̬�ˣ�
			//�Ա���synchronized���������һ���ֵ������ٶȣ�
			
				new TaskConsumeThread("TaskConsumewThread��"+i).start();
				System.out.println("TaskConsumewThread��"+i+" ��������");
				
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
					//����û��Ҫ�ٻ��������߳�
					//���һ�����������ӵĵط����Ѽ��ɣ�
					//���������
				}
				System.out.println("�����ѱ� "+this.getName()+" �ӵ����д���");
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
        System.out.println("������Ͼ����ˣ�"+(s2-s1)+"ss");
	}
//	public static void search(File file, String search,ThreadPoolExecutor threadPool) {
	public static void search(File file, String search,ThreadPool threadPool) {
		if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                //���ҵ�.java�ļ���ʱ�򣬾�����һ���̣߳�����ר�ŵĲ���
                Runnable r=new Runnable() {
                	public void run() {
                		String fileContent = readFileConent(file);
                        if(fileContent.contains(search)){
                            System.out.printf("�ҵ���Ŀ���ַ���%s,���ļ�:%s%n",search,file);
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
