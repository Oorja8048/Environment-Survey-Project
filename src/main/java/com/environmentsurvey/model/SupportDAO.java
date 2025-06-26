package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.environmentsurvey.bean.SupportBean;
import com.environmentsurvey.utility.DBConnect;

public class SupportDAO {

	public boolean addIssue(SupportBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO E_SUPPORT (ID,FNAME,LNAME,ROLE,SUBJECT) VALUES (NULL,?,?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getFirst_name());
		preparedStatement.setString(2, bean.getLast_name());
		preparedStatement.setString(3, bean.getRole());
		preparedStatement.setString(4, bean.getSubject());
		
		int i=preparedStatement.executeUpdate();
		if(i!=0)
		{
			return true;
		}
		return false;
	}

}
