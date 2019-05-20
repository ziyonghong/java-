package com.zyh.ball0420;



import javax.swing.JFrame;

public class MyBall {
	public static void main(String args[]){
		JFrame f=new JFrame();
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(3);;
		
		MyPanel mp=new MyPanel();
		f.add(mp);
		Thread t=new Thread(mp);
		t.start();
		f.setVisible(true);;
	}
}
