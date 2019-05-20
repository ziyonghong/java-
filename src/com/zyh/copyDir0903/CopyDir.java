package com.zyh.copyDir0903;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.zyh.weather0707.mainFrame;

public class CopyDir extends JFrame implements ActionListener {
	CopyDir(){
		this.setSize(500,600);
		JLabel labFrom=new JLabel("源目录");
		JLabel labTo=new JLabel("目标目录");
		
		JTextField txtFrom=new JTextField();
		JTextField txtTo=new JTextField();
		
		JButton btnFrom=new JButton("源目录");
		JButton btnTo=new JButton("目标目录");
		
		JTextArea txtIng=new JTextArea();
		JScrollPane sp=new JScrollPane(txtIng);
		
		JButton btnCopy=new JButton("复制");
		
		//注册事件监听
		btnFrom.addActionListener(this);
		btnTo.addActionListener(this);
		//布局输入面板
		JPanel panInput=new JPanel();
		panInput.setLayout(new GridLayout(2, 3));
		panInput.add(labFrom);
		panInput.add(labTo);
		panInput.add(txtFrom);
		panInput.add(txtTo);
		panInput.add(btnFrom);
		panInput.add(btnTo);
		
		//布局窗体
		this.setLayout(new BorderLayout());
		this.add(panInput,BorderLayout.NORTH);
		this.add(sp,BorderLayout.CENTER);
		this.add(btnCopy, BorderLayout.SOUTH);
		
	}
public static void main(String[] args) {
	CopyDir cd=new CopyDir();
	cd.setVisible(true);
}
	
	public void actionPerformed(ActionEvent e) {


		
		
		
		

	}

}
