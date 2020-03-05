package com.register;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	int result = 0;
	// Create Connection using ConnectionUtils Class
	ConnectionUtils conUtils=new ConnectionUtils();
	
    public int registerUser(User user) throws ClassNotFoundException
    {
        try {
        	
        	Connection connection = conUtils.getCon();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.insertQuery);
            //store input from user in database fields
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            //execute query to store data in database
            result = preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            
            System.out.println("Database doesnot exist!!");
        }
        return result;
    }
}
   
    	
  


