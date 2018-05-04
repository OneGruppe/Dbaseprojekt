package test01917;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;

public class Test_main {
	public static void main(String[] args) {
		try {
			new Connector();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		MySQLOperatoerDAO opr = new	MySQLOperatoerDAO();

		// Create a user (MySQLOperatoer-object, Fornavn, Efternavn, Ini, CPR, Password)
		createUser(opr, "Yetti", "LastNaim", "YL", "011100-0011", "MyNewPasswordWhichIsSecure");

		// Update user '15' (MySQLOperatoer-object, Fornavn, Efternavn, Ini, Password)
		updateUser(opr, "Eva", "Jørgensen", "EJ", "PasswordErNemt");

		// Get a user from CPR (MySQLOperatoer-object, cpr)
		getUserIdFromCPR(opr, "010195-2012");
		
		// Get a userList (MySQLOperatoer-object)
		getUserList(opr);
	}
	
	
	

	public static void createUser(MySQLOperatoerDAO opr, String name, String lname, String ini, String cpr, String pass) {
		System.out.println("Indsaettelse af ny operatoer");		
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(2);
		roles.add(3);

		OperatoerDTO oprDTO = new OperatoerDTO(0, name, lname, ini, cpr, pass, roles); 
		try {
			opr.createOperatoer(oprDTO);
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}
	}

	public static void updateUser (MySQLOperatoerDAO opr, String name, String lname, String Ini, String pass) {
		System.out.println("Opdatering af nuværende operatoer 'Eva'");
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(1);
		roles.add(2);
		OperatoerDTO updatedUser = new OperatoerDTO(15, name, lname, Ini, "010195-2012", pass, roles);

		try { 
			opr.updateOperatoer(updatedUser);
		} catch
		(DALException e) { 
			System.out.println(e.getMessage()); 
		}
	}

	public static void getUserIdFromCPR(MySQLOperatoerDAO opr, String cpr) {
		try {
			System.out.println("Få operatør id fra CPR '010195-2012': " + opr.getOperatoerId("010195-2012"));
		} catch (DALException e1) {
			System.out.println(e1.getMessage()); 
		}
	}
	
	public static void getUserList(MySQLOperatoerDAO opr) {
		System.out.println("Alle operatoerer:"); 
		try {
			System.out.println(opr.getOperatoerList()); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}
	}
}
