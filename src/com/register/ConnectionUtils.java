package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Connection Provider Class
public class ConnectionUtils {
	
	static Connection connection=null;
	
	public static Connection getCon() throws SQLException, ClassNotFoundException 
    { 
		//registering the driver
		Class.forName(ConnectionInformation.driverClass);
		//establishing connection with connection url, databasename, username, password through JDBC driver with mysql database
		connection = DriverManager
	            .getConnection(ConnectionInformation.connectionUrl+"/"+ConnectionInformation.databaseName, ConnectionInformation.username, ConnectionInformation.password);
        return connection; 
    }

}

