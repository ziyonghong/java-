package com.zyh.database0510;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.annotation.processing.Filer;

public class MyUser {
	public static void main(String [] args){
		String u="bbb";
		String p="222";
		try{
			File f=new File("c:/work/user.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			boolean b=false;
			while(br.ready()){
				String uandp=br.readLine();
				String user=uandp.split("%")[0];
				String pass=uandp.split("%")[1];
				if(u.equals(user)&&p.equals(pass)){
					b=true;
				break;
			}
			}
			if(b){
				System.out.println("验证通过");
			}else{
				System.out.println("验证失败");
			}
		}catch(Exception e){}
	}
}
