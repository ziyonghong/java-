package com.zyh.weather0707;

/*
 * AboutPanel.java
 *
 * Created on 2007年9月8日, 上午9:38
 */

import javax.swing.*;

public class AboutPanel extends javax.swing.JPanel {
    private JDialog pFr;
    /** Creates new form AboutPanel */
    public AboutPanel(String label , String taText , Icon iconLab , JDialog parentFr) {
        initComponents();
        pFr = parentFr;
        lab_icon.setText(label);
        lab_icon.setIcon(iconLab);
        ta_infor.setText(taText);
    }
    
  
    // <editor-fold defaultstate="collapsed" desc=" 生成的代码 ">//GEN-BEGIN:initComponents
    private void initComponents() {
        lab_icon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_infor = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        setVerifyInputWhenFocusTarget(false);
        lab_icon.setBackground(new java.awt.Color(255, 255, 255));
        lab_icon.setText(".");
        lab_icon.setFocusable(false);
        lab_icon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lab_icon.setMaximumSize(null);
        lab_icon.setMinimumSize(null);
        lab_icon.setPreferredSize(null);
        lab_icon.setRequestFocusEnabled(false);
        lab_icon.setVerifyInputWhenFocusTarget(false);
        add(lab_icon, java.awt.BorderLayout.NORTH);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(134, 48));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(134, 48));
        ta_infor.setColumns(5);
        ta_infor.setEditable(false);
        ta_infor.setRows(2);
        ta_infor.setTabSize(4);
        ta_infor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ta_infor.setFocusable(false);
        ta_infor.setMaximumSize(null);
        ta_infor.setMinimumSize(null);
        ta_infor.setOpaque(false);
        ta_infor.setPreferredSize(null);
        ta_infor.setRequestFocusEnabled(false);
        ta_infor.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(ta_infor);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setText("\u77e5\u9053\u4e86");
        jButton1.setPreferredSize(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        add(jButton1, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO 将在此处添加您的处理代码：
        pFr.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // 变量声明 - 不进行修改//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab_icon;
    private javax.swing.JTextArea ta_infor;
    // 变量声明结束//GEN-END:variables
    
}
