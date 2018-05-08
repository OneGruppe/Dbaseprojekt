package test01917;

import java.util.ArrayList;
import java.util.List;

import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import dto01917.OperatoerDTO;

public class Test_main_operatoer {

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
