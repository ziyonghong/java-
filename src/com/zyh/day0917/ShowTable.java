package com.zyh.day0917;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ShowTable extends JFrame implements ActionListener{
	JComboBox Database = new JComboBox();
	JList lstTble = new JList();

	public ShowTable() {
		// TODO Auto-generated constructor stub
		this.setSize(200, 300);
		JScrollPane sp = new JScrollPane(lstTble);
		//注册事件
		Database.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.add(Database, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		
		//添加数据库名字到下拉列表框中
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			cn=DataBase.getConnection();
			st=cn.createStatement();
			rs=st.executeQuery("show Databases");
			while(rs.next()){
				Database.addItem(rs.getString(l));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rs.close();
			st.close();
			cn.close();
		}
		
	}

	public static void main(String[] args) {
		ShowTable w = new ShowTable();
		w.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String database=(String)Database.getSelectedItem();
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			cn=DataBase.getConnection(database);
			st=cn.createStatement();
			rs=st.executeQuery("show table");
			Vector v=new Vector();
			
			while(rs.next()){
				v.add(rs.getString(l));
			}
			lstTble.setListData(v);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			rs.close();
			st.close();
			cn.close();
		}
	}
}
