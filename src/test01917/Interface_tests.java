package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLReceptDAO;
import daoimpl01917.MySQLReceptKompDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

public class Interface_tests {

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
		
		/*****************************************************************
		 **Produktbatch tests**
		 ****************************************************************/
		
		System.out.println("\n\n/*****************************************************************");
		System.out.println("**Produktbatch tests**");
		System.out.println("****************************************************************/");

		MySQLProduktBatchDAO prod = new MySQLProduktBatchDAO();

		System.out.println("\nProduktbatch nummer 1: ");
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
			produkt.setStatus(0);
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
		 **Produktbatchkomponent tests**
		 ****************************************************************/
		
		System.out.println("\n\n/*****************************************************************");
		System.out.println("**Produktbatchkomponent tests**");
		System.out.println("****************************************************************/");

		MySQLProduktBatchKompDAO prodKomp = new MySQLProduktBatchKompDAO();

		System.out.println("\nProduktbatchkomponent nummer 1-1: ");
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
			produktBatchKomp.setNetto(12.03);
			prodKomp.updateProduktBatchKomp(produktBatchKomp);

			System.out.println("Produktbatchkomponenten er blevet opdateret");
			System.out.println(prodKomp.getProduktBatchKomp(4, 3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		/*****************************************************************
		 **Raavarebatch tests**
		 ****************************************************************/
		
		System.out.println("\n\n/*****************************************************************");
		System.out.println("**Raavarebatch tests**");
		System.out.println("****************************************************************/");

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
			raavarebatch.setMaengde(500.0);
			raaBatch.updateRaavareBatch(raavarebatch);

			System.out.println("Råvarebatchet er blevet opdateret");
			System.out.println(raaBatch.getRaavareBatch(9));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*****************************************************************
		 **Raavare tests**
		 ****************************************************************/
		
		System.out.println("\n\n/*****************************************************************");
		System.out.println("**Raavare tests**");
		System.out.println("****************************************************************/");

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

		System.out.println("\nPrint alle råvarer: ");
		try {
			System.out.println(raavare.getRaavareList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*****************************************************************
		 **Recept tests**
		 ****************************************************************/
		
		System.out.println("\n\n/*****************************************************************");
		System.out.println("**Recept tests**");
		System.out.println("****************************************************************/");

		MySQLReceptDAO recept = new MySQLReceptDAO();

		System.out.println("\nRecept nummer 3: ");
		try {
			System.out.println(recept.getRecept(3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpret ny recept: ");
		ReceptDTO recept_obj = new ReceptDTO(4, "newroz");
		try {
			recept.createRecept(recept_obj);
			System.out.println("Recepten er oprettet");
			System.out.println(recept.getRecept(4));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpdater receptinformation: ");
		try {
			recept_obj.setReceptNavn("matador");
			recept.updateRecept(recept_obj);

			System.out.println("Recepten er blevet opdateret");
			System.out.println(recept.getRecept(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nPrint alle recepter: ");
		try {
			System.out.println(recept.getReceptList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*****************************************************************
		 **Receptkomponent tests**
		 ****************************************************************/
		
		System.out.println("\n\n/*****************************************************************");
		System.out.println("**Receptkomponent tests**");
		System.out.println("****************************************************************/");

		MySQLReceptKompDAO receptKomp = new MySQLReceptKompDAO();

		System.out.println("\nRecepotkomponent nummer 3-4: ");
		try {
			System.out.println(receptKomp.getReceptKomp(3,4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nPrint alle receptkomponenter: ");
		try {
			System.out.println(receptKomp.getReceptKompList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nPrint alle receptkomponenter med recept_id 3: ");
		try {
			System.out.println(receptKomp.getReceptKompList(3));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpret ny receptkomponent: ");
		ReceptKompDTO receptKomponent = new ReceptKompDTO(4, 7, 15, 0.1);
		try {
			receptKomp.createReceptKomp(receptKomponent);
			System.out.println("Receptkomponenten er oprettet");
			System.out.println(receptKomp.getReceptKomp(4, 7));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nOpdater receptkomponentinformation: ");
		try {
			receptKomponent.setNomNetto(17);
			receptKomp.updateReceptKomp(receptKomponent);

			System.out.println("Receptkomponenten er blevet opdateret");
			System.out.println(receptKomp.getReceptKomp(4, 7));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
