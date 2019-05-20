package com.zyh.typegame0421;

import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyChar {
		public static void main(String[] args){
			JFrame f=new JFrame();
			f.setSize(500, 800);
			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(3);
			f.getContentPane().setBackground(Color.GREEN);
			MyPanel mp=new MyPanel(f);
			f.add(mp);
			
			Thread t=new Thread(mp);
			t.start();
			f.addKeyListener(mp);
			mp.addKeyListener(mp);
			f.setVisible(true);;
		}
}
