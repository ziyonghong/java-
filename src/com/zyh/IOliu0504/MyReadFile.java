package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyReadFile {
	public static void main(String[] args){
		
		try{
			//��һ������λ����Դ
			File f=new File("c:/work/test.txt");
			//�ڶ����������ܵ�,FileInputStream�ļ������������ڶ��ļ�
			FileInputStream fis=new FileInputStream(f);
			
			//FileOutputStream�ļ������������д�ļ�
			File outFile=new File("c:/work/test1.txt");	
			FileOutputStream fos=new FileOutputStream(outFile);
			//�������������ܵ�
			int length=fis.available();
			for(int i=0;i<length;i++)
			System.out.print((char)fis.read());
			
			//��test�е��ļ�������-->��д�뵽test1�У�ʵ���ļ�����
			for(int i=0;i<length;i++)
				fos.write(fis.read());
		}catch(Exception e){}  //IO�쳣
	}
}
