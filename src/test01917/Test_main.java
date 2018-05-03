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

		System.out.println("Operatoer nummer 1:");
		MySQLOperatoerDAO opr = new	MySQLOperatoerDAO();

		try {
			System.out.println(opr.getOperatoer(15));
		} catch
		(DALException e) {
			System.out.println(e.getMessage()); 
		}

		System.out.println("Indsaettelse af ny operatoer");
		
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(2);
		roles.add(3);

		OperatoerDTO oprDTO = new OperatoerDTO(0, "Don", "Sebastian","DS", 1, "123123-1111","alleMineShibabs", roles); 
		try {
			opr.createOperatoer(oprDTO);
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}

		System.out.println("Operatoer:"); 
		try {
			System.out.println(opr.getOperatoer(16)); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}
		System.out.println("Opdatering af aktivitet for operatoer");
		OperatoerDTO updatedUser = new OperatoerDTO(15, "Eva-musse",  "Jørgensen", "EJ", 1, "010195-2012", "MitPasswordErSvaert", null);
		oprDTO.setIni("DoJu");

		try { 
			opr.updateOperatoer(updatedUser);
		} catch
		(DALException e) { 
			System.out.println(e.getMessage()); 
		}

		System.out.println("Operatoer:"); 
		try {
			System.out.println(opr.getOperatoer(15)); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}

		System.out.println("Alle operatoerer:"); 
		try {
			System.out.println(opr.getOperatoerList()); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}

		System.out.println("Operatoer nummer 5:"); 
		try {
			System.out.println(opr.getOperatoer(42)); 
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}

	}
}
