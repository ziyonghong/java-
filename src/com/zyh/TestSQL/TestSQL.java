package com.zyh.TestSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSQL {
	public static void main(String[] args) {
		String u="aaa";
		String p="bbb";
		ResultSet rs=null;
		Statement st=null;
		Connection cn=null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			 cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qq","root","root");
			 PreparedStatement ps=cn.prepareStatement("select * from userinfo where name=? and pwd=?");
			 ps.setString(1, u);
			 ps.setString(2, p);
			 rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("验证成功");
			}
				else{
					System.out.println("验证失败");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				rs.close();	
				st.close();
				cn.close();
	         }catch(Exception e){}
		}
	}
}
