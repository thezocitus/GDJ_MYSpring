package com.winter.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {

public static Connection getConnetor() throws Exception {
		
		String user="user01";
		String password="user01";
//		String url="3.36.131.0:1521"
		String url="jdbc:oracle:thin:@3.35.207.180:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
			//1.driver를 메모리에 로딩(객체생성) to loaded dirver at memory; 
		
			Class.forName(driver);
			//2. DB연결 i in a vionet circle is meaning Interface;
			Connection con = DriverManager.getConnection(url, user, password);
			
			return con;		
	}

	
	//SELECT
		public static void disConnect (ResultSet rs, PreparedStatement st, Connection con) throws Exception {
			rs.close();
			st.close();
			con.close();
		}
		//INSERT, UPDATE, DELETE
		public static void disConnect(PreparedStatement st, Connection con)throws Exception{
			st.close();
			con.close();
		}
}
