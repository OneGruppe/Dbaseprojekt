package test01917;

import java.sql.ResultSet;
import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import dto01917.RaavareDTO;

public class Test_main_raavare {
	static RaavareDAO raav = new MySQLRaavareDAO();
	
	public static void createRaavare() {
		RaavareDTO raavare = new RaavareDTO(0, "Majs", "Majs Levering A/S");
		try {
			raav.createRaavare(raavare);
		} catch (DALException e) {
			System.out.println(e);
		}
	}
	public static void deleteRaavare() {
		int id = 0;
		try {
			ResultSet rs = Connector.doQuery("SELECT raavare_id FROM raavare WHERE raavare_navn = 'Majs'");
			while (rs.next()) {
				id = rs.getInt("raavare_id");
			}
			raav.deleteRaavare(id);
		} catch (DALException | SQLException e) {
			e.printStackTrace();
		}
	}
}
