package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.environmentsurvey.bean.EparticipationBean;
import com.environmentsurvey.utility.DBConnect;

public class EParticipationDAO {

	public int addSeminar(EparticipationBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO e_paticipation (ID,NAME,VENUE,VOLUNTEERS,DATEOFSEMINAR) VALUES (NULL,?,?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(2, bean.getVenue());
		preparedStatement.setString(3, bean.getVoulteers());
		preparedStatement.setString(4, bean.getDofseminar());
		int i=preparedStatement.executeUpdate();
		if(i==0)
		{
			return 0;
		}
		return 1;
	}

}
