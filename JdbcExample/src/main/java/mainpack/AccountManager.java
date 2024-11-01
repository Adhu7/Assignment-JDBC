package mainpack;

import java.sql.SQLException;
import java.util.List;

import bean.Account;
import dao.AccountDAO;

public class AccountManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AccountDAO accountDAO=new AccountDAO();
try {
	Account account1=new Account(1007, "Akhil", 5000.00f);
	Account account2=new Account(1008, "Abi", 15000.00f);
	Account account3=new Account(1009, "John", 8000.00f);
	Account account4=new Account(10010, "Mani", 10000.00f);
	Account account5=new Account(10011, "Sanjay", 3000.00f);
	Account account6=new Account(10012, "Unni", 20000.00f);
	accountDAO.insertAccount(account1);
	accountDAO.insertAccount(account2);
	accountDAO.insertAccount(account3);
	accountDAO.insertAccount(account4);
	accountDAO.insertAccount(account5);
	accountDAO.insertAccount(account6);
	System.out.println("Account inserted.");
	
	Account retrievedAccount= accountDAO.getAccount(1001);
	if (retrievedAccount != null) {
		System.out.println("Account Retrieved: " + retrievedAccount.getName());;
	} else {
System.out.println("Account not found");
	}
	
	retrievedAccount.setBalance(7000.00f);
	accountDAO.updateAccount(retrievedAccount);
	System.out.println("Account updated.");
	
	List<Account> accounts= accountDAO.getAllAccounts();
	System.out.println("All Acoounts:");
	for (Account account : accounts) {
		System.out.println("Acc No: " + account.getAccNo()+ ",Name: " +account.getName()+ ",Balance: "+account.getBalance());
	}
	
	accountDAO.deleteAccount(1001);
	System.out.println("Account deleted.");
} catch (SQLException e) {
	// TODO: handle exception
	e.printStackTrace();
}
	}

}
