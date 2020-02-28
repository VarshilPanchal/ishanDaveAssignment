package com.register;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	int result = 0;
    public int registerUser(User user) throws ClassNotFoundException {
              

        Class.forName(connectionInformation.driverClass);

        try (Connection connection = DriverManager
            .getConnection(connectionInformation.connectionUrl+"/"+connectionInformation.databaseName, connectionInformation.username, connectionInformation.password);

          
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.insertQuery)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
         
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            
            System.out.println("Database doesnot exist!!");
        }
        return result;
    }
   
    	
    }


