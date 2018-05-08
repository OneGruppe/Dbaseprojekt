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
		
		Test_main_operatoer.getUserList();
				
		Test_main_operatoer.createUser();
		
		Test_main_operatoer.getUserList();

		Test_main_operatoer.updateUser();

	}

}
