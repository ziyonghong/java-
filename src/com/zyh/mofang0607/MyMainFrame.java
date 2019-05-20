package com.zyh.mofang0607;

import javax.swing.table.*;
import java.util.*;
import java.applet.Applet ;
import java.awt.*;
import java.awt.BorderLayout ;
import com.sun.j3d.utils.universe.SimpleUniverse ;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame.*;
import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer ;

class MyMainFrame extends JFrame 
{
    
    public TotlePanel totlePanel=new TotlePanel();
    
    public MyMainFrame()
    {
        
        
        
        JMenu gameMenu=new JMenu("��Ϸ");
        JMenuItem newGameMenuItem=new JMenuItem("����Ϸ");
        JMenuItem dakaiMenuItem=new JMenuItem("����Ϸ״̬");
        JMenuItem saveMenuItem=new JMenuItem("������Ϸ״̬");
        JMenuItem exitMenuItem=new JMenuItem("�˳���Ϸ");
        
        JMenu zhuangTaiMenu=new JMenu("״̬���ݱ�");
        JMenuItem useMenuItem=new JMenuItem("ʹ���ڱ����޸ĺ��״̬����");
        
        JMenu helpTaiMenu=new JMenu("����");
        JMenuItem shiYongMenuItem=new JMenuItem("ʹ��˵��");
        JMenuItem qiuJieMenuItem=new JMenuItem("������");
        JMenuItem zuoZeMenuItem=
        new JMenuItem("��������");
        
        gameMenu.add(newGameMenuItem);
        gameMenu.add(dakaiMenuItem);
        gameMenu.add(saveMenuItem);
        gameMenu.add(exitMenuItem);
        
        zhuangTaiMenu.add(useMenuItem);
        
        helpTaiMenu.add(shiYongMenuItem);
        helpTaiMenu.add(qiuJieMenuItem);
        helpTaiMenu.add(zuoZeMenuItem);
        
        JMenuBar aJMenuBar=new JMenuBar();
        aJMenuBar.add(gameMenu);
        aJMenuBar.add(zhuangTaiMenu);
        aJMenuBar.add(helpTaiMenu);
        
        setJMenuBar(aJMenuBar);
        
        
        
        //	table.getValueAt ();
        
        useMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                MofangStatusMessage newMofangStatusMessage=new MofangStatusMessage("new");
                JTable table=totlePanel.table ;
                BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                
                
                for(int i=0;i<27;i++)
                {
                    int l=i%3 ;
                    int j=(i/3)%3 ;
                    int k=(i/3)/3 ;
                    
                    String c1=(String)table.getValueAt(i,1);
                    aBranchGroup3.blockBianHaoZiDingYi[k][j][l]=Integer.parseInt(c1);
                    
                    String c2=(String)table.getValueAt(i,2);
                    StringTokenizer st2=new StringTokenizer(c2);
                    
                    newMofangStatusMessage.dataMessage[k][j][l].blockCenter.x=Integer.parseInt(st2.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockCenter.y=Integer.parseInt(st2.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockCenter.z=Integer.parseInt(st2.nextToken());
                    
                    String c3=(String)table.getValueAt(i,3);
                    StringTokenizer st3=new StringTokenizer(c3);
                    
                    newMofangStatusMessage.dataMessage[k][j][l].blockEx.x=Integer.parseInt(st3.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockEx.y=Integer.parseInt(st3.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockEx.z=Integer.parseInt(st3.nextToken());
                    
                    String c4=(String)table.getValueAt(i,4);
                    StringTokenizer st4=new StringTokenizer(c4);
                    
                    newMofangStatusMessage.dataMessage[k][j][l].blockEy.x=Integer.parseInt(st4.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockEy.y=Integer.parseInt(st4.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockEy.z=Integer.parseInt(st4.nextToken());
                    
                    String c5=(String)table.getValueAt(i,5);
                    StringTokenizer st5=new StringTokenizer(c5);
                    
                    newMofangStatusMessage.dataMessage[k][j][l].blockEz.x=Integer.parseInt(st5.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockEz.y=Integer.parseInt(st5.nextToken(","));
                    newMofangStatusMessage.dataMessage[k][j][l].blockEz.z=Integer.parseInt(st5.nextToken());
                    
                }
                
                MoFang.aMofangStatusMessage.setMofangStatusMessage(newMofangStatusMessage);
                MoFang.aMofangStatusMessage.outToATable();
                //BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                aBranchGroup3.setStatus(MoFang.aMofangStatusMessage.dataMessage);
                aBranchGroup3.ziDingYiBianHaoToAllBlock();
                
                
                JOptionPane.showMessageDialog(null,"�Ѿ���������޸ĵ�����");
                
            }
        }
        );
        
        
        
        
        newGameMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                MofangStatusMessage newMofangStatusMessage=new MofangStatusMessage("new");
                
                MoFang.aMofangStatusMessage.setMofangStatusMessage(newMofangStatusMessage);
                MoFang.aMofangStatusMessage.outToATable();
                BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                aBranchGroup3.setStatus(MoFang.aMofangStatusMessage.dataMessage);
                
                JOptionPane.showMessageDialog(null,"�ѿ�ʼ��ħ��");
                
            }
        }
        );
        
        
        saveMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser chooser=new JFileChooser();
                int returnVal=chooser.showSaveDialog(totlePanel);
                if(returnVal==JFileChooser.APPROVE_OPTION)
                {
                    System.out.println("You chose to save this file: "+
                    chooser.getSelectedFile().getName());
                    
                    try 
                    {
                        FileOutputStream ostream=new FileOutputStream(chooser.getSelectedFile());
                        ObjectOutputStream p=new ObjectOutputStream(ostream);
                        p.writeObject(MoFang.aMofangStatusMessage);
                        p.flush();
                        p.close();
                        ostream.close();
                        
                    }
                    catch(Exception ee)
                    {
                        ee.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,"�ѱ���״̬���ļ�:"+chooser.getSelectedFile().getPath()+chooser.getSelectedFile().getName(),"����״̬�ļ�...",1);
                    
                }
                
            }
        }
        );
        
        dakaiMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser chooser=new JFileChooser();
                int returnVal=chooser.showOpenDialog(totlePanel);
                if(returnVal==JFileChooser.APPROVE_OPTION)
                {
                    System.out.println("You chose to open this file: "+
                    chooser.getSelectedFile().getName());
                    
                    try 
                    {
                        FileInputStream istream=new FileInputStream(chooser.getSelectedFile());
                        ObjectInputStream p=new ObjectInputStream(istream);
                        
                        MofangStatusMessage newMofangStatusMessage=(MofangStatusMessage)p.readObject();
                        
                        MoFang.aMofangStatusMessage.setMofangStatusMessage(newMofangStatusMessage);
                        MoFang.aMofangStatusMessage.outToATable();
                        BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                        aBranchGroup3.setStatus(MoFang.aMofangStatusMessage.dataMessage);
                        
                        
                        p.close();
                        istream.close();
                        
                        
                    }
                    catch(Exception ee)
                    {
                        ee.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,"�Ѵ�״̬�ļ�:"+chooser.getSelectedFile().getPath()+chooser.getSelectedFile().getName(),"��״̬�ļ�...",1);
                    
                }
            }
        }
        );
        
        
        shiYongMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                try 
                {
                    Runtime r=Runtime.getRuntime();
                    Process p=r.exec("cmd.exe /c start ʹ��˵��.doc");
                }
                catch(Exception ee)
                {
                }
                
            }
        }
        );
        
        qiuJieMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                try 
                {
                    Runtime r=Runtime.getRuntime();
                    Process p=r.exec("cmd.exe /c start ������.doc");
                }
                catch(Exception ee)
                {
                }
            }
        }
        );
        
        exitMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                System.exit(0);
            }
        }
        );
        
        zuoZeMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // "����"�Ի���Ĵ���
                JDialog aboutDialog=new JDialog();
                //-------------------------
                aboutDialog.setTitle("����");
                
                Container con=aboutDialog.getContentPane();
                
                // Swing ��ʹ��html���
                Icon icon=new ImageIcon("smile.gif");
                JLabel aboutLabel=new JLabel("<html><b><font size=5>"+
                "<center>ħ��-java3D"+"<br>����Ф(���ϴ�ѧ-2005)<br>QQ:77690139,<br>bazhonglixiao@163.com",JLabel.CENTER);
                con.add(aboutLabel,BorderLayout.CENTER);
                
                aboutDialog.setSize(450,225);
                aboutDialog.setLocation(300,300);
                aboutDialog.addWindowListener(new WindowAdapter()
                {
                    public void WindowClosing(WindowEvent e)
                    {
                        dispose();
                    }
                }
                )
                
                ;
                //----------------
                
                aboutDialog.show();
                
            }
        }
        );
        
        
        //======================
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        //c.setLayout(null);
        //totlePanel.coloo
        
        JPanel aPanel=new JPanel();
        aPanel.setLayout(new BorderLayout());
        aPanel.add(totlePanel,BorderLayout.CENTER);
        c.add(aPanel,BorderLayout.CENTER);
        
        
        
        
        
        
        
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.exit(0);
            }
        }
        );
        
        setTitle("java3Dħ�����԰�");
        
        
    }
    public static void main(String args[])
    {
        MyMainFrame theMainFrame=new MyMainFrame();
        theMainFrame.show();
    }
    
}





class TotlePanel extends JPanel 
{
    
    JTabbedPane tab=new JTabbedPane(JTabbedPane.TOP);
    
    JTextArea textPane=new JTextArea();
    JPanel tablePane=new JPanel();
    JPanel tablePane1=new JPanel();
    
    
    JTable table=new JTable();
    JTable table1=new JTable();
    JTable table2=new JTable();
    TotlePanel()
    {
        table.setRowHeight(20);
        table1.setRowHeight(20);
        table2.setRowHeight(20);
        this.setLayout(null);
        
        
        
        JScrollPane jScrollPaneOfTablePane=new JScrollPane(table);
        JScrollPane jScrollPaneOfTablePane1=new JScrollPane(table1);
        
        JPanel table2JPanel=new JPanel();
        JScrollPane jScrollPaneOfTablePane2=new JScrollPane(table2JPanel);
        
        JPanel table2JPanel2=new JPanel();
        table2JPanel2.add(table2,BorderLayout.CENTER);
        
        JTableHeader aTableHeader=table2.getTableHeader();
        aTableHeader.setSize(1000,40);
        
        table2JPanel.setLayout(new BorderLayout());
        table2JPanel.add(aTableHeader,BorderLayout.NORTH);
        table2JPanel.add(table2JPanel2);
        //��ͱ�ͷ���ܼ���ͬһ������У�������ס��
        
        
        
        JScrollPane jScrollPaneOfTextPane=new JScrollPane(textPane);
        jScrollPaneOfTextPane.setCursor(new Cursor(12));
        
        tab.addTab("0-ħ��״̬���ݱ�",jScrollPaneOfTablePane);
        tab.addTab("�ı���",jScrollPaneOfTextPane);
        tab.addTab("1-����仯��",jScrollPaneOfTablePane1);
        tab.addTab("2-���ڷ����������",jScrollPaneOfTablePane2);
        tab.setBounds(0,0,600,600);
        
        tab.setTabLayoutPolicy(0);
        this.add(tab);
        
    }
}
