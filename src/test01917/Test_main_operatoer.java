package test01917;

import java.util.ArrayList;
import java.util.List;

import daoimpl01917.MySQLOperatoerDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import dto01917.OperatoerDTO;

public class Test_main_operatoer {
	static OperatoerDAO opr = new MySQLOperatoerDAO();

	public static void createUser() {
		System.out.println("Indsaettelse af ny operatoer");		
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(2);

		OperatoerDTO oprDTO = new OperatoerDTO(0, "Lise", "Jørgensen", "LJ", "010680-1244" , "Password", roles); 
		try {
			opr.createOperatoer(oprDTO);
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}
	}

	public static int getUserIdFromCPR(String cpr) {
		try {
			return opr.getOperatoerId(cpr);
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
			return 0;
		}
	}

	public static void updateUser () {
		System.out.println("Opdatering af nuværende operatoer 'Eva'");
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(1);
		OperatoerDTO updatedUser = new OperatoerDTO(getUserIdFromCPR("010680-1244"), "Lise", "Jørgensen", "LJ", "010195-2012", "Password", roles);

		try { 
			opr.updateOperatoer(updatedUser);
		} catch	(DALException e) { 
			System.out.println(e.getMessage()); 
		}
	}

	public static void getUserList() {
		System.out.println("Alle operatoerer:"); 
		try {
			for(OperatoerDTO opr : opr.getOperatoerList()) {
				System.out.println(opr.toString());
			}
		} catch (DALException e) {
			System.out.println(e.getMessage()); 
		}
	}
}
