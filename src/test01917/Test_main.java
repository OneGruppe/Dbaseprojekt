package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.*;
import daointerfaces01917.*;

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
		Test_main_operatoer.createUser(opr, "Yetti", "LastNaim", "YL", "011100-0011", "MyNewPasswordWhichIsSecure");

		// Update user '15' (MySQLOperatoer-object, Fornavn, Efternavn, Ini, Password)
		Test_main_operatoer.updateUser(opr, "Eva", "Jørgensen", "EJ", "PasswordErNemt");

		// Get a user from CPR (MySQLOperatoer-object, cpr)
		Test_main_operatoer.getUserIdFromCPR(opr, "010195-2012");

		// Get a userList (MySQLOperatoer-object)
		Test_main_operatoer.getUserList(opr);

	}

}
