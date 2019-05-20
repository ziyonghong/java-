package com.zyh.fractal0425;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Trangle extends JPanel {
	public void show(){
		JFrame frame=new JFrame();
		frame.setTitle("SierpinskiÈý½ÇÐÎ");
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
		Graphics2D g2d=(Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(1));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		trangle(5,g2d,200,300,400,400,100,400);
	}
	public void trangle(int count,Graphics2D g2d,int x1,int x2,int x3,int y1,int y2,int y3){
		if(count==0){
			return;
		}
		g2d.drawLine(x1, y1, x2, y2);
		g2d.drawLine(x1, y1, x3, y3);
		g2d.drawLine(x2, y2, x3, y3);
		trangle(count-1,g2d,x1,(x1+x2)/2,(x1+x3)/2,y1,(y1+y2)/2,(y1+y3)/2);
		trangle(count-1,g2d,(x1+x2)/2,x2,(x2+x3)/2,(y1+y2)/2,y2,(y2+y3)/2);
		trangle(count-1,g2d,(x1+x3)/2,(x2+x3)/2,x3,(y1+y3)/2,(y2+y3)/2,y3);
		
	}
	public static void main(String[] args) {
		Trangle tra=new Trangle();
		tra.show();
	}
}