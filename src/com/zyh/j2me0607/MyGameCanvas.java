package com.zyh.j2me0607;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;


public class MyGameCanvas extends GameCanvas implements Runnable
{
	//APP
	public Game m_game;
	
	//��ָ���������
	private short m_x;
	private short m_y;
	
	//��Ԫ��
	private final int UNITY;
	private final int UNITX;
	
	//ͼƬ
	private Image imgGround;
	private Image imgBlack;
	private Image imgWhite;
	
	private Graphics g;
	
	//Command
	public Command runCommand;
	public Command backCommand;
	public Command fullCommand;
	public Command notFullCommand;
	public boolean full;
	
	//Temp
	private int clrRect;	//ѡ�����ɫ
	Thread thread;
	
	MyGameCanvas()
	{
		super(true);
		
		full = false;
		m_x = m_y = 1;
		clrRect = 0x00ff00;
		m_game = new Game();
		
		runCommand = new Command("��ʼ", Command.SCREEN, 1);
		fullCommand = new Command("ȫ��",Command.SCREEN,3);
		backCommand = new Command("����", Command.BACK, 1);
		notFullCommand = new Command("�˳�ȫ��",Command.SCREEN,4);
		
		//��ʼ����Ļ
		//this.setFullScreenMode(true);
	    
		int unitY = getHeight() > getWidth() ? 12:10;
		int unitX = getHeight() > getWidth() ? 10:12;
		if(getHeight() == getWidth())
		{
			unitX = unitY = 10;
		}
		UNITY = getHeight() / unitY;
		UNITX = getWidth()  / unitX;
		
		//��ʼ��ͼƬ
		try
		{
			imgGround = Image.createImage("/ground.png");
			imgGround = transImage.scale(imgGround, getWidth(),getHeight());
			
			imgBlack = Image.createImage("/black.png");
			imgBlack = transImage.scale(imgBlack, UNITX*3/4, UNITY*3/4);

			imgWhite = Image.createImage("/white.png");
			imgWhite = transImage.scale(imgWhite, UNITX*3/4, UNITY*3/4);
		}catch(java.io.IOException e){}
		
		g = this.getGraphics();
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void keyPressed()
	{
		int keyState = getKeyStates();
		if(m_game.m_state != AllDef.RUN)
		{
			return;
		}
		if((keyState & UP_PRESSED) != 0)
		{
			if(m_x != 1)
			{
				m_x--;
			}
		}
		else if((keyState & DOWN_PRESSED) != 0)
		{
			if(m_x != 8)
			{
				m_x++;
			}
		}
		else if((keyState & RIGHT_PRESSED) != 0)
		{
			if(m_y != 8 )
			{
				m_y++;
			}
		}
		else if((keyState & LEFT_PRESSED) != 0)
		{
			if(m_y != 1)
			{
				m_y--;
			}	
		}
		else if((keyState & FIRE_PRESSED) != 0)
		{
			if( AllDef.BLACK == m_game.m_turn )
			{
				if(m_game.m_black.setChess(m_x, m_y))
				{
					m_game.m_turn = !m_game.m_turn;
				}
			}
			if( AllDef.WHITE == m_game.m_turn )
			{
				int x[] = m_game.m_white.aiXY();
				if(m_game.m_white.setChess(x[0], x[1]))
				{
					m_game.m_turn = !m_game.m_turn;
				}
			}
			
		}
	}
	public void draw()
	{
		g.drawImage(imgGround, getWidth()/2, getHeight()/2, Graphics.VCENTER | Graphics.HCENTER);
		
		if(AllDef.ABOUT == m_game.m_state)
		{
			drawAbout();
		}
		else if(AllDef.READY == m_game.m_state)
		{
			drawReady();
		}
		else if(AllDef.RUN == m_game.m_state)
		{
			drawRun();
		}
		else if(AllDef.SCORE == m_game.m_state)
		{
			drawScore();
		}
		
		
		//Command
		if(m_game.m_state != AllDef.READY)
		{
			this.removeCommand(runCommand);
		}
		else 
		{
			this.addCommand(runCommand);
		}
		if(m_game.m_state == AllDef.ABOUT || m_game.m_state == AllDef.SCORE)
		{
			this.addCommand(backCommand	);
		}
		else
		{
			this.removeCommand(backCommand);
		}
		if(full == false)
		{
			this.addCommand(fullCommand	);
			this.removeCommand(notFullCommand);
		}
		else
		{
			this.addCommand(notFullCommand);
			this.removeCommand(fullCommand);
		}
		
		
		flushGraphics();
	}
	private boolean sign =true;
	public void run()
	{
		synchronized(thread)
		{
			while(true)
			{
				this.setFullScreenMode(full);
				
				if(sign) 
				{
					color-=10;
					if(color == 170)
					{
						sign = false;
					}
				}
				else if(!sign)
				{
					color+=10;
					if(color == 240)
					{
						sign = true;
					}
				}
				keyPressed();
				clrRect = (clrRect==0x00ff00) ? 0x00c800 : 0x00ff00;
				draw();
				try
				{
					thread.wait(100);
				}catch(InterruptedException ie){}
			}
		}
	}
	
	//////////////////////////////////////////////////
	//draw()
	private int color=240;
	private void drawAbout()
	{
		g.setColor(45, color, 50);
		g.setFont(Font.getFont(Font.FACE_SYSTEM,Font.STYLE_PLAIN,Font.SIZE_LARGE));
		
		String str1 = new String("�ڰ�����Ϸ����:");
		String str2 = new String("�������ҷֱ���Ʒ���");
		g.drawString(str1, getWidth()/2, getHeight()/2-UNITY, Graphics.BASELINE | Graphics.HCENTER);
		g.drawString(str2, getWidth()/2, getHeight()/2, Graphics.BASELINE | Graphics.HCENTER);
		g.drawString("�м�����,���ֺ�������", getWidth()/2, getHeight()/2+UNITY,
				Graphics.BASELINE | Graphics.HCENTER);
	}
	private void drawReady()
	{
		g.setColor(45, color, 50);
		g.setFont(Font.getFont(Font.FACE_SYSTEM,Font.STYLE_PLAIN,Font.SIZE_LARGE));
		g.drawString("�ڰ�����Ϸ V2.1", getWidth()/2, getHeight()/2,
				Graphics.BASELINE | Graphics.HCENTER);
		g.drawString("by Wupei", getWidth()/2+2*UNITY, getHeight()/2+UNITY, 
				Graphics.BASELINE | Graphics.HCENTER);
	}
	
	private String msgStr = "None";
	private void drawScore()
	{
		g.setColor(45, color, 50);
		g.setFont(Font.getFont(Font.FACE_SYSTEM,Font.STYLE_PLAIN,Font.SIZE_LARGE));
		
		g.drawImage(imgGround, getWidth()/2, getHeight()/2, Graphics.VCENTER | Graphics.HCENTER);
		
		g.drawString("Last game: "+msgStr, getWidth()/2, getHeight()/2-UNITY, 
					Graphics.BASELINE | Graphics.HCENTER);
		
		String strBlack = new String("Black score: " + m_game.m_black.m_scroe);
		String strWhite = new String("White score: " + m_game.m_white.m_scroe);
		g.drawString(strBlack, getWidth()/2, getHeight()/2, Graphics.BASELINE | Graphics.HCENTER);
		g.drawString(strWhite, getWidth()/2, getHeight()/2+UNITY, Graphics.BASELINE | Graphics.HCENTER);
	}
	private void drawRun()
	{
		drawRect();
		drawBoard();
	}
	
	//drawRun()
	private void drawRect()
	{
		for(int x=1; x<=8; x++)
		{
			for(int y=1; y<=8; y++)
			{
				
				g.setColor(0x0000ff);
				g.drawRect(x*UNITX, y*UNITY, UNITX, UNITY);
			}
		}		
	}
	private void drawBoard()
	{
		for(int x=1; x<=8; x++)
		{
			for(int y=1; y<=8; y++)
			{
				if(null == m_game.m_black.getChess(y, x))
				{
					continue;
				}
				else if(AllDef.BLACK == m_game.m_black.getChess(y, x).toBool())
				{
					g.drawImage(imgBlack, x*UNITX+UNITX/2, y*UNITY+UNITY/2,
							Graphics.VCENTER | Graphics.HCENTER);
				}
				else if (AllDef.WHITE == m_game.m_white.getChess(y, x).toBool())
				{
					g.drawImage(imgWhite, x*UNITX+UNITX/2, y*UNITY+UNITY/2,
							Graphics.VCENTER | Graphics.HCENTER);
				}
			}
		}
		g.setColor(clrRect);
		g.drawRect(m_y*UNITX, m_x*UNITY, UNITX, UNITY);
		
		g.setFont(Font.getDefaultFont());
		g.setColor(0x0000ff);
		String strNum = "Black: " + m_game.m_black.getNum() +"   White: " + m_game.m_white.getNum();
		g.drawString(strNum, getWidth()/2, 9*UNITY, Graphics.HCENTER | Graphics.TOP);
		
		other();
	}
	private void other()
	{
		//NOSET
		if(AllDef.NOSET == m_game.m_black.result())
		{
			m_game.m_turn = AllDef.WHITE;
		}
		if(AllDef.NOSET == m_game.m_white.result())
		{
			m_game.m_turn = AllDef.BLACK;
		}
		
		String strMsg = m_game.m_turn ? "White set!":"Black set!";
		g.drawString(strMsg, getWidth()/2, 10*UNITY-UNITY/3, Graphics.HCENTER | Graphics.TOP );
		
		//WIN
		if(AllDef.WIN == m_game.m_black.result())
		{
			m_game.m_black.init();
			m_game.m_black.m_scroe += 10;
			msgStr = "Black Win!";
			m_game.m_state = AllDef.SCORE;
		}
		else if(AllDef.WIN == m_game.m_white.result())
		{
			m_game.m_white.init();
			m_game.m_white.m_scroe += 10;
			msgStr = "White Win!";
			m_game.m_state = AllDef.SCORE;
		}
		if(m_game.m_white.getNum()+m_game.m_black.getNum() == 64)
		{
			if(m_game.m_white.getNum() > m_game.m_black.getNum())
			{
				m_game.m_white.m_scroe += 10;
				msgStr = "White Win!";
			}
			else if(m_game.m_white.getNum() < m_game.m_black.getNum())
			{
				m_game.m_black.m_scroe += 10;
				msgStr = "Black Win!";
			}
			else
			{
				msgStr = "Dogfall";
			}
			
			m_game.m_black.init();
			m_game.m_white.init();
			
			m_game.m_state = AllDef.SCORE;
		}
	}
}
