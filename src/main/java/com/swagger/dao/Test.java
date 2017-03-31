package com.swagger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Test {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		String sql = "select * from seckill";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zhuw?useUnicode=true&characterEncoding=utf8", "root","1234");
			System.out.println(connection);
			statement = connection.createStatement();
			ResultSet executeQuery = statement.executeQuery(sql);
			while(executeQuery.next()){
				String string = executeQuery.getString("name");
				System.out.println(string);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
