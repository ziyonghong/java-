package com.zyh.fractal0425;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Square extends JPanel{
	public void show(){
		JFrame frame=new JFrame();
		frame.setTitle("������ ����");
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
	//count�ݹ����
	public void tangle(int count,Graphics g,int x1,int y1,int width,int height){
		if(count==0){
			return;
		}
		//��n�β�������һ��������
		g.fillRect(x1,y1, width, height);
		//��n-1�β�����ÿ����������Χ��8��С�����Σ����ǵݹ���ú�������
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