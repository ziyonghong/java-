package com.zyh.fractal0425;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Square extends JPanel{
	public void show(){
		JFrame frame=new JFrame();
		frame.setTitle("正方形 分形");
		frame.setSize(600,600);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		this.setBackground(Color.WHITE);
		frame.add(this);
		frame.setVisible(true);
		draw(this.getGraphics());
		
	}
	public void paint(Graphics g){
		super.paint(g);
		draw(g);
	}
	public void draw(Graphics g){
		tangle(5,g,200,200,100,100);
	}
	//count递归次数
	public void tangle(int count,Graphics g,int x1,int y1,int width,int height){
		if(count==0){
			return;
		}
		//第n次操作：画一个正方形
		g.fillRect(x1,y1, width, height);
		//第n-1次操作：每个正方形周围画8个小正方形，即是递归调用函数本身。
		tangle(count-1,g,(int)(x1+(1.0/3)*width),(int)(y1-(2.0/3)*height),width/3,height/3);
		tangle(count-1,g,(int)(x1+(1.0/3)*width),(int)(y1+(4.0/3)*height),width/3,height/3);
		tangle(count-1,g,(int)(x1-(2.0/3)*width),(int)(y1+(1.0/3)*height),width/3,height/3);
		tangle(count-1,g,(int)(x1+(4.0/3)*width),(int)(y1+(1.0/3)*height),width/3,height/3);
		tangle(count-1,g,(int)(x1-(2.0/3)*width),(int)(y1-(2.0/3)*height),width/3,height/3);
		tangle(count-1,g,(int)(x1+(4.0/3)*width),(int)(y1-(2.0/3)*height),width/3,height/3);
		tangle(count-1,g,(int)(x1-(2.0/3)*width),(int)(y1+(4.0/3)*height),width/3,height/3);
		tangle(count-1,g,(int)(x1+(4.0/3)*width),(int)(y1+(4.0/3)*height),width/3,height/3);
	}
	public static void main(String[] args) {
		Square squ=new Square();
		squ.show();
	}
}