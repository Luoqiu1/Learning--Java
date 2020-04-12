package classes_objects;

import java.util.ArrayList;

public class ThreadPool {
	ArrayList<Runnable> tasks = new ArrayList<>();
	int threadSize;

	public ThreadPool(int size) {
		this.threadSize = size;
		for (int i = 0; i < threadSize; i++) {
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
				}
				System.out.println("�����ѱ� "+this.getName()+" �ӵ����д���");
				task.run();
			}
		}
	}
	public static void main(String[] args) {
		ThreadPool threadPool=new ThreadPool(5);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int gap=1000;
		while(true) {
			threadPool.add(new Runnable() {
				public void run() {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			try {
				Thread.sleep(gap);
				gap=gap>100?gap-100:100;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
