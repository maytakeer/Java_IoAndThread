package com.ushine.xuexi.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 第二种方法快 2>3>1
 * @author Administrator
 *
 */
public class FileTest {
	public FileTest(){
		
	}
	public static void main(String[] args) {
		FileOutputStream out = null;
		FileOutputStream outStr = null;
		BufferedOutputStream buff = null;
		FileWriter fw = null;
		int count = 10000;//写文件行数
		try {
			out = new FileOutputStream(new File("F:/temp/add.txt"));
			long begin = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				out.write("测试java 文件操作\r\n".getBytes());
			}
			out.close();
			long end = System.currentTimeMillis();
			System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 豪秒"); 
			outStr = new FileOutputStream(new File("F:/temp/add1.txt"));
			buff = new BufferedOutputStream(outStr);
			long begin1 = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				buff.write("测试java 文件操作\r\n".getBytes());
			}
			buff.flush();
			buff.close();
			long end1 = System.currentTimeMillis();
			System.out.println("FileOutputStream执行耗时:" + (end1 - begin1) + " 豪秒"); 
			fw = new FileWriter("F:/temp/add2.txt");
			long begin2 = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				fw.write("测试java 文件操作\r\n");
			}
			fw.close();
			long end2 = System.currentTimeMillis();
			System.out.println("FileOutputStream执行耗时:" + (end2 - begin2) + " 豪秒");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
				buff.close();
				outStr.close();
				out.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
