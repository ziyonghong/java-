package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileOutputStream;

//������Կ�ļ�
public class MyKey {
   public static void main(String[] args){
	   try{
	   File f=new File("c:/work/key.key");//����������Կ��·��
	   FileOutputStream fos=new FileOutputStream(f);
	   for(int i=0;i<128;i++)
		   //д�����ɵ������
		   fos.write((int)(Math.random()*128));
	   
	   }catch (Exception e){}
   }
}
