package com.zyh.sendmsg0509;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args){
		try{
			ServerSocket ss=new ServerSocket(8000);
			System.out.println("¼àÌýÇ°...");
			Socket s=ss.accept();
			System.out.println("¼àÌýºó...");
//			
//			InputStream is=s.getInputStream();
//			InputStreamReader isr=new InputStreamReader(is);
//			BufferedReader br=new BufferedReader(isr);
//			String name=br.readLine();
//			System.out.println(name);
//			
//			OutputStream os=s.getOutputStream();
//			OutputStreamWriter osw=new OutputStreamWriter(os);
//			PrintWriter pw=new PrintWriter(osw,true);
//			pw.println("welcome"+name);
		}catch(Exception e){}
	}
}
