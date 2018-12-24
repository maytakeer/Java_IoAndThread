package com.ushine.xuexi.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class testFile {
	public static void main(String[] args) {
		
		//file(内存)----输入流---->【程序】----输出流---->file(内存)
		File file = new File("F:/temp","addfile.txt");
		try {
			//创建文件
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//向文件写入内容（输出流）
		String str = "摸鱼的一天";
		byte bt[] = new byte[1024];
		bt = str.getBytes();
		try {
			FileOutputStream in = new FileOutputStream(file);
			try {
				in.write(bt, 0, bt.length);
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//读取文件内容（输入流）
			FileInputStream out = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(out);
			int ch =0;
			while((ch=isr.read())!=-1){
				System.out.println((char) ch);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
