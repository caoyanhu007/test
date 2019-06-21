package com.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class JdbcDemo {

	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			long begin =System.currentTimeMillis();
			//建立连接
			conn =DriverManager.getConnection("jdbc:mysql://localhost/cyh_temp?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
			long end =System.currentTimeMillis();
			System.out.println("建立连接耗时："+(end-begin)+"ms");
			
			//执行sql语句
			
			/*Statement statement =con.createStatement();//实际开发很少用Statement，存在SQL注入风险
			String sql ="INSERT INTO user(userName, password, age, reg_time) VALUES ('赵六', '123', 25, now())";
			statement.execute(sql);*/
			
			/*String sql = "INSERT INTO user(userName, password, age, reg_time) VALUES (?, ?, ?, ?)";
			ps =con.prepareStatement(sql);*/
			
			/*ps.setString(1, "小七");//索引从1开始，非0开始
			ps.setInt(2, 123);
			ps.setInt(3, 22);
			ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));*/
			
			/*ps.setObject(1, "小七");
			ps.setObject(2, 123);
			ps.setObject(3, 22);
			ps.setObject(4, new java.sql.Date(System.currentTimeMillis()));
			ps.execute();*/
			
			/*
			 * 总结：
			 * execute()运行语句，返回是否有结果集
			 * executeQuery()运行select语句，返回ResultSet结果集
			 * executeUpdate()运行 insert，delete，update语句，返回更新的行数 
			 */
			String sql = "select  userName, password, reg_time from user where id >?";
			ps =conn.prepareStatement(sql);
			ps.setObject(1, 7);
			//处理返回结果
			rs =ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"==>"+rs.getString(2)+"==>"+rs.getDate(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//后开先关
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
