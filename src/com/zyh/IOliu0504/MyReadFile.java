package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyReadFile {
	public static void main(String[] args){
		
		try{
			//第一步，定位数据源
			File f=new File("c:/work/test.txt");
			//第二布，建立管道,FileInputStream文件输入流类用于读文件
			FileInputStream fis=new FileInputStream(f);
			
			//FileOutputStream文件输出流类用于写文件
			File outFile=new File("c:/work/test1.txt");	
			FileOutputStream fos=new FileOutputStream(outFile);
			//第三步，操作管道
			int length=fis.available();
			for(int i=0;i<length;i++)
			System.out.print((char)fis.read());
			
			//将test中的文件读出来-->再写入到test1中，实现文件复制
			for(int i=0;i<length;i++)
				fos.write(fis.read());
		}catch(Exception e){}  //IO异常
	}
}
