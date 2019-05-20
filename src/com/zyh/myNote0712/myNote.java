package com.zyh.myNote0712;

import javax.swing.JFrame;

import com.zyh.weather0707.mainFrame;

public class myNote {
 public static void main(String[] args) {
	JFrame jf=new JFrame();
	jf.setSize(300, 400);
	
	MyPanel mp=new MyPanel();
	jf.add(mp);
	
	jf.addKeyListener(mp);
	mp.addKeyListener(mp);
	
	
	jf.setVisible(true);
}
}
