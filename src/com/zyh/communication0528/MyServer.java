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
			System.out.println("��8800�˿ڼ���");
			// ����������
			ServerSocket ss = new ServerSocket(8800);
			System.out.println("����ǰ");
			// ��ȡIO��
			Socket s = ss.accept();
			// �Զ�������ʽ��ȡ������ͻ��˷��͵���user��һ������
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			User u = (User) ois.readObject();
			System.out.println("�ӿͻ��˽��յ�" + u.getName() + " " + u.getPass());
			
			// System.out.println(s.getInputStream().read());
		} catch (Exception e) {
		}

	}
}
