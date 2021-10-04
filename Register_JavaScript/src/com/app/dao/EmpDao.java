package com.app.dao;

import java.sql.*;

import com.app.model.Employee;

public class EmpDao {

	public static Connection getConnection() throws SQLException
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Found");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");
			System.out.println("Connection Established");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static int save(Employee e) throws SQLException
	{
		Connection con=EmpDao.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into empreg value(?,?,?,?)");
		
		stmt.setString(1, e.getEmpName());
		stmt.setString(2, e.getEmpPwd());
		stmt.setString(3, e.getEmpEmail());
		stmt.setString(4, e.getEmpPhone());
		
		int ans=stmt.executeUpdate();
		return ans;
	}
	
	public static ResultSet getOutput(String name, String pwd) throws SQLException
	{
		Connection con=EmpDao.getConnection();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs1= stmt.executeQuery("Select * from empreg where empname = '"+name+"'"+" and emppassword = '"+pwd+"'" );
//		System.out.println(rs1.getString(1)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
		return rs1;
		
	}
}
