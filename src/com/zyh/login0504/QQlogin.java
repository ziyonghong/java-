package com.zyh.login0504;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class QQlogin implements ActionListener{
	public static void main(String[] args){
		JFrame w=new JFrame();
		w.setSize(250,125);
		
		//���
		JLabel jl=new JLabel("�û���");
		JLabel jl1=new JLabel("����");
		
		JTextField jf=new JTextField();
		JPasswordField jpf=new JPasswordField();
		
		JButton jb=new JButton("��½");
		JButton jb1=new JButton("ע��");
		JButton jb2=new JButton("ȡ��");
		//ע���¼�����
		QQlogin e=new QQlogin();
		jb.addActionListener(e);
		jb1.addActionListener(e);
		jb2.addActionListener(e);
		
		//�����������
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(2, 2));
		
		jp.add(jl);
		jp.add(jl1);
		jp.add(jf);
		jp.add(jpf);
		
		//���ð�ť���
		JPanel button=new JPanel();
		button.setLayout(new FlowLayout());
		button.add(jb);
		button.add(jb1);
		button.add(jb2);
		
		//���ô���
		w.setLocationRelativeTo(null);
		w.setLayout(new BorderLayout());
		w.add(jp,BorderLayout.CENTER);
		w.add(button,BorderLayout.SOUTH);
		
		w.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�¼���Ӧ��");
	}
}
