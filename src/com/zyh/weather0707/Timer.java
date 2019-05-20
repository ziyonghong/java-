package com.zyh.weather0707;

import java.util.*;
import javax.swing.*;

public class Timer extends Thread{
    private Map<String , String> map;
    private mainFrame mf;
    private String mplace;
    private JProgressBar pbar;
    private JTabbedPane jtp;

    public Timer(Map<String,String> fc_in , mainFrame frame , JTextField tf , JProgressBar bar , JTabbedPane jtpin) {
        map = fc_in;
        mf = frame;
        pbar = bar;
        jtp = jtpin;
        mplace = tf.getText().trim();
    }
    public void run(){
        try{
            while(true){
                new Updater("updater" , map , mf , mplace ,pbar ,jtp);
                sleep(900000);
            }
        }catch(InterruptedException ex){
            System.err.println("sleep failed");
        }
            
    }
}
