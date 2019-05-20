package com.zyh.ball0426;

import java.awt.Color;

import javax.swing.JFrame;


public class MyBall {
	
	public static void main(String [] args){
		JFrame jf=new JFrame("ball");
		jf.setSize(300, 400);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setBackground(Color.WHITE);
		
		MyPanel mp=new MyPanel();
		jf.add(mp);
		jf.addMouseMotionListener(mp);
		mp.addMouseMotionListener(mp);
		jf.setVisible(true);
	}
}
