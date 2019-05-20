package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//º”√‹
public class MyEncrypt {
	public static void main(String[] args) {
		try{
			File inFile=new File("c:/work/test.txt");
			File outFile=new File("c:/work/test1.txt");
			
			FileInputStream fis=new FileInputStream(inFile);
			FileOutputStream fos=new FileOutputStream(outFile);
			
			int length=fis.available();
			//for(int i=0;i<length;i++)
				fos.write(fis.read()+100);
			}catch(Exception e){}
	}
}
