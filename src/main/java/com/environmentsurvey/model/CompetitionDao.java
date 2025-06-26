package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.environmentsurvey.bean.CompetitionBean;

import com.environmentsurvey.utility.DBConnect;


public class CompetitionDao {
	public boolean addComp(CompetitionBean bean) throws SQLException {
	Connection con = DBConnect.getConn();
	String sql = "INSERT INTO E_COMP (ID,NAME,DESCRIPTION,VOLUNTEER,DATE,VENUE) VALUES (NULL,?,?,?,?,?)";
	PreparedStatement preparedStatement = con.prepareStatement(sql);
	preparedStatement.setString(1, bean.getName());
	preparedStatement.setString(2, bean.getDescription());
	preparedStatement.setString(3, bean.getVolunteers());
	preparedStatement.setString(4, bean.getDateofcomp());
	preparedStatement.setString(5, bean.getVenue());
	int i = preparedStatement.executeUpdate();
	System.out.println(i);
	if (i != 0) {
		return true;
	}
	return false;

}
	public boolean addCompByfaculty(CompetitionBean bean) throws SQLException {
		Connection con = DBConnect.getConn();
		String sql = "INSERT INTO E_COMPBYFACULTY (ID,NAME,DESCRIPTION,VOLUNTEER,DATE,VENUE) VALUES (NULL,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(2, bean.getDescription());
		preparedStatement.setString(3, bean.getVolunteers());
		preparedStatement.setString(4, bean.getDateofcomp());
		preparedStatement.setString(5, bean.getVenue());
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
		if (i != 0) {
			return true;
		}
		return false;

	}
}
