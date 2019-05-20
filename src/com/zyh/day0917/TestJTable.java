package com.zyh.day0917;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.zyh.weather0707.mainFrame;

public class TestJTable extends JFrame {
	TestJTable() {
		this.setSize(400, 300);
		JTable t = new JTable(4, 3);
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			cn = DataBase.getConnection("student");
			st = cn.createStatement();
			rs = st.executeQuery("select *from stu");
			int row = 0;
			while (rs.next()) {
				for (int i = 0; i < 6; i++) {
					t.setValueAt(rs.getObject(i), row, i - 1);
				}
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				cn.close();
			} catch (Exception e) {
			}

		}
		this.add(t);
	}

	public static void main(String[] args) {
		TestJTable w = new TestJTable();
		w.setVisible(true);
	}
}
