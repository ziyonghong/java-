package com.zyh.myNote0712;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
	char c[] = new char[1000];
	int size = 0;
	int cursor = 0;// 记录光标位置

	public void paint(Graphics g) {
		super.paint(g);// 清楚屏幕
		for (int i = 0; i < size; i++) {
			g.drawString(" " + c[i], 10 + 8 * i, 10);
		}
		// 光标
		g.drawLine(10 + cursor * 8, 0, 10 + cursor * 8, 10);
	}

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z) {
		for (int i = size; i > cursor; i--) {
					c[i] = c[i - 1];
				}
				c[cursor] = e.getKeyChar();
				size++;
				cursor++;
			}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			if (cursor > 0)
				cursor--;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if (cursor < size)
				cursor++;
		}
		
		//删除
		if(e.getKeyCode()==KeyEvent.VK_DELETE){
			if(cursor<size){
				for(int i=cursor;i<size;i++){
					c[i]=c[i+1];
				}
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
