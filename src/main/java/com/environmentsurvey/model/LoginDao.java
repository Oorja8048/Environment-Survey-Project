package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.environmentsurvey.bean.LoginBean;
import com.environmentsurvey.utility.DBConnect;
import com.mysql.cj.xdevapi.Statement;

public class LoginDao {

	public boolean validateLogin(LoginBean bean) throws SQLException {
		String userName = bean.getUserName();
		String password = bean.getPassword();
		Connection con = DBConnect.getConn();
		/*
		 * String sql=
		 * "SELECT * from e_user where name=? and password=? and roleid=?";
		 * PreparedStatement preparedStatement=con.prepareStatement(sql);
		 * ResultSet rs=preparedStatement.executeQuery(); while(rs.next()) {
		 * String nameDB=rs.getString("name"); String
		 * passDB=rs.getString("pass"); Long roleIDDB=rs.getLong(roleid);
		 * if(userName.equals(nameDB) && password.equals(passDB) &&
		 * roleIDDB.equals(3)) { return true; } }
		 */
		String sql = "SELECT * from e_user where name=? and password=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getUserName());
		preparedStatement.setString(2, bean.getPassword());
		// preparedStatement.setLong(3, bean.ge);
		ResultSet resultSet = preparedStatement.executeQuery();
		boolean result = resultSet.next();
		/*
		 * while(resultSet.next()) { String name=resultSet.getString("name");
		 * String pass=resultSet.getString("password"); Long
		 * roledb=resultSet.getLong("roleid");
		 * 
		 * if(userName.equals(name) && password.equals(pass) &&
		 * roledb.equals(1)) return 1; else if(userName.equals(name) &&
		 * password.equals(pass) && roledb.equals(2)) return 2; else
		 * if(userName.equals(name) && password.equals(pass) &&
		 * roledb.equals(3)) return 3;
		 * 
		 * 
		 * }
		 */

		return result;

	}

	public String authenticate(LoginBean bean) throws SQLException {
		String userName = bean.getUserName();
		String password = bean.getPassword();
		System.out.println("username:"+userName+"password"+password);
		
		Connection con=null;
		java.sql.Statement statement = null;
	    ResultSet resultSet = null;
	    String nameDB="";
	    String passDB="";
	    Long roleIDDB=null;
	   // int status=0;
	    con=DBConnect.getConn();
	    statement=con.createStatement();
	    resultSet=statement.executeQuery("SELECT * from e_user where name='"+userName+"' and password='"+password+"'");
		//String sql = "SELECT * from e_user where name='"+userName+"' and password='"+password+"'?";
		while (resultSet.next()) {
			 nameDB = resultSet.getString("name");
			 passDB = resultSet.getString("password");
			 roleIDDB = resultSet.getLong("roleid");
			 int status=resultSet.getInt("status");
			 /*boolean a=roleIDDB.equals(1);
			 System.out.println(a);*/
			 
			System.out.println("name"+nameDB+passDB+roleIDDB+status);
			if (userName.equals(nameDB) && password.equals(passDB) && roleIDDB==3 && status==1)
				//System.out.println("insert if student statement");
				return "Student_Role";
			else if (userName.equals(nameDB) && password.equals(passDB) && roleIDDB==1)
				//System.out.println("insert if admin statement");
				return "Admin_Role";
			
				else if(userName.equals(nameDB) && password.equals(passDB) && roleIDDB==2)
				
			return "Faculty_Role";
				}
		
			System.out.println("after role dao");
			return "invalid";
		
		
		}
	
}

