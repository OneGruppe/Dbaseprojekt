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

		System.out.println("Indsaettelse af ny operatoer");
		
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(2);
		roles.add(3);

		OperatoerDTO oprDTO = new OperatoerDTO(0, "Mathias", "Muhameddaner","MM", 0, "120106","password123", roles); 
		try {
			opr.createOperatoer(oprDTO);
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}

		System.out.println("Opdatering af nuværende operatoer 'Eva'");
		List<Integer> evaRoles = new ArrayList<Integer>();
		roles.add(1);
		roles.add(2);
		OperatoerDTO updatedUser = new OperatoerDTO(15, "Eva",  "Jørgensen", "EJ", 1, "010195-2012", "MitPasswordErSvaert", evaRoles);
		oprDTO.setIni("DoJu");

		try { 
			opr.updateOperatoer(updatedUser);
		} catch
		(DALException e) { 
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Få operatør id fra CPR '010195-2012'");
		try {
			System.out.println("Operatør: " + opr.getOperatoerId("010195-2012"));
		} catch (DALException e1) {
			System.out.println(e1.getMessage()); 
		}

		System.out.println("Operatoer nummer 15"); 
		try {
			System.out.println(opr.getOperatoer(15)); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}

		System.out.println("Operatoer nummer 42:"); 
		try {
			System.out.println(opr.getOperatoer(42)); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}
		
		System.out.println("Alle operatoerer:"); 
		try {
			System.out.println(opr.getOperatoerList()); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}

	}
}
