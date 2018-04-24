package test01917;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import dto01917.ProduktBatchDTO;

class Test_database {
	MySQLProduktBatchDAO prod = new MySQLProduktBatchDAO();

	@Test
	void getProduktBatch() {
		try {
			new Connector();
			System.out.println(prod.getProduktBatch(1));
			ProduktBatchDTO actual = prod.getProduktBatch(1);
			ProduktBatchDTO expected = new ProduktBatchDTO(1, 2, 1);
			
			assertTrue((actual.toString()).equals(expected.toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void createProduktBatch() {
		try {
			new Connector();
			ProduktBatchDTO produkt = new ProduktBatchDTO(6, 0, 2);
			prod.createProduktBatch(produkt);
			
			ProduktBatchDTO actual = prod.getProduktBatch(6);
			ProduktBatchDTO expected = new ProduktBatchDTO(6, 0, 2);
			
			assertTrue((actual.toString()).equals(expected.toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void updateProduktBatch() {
		try {
			new Connector();
			ProduktBatchDTO produkt = prod.getProduktBatch(6);
			produkt.setStatus(2);
			
			prod.updateProduktBatch(produkt);
			
			ProduktBatchDTO actual = prod.getProduktBatch(6);
			ProduktBatchDTO expected = new ProduktBatchDTO(6, 2, 2);
			
			assertTrue((actual.toString()).equals(expected.toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
