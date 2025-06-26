package com.environmentsurvey.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnect {
	
	public static Connection getConn() {
		ResourceBundle rd=ResourceBundle.getBundle("system");
	    String loadDriver=rd.getString("driver");
	    String dbURL=rd.getString("url");
	    String dbUSERNAME=rd.getString("userName");
	    String dbPASSWORD=rd.getString("password");
	    
	    Connection con = null;
	    try {
	      Class.forName(loadDriver);
	      con = DriverManager.getConnection(dbURL,dbUSERNAME,dbPASSWORD);
	    } catch (ClassNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return con;
	  }
	 
     
}
