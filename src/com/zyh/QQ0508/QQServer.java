package com.zyh.QQ0508;

import java.net.*;
import java.io.*;

public class QQServer {
	public static void main(String[] args) {
		try {
			// ��������8000�˿ڼ���
			ServerSocket ss = new ServerSocket(8000);

			System.out.println("����������8000�˿ڼ���......");
			Socket s = ss.accept();

			// �����û���������
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String uandp = br.readLine();

			// ����û���������
			String u = " ";
			String p = " ";
			try {
				u = uandp.split("%")[0];
				p = uandp.split("%")[1];
			} catch (Exception ee) {
			}

			// ������������Ϣ
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw, true);

			if (u.equals("aaa") && p.equals("111")) {
				// ������ȷ��Ϣ���ͻ���
				pw.println("ok");
				while (true) {
					String message = br.readLine();
					System.out.println(message);
				}
			} else {
				// ���ʹ�����Ϣ���ͻ���
				pw.println("err");
			}
		} catch (Exception e) {
		}
	}
}