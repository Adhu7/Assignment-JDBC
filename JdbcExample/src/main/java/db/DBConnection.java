package db;

import java.sql.*;

public class DBConnection {
private static  final String HOST="localhost";
private static final String PORT="3306";
private static final String DATABASE="bank";
private static final String USER="root";
private static final String PASSWORD="";

public static Connection getConnection() throws SQLException{
	String url="jdbc:mysql://" + HOST +":" + PORT +"/" + DATABASE;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	}
	catch (Exception e) {
		System.out.println(e);
	}

	return DriverManager.getConnection(url,USER,PASSWORD);
}
}
