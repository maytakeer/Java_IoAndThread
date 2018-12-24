package com.ushine.xuexi.thread;

class Thread2 extends Thread{
	
	private String name;
	
	public Thread2(String name){
		this.name = name;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name+ " 运行 ： "+i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束！");
	}
}

public class Thread1{
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " 主线程运行开始！");
		Thread2 mTh1 = new Thread2("A");
		Thread2 mTh2 = new Thread2("B");
//		Thread2 mTh2 = mTh1;
		mTh1.start();
		mTh2.start();
//		new Thread(new Thread2("D")).start();
		try {
			mTh1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			mTh2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 主线程运行结束！");
	}
}