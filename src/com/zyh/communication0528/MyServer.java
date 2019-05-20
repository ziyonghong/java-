package com.zyh.communication0528;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		MyServer ms = new MyServer();
	}

	public MyServer() {
		try {
			System.out.println("在8800端口监听");
			// 创建服务器
			ServerSocket ss = new ServerSocket(8800);
			System.out.println("监听前");
			// 获取IO流
			Socket s = ss.accept();
			// 以对象流方式读取（假设客户端发送的是user的一个对象）
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			User u = (User) ois.readObject();
			System.out.println("从客户端接收到" + u.getName() + " " + u.getPass());
			
			// System.out.println(s.getInputStream().read());
		} catch (Exception e) {
		}

	}
}
