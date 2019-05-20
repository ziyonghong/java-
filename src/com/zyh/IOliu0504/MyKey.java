package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileOutputStream;

//生成密钥文件
public class MyKey {
   public static void main(String[] args){
	   try{
	   File f=new File("c:/work/key.key");//保存生成密钥的路径
	   FileOutputStream fos=new FileOutputStream(f);
	   for(int i=0;i<128;i++)
		   //写入生成的随机数
		   fos.write((int)(Math.random()*128));
	   
	   }catch (Exception e){}
   }
}
