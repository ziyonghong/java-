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
		JLabel labFrom=new JLabel("ԴĿ¼");
		JLabel labTo=new JLabel("Ŀ��Ŀ¼");
		
		JTextField txtFrom=new JTextField();
		JTextField txtTo=new JTextField();
		
		JButton btnFrom=new JButton("ԴĿ¼");
		JButton btnTo=new JButton("Ŀ��Ŀ¼");
		
		JTextArea txtIng=new JTextArea();
		JScrollPane sp=new JScrollPane(txtIng);
		
		JButton btnCopy=new JButton("����");
		
		//ע���¼�����
		btnFrom.addActionListener(this);
		btnTo.addActionListener(this);
		//�����������
		JPanel panInput=new JPanel();
		panInput.setLayout(new GridLayout(2, 3));
		panInput.add(labFrom);
		panInput.add(labTo);
		panInput.add(txtFrom);
		panInput.add(txtTo);
		panInput.add(btnFrom);
		panInput.add(btnTo);
		
		//���ִ���
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
