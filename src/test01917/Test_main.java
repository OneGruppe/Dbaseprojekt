package test01917;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daoimpl01917.*;
import daointerfaces01917.*;
import dto01917.*;

public class Test_main {
	public static void main(String[] args) {
		try {
			new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}

		/**
		 * 
		 * OPERATOER 
		 * 
		 * CREATE, UPDATE, GETUSER, GETUSERLIST
		 * 
		 */
		OperatoerDAO opr = new	MySQLOperatoerDAO();

		// Create a user (MySQLOperatoer-object, Fornavn, Efternavn, Ini, CPR, Password)
		createUser(opr, "Yetti", "LastNaim", "YL", "011100-0011", "MyNewPasswordWhichIsSecure");

		// Update user '15' (MySQLOperatoer-object, Fornavn, Efternavn, Ini, Password)
		updateUser(opr, "Eva", "Jørgensen", "EJ", "PasswordErNemt");

		// Get a user from CPR (MySQLOperatoer-object, cpr)
		getUserIdFromCPR(opr, "010195-2012");

		// Get a userList (MySQLOperatoer-object)
		getUserList(opr);

	}
	
	public static void createUser(OperatoerDAO opr, String name, String lname, String ini, String cpr, String pass) {
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

	public static void updateUser (OperatoerDAO opr, String name, String lname, String Ini, String pass) {
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

	public static void getUserIdFromCPR(OperatoerDAO opr, String cpr) {
		try {
			System.out.println("Få operatør id fra CPR '010195-2012': " + opr.getOperatoerId("010195-2012"));
		} catch (DALException e1) {
			System.out.println(e1.getMessage()); 
		}
	}

	public static void getUserList(OperatoerDAO opr) {
		System.out.println("Alle operatoerer:"); 
		try {
			System.out.println(opr.getOperatoerList()); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}
	}
	
}
