package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * batch批处理
 *注意点：
 *1、事务设置手动提交
 *2、选用Statement接口
 */
public class BatchDemo {

	public static void main(String[] args) {

		Connection con =null;
		Statement st  =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost/cyh_temp?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
			con.setAutoCommit(false);//设置手动提交,默认自动提交
			long begin =System.currentTimeMillis();
			st =con.createStatement();
			for (int i = 0; i < 1000; i++) {
				st.addBatch("INSERT INTO user(userName, password, age, reg_time) VALUES ('张"+i+"', '123', 25, now())");
			}
			st.executeBatch();
			con.commit();//提交事务
			long end =System.currentTimeMillis();
			System.out.println("批处理耗时(ms):"+(end-begin));
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
