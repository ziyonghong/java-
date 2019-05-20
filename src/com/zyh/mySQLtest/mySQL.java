package com.zyh.mySQLtest;
import java.sql.*;
public class mySQL {
	public static void main(String[] args) {
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","root");
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from stu");
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
