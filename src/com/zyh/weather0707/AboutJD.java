package com.zyh.weather0707;

/*
 * AboutJD.java
 * Download by http://www.codefans.net
 * Created on 2007年9月4日, 上午9:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class AboutJD extends JDialog {
    AboutPanel mp ;
    public AboutJD(JFrame jf , String title ,String label , String information) {
        super(jf,title,true);
        mp = new AboutPanel(label ,information ,null ,this);       
        showAbout();
    }
    public AboutJD(JFrame jf , String title ,String label , String information , Icon icon1){
        super(jf,title ,true);
        mp = new AboutPanel(label ,information ,icon1 ,this);
        showAbout();
    }    
    
    public void showAbout(){
        this.setSize(340,130);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Toolkit.getDefaultToolkit().beep();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( (int)(screenSize.width / 3 + 30) ,(int)(screenSize.height / 3 +30));
        this.add(mp);
        this.setVisible(true);
    }
}