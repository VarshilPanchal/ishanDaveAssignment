package com.register;
//providing SQL queries for database opertaions
public class sqlQuery 
{
	
	private final static String questionMark = "\"?\"";
	//insert query for database operations
	protected final static String insertQuery = "INSERT INTO " + ConnectionInformation.tableName + "("
			+ ConnectionInformation.column1 + "," + ConnectionInformation.column2 + ") VALUES" + " (?, ?);";
	//delete query for database operations
	protected final static String deleteQuery = "DELETE FROM " + ConnectionInformation.tableName + " WHERE "
			+ ConnectionInformation.username + " = " + questionMark + ";";
	//update query for database operations
	protected final static String updateQuery = "UPDATE " + ConnectionInformation.tableName + " SET "
			+ ConnectionInformation.password + " = " + questionMark + ";";
}
