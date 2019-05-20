package com.zyh.QQ0508;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.* ;
import java.net.Socket;

public class QQMain extends JFrame implements ActionListener{
 private Socket s;
 public void setSocket(Socket s){
	 this.s=s;
 }
	JTextField txtMess = new JTextField() ;
	JComboBox cmbUser = new JComboBox() ;
	JTextArea txtContent = new JTextArea() ;
	QQMain(){
		this.setSize(300 , 400) ;
		
		//new组件
		JButton btnSend = new JButton("发送") ;
		
		JScrollPane spContent = new JScrollPane(txtContent) ;
		
		//注册事件监听
		btnSend.addActionListener(this) ;
		
		//布置小面板
		JPanel panSmall = new JPanel() ;
		panSmall.setLayout(new GridLayout(1 , 2)) ;
		
		panSmall.add(cmbUser) ;
		panSmall.add(btnSend) ;
		
		//布置大面板
		JPanel panBig = new JPanel() ;
		panBig.setLayout(new GridLayout(2 , 1)) ;
		
		panBig.add(txtMess) ;
		panBig.add(panSmall) ;
		
 		//布置窗体
		this.setLayout(new BorderLayout()) ;
		
		this.add(panBig , BorderLayout.NORTH) ;
		this.add(spContent , BorderLayout.CENTER) ;

		//读聊天记录
		try{
			File f = new File("c:/work/聊天记录.qq") ;
			
			FileReader fr = new FileReader(f) ;
			BufferedReader br = new BufferedReader(fr) ;
			
			while(br.ready()){
				txtContent.append(br.readLine()+"\n") ;
			}
		}catch(Exception e){}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// txtMess -------> txtContent
		txtContent.append(txtMess.getText()+"\n") ;
		
		// 将txtMess的内容存入聊天记录文件
		try{
			File f = new File("c:/work/聊天记录.qq") ;
			
			FileWriter fw = new FileWriter(f) ;
			PrintWriter pw = new PrintWriter(fw) ;
			
			pw.println(txtMess.getText()) ;
			
			pw.close() ;
		}catch(Exception e){}
		
		//发送消息到服务器
		try{
			OutputStream os=s.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			PrintWriter pw=new PrintWriter(osw,true);
			pw.print(txtMess.getText());
			//System.out.println(txtMess.getText());
		}catch(Exception e){}
		// 清除txtMess中的内容
		txtMess.setText("") ;		
	}
}