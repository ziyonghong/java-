package com.zyh.ball0420;

import java.awt.*;

@SuppressWarnings("serial")
public class MyPanel extends Panel implements Runnable {
	int x=200;
	int y=200;
	int att=0;//0右下，1左下，2左上，3右上
	public void paint(Graphics g){
		g.setColor(Color.blue);
		g.fillOval(x, y, 20, 20);
	}
	public void run(){
		while(true){
			//定义飞行姿态
			if(att==0){
				x++;
				y++;
			}
			if(att==1)
				{
				x--;
				y++;
				}
			if(att==2)
			{
			x--;
			y--;
			}
			if(att==3)
			{
			x++;
			y--;
			}
			//改变飞行姿态
			if(x>460){
				if(att==0)
					att=1;
				else
					att=2;
			}
			if(y>430){
				if(att==1)
					att=2;
				else
					att=3;
			}
			if(x<0){
				if(att==2)
					att=3;
				else
					att=0;
			}
			if(y<0){
				if(att==3)
					att=0;
				else
					att=1;
			}
				try{
				Thread.sleep(10);
			}catch(Exception e){}
			repaint();
		}
	}
}
