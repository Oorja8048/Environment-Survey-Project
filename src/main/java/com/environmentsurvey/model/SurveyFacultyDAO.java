package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.environmentsurvey.bean.SurveyFacultyBean;
import com.environmentsurvey.bean.SurveyStudentBean;
import com.environmentsurvey.utility.DBConnect;

public class SurveyFacultyDAO {

	public boolean addSurvey(SurveyFacultyBean bean) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = DBConnect.getConn();
		String sql = "INSERT INTO E_SURVEYFACULTY (ID,NAME,DESCRIPTION,VOLUNTEER,DATE,VENUE) VALUES (NULL,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(2, bean.getDescription());
		preparedStatement.setString(3, bean.getVolunteers());
		preparedStatement.setString(4, bean.getDateofsurvey());
		preparedStatement.setString(5, bean.getVenue());
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		if (i != 0) {
			return true;
		}
		return false;

	}
	public static int update(SurveyFacultyBean bean) throws SQLException
	{
		int status=0;
		Connection con=DBConnect.getConn();
		String sql="UPDATE E_SURVEYFACULTY SET NAME=?,DESCRIPTION=?,VOLUNTEER=?,DATE=?,VENUE=? WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(2, bean.getDescription());
		preparedStatement.setString(3, bean.getVolunteers());
		preparedStatement.setString(4, bean.getDateofsurvey());
		preparedStatement.setString(5, bean.getVenue());
		preparedStatement.setInt(6, bean.getId());
		status=preparedStatement.executeUpdate();
		System.out.println(status);
		if(status==0)
		{
			return 0;
		}
		return 1;
		
	}
	
	public static SurveyFacultyBean getRecordById(int id) throws SQLException {
		SurveyFacultyBean bean=null;
		Connection con=DBConnect.getConn();
		String sql="SELECT * FROM E_SURVEYFACULTY WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset=preparedStatement.executeQuery();
		while(resultset.next())
		{
			bean=new SurveyFacultyBean();
			bean.setId(resultset.getInt(1));
			
			bean.setName(resultset.getString(2));
			
			bean.setDescription(resultset.getString(3));
			
			bean.setVolunteers(resultset.getString(4));
			
			bean.setDateofsurvey(resultset.getString(5));
			
			bean.setVenue(resultset.getString(6));
			
			
		}
		return bean;
		
	}
	
	}


