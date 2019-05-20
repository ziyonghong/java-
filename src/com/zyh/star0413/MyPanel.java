package com.zyh.star0413;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class MyPanel extends Panel{
	public void paint (Graphics g){
		//g.setColor(Color.BLUE);
		//g.drawLine(20, 20, 100, 100);
		//g.fillOval(50,50, 60, 80);
		g.setFont(new Font("",0,30));//°ÑÐÇÐÇ±ä´ó
			g.setColor(new Color(0,255,20));
			for(int i=0;i<300;i++)
			{
		g.drawString("*", (int)(Math.random()*2000),(int)(Math.random()*1000));
			}
	}
}
