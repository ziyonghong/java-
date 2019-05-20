package com.zyh.sendmsg0509;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) {
		try{
			@SuppressWarnings("resource")
			Socket s=new Socket("localhost", 8000);
			
//			OutputStream os=s.getOutputStream();
//			OutputStreamWriter osw=new OutputStreamWriter(os);
//			PrintWriter pw=new PrintWriter(osw,true);
//			pw.println("втсю╨Л");
//			
//
//			InputStream is=s.getInputStream();
//			InputStreamReader isr=new InputStreamReader(is);
//			BufferedReader br=new BufferedReader(isr);
//			String mess=br.readLine();
//			System.out.println(mess);
			}catch(Exception e){}

	}

}
