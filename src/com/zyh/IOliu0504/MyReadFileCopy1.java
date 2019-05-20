package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyReadFileCopy1 {
	public static void main(String[] args){
		try{
			File inFile=new File("C:\\Program Files\\Java\\jdk1.8.0_91\\src.zip");
			File outFile=new File("C:\\work\\src.zip");
			
			FileInputStream fis=new FileInputStream(inFile);
			FileOutputStream fos=new FileOutputStream(outFile);
			
//			int length=fis.available();
//			for(int i=0;i<length;i++)
//				fos.write(fis.read());
			byte []tmp=new byte[8192];
			int length=fis.available()/8192+1;
			for(int i=0;i<length;i++){
				fis.read(tmp);
				fos.write(tmp);
				fos.write(tmp, 0,fis.read());
			}
			
		}catch(Exception e){}
	}
}
