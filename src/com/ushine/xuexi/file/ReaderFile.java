package com.ushine.xuexi.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReaderFile {
	
	public static void main(String[] args) {
		new ReaderFile().bufferedReader();
	}
	public void fileReader(){
		try {
			FileReader fr = new FileReader("F:\\file.txt");
			int ch = 0;
			while((ch=fr.read())!=-1){
				System.out.println((char)ch);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提高效率我们可以使用BufferedReader对Reader进行包装，这样可以提高读取得速度，我们可以一行一行的读取文本，使用readLine()方法。
	 */
	public void bufferedReader(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\file.txt")));
			String data = null;
			while((data=br.readLine())!=null){
				System.out.println(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
