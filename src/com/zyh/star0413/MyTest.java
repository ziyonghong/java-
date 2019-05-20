package com.zyh.star0413;
import java.awt.*;
public class MyTest {
	@SuppressWarnings("deprecation")
	public static void main(String [] args){
		Frame f=new Frame();
		f.setSize(2000, 1000);
		f.setBackground(Color.BLACK);
		
		MyPanel mp=new MyPanel();
		f.add(mp);
		
		f.show();
	}

}
