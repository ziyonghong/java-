package com.zyh.typegame0421;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyPanel extends Panel implements Runnable, KeyListener {
	int x[] = new int[15];
	int y[] = new int[15];
	char c[] = new char[15];
	int score = 1000;
	int a;
	private BufferedImage buffer;
	private Graphics bg;
	private JFrame f;
	MyPanel(JFrame f) {
		this.f=f;
		for (int i = 0; i < 15; i++) {
			//如何保证不在同一个位置？
			x[i] = (int) (Math.random()*500);
//			a=x[i];
//			System.out.println(a);
			y[i] = (int) (Math.random() * 600);
			c[i] = (char) (Math.random() * 26 + 97);

		}
	}

	public void paint(Graphics g) {
		//buffer=new BufferedImage(f.getHeight(), f.getWidth(), BufferedImage.TYPE_4BYTE_ABGR);
		//bg=buffer.getGraphics();
		g.setFont(new Font("", 0, 30));
		for (int i = 0; i < 15&&x[i]!=a; i++) {
			g.drawString(new Character(c[i]).toString(), x[i], y[i]);
		}
		// 显示成绩
		g.setColor(Color.RED);
		g.drawString("your score: " + score, 20, 25);
		g.drawImage(buffer,0,0,null);
	}

	public void run() {
		buffer=new BufferedImage(f.getHeight(), f.getWidth(), BufferedImage.TYPE_4BYTE_ABGR);
		bg=buffer.getGraphics();
		while (true) {
			for (int i = 0; i < 15; i++) {
				y[i]++;
				if (y[i] > 600) {
					y[i] = 0;
					x[i] = (int) (Math.random() * 500);
					c[i] = (char) (Math.random() * 26 + 97);
					score -= 100;
				}
			}
			try {
				Thread.sleep(30);
			} catch (Exception e) {
			}
			repaint();
		}

	}

	public void keyPressed(KeyEvent arg0) {
		char keyC = arg0.getKeyChar();
		int nowY = -1;
		int nowIndex = -1;
		for (int i = 0; i < 15; i++) {
			if (keyC == c[i]) { //输入字母与产生的字母相等
				if (y[i] > nowY) {
					nowY = y[i];
					nowIndex = i;
				}
			}
		}
		if (nowIndex != -1) {
			y[nowIndex] = 0;
			x[nowIndex] = (int) (Math.random() * 500);
			c[nowIndex] = (char) (Math.random() * 26 + 97);
			score += 10;
		} else
			score -= 10;
		
	}
	
	public void over(){
	if(score<=0){
		JOptionPane.showMessageDialog(null, "game over");
		
	}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
