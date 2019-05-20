package com.zyh.QQ0508;

import java.net.*;
import java.io.*;

public class QQServer {
	public static void main(String[] args) {
		try {
			// 服务器在8000端口监听
			ServerSocket ss = new ServerSocket(8000);

			System.out.println("服务器正在8000端口监听......");
			Socket s = ss.accept();

			// 接受用户名和密码
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String uandp = br.readLine();

			// 拆分用户名和密码
			String u = " ";
			String p = " ";
			try {
				u = uandp.split("%")[0];
				p = uandp.split("%")[1];
			} catch (Exception ee) {
			}

			// 服务器发送信息
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw, true);

			if (u.equals("aaa") && p.equals("111")) {
				// 发送正确信息到客户端
				pw.println("ok");
				while (true) {
					String message = br.readLine();
					System.out.println(message);
				}
			} else {
				// 发送错误信息到客户端
				pw.println("err");
			}
		} catch (Exception e) {
		}
	}
}