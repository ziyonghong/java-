package com.zyh.weather0707;


import java.io.IOException;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import java.awt.*;

public class mainFrame extends javax.swing.JFrame {
    private ImageIcon icon1;
    private Map<String,String> weatherData;
    private Updater update;
    private String imgPath;
    private String city;
    private Timer autoUpdatet;
    private Pattern cityP;
//    private boolean first = true;
    /** Creates new form mainFrame */
    public mainFrame() {
        cityP = Pattern.compile("[^\\d\\w\\p{Punct}]{2,10}");
        try
            {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            }catch(Exception e)
            {
            e.printStackTrace();
            }
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( (int)(screenSize.width / 3) ,(int)(screenSize.height / 3));
        progress_net.setIndeterminate(true);
        //for component

        ArrayList icon = new ArrayList();
        try {
            icon.add(new ImageIcon(new URL("http://www.weather.com.cn/images/sun.gif")).getImage());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        this.setIconImages(icon);        
        this.setResizable(false);
        this.setVisible(true);
        
        
        imgPath = "http://weather.tq121.com.cn/images/";
        weatherData = new HashMap<String,String>();
        tf_city.setText(initCity());      
        
        autoUpdatet = new Timer(weatherData , this , tf_city , progress_net ,jTabbedPane1);                       
    }
    
    public void online(){
        autoUpdatet.start();
    }
    
    // <editor-fold defaultstate="collapsed" desc=" 生成的代码 ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lab_temperature = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_hint = new javax.swing.JTextArea();
        jPanel1_weather = new javax.swing.JPanel();
        lab_place = new javax.swing.JLabel();
        lab_reportTime = new javax.swing.JLabel();
        jPanel4_img = new javax.swing.JPanel();
        lab_img1 = new javax.swing.JLabel();
        lab_img2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel2_left_up = new javax.swing.JPanel();
        lab_future2 = new javax.swing.JLabel();
        lab_future2_img2 = new javax.swing.JLabel();
        lab_future2_img1 = new javax.swing.JLabel();
        lab_future2_temperature = new javax.swing.JLabel();
        jPanel2_right_up = new javax.swing.JPanel();
        lab_future3 = new javax.swing.JLabel();
        lab_future3_temperature = new javax.swing.JLabel();
        lab_future3_img1 = new javax.swing.JLabel();
        lab_future3_img2 = new javax.swing.JLabel();
        jPanel2_left_down = new javax.swing.JPanel();
        lab_future4_img2 = new javax.swing.JLabel();
        lab_future4_img1 = new javax.swing.JLabel();
        lab_future4 = new javax.swing.JLabel();
        lab_future4_temperature = new javax.swing.JLabel();
        jPanel2_right_down = new javax.swing.JPanel();
        lab_future5_img2 = new javax.swing.JLabel();
        lab_future5_img1 = new javax.swing.JLabel();
        lab_future5 = new javax.swing.JLabel();
        lab_future5_temperature = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        bt_city = new javax.swing.JButton();
        tf_city = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lab_infor = new javax.swing.JLabel();
        bt_about = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lab_ver = new javax.swing.JLabel();
        progress_net = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("寻儿天气");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setResizable(false);
        lab_temperature.setFont(new java.awt.Font("Dialog", 0, 14));
        lab_temperature.setText("...");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ta_hint.setColumns(21);
        ta_hint.setEditable(false);
        ta_hint.setLineWrap(true);
        ta_hint.setRows(5);
        ta_hint.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));
        ta_hint.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(ta_hint);

        lab_place.setFont(new java.awt.Font("Dialog", 1, 18));
        lab_place.setText("...");

        lab_reportTime.setText("...");

        javax.swing.GroupLayout jPanel1_weatherLayout = new javax.swing.GroupLayout(jPanel1_weather);
        jPanel1_weather.setLayout(jPanel1_weatherLayout);
        jPanel1_weatherLayout.setHorizontalGroup(
            jPanel1_weatherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_weatherLayout.createSequentialGroup()
                .addGroup(jPanel1_weatherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_reportTime)
                    .addGroup(jPanel1_weatherLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lab_place, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1_weatherLayout.setVerticalGroup(
            jPanel1_weatherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_weatherLayout.createSequentialGroup()
                .addComponent(lab_reportTime)
                .addGap(18, 18, 18)
                .addComponent(lab_place)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lab_img1.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("http://weather.tq121.com.cn/images/a1.gif")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        lab_img1.setToolTipText("\u672a\u676512~24\u5c0f\u65f6");
        lab_img1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lab_img1.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_img1.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_img1.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_img2.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("http://weather.tq121.com.cn/images/a1.gif")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        lab_img2.setToolTipText("\u672a\u676512\u5c0f\u65f6");
        lab_img2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lab_img2.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_img2.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_img2.setPreferredSize(new java.awt.Dimension(70, 65));

        javax.swing.GroupLayout jPanel4_imgLayout = new javax.swing.GroupLayout(jPanel4_img);
        jPanel4_img.setLayout(jPanel4_imgLayout);
        jPanel4_imgLayout.setHorizontalGroup(
            jPanel4_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4_imgLayout.createSequentialGroup()
                .addComponent(lab_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_img1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4_imgLayout.setVerticalGroup(
            jPanel4_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4_imgLayout.createSequentialGroup()
                .addGroup(jPanel4_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lab_img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_img2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1_weather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(lab_temperature, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1_weather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_temperature)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        );
        jTabbedPane1.addTab("今天天气", jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jPanel2_left_up.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 51)));
        jPanel2_left_up.setVerifyInputWhenFocusTarget(false);
        lab_future2.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future2.setText("_");

        lab_future2_img2.setToolTipText("\u672a\u676512~24\u5c0f\u65f6");
        lab_future2_img2.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future2_img2.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future2_img2.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_future2_img1.setToolTipText("\u672a\u676512\u5c0f\u65f6");
        lab_future2_img1.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future2_img1.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future2_img1.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_future2_temperature.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future2_temperature.setText("...");

        javax.swing.GroupLayout jPanel2_left_upLayout = new javax.swing.GroupLayout(jPanel2_left_up);
        jPanel2_left_up.setLayout(jPanel2_left_upLayout);
        jPanel2_left_upLayout.setHorizontalGroup(
            jPanel2_left_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_left_upLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2_left_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2_left_upLayout.createSequentialGroup()
                        .addComponent(lab_future2_img1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lab_future2_img2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lab_future2)
                    .addComponent(lab_future2_temperature))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2_left_upLayout.setVerticalGroup(
            jPanel2_left_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_left_upLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab_future2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_future2_temperature)
                .addGap(9, 9, 9)
                .addGroup(jPanel2_left_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lab_future2_img2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_future2_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2_left_upLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lab_future2_img1, lab_future2_img2});

        jPanel2.add(jPanel2_left_up);

        jPanel2_right_up.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 51)));
        jPanel2_right_up.setVerifyInputWhenFocusTarget(false);
        lab_future3.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future3.setText("_");

        lab_future3_temperature.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future3_temperature.setText("...");

        lab_future3_img1.setToolTipText("\u672a\u676512\u5c0f\u65f6");
        lab_future3_img1.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future3_img1.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future3_img1.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_future3_img2.setToolTipText("\u672a\u676512~24\u5c0f\u65f6");
        lab_future3_img2.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future3_img2.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future3_img2.setPreferredSize(new java.awt.Dimension(70, 65));

        javax.swing.GroupLayout jPanel2_right_upLayout = new javax.swing.GroupLayout(jPanel2_right_up);
        jPanel2_right_up.setLayout(jPanel2_right_upLayout);
        jPanel2_right_upLayout.setHorizontalGroup(
            jPanel2_right_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_right_upLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2_right_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_future3_temperature)
                    .addGroup(jPanel2_right_upLayout.createSequentialGroup()
                        .addComponent(lab_future3_img1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_future3_img2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lab_future3))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2_right_upLayout.setVerticalGroup(
            jPanel2_right_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2_right_upLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab_future3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_future3_temperature)
                .addGap(8, 8, 8)
                .addGroup(jPanel2_right_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_future3_img2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_future3_img1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2.add(jPanel2_right_up);

        jPanel2_left_down.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 51)));
        jPanel2_left_down.setVerifyInputWhenFocusTarget(false);
        lab_future4_img2.setToolTipText("\u672a\u676512~24\u5c0f\u65f6");
        lab_future4_img2.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future4_img2.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future4_img2.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_future4_img1.setToolTipText("\u672a\u676512\u5c0f\u65f6");
        lab_future4_img1.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future4_img1.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future4_img1.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_future4.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future4.setText("_");

        lab_future4_temperature.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future4_temperature.setText("...");

        javax.swing.GroupLayout jPanel2_left_downLayout = new javax.swing.GroupLayout(jPanel2_left_down);
        jPanel2_left_down.setLayout(jPanel2_left_downLayout);
        jPanel2_left_downLayout.setHorizontalGroup(
            jPanel2_left_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_left_downLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2_left_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_future4_temperature)
                    .addGroup(jPanel2_left_downLayout.createSequentialGroup()
                        .addComponent(lab_future4_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_future4_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lab_future4))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2_left_downLayout.setVerticalGroup(
            jPanel2_left_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2_left_downLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2_left_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lab_future4_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2_left_downLayout.createSequentialGroup()
                        .addComponent(lab_future4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_future4_temperature)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lab_future4_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2_left_downLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lab_future4_img1, lab_future4_img2});

        jPanel2.add(jPanel2_left_down);

        jPanel2_right_down.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 51)));
        jPanel2_right_down.setVerifyInputWhenFocusTarget(false);
        lab_future5_img2.setToolTipText("\u672a\u676512~24\u5c0f\u65f6");
        lab_future5_img2.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future5_img2.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future5_img2.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_future5_img1.setToolTipText("\u672a\u676512\u5c0f\u65f6");
        lab_future5_img1.setMaximumSize(new java.awt.Dimension(70, 65));
        lab_future5_img1.setMinimumSize(new java.awt.Dimension(70, 65));
        lab_future5_img1.setPreferredSize(new java.awt.Dimension(70, 65));

        lab_future5.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future5.setText("_");

        lab_future5_temperature.setFont(new java.awt.Font("Dialog", 0, 12));
        lab_future5_temperature.setText("...");

        javax.swing.GroupLayout jPanel2_right_downLayout = new javax.swing.GroupLayout(jPanel2_right_down);
        jPanel2_right_down.setLayout(jPanel2_right_downLayout);
        jPanel2_right_downLayout.setHorizontalGroup(
            jPanel2_right_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_right_downLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2_right_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_future5_temperature)
                    .addGroup(jPanel2_right_downLayout.createSequentialGroup()
                        .addComponent(lab_future5_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lab_future5_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lab_future5))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2_right_downLayout.setVerticalGroup(
            jPanel2_right_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2_right_downLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab_future5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_future5_temperature)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2_right_downLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lab_future5_img2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(lab_future5_img1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2.add(jPanel2_right_down);

        jTabbedPane1.addTab("看最近几天的？点这里", jPanel2);

        bt_city.setText("\u6539\u53d8\u57ce\u5e02");
        bt_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cityActionPerformed(evt);
            }
        });

        tf_city.setToolTipText("\u8bf7\u5728\u8fd9\u91cc\u8f93\u5165\u4f60\u60f3\u770b\u9884\u62a5\u7684\u57ce\u5e02");
        tf_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cityActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 18));
        jLabel1.setText("\u8bf7\u8bbe\u5b9a\u4f60\u6240\u5728\u7684\u57ce\u5e02\uff1a");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tf_city, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(bt_city)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_city)
                    .addComponent(tf_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lab_infor.setFont(new java.awt.Font("Dialog", 1, 13));
        lab_infor.setText("XX Weather ");

        bt_about.setText("\u5173\u4e8e");
        bt_about.setToolTipText("\u5173\u4e8e\u4f5c\u8005 yuhui_bear");
        bt_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("宋体", 0, 10));
        jLabel2.setText("欢迎使用");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lab_infor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(bt_about))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_about)
                    .addComponent(lab_infor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(10, 10, 10))
        );

       // lab_ver.setText("0.0beta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progress_net, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(315, Short.MAX_VALUE)
                .addComponent(lab_ver)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lab_ver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress_net, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jTabbedPane1.addTab("在这里设置城市", jPanel3);

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String initCity(){
        try{
            File f = new File(".\\" , "city.txt");
            RandomAccessFile raf = new RandomAccessFile(new File(".\\" , "city.txt") ,"r");
            return raf.readUTF();
        }catch (IOException ex) {
            return "成都";
        }
    }
    
    private void updateAction(){
        city = tf_city.getText().trim();
        if(cityP.matcher(city).matches()){
            jTabbedPane1.setEnabledAt(1,false);
            jTabbedPane1.setEnabledAt(0,false);
            bt_city.setEnabled(false);
            tf_city.setEditable(false);
            new Updater("updater" , weatherData , this ,tf_city.getText().trim() , progress_net ,jTabbedPane1); 
        }else{
                new AboutJD(this , "输入的内容不对吧", "请输入中文城市名字 ：" ,"\t 大哥大姐 ,拜托！\n搞什么飞机嘛？我只认识中文.");
        }    
    }
    private void tf_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cityActionPerformed
// TODO 将在此处添加您的处理代码：
        updateAction();
    }//GEN-LAST:event_tf_cityActionPerformed

 //   private void bt_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aboutActionPerformed
// TODO 将在此处添加您的处理代码：
//        new AboutJD(this , "关于作者", null ,"  本软件完全免费，并且公开源代码供交流学习之用。\n欢迎到我的博客 hi.baidu.com/yuhui_bear 看看." 
//                , new ImageIcon(mainFrame.class.getResource("author.gif")));
 //   }//GEN-LAST:event_bt_aboutActionPerformed

    private void bt_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cityActionPerformed
         updateAction();
    }//GEN-LAST:event_bt_cityActionPerformed
    
    public  void dataUpdate(){
      String imgUrl=null;
      if(weatherData.size() >1){
          lab_place.setText(weatherData.get("city"));
          lab_reportTime.setText(weatherData.get("reportTime"));
          lab_temperature.setText(weatherData.get("day0").replaceAll("\\s?[0-9]{0,2}月[0-9]{0,2}日","未来24小时"));
          imgUrl = weatherData.get("day0_image");
          imgUrl = imgUrl.replaceAll("img\\s?src=\\\"\\.\\.images" , " ");
          imgUrl = imgUrl.replaceAll("\\s?\"\\s?width=\"[0-9]{0,2}\"\\s?" , " ");
          
            try {
                lab_img1.setIcon(new ImageIcon(
                        new URL(imgPath + imgUrl.substring(0 ,imgUrl.length()/2).trim())));
                lab_img2.setIcon(new ImageIcon(
                        new URL(imgPath + imgUrl.substring(imgUrl.length()/2, imgUrl.length()).trim())));
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
          lab_future2.setText(weatherData.get("day1").trim().substring(0,7));
          lab_future3.setText(weatherData.get("day2").trim().substring(0,7));
          lab_future4.setText(weatherData.get("day3").trim().substring(0,7));
          lab_future5.setText(weatherData.get("day4").trim().substring(0,7));
          lab_future2_temperature.setText(weatherData.get("day1").trim().substring(8));
          lab_future3_temperature.setText(weatherData.get("day2").trim().substring(8));
          lab_future4_temperature.setText(weatherData.get("day3").trim().substring(8));
          lab_future5_temperature.setText(weatherData.get("day4").trim().substring(8));
          
          ArrayList<JLabel> fillList = new ArrayList<JLabel>();
          fillList.add(lab_future2_img1);
          fillList.add(lab_future2_img2);
          fillList.add(lab_future3_img1);
          fillList.add(lab_future3_img2);
          fillList.add(lab_future4_img1);
          fillList.add(lab_future4_img2);
          fillList.add(lab_future5_img1);
          fillList.add(lab_future5_img2);
          
          int iday = 0;
          for(int i =0;i<8;i+=2){
                iday++;
                imgUrl = weatherData.get("day" + iday +"_image");
                imgUrl = imgUrl.replaceAll("img\\s?src=\\\"\\.\\.images" , " ");
                imgUrl = imgUrl.replaceAll("\\s?\"\\s?width=\"[0-9]{0,2}\"\\s?" , " ");
                try {
                fillList.get(i).setIcon(new ImageIcon(
                        new URL(imgPath + imgUrl.substring(0 ,imgUrl.length()/2).trim())));
                fillList.get(i+1).setIcon(new ImageIcon(
                        new URL(imgPath + imgUrl.substring(imgUrl.length()/2, imgUrl.length()).trim())));
                } catch (MalformedURLException ex) {
                ex.printStackTrace();
                }
          }

          for(int i =0;i<20;i++){
                  ta_hint.append(weatherData.get("detail_"+i));                 
          }
          bt_city.setEnabled(true);              
          tf_city.setEditable(true);
      }
    }
    
    // 变量声明 - 不进行修改//GEN-BEGIN:variables
    private javax.swing.JButton bt_about;
    private javax.swing.JButton bt_city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1_weather;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel2_left_down;
    private javax.swing.JPanel jPanel2_left_up;
    private javax.swing.JPanel jPanel2_right_down;
    private javax.swing.JPanel jPanel2_right_up;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel4_img;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lab_future2;
    private javax.swing.JLabel lab_future2_img1;
    private javax.swing.JLabel lab_future2_img2;
    private javax.swing.JLabel lab_future2_temperature;
    private javax.swing.JLabel lab_future3;
    private javax.swing.JLabel lab_future3_img1;
    private javax.swing.JLabel lab_future3_img2;
    private javax.swing.JLabel lab_future3_temperature;
    private javax.swing.JLabel lab_future4;
    private javax.swing.JLabel lab_future4_img1;
    private javax.swing.JLabel lab_future4_img2;
    private javax.swing.JLabel lab_future4_temperature;
    private javax.swing.JLabel lab_future5;
    private javax.swing.JLabel lab_future5_img1;
    private javax.swing.JLabel lab_future5_img2;
    private javax.swing.JLabel lab_future5_temperature;
    private javax.swing.JLabel lab_img1;
    private javax.swing.JLabel lab_img2;
    private javax.swing.JLabel lab_infor;
    private javax.swing.JLabel lab_place;
    private javax.swing.JLabel lab_reportTime;
    private javax.swing.JLabel lab_temperature;
    private javax.swing.JLabel lab_ver;
    private javax.swing.JProgressBar progress_net;
    private javax.swing.JTextArea ta_hint;
    private javax.swing.JTextField tf_city;
    // 变量声明结束//GEN-END:variables
    
}

