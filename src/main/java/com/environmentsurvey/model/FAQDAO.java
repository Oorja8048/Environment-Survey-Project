package com.environmentsurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.environmentsurvey.bean.FAQBean;
import com.environmentsurvey.bean.UserBean;
import com.environmentsurvey.utility.DBConnect;

public class FAQDAO {

	public int addFaq(FAQBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO E_FAQ(ID,QUESTION,ANSWER) VALUES (NULL,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getQuestion());
		preparedStatement.setString(2, bean.getAnswer());
		int i=preparedStatement.executeUpdate();
		System.out.println("i is "+i);
		if(i==0)
		{
			return 0;
		}
		return 1;
	}
	public static FAQBean getRecordbyId(int id) throws SQLException {
		FAQBean bean=null;
		Connection con=DBConnect.getConn();
		String sql="SELECT * FROM E_FAQ WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset=preparedStatement.executeQuery();
		while(resultset.next())
		{
			bean=new FAQBean();
			bean.setId(resultset.getInt(1));
			
			bean.setQuestion(resultset.getString(2));
			
			bean.setAnswer(resultset.getString(3));
			
			
			
		}
		return bean;
	}

	public int editFaq(FAQBean bean) throws SQLException {
		int status=0;
		Connection con=DBConnect.getConn();
		String sql="UPDATE E_FAQ SET QUESTION=?,ANSWER=? WHERE ID=?";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		//preparedStatement.setInt(1, bean.getId());
		preparedStatement.setString(1, bean.getQuestion());
		preparedStatement.setString(2, bean.getAnswer());
		
		
		//preparedStatement.setString(6, bean.getPassword());
		preparedStatement.setInt(3, bean.getId());
		status=preparedStatement.executeUpdate();
		System.out.println("status "+status);
		if(status==0)
		{
			return 0;
		}
		return 1;	// TODO Auto-generated method stub
		
	}

}
