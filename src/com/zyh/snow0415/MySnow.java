package com.zyh.snow0415;
import java.awt.*;
public class MySnow {
	@SuppressWarnings("deprecation")
	public static void main(String [] args){
		Frame f=new Frame();
		f.setSize(2000, 1000);
		f.setBackground(Color.BLACK);
		
		MyPanel mp=new MyPanel();
		f.add(mp);
		
		Thread t=new Thread(mp);
		t.start();
		
		f.show();
	}

}
