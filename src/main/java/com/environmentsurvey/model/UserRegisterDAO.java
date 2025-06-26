package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.environmentsurvey.bean.SurveyStudentBean;
import com.environmentsurvey.bean.UserBean;
import com.environmentsurvey.utility.DBConnect;

public class UserRegisterDAO {

	public boolean addUser(UserBean bean)
	{
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO E_USER (ID,NAME,ROLL_NO,CLASS,SPECIFICATION,SECTION,ROLEID,PASSWORD,STATUS,DATEOFADMISSION) VALUES (NULL,?,?,?,?,?,?,?,?,?)";
		int i=0;
		try {
			System.out.println(sql.toString());
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, bean.getName());
			preparedStatement.setString(2, bean.getRoll());
			preparedStatement.setString(3, bean.getUserclass());
			preparedStatement.setString(4, bean.getSpecification());
			preparedStatement.setString(5, bean.getSection());
			preparedStatement.setLong(6, bean.getRoleid());
			preparedStatement.setString(7, bean.getPassword());
			//preparedStatement.setDate(7, bean.getDoa());
			preparedStatement.setInt(8, bean.getStatus());
			preparedStatement.setString(9, bean.getDoa());
			 i=preparedStatement.executeUpdate();
			 System.out.println("here:");
			
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(i==0)
		 {
			 return false;
		 }else
		 {
		return true;
		 }
		
	}
	public boolean addFaculty(UserBean bean)
	{
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO E_USER (ID,NAME,ROLL_NO,CLASS,SPECIFICATION,SECTION,ROLEID,PASSWORD,DATEOFADMISSION) VALUES (NULL,?,?,?,?,?,?,?,?)";
		int i=0;
		try {
			System.out.println("inside nw function");
			System.out.println(sql.toString());
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, bean.getName());
			preparedStatement.setString(2, bean.getRoll());
			preparedStatement.setString(3, bean.getUserclass());
			preparedStatement.setString(4, bean.getSpecification());
			preparedStatement.setString(5, bean.getSection());
			preparedStatement.setLong(6, bean.getRoleid());
			preparedStatement.setString(7, bean.getPassword());
			//preparedStatement.setDate(7, bean.getDoa());
			//preparedStatement.setInt(8, bean.getStatus());
			preparedStatement.setString(8, bean.getDoa());
			 i=preparedStatement.executeUpdate();
			 System.out.println("here:");
			
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(i==0)
		 {
			 return false;
		 }else
		 {
		return true;
		 }
		
	}
	public static int updateUser(UserBean bean) throws SQLException {
		// TODO Auto-generated method stub
		int status=0;
		Connection con=DBConnect.getConn();
		String sql="UPDATE E_USER SET NAME=?,ROLL_NO=?,CLASS=?,SPECIFICATION=?,SECTION=?,PASSWORD=?,DATEOFADMISSION=? WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		//preparedStatement.setInt(1, bean.getId());
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(2, bean.getRoll());
		preparedStatement.setString(3,bean.getUserclass() );
		preparedStatement.setString(4, bean.getSpecification());
		preparedStatement.setString(5, bean.getSection());
		
		preparedStatement.setString(6, bean.getPassword());
		preparedStatement.setString(7, bean.getDoa());
		preparedStatement.setInt(8, bean.getId());
		
		status=preparedStatement.executeUpdate();
		System.out.println(status);
		if(status==0)
		{
			return 0;
		}
		return 1;
	}
	
	public static UserBean getRecordbyId(int id) throws SQLException {
		UserBean bean=null;
		Connection con=DBConnect.getConn();
		String sql="SELECT * FROM E_USER WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset=preparedStatement.executeQuery();
		while(resultset.next())
		{
			bean=new UserBean();
			bean.setId(resultset.getInt(1));
			
			bean.setName(resultset.getString(2));
			
			bean.setRoll(resultset.getString(3));
			
			bean.setUserclass(resultset.getString(4));
			
			bean.setSpecification(resultset.getString(5));
			
			bean.setSection(resultset.getString(6));
			bean.setPassword(resultset.getString(8));
			bean.setStatus(resultset.getInt(9));
			bean.setDoa(resultset.getString(10));
			
		}
		return bean;
	}
	public static int editStudentByadmin(UserBean bean) throws SQLException { //edit by admin
		// TODO Auto-generated method stub
		int status=0;
		Connection con=DBConnect.getConn();
		String sql="UPDATE E_USER SET ROLL_NO=?,CLASS=?,SPECIFICATION=?,SECTION=?,DATEOFADMISSION=? WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		//preparedStatement.setInt(1, bean.getId());
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(1, bean.getRoll());
		preparedStatement.setString(2,bean.getUserclass() );
		preparedStatement.setString(3, bean.getSpecification());
		preparedStatement.setString(4, bean.getSection());
		preparedStatement.setString(5, bean.getDoa());
		//preparedStatement.setString(6, bean.getPassword());
		preparedStatement.setInt(6, bean.getId());
		status=preparedStatement.executeUpdate();
		System.out.println("status "+status);
		if(status==0)
		{
			return 0;
		}
		return 1;
	}

	public int updateStatus(UserBean bean) throws SQLException { //accept by admin
		// TODO Auto-generated method stub
		int result=0;
		Connection con=DBConnect.getConn();
		String sql="UPDATE E_USER SET NAME=?,ROLL_NO=?,CLASS=?,SPECIFICATION=?,SECTION=?,PASSWORD=?,STATUS=?,DATEOFADMISSION=? WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		//preparedStatement.setInt(1, bean.getId());
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(2, bean.getRoll());
		preparedStatement.setString(3,bean.getUserclass() );
		preparedStatement.setString(4, bean.getSpecification());
		preparedStatement.setString(5, bean.getSection());
		
		preparedStatement.setString(6, bean.getPassword());
		
		preparedStatement.setInt(7, bean.getStatus());
		preparedStatement.setString(8, bean.getDoa());
		preparedStatement.setInt(9, bean.getId());
		//preparedStatement.setInt(9, bean.getId());
		//System.out.println(bean.getStatus());
		System.out.println("status= "+bean.getStatus());
		result=preparedStatement.executeUpdate();
		System.out.println("execute update"+result);
		if(result==0)
		{
			return 0;
		}
		return 1;
	}
	
}
