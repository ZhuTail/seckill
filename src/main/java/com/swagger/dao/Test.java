package com.swagger.dao;

import java.sql.*;


public class Test {

	public static void main(String[] args) {
		Connection connection = null;
		String sql = "select * from seckill";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://192.168.3.18:3306/seckill?useUnicode=true&characterEncoding=utf8", "seckill","");
			System.out.println(connection);
            Statement statement = connection.createStatement();
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
