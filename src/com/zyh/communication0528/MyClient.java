package com.zyh.communication0528;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args){
		MyClient mc=new MyClient();
	}
	public MyClient(){
		
		try{
			Socket s=new Socket("localhost",8800);
			//ͨ��ObjectOutputStream�����������Ͷ���
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			User u=new User();
			u.setName("ziyonghong");
			u.setPass("123456");
			oos.writeObject(u);
			System.out.println("a");
			s.close();
			//s.getOutputStream().write(20);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
