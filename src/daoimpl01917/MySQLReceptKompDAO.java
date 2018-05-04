package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptKompDAO;
import dto01917.ReceptKompDTO;

public class MySQLReceptKompDAO implements ReceptKompDAO{

	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = " +receptId+ " AND raavare_id = " +raavareId);

		try {
			if (!rs.first()) 
			{				
				throw new DALException("Receptkomponenten " +receptId+ "-" +raavareId+ " findes ikke");
			}
			return new ReceptKompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		List<ReceptKompDTO> receptKompList = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id= " +receptId);
		try {
			while(rs.next()) {
				receptKompList.add(new ReceptKompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
			}
			
		} catch(SQLException e) {
			throw new DALException(e);
		}
		
		return receptKompList;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		List<ReceptKompDTO> receptKompList = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent");
		try {
			while(rs.next()) {
				receptKompList.add(new ReceptKompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
			}
			
		} catch(SQLException e) {
			throw new DALException(e);
		}
		
		return receptKompList;
	}

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doUpdate("INSERT INTO receptkomponent (recept_id_rk, raacvare_id_rk, nom_netto, tolerance) VALUES (" + receptkomponent.getReceptId() + ", " + receptkomponent.getRaavareId() + ", " + receptkomponent.getNomNetto() + ", " + receptkomponent.getTolerance());
	}
	
	@Override
	public void deleteReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doUpdate("DELETE FROM receptkomponent, WHERE recept_id_rk = " + receptkomponent.getReceptId());
	}

}
