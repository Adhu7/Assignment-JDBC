package mainpack;
import java.sql.*;
import java.util.List;

import bean.Users;
import dao.UsersDAO;
public class UserMain {

	public static void main(String[] args) {
		UsersDAO usersDAO=new UsersDAO();
		try {
			Users user1=new Users(1, "Akhil", "akhil@email.com", "India", "Akhil123");
			Users user2=new Users(2, "Antony", "antony3@email.com", "USA", "Samu5464");
			Users user3=new Users(3, "Cyril", "cyril53@email.com", "India", "Cyril987");
			Users user4=new Users(4, "John", "john11@email.com", "UK", "John6015");
			Users user5=new Users(5, "Nismal", "nismal983@email.com", "Spain", "nismalS98");
			Users user6=new Users(6, "Sanjay", "sanjay3@email.com", "Germany", "sanju7788");
			Users user7=new Users(7, "Vignesh", "vk7@email.com", "Ireland", "vignesh7777");
			usersDAO.insertUsers(user1);
			usersDAO.insertUsers(user2);
			usersDAO.insertUsers(user3);
			usersDAO.insertUsers(user4);
			usersDAO.insertUsers(user5);
			usersDAO.insertUsers(user6);
			usersDAO.insertUsers(user7);
			System.out.println("Users inserted.");
			
			Users retrievedUsers= usersDAO.getUsers(1);
			if (retrievedUsers != null) {
				System.out.println("Users retrieved: " + retrievedUsers.getName());
			} else {
System.out.println("Users not found.");
			}
			retrievedUsers.setPassword("Akhilpa1245");
			usersDAO.updateUsers(retrievedUsers);
			System.out.println("Users updated");
			
			List<Users> users= usersDAO.getAllUsers();
			System.out.println("All users");
			for (Users users2 : users) {
				System.out.println("ID: "+users2.getId()+ "Name: "+users2.getName()+ "Email: "+users2.getEmail()+ "Country: "+users2.getCountry()+ "Password: "+users2.getPassword());
			}
			usersDAO.deleteUsers(1);
			System.out.println("Users deleted.");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
