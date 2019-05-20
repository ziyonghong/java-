package com.zyh.weather0707;



import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;
import java.awt.image.*;
/**
 *
 * @author yuhui_bear
 */
public class Updater extends Thread{
    private WebFilter web;
    private Map<String,String> forecast;
    private mainFrame mf;
    private String url;
    private String oCity;
    private JProgressBar jpb;
    private JTabbedPane jtp;
    /** Creates a new instance of ContentAdapter */
    public Updater(String name ,Map<String,String> fc_in , mainFrame frame , String place , JProgressBar jpbin ,JTabbedPane jtpin) {
        super(name);
        jpb = jpbin;
        jtp = jtpin;
        oCity = place;
        url = setUrl(oCity);
        web=new WebFilter( url,"src");
        forecast = fc_in;
        mf = frame;
        this.setDaemon(true);
        this.setPriority(Thread.MIN_PRIORITY);

        jpb.setVisible(true);
        this.start();
    }
    
    public void run() {        
        for(int i =0;i<1;i++){
            getWebFailed:
                try{web.getData();
                }catch (UnknownHostException ex2){
                	System.out.println("lala");
                   // new AboutJD (mf ,"���粻ͨ��" , "�ϴ� �����ǲ��Ǳ��˼������ˣ�","\t������ϣ�����������粻ͨ������."
                   //         ,new ImageIcon(mainFrame.class.getResource("crazy.gif")));
                    break getWebFailed;
                }catch (SocketTimeoutException stoute){
                    new AboutJD (mf ,"����̫����" , "�ϴ� ��̫���ˣ�������������ż������ȥ����"
                            ,"������Ĵ������ӵ�������� ��ʱ�޷�����㹻����\n����ڴ�������Ժ�����." 
                            ,new ImageIcon(mainFrame.class.getResource("sad.gif")));
                }catch(IOException ex){
                    try {
                        this.sleep(8000);
                        web.getData();
                    } catch(IOException ioe){
                        break;
                    }catch (InterruptedException exi) {
                        System.err.println("��������ʱ�������ش��󣡣���");
                        break;
                    }
                }
            sendData();
            mf.dataUpdate();
            saveCity();
            jpb.setVisible(false);
            jtp.setEnabledAt(0,true);
            jtp.setEnabledAt(1,true);
            jtp.setSelectedIndex(0);
        }
    }
    private void saveCity(){
        try {
            RandomAccessFile out = new RandomAccessFile(new File(".\\","city.txt") ,"rw");
            out.writeUTF(oCity);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        
    }
    private synchronized void sendData(){
        web.adapted(forecast);        
    }
    
    private String setUrl(String str){
        try {
//            String tt = URLEncoder.encode("�ɶ�","GBK");
            return "http://weather.tq121.com.cn/detail.php?city="+URLEncoder.encode(str , "GBK")+"&submit=%B3%C7%CA%D0%CB%D1%CB%F7";
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return "http://weather.tq121.com.cn/detail.php?city=%B3%C9%B6%BC&submit=%B3%C7%CA%D0%CB%D1%CB%F7";            
        }
    }
}


