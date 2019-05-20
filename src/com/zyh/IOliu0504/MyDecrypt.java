package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//Ω‚√‹
public class MyDecrypt {
	public static void main(String[] args) {
		try{
			File f=new File("c:/work/test1.txt");
			
			FileInputStream fis=new FileInputStream(f);
			
			int length=fis.available();
			//for(int i=0;i<length;i++)
				System.out.print((char)fis.read()-100);
			}catch(Exception e){}
	}
}
