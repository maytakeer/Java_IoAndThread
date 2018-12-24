package com.ushine.xuexi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

//1.按字节读取文件内容
//2.按字符读取文件内容
//3.按行读取文件内容
//4.随机读取文件内容
public class ReadFromFile {
	/**
	 * 以字节为单位读取文件，常用于	读二进制文件，如图片、声音、影像等文件
	 * @param filename
	 */
	public static void readFileByBytes(String filename){
		File file = new File(filename);
		InputStream in = null;
		try {
			System.out.println("以字节为单位读取文件内容，一次读一个字节：");
			//一次读一个字节
			in = new FileInputStream(file);
			int tempbyte;
			while((tempbyte=in.read())!=-1){
				System.out.write(tempbyte);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		try {
			System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			//一次读多个字节
			byte[] tempbytes = new byte[100];
			int byteread = 0;
			in = new FileInputStream(filename);
			ReadFromFile.showAvailableBytes(in);
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			while((byteread=in.read(tempbytes))!=-1){
				System.out.write(tempbytes,0,byteread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e2) {
				}
			}
		}
	}
	
	/**
	 * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	 * @param fileName
	 */
	public static void readFileByChars(String fileName){
		File file = new File(fileName);
		Reader reader = null;
		try {
			System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			//一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
			int tempchar;
			while((tempchar=reader.read())!=-1){
				//对于windows下，rn这两个字符在一起的时，表示一个换行
				//但是如果这两个字符分开显示时，会换两次行
				//因此屏蔽r，或者屏蔽n。否则将会多出很多空行
				if(((char)tempchar) != 'r'){
					System.out.println((char) tempchar);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("以字符为单位读取文件内容，一次读多个字节：");
			//一次读多出字符
			char[] tempchars = new char[30];
			int charread = 0;
			reader = new InputStreamReader(new FileInputStream(fileName),"UTF-8");
			// 读入多个字符到字符数组中，charread为一次读取字符数
			while((charread = reader.read(tempchars))!=-1){
				//同样屏蔽掉r不显示
				if((charread==tempchars.length)&&(tempchars[tempchars.length-1]!='r')){
						System.out.println(tempchars);
				}else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i]=='r') {
							continue;
						}else {
							System.out.println(tempchars[i]);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e2) {
				}
			}
		}
		
	}
	
	/**
	 * 	以行为单位读取文件，常用于读面向行的格式化文件
	 * @param filename
	 */
	public static void readFileByLines(String filename){
		File file = new File(filename);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			//一次读入一行，直到读入null为文件结束
			while((tempString = reader.readLine())!=null){
				//显示行号
				System.out.println("line "+line+": "+tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e2) {
					
				}
			}
		}
	}
	
	/**
	 * 随机读取文件内容
	 * @param fileName
	 */
	public static void readFileByRandomAccess(String fileName){
		RandomAccessFile randomFile = null;
		try {
			System.out.println("随机读取一段文件内容：");
			//打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(fileName, "r");
			//文件长度，字节数
			long fileLength = randomFile.length();
			//读文件的起始位置
			int bigIndex = (fileLength >4) ? 4 : 0;
			//将读文件的开始位置移到beginIndex位置
			randomFile.seek(bigIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while((byteread=randomFile.read(bytes))!=-1){
				System.out.write(bytes,0,byteread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e2) {
				}
			}
		}
	}
	
	/**
	 * 显示输入流中还剩的字节数
	 * @param in
	 */
	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当前字节输入流中的字节数为:"+in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String fileName = "F:/temp/test.txt";
	//	ReadFromFile.readFileByBytes(fileName);
		ReadFromFile.readFileByChars(fileName);
	//	ReadFromFile.readFileByLines(fileName);
	//	ReadFromFile.readFileByRandomAccess(fileName);
	}
}
