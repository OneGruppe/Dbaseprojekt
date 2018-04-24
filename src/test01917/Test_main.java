package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;

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
		/*
		 * System.out.println("Operatoer nummer 3:"); MySQLOperatoerDAO opr = new
		 * MySQLOperatoerDAO(); try { System.out.println(opr.getOperatoer(3)); } catch
		 * (DALException e) { System.out.println(e.getMessage()); }
		 * 
		 * System.out.println("Indsaettelse af ny operatoer med opr_id =  4");
		 * OperatoerDTO oprDTO = new
		 * OperatoerDTO(4,"Don Juan","DJ","000000-0000","iloveyou"); try {
		 * opr.createOperatoer(oprDTO); } catch (DALException e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * System.out.println("Operatoer nummer 4:"); try {
		 * System.out.println(opr.getOperatoer(4)); } catch (DALException e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * System.out.println("Opdatering af initialer for operatoer nummer 4");
		 * oprDTO.setIni("DoJu"); try { opr.updateOperatoer(oprDTO); } catch
		 * (DALException e) { System.out.println(e.getMessage()); }
		 * 
		 * System.out.println("Operatoer nummer 4:"); try {
		 * System.out.println(opr.getOperatoer(4)); } catch (DALException e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * System.out.println("Alle operatoerer:"); try {
		 * System.out.println(opr.getOperatoerList()); } catch (DALException e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * System.out.println("Operatoer nummer 5:"); try {
		 * System.out.println(opr.getOperatoer(5)); } catch (DALException e) {
		 * System.out.println(e.getMessage()); }
		 */

		/*****************************************************************
		 ** Produktbatch tests**
		 ****************************************************************/

		MySQLProduktBatchDAO prod = new MySQLProduktBatchDAO();

		System.out.println("Produktbatch nummer 1: ");
		try {
			System.out.println(prod.getProduktBatch(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpret nyt produktbatch: ");
		ProduktBatchDTO produkt = new ProduktBatchDTO(7, 0, 2);
		try {
			prod.createProduktBatch(produkt);
			System.out.println("Produktbatchet er oprettet");
			System.out.println(prod.getProduktBatch(7));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpdater produktbatchinformation: ");
		try {
			produkt.setStatus(2);
			prod.updateProduktBatch(produkt);

			System.out.println("Produktbatchet er blevet opdateret");
			System.out.println(prod.getProduktBatch(7));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nPrint alle produktbatches: ");
		try {
			System.out.println(prod.getProduktBatchList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		/*****************************************************************
		 ** Produktbatchkomponent tests**
		 ****************************************************************/

		MySQLProduktBatchKompDAO prodKomp = new MySQLProduktBatchKompDAO();

		System.out.println("\nProduktbatchkomponent nummer 1: ");
		try {
			System.out.println(prodKomp.getProduktBatchKomp(1, 1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nPrint alle produktbatchekomponenter: ");
		try {
			System.out.println(prodKomp.getProduktBatchKompList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nPrint alle produktbatchekomponenter med pb_id 1: ");
		try {
			System.out.println(prodKomp.getProduktBatchKompList(1));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpret nyt produktbatchkomponent: ");
		ProduktBatchKompDTO produktBatchKomp = new ProduktBatchKompDTO(4, 3, 0.8, 11.05, 2);
		try {
			prodKomp.createProduktBatchKomp(produktBatchKomp);
			System.out.println("Produktbatchkomponenten er oprettet");
			System.out.println(prodKomp.getProduktBatchKomp(4, 3));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpdater produktbatchkomponentinformation: ");
		try {
			produktBatchKomp.setNetto(12.08);
			prodKomp.updateProduktBatchKomp(produktBatchKomp);

			System.out.println("Produktbatchkomponenten er blevet opdateret");
			System.out.println(prodKomp.getProduktBatchKomp(4, 3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		/*****************************************************************
		 ** Raavarebatch tests**
		 ****************************************************************/

		MySQLRaavareBatchDAO raaBatch = new MySQLRaavareBatchDAO();

		System.out.println("\nRaavarebatch nummer 3: ");
		try {
			System.out.println(raaBatch.getRaavareBatch(3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nPrint alle raavarebatches: ");
		try {
			System.out.println(raaBatch.getRaavareBatchList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nPrint alle raavarebatches med rb_id 3: ");
		try {
			System.out.println(raaBatch.getRaavareBatchList(3));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpret nyt raavarebatch: ");
		RaavareBatchDTO raavarebatch = new RaavareBatchDTO(9, 5, 200);
		try {
			raaBatch.createRaavareBatch(raavarebatch);
			System.out.println("Råvarebatchet er oprettet");
			System.out.println(raaBatch.getRaavareBatch(9));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpdater raavarebatch: ");
		try {
			raavarebatch.setMaengde(400.0);
			raaBatch.updateRaavareBatch(raavarebatch);

			System.out.println("Råvarebatchet er blevet opdateret");
			System.out.println(raaBatch.getRaavareBatch(9));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*****************************************************************
		 ** Raavare tests**
		 ****************************************************************/

		MySQLRaavareDAO raavare = new MySQLRaavareDAO();

		System.out.println("\nRåvare nummer 4: ");
		try {
			System.out.println(raavare.getRaavare(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpret ny råvare: ");
		RaavareDTO raavare_obj = new RaavareDTO(8, "champignon", "Champignon A/S");
		try {
			raavare.createRaavare(raavare_obj);
			System.out.println("Råvaren er oprettet");
			System.out.println(raavare.getRaavare(8));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpdater råvareinformation: ");
		try {
			raavare_obj.setLeverandoer("Champignon & Svampe A/S");
			raavare.updateRaavare(raavare_obj);

			System.out.println("Raavaren er blevet opdateret");
			System.out.println(raavare.getRaavare(8));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nPrint alle produktbatches: ");
		try {
			System.out.println(raavare.getRaavareList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
