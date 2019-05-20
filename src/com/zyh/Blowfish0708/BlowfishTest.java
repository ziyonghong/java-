package com.zyh.Blowfish0708;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public  class BlowfishTest{ 
   	public  static void main(String [] args){
   	//实际应用中这里应是个随机数
   	BlowfishTest bt=new BlowfishTest();
   		//bt.showUI();
   	String keyString = "hello cnjbb!";	
   	String testString = "独孤求胜";
    System.out.println("加密前**************\n"+"testString = "+testString);
    Blowfish  crypt = new Blowfish(keyString);
	System.out.println("开始加密");      
    testString = crypt.encryptString(testString);
    System.out.println("加密之后**************\n"+"testString = "+testString);
    System.out.println("开始解密");
    testString = crypt.decryptString(testString);
    System.out.println("解密之后**************\n"+"testString = "+testString);
    } 
   	public void showUI(){
   		JFrame jf=new JFrame();
   		jf.setSize(500, 500);
   		jf.setTitle("Blowfish");
   		jf.setDefaultCloseOperation(3);
   		jf.setLocationRelativeTo(null);
   		FlowLayout flow=new FlowLayout();
   		jf.setLayout(flow);
   		JLabel jl=new JLabel("输入加密前文字：");
   		jf.add(jl);
   		JTextField jtf=new JTextField();
   		jtf.setPreferredSize(new Dimension(200,30));
   		jf.add(jtf);
   		//JButton jb=new JButton("");
   		jf.setVisible(true);
   	}
}