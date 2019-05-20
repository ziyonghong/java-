package com.zyh.button0427;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyButton {
	public static void main(String [] args){
		JFrame jf=new JFrame();
		jf.setSize(400,400);
		
		JButton jb=new JButton("ok");
		JButton jb1=new JButton("ok1111111");
		JButton jb2=new JButton("ok2");
		JButton jb3=new JButton("ok3");
		//jf.setLayout(new FlowLayout());
		jf.add(jb,BorderLayout.EAST);
		jf.add(jb1,BorderLayout.WEST);
		jf.add(jb2);
		jf.add(jb3);

		
		jf.setVisible(true);
	}
}
