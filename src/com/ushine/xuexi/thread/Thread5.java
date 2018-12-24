package com.ushine.xuexi.thread;


class Data 
{ 
public int value = 0; 
} 
class Work 
{ 
public void process(Data data, Integer[] numbers) 
{ 
for (int n : numbers) 
{ 
data.value += n; 
} 
} 
} 

public class Thread5 extends Thread{
	private Work work; 
	public Thread5(Work work) 
	{ 
	this.work = work; 
	} 
	public void run() 
	{ 
	java.util.Random random = new java.util.Random(); 
	Data data = new Data(); 
	int n1 = random.nextInt(1000); 
	int n2 = random.nextInt(2000); 
	int n3 = random.nextInt(3000); 
	Integer[] arr = new Integer[3];
	arr[0] = n1;
	arr[1] = n2;
	arr[2] = n3;
	work.process(data, arr); // 使用回调函数 
	System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+" 
	+ String.valueOf(n3) + "=" + data.value); 
	} 
	public static void main(String[] args) 
	{ 
	Thread thread = new Thread5(new Work()); 
	thread.start(); 
	} 

}
