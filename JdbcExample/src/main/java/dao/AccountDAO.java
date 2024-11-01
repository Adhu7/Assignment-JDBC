package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Account;
import db.DBConnection;

public class AccountDAO {
public void insertAccount(Account account) throws SQLException{
	String query ="INSERT INTO account(accNO, name, balance) VALUES(?,?,?)";
	try ( Connection con=DBConnection.getConnection();
			PreparedStatement pst= con.prepareStatement(query)){
		pst.setInt(1, account.getAccNo());
		pst.setString(2, account.getName());
		pst.setFloat(3, account.getBalance());
		pst.executeUpdate();
	}
}
public Account getAccount(int accNo) throws SQLException {
	 String query = "SELECT * FROM account WHERE accno = ?";
	 try (Connection con = DBConnection.getConnection();
	 PreparedStatement pst = con.prepareStatement(query)) {
	 pst.setInt(1, accNo);
	 ResultSet rs = pst.executeQuery();
	 if (rs.next()) {
	 return new Account(rs.getInt("accno"), rs.getString("name"),
	rs.getFloat("balance"));
	 }
	 }
	 return null; // Account not found
	 }

public void updateAccount(Account account) throws SQLException{
	String query= "UPDATE account SET name= ?, balance= ? WHERE accNo= ?";
	try (Connection con= DBConnection.getConnection();
	PreparedStatement pst= con.prepareStatement(query)) {
		pst.setString(1, account.getName());
		pst.setFloat(2, account.getBalance());
		pst.setInt(3, account.getAccNo());
		pst.executeUpdate();
	}
}

public void deleteAccount(int accNo) throws SQLException {
	String query ="DELETE FROM account WHERE accNo= ?";
	try (Connection con=DBConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(query)){
		pst.setInt(1, accNo);
		pst.executeUpdate();
}
}

public List<Account> getAllAccounts() throws SQLException {
	List<Account> accounts= new ArrayList<>();
	String query ="SELECT * FROM account";
	try (Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query)){
		while (rs.next()) {
			accounts.add(new Account(rs.getInt("accNO"), rs.getString("name"),
				rs.getFloat("balance")));	
		}
	}
	return accounts;
}
}

