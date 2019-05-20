package com.zyh.AppletDemo0725;

import java.applet.Applet;
import java.awt.Graphics;

public class Sample extends Applet {
	StringBuffer buffer;

	public void init() {
		buffer = new StringBuffer();
		addItem("Applet ≥ı ºªØ");
	}

	public void start() {
		addItem("Applet start");
	}

	public void stop() {
		addItem("Applet stop");
	}

	void addItem(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		buffer.append(string);
		repaint();
	}

	public void paint(Graphics g) {
		 g.drawRect(0, 0, getSize().width-1, getSize().height-1);
		//g.drawOval(0, 0, 100,100);
		g.drawString(buffer.toString(), 5, 15);
	}
}
