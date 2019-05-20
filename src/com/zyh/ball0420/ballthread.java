package com.zyh.ball0420;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ballthread extends Thread{
	int x;
	int y;
	Graphics g;
	Color c;
	public ballthread(int x,int y,Graphics g,Color c){
		this.x=x;
		this.y=y;
		this.g=g;
		this.c=c;
	}
	public void run() {
		// TODO Auto-generated method stub
		Random r=new Random();
		int r1=r.nextInt(25);
		int r2=r.nextInt(50);
		  while(y<500){
		    	g.setColor(Color.black);
		    	g.fillOval(x, y, r1, r1);
		    	try {
					Thread.sleep(10);
				} catch (InterruptedException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
		    	g.setColor(Color.white);
		    	g.fillOval(x, y, 50, 50);
		    	y++;
		    }
	}
}
