package com.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Connect {
	
	public Connection  getConnection(){
		
		Properties props=new Properties();
		java.io.InputStream in=null;
		Connection con=null;
		
		   
	    
	    try {
			 in= new Login().getClass().getResourceAsStream("/dbconfig.properties");

	    	props.load(in);
	        Class.forName(props.getProperty("DB_DRIVER"));

	        con=DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USER"),props.getProperty("DB_PASSWORD"));  
	        
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
        return con;

	}

}
