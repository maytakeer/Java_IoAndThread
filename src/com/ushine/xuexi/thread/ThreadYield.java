package com.ushine.xuexi.thread;

public class ThreadYield {
	
	public static void main(String[] args) {
		ThreadYield1 yt1 = new ThreadYield1("张三");
		ThreadYield1 yt2 = new ThreadYield1("李四");
		yt1.start();
		yt2.start();
	}
}

class ThreadYield1 extends Thread{
	public ThreadYield1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 50; i++) {
			System.out.println(" "+ this.getName() + "-----------" + i);
			// 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
			if (i == 30) {
				this.yield();
			}
		}
	}
}