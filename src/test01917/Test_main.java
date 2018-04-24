package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;

public class Test_main {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		/*
		System.out.println("Operatoer nummer 3:");
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		try { System.out.println(opr.getOperatoer(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny operatoer med opr_id =  4");
		OperatoerDTO oprDTO = new OperatoerDTO(4,"Don Juan","DJ","000000-0000","iloveyou");
		try { opr.createOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af initialer for operatoer nummer 4");
		oprDTO.setIni("DoJu");
		try { opr.updateOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle operatoerer:");
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operatoer nummer 5:");
		try { System.out.println(opr.getOperatoer(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
		*/
		
		/*****************************************************************
							**Produktbatch tests**
		****************************************************************/
		
		MySQLProduktBatchDAO prod = new MySQLProduktBatchDAO();
		
		System.out.println("Produktbatch nummer 1: ");
		try {
			System.out.println(prod.getProduktBatch(1));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nOpret nyt produktbatch: ");
		ProduktBatchDTO produkt = new ProduktBatchDTO(7, 0, 2);
		try {
			prod.createProduktBatch(produkt);
			System.out.println("Produktbatchet er oprettet");
			System.out.println(prod.getProduktBatch(7));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nOpdater produktbatchinformation: ");
		try {
			produkt.setStatus(2);
			prod.updateProduktBatch(produkt);
			
			System.out.println("Produktbatchet er blevet opdateret");
			System.out.println(prod.getProduktBatch(7));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nPrint alle produktbatches: ");
		try {
			System.out.println(prod.getProduktBatchList());
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*****************************************************************
		 				**Produktbatchkomponent tests**
		 ****************************************************************/
		
		MySQLProduktBatchKompDAO prodKomp = new MySQLProduktBatchKompDAO();
		
		System.out.println("\nProduktbatchkomponent nummer 1: ");
		try {
			System.out.println(prodKomp.getProduktBatchKomp(1, 1));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nPrint alle produktbatchekomponenter: ");
		try {
			System.out.println(prodKomp.getProduktBatchKompList());
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nPrint alle produktbatchekomponenter med pb_id 1: ");
		try {
			System.out.println(prodKomp.getProduktBatchKompList(1));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nOpret nyt produktbatchkomponent: ");
		ProduktBatchKompDTO produktBatchKomp = new ProduktBatchKompDTO(4, 3, 0.8, 11.05, 2);
		try {
			prodKomp.createProduktBatchKomp(produktBatchKomp);
			System.out.println("Produktbatchkomponenten er oprettet");
			System.out.println(prodKomp.getProduktBatchKomp(4, 3));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nOpdater produktbatchkomponentinformation: ");
		try {
			produktBatchKomp.setNetto(12.08);
			prodKomp.updateProduktBatchKomp(produktBatchKomp);
			
			System.out.println("Produktbatchkomponenten er blevet opdateret");
			System.out.println(prodKomp.getProduktBatchKomp(4, 3));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
