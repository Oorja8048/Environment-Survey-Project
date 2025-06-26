package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.environmentsurvey.utility.DBConnect;

public class QuestionDAO {

	public int addCompletedSurveyinDb(String name,int t_count) throws SQLException   //completed Survey by student in DATABASE.
	{
		Connection con=DBConnect.getConn();
		
		String sql="INSERT INTO E_SUBMITTED (ID,NAME,TOTALSURVEY) VALUES(NULL,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, t_count);
		int i=	preparedStatement.executeUpdate();
		System.out.println("i is "+i);
		if(i==0)
		{
			return 0;
		}
		return 1;
	}
}
