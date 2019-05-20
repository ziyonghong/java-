package com.zyh.ball0413;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class MyPanel extends Panel implements KeyListener {
	 int x=50,y=50;
	public void paint(Graphics g){
		g.fillOval(x, y, 20, 20);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		//System.out.println(arg0);
	    if(arg0.getKeyCode()==37){
	    	x--;
	    }
	    if(arg0.getKeyCode()==38){
	    	y--;
	    }
	    if(arg0.getKeyCode()==39){
	    	x++;
	    }
	    if(arg0.getKeyCode()==40){
	    	y++;
	    }
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
