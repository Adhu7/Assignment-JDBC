package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Users;
import db.UserDB;
public class UsersDAO {
public void insertUsers(Users users) throws SQLException{
	String query ="INSERT INTO users(id, name, email, country, password) VALUES(?,?,?,?,?)";
	try (Connection con=UserDB.getConnection();
			PreparedStatement pst= con.prepareStatement(query)){
		pst.setInt(1, users.getId());
		pst.setString(2, users.getName());
		pst.setString(3, users.getEmail());
		pst.setString(4, users.getCountry());
		pst.setString(5, users.getPassword());
		pst.executeUpdate();
	}
}
public Users getUsers(int id) throws SQLException {
	String query = "SELECT * FROM users WHERE id = ?";
	try (Connection con=UserDB.getConnection();
			PreparedStatement pst=con.prepareStatement(query)){
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		if (rs.next()) {
			return new Users(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("country"), rs.getString("password"));		
		}
	}
	return null;
}
public void updateUsers(Users users) throws SQLException {
	String query = "UPDATE users SET name= ?, email= ?, country= ?, password= ? WHERE id= ? ";
	try (Connection con= UserDB.getConnection();
			PreparedStatement pst=con.prepareStatement(query)){
		pst.setString(1, users.getName());
		pst.setString(2, users.getEmail());
		pst.setString(3, users.getCountry());
		pst.setString(4, users.getPassword());
		pst.setInt(5, users.getId());
		pst.executeUpdate();
	}
}
public void deleteUsers(int id) throws SQLException {
	String query= "DELETE FROM users WHERE id= ?";
	try (Connection con=UserDB.getConnection(); 
			PreparedStatement pst=con.prepareStatement(query)){
		pst.setInt(1, id);
		pst.executeUpdate();
	}
}
public List<Users> getAllUsers() throws SQLException {
	List<Users> users= new ArrayList<Users>();
	String query= "SELECT * FROM users";
	try (Connection con=UserDB.getConnection();
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(query)){
		while (rs.next()) {
			users.add(new Users(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
					rs.getString("country"), rs.getString("password")));
		}
	}
	return users;
}
}
