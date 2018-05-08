package test01917;

import java.sql.SQLException;

import connector01917.Connector;

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
		System.out.println("\n*********** Liste over bruger ***********");
		Test_main_operatoer.getUserList();
		System.out.println("");

		System.out.println("\n***********  Create en user   ***********");
		Test_main_operatoer.createUser();
		Test_main_operatoer.getUserList();
		System.out.println("");

		System.out.println("\n***********  Update en user   ***********");
		Test_main_operatoer.updateUser();
		Test_main_operatoer.getUserList();
		System.out.println("");
		
		System.out.println("\n***********  Delete en user   ***********");
		Test_main_operatoer.deleteUser();
		Test_main_operatoer.getUserList();
		System.out.println("");

	}

}
