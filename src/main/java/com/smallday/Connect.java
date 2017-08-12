package com.smallday;



        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.Properties;

public class Connect {


    //This method connects with the database & by calling this method,one class can get the database connection
    public static Connection  getConnection(){

        Properties props=new Properties();
        java.io.InputStream in=null;
        Connection con=null;



        try {
            //get the database properties from dbconfig.proprties file
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

