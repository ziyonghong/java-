package com.zyh.Blowfish0708;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public  class BlowfishTest{ 
   	public  static void main(String [] args){
   	//ʵ��Ӧ��������Ӧ�Ǹ������
   	BlowfishTest bt=new BlowfishTest();
   		//bt.showUI();
   	String keyString = "hello cnjbb!";	
   	String testString = "������ʤ";
    System.out.println("����ǰ**************\n"+"testString = "+testString);
    Blowfish  crypt = new Blowfish(keyString);
	System.out.println("��ʼ����");      
    testString = crypt.encryptString(testString);
    System.out.println("����֮��**************\n"+"testString = "+testString);
    System.out.println("��ʼ����");
    testString = crypt.decryptString(testString);
    System.out.println("����֮��**************\n"+"testString = "+testString);
    } 
   	public void showUI(){
   		JFrame jf=new JFrame();
   		jf.setSize(500, 500);
   		jf.setTitle("Blowfish");
   		jf.setDefaultCloseOperation(3);
   		jf.setLocationRelativeTo(null);
   		FlowLayout flow=new FlowLayout();
   		jf.setLayout(flow);
   		JLabel jl=new JLabel("�������ǰ���֣�");
   		jf.add(jl);
   		JTextField jtf=new JTextField();
   		jtf.setPreferredSize(new Dimension(200,30));
   		jf.add(jtf);
   		//JButton jb=new JButton("");
   		jf.setVisible(true);
   	}
}