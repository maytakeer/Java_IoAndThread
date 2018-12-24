package com.ushine.xuexi.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 往文件依次写入3名员工信息
 * 每位员工有姓名和员工两个字段 然后按照
 *	第二名，第一名，第三名的先后顺序读取员工信息
 * @author Administrator
 *
 */
public class RandomAccessFileTest {
	public static void main(String[] args) {
		Employee e1 = new Employee(23, "张三");
		Employee e2 = new Employee(24, "李四");
		Employee e3 = new Employee(25, "王五");
		File file = new File("F:/temp/employee.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 一个中文占两个字节 一个英文字母占一个字节
		// 整形 占的字节数目 跟cpu位长有关 32位的占4个字节
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
			randomAccessFile.writeChars(e1.getName());
			randomAccessFile.writeInt(e1.getAge());
			randomAccessFile.writeChars(e2.getName());
			randomAccessFile.writeInt(e2.getAge());
			randomAccessFile.writeChars(e3.getName());
			randomAccessFile.writeInt(e3.getAge());
			randomAccessFile.close();
			
			RandomAccessFile raf2 = new RandomAccessFile(file, "r");
			raf2.skipBytes(Employee.LEN*2+4);
			String strName2 = "";
			for (int i = 0; i < Employee.LEN; i++) {
				strName2 = strName2 + raf2.readChar();
			}	
			int age2 = raf2.readInt();
			System.out.println("strName2 = " + strName2.trim());
			System.out.println("age2 = " + age2);
			
			raf2.seek(0);
			String strName1 = "";
			for (int i = 0; i < Employee.LEN; i++) {
				strName1 = strName1 + raf2.readChar();
			}
			int age1 = raf2.readInt();
			System.out.println("strName1 = " + strName1.trim());
			System.out.println("age1 = " + age1);
	 
			raf2.skipBytes(Employee.LEN * 2 + 4);
			String strName3 = "";
			for (int i = 0; i < Employee.LEN; i++) {
				strName3 = strName3 + raf2.readChar();
			}
			int age3 = raf2.readInt();
			System.out.println("strName3 = " + strName3.trim());
			System.out.println("age3 = " + age3);
			
			raf2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


class Employee{
	//年龄
	public int age;
	//姓名
	public String name;
	//姓名的长度
	public static final int LEN = 8;
	
	public Employee(int age,String name) {
		this.age = age;
		//对name字符长度的一个处理
		if (name.length()>LEN) {
			name = name.substring(0,LEN);
		}else {
			while(name.length()<LEN){
				name = name + "/u0000";
			}
		}
		this.name = name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
}
