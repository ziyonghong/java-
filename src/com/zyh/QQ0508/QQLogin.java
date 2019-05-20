package com.zyh.QQ0508;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.* ;
import java.net.* ;

public class QQLogin extends JFrame implements ActionListener {
	JTextField txtUser = new JTextField() ;
	JPasswordField txtPass = new JPasswordField() ;
	
	public QQLogin() {
		this.setSize(250 , 125) ;
		
		//new组件
		JLabel labUser = new JLabel("用户名") ;
		JLabel labPass = new JLabel("密码") ;
		
		JButton btnLogin = new JButton("登陆") ;
		JButton btnReg = new JButton("注册") ;
		JButton btnCancel = new JButton("取消") ;
		
		//注册事件监听
		btnLogin.addActionListener(this) ;
		btnReg.addActionListener(this) ;
		btnCancel.addActionListener(this) ;
		
		//布置输入面板
		JPanel panInput = new JPanel() ;
		panInput.setLayout(new GridLayout(2 , 2)) ;
		
		panInput.add(labUser) ;
		panInput.add(txtUser) ;
		
		panInput.add(labPass) ;
		panInput.add(txtPass) ;
		
		//布置按钮面板
		JPanel panButton = new JPanel() ;
		panButton.setLayout(new FlowLayout()) ;
		
		panButton.add(btnLogin) ;
 		panButton.add(btnReg) ;
 		panButton.add(btnCancel) ;
 		
 		//布置窗体
 		this.setLayout(new BorderLayout()) ;
 		
 		this.add(panInput , BorderLayout.CENTER) ;
 		this.add(panButton , BorderLayout.SOUTH) ;
 
	}
	public static void main(String args[]){
		QQLogin w = new QQLogin() ;
		w.setVisible(true) ;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("登陆")){
			try {
				// 发送用户名和密码到服务器
				String user = txtUser.getText();
				String pass = txtPass.getText();
				Socket s = new Socket("127.0.0.1" , 8000) ;
					
				OutputStream os = s.getOutputStream() ;
				OutputStreamWriter osw = new OutputStreamWriter(os) ;
				PrintWriter pw = new PrintWriter(osw , true) ;
					
				pw.println(user+"%"+pass) ;
					
				//接受服务器发送回来的确认信息
				InputStream is = s.getInputStream() ;
				InputStreamReader isr = new InputStreamReader(is) ;
				BufferedReader br = new BufferedReader(isr) ;
				
				String yorn = br.readLine() ;
			
				//显示主窗体
				if (yorn.equals("ok")) {
					QQMain w = new QQMain();
					w.setSocket(s);
					w.setVisible(true);
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(this, "对不起，用户名或密码错误") ;
				}		
			} catch (Exception e) {}		
		}		
		if(arg0.getActionCommand().equals("注册")){
			System.out.println("用户点了注册") ;
		}
		if(arg0.getActionCommand().equals("取消")){
			System.out.println("用户点了取消") ;
		}
	}
}