package com.zyh.snow0415;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class MyPanel extends Panel implements Runnable{
	
		//g.setColor(Color.BLUE);
		//g.drawLine(20, 20, 100, 100);
		//g.fillOval(50,50, 60, 80);
		int x[]=new int [300];
		int y[]=new int [300];
		//构造方法
		public MyPanel(){
			for(int i=0;i<300;i++){
				x[i]=(int)(Math.random()*2000);
				y[i]=(int)(Math.random()*2000);
			}
		}
		public void paint (Graphics g){
		g.setFont(new Font("",0,30));//把星星变大
			g.setColor(new Color(0,255,20));
			for(int i=0;i<300;i++)
			{
		g.drawString("*", (int)(Math.random()*2000),(int)(Math.random()*1000));
			}
		}
	public void run(){
		while(true){
			try{
				for(int i=0;i<300;i++){
					y[i]++;
					if(y[i]>2000){
						y[i]=0;
					}
				}
				Thread.sleep(30);
			}catch(Exception e){}
		repaint();
		}
	}
}


