package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	static Connection connection=null;
	
	public static Connection getCon() throws SQLException, ClassNotFoundException 
    { 
		connection = DriverManager
	            .getConnection(connectionInformation.connectionUrl+"/"+connectionInformation.databaseName, connectionInformation.username, connectionInformation.password);
        return connection; 
    }

}

