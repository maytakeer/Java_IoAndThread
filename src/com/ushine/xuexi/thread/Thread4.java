package com.ushine.xuexi.thread;

public class Thread4 {
	public static void main(String[] args) {
		new Thread(new Thread3("C")).start();
		new Thread(new Thread3("D")).start();
	}
}

class Thread3 implements Runnable{
	
	private String name;
	
	public Thread3(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + " 运行 : " + i);
			try {
				Thread.sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
