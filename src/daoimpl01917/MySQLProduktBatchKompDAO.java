package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchKompDTO;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO {

	@Override
	public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " +pbId+ " AND rb_id = " +rbId);

		try {
			if (!rs.first()) 
			{				
				throw new DALException("Produktbatchkomponenten " + pbId + " findes ikke");
			}
			return new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
		List<ProduktBatchKompDTO> prodKompList = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id= " +pbId);
		try {
			while(rs.next()) {
				prodKompList.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
			
		} catch(SQLException e) {
			throw new DALException(e);
		}
		
		return prodKompList;	
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
		List<ProduktBatchKompDTO> prodKompList = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
		try {
			while(rs.next()) {
				prodKompList.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
			
		} catch(SQLException e) {
			throw new DALException(e);
		}
		
		return prodKompList;
	}

	@Override
	public void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate("INSERT INTO produktbatchkomponent (pb_id_pbk, rb_id_pbk, tara, netto, opr_id_pbk) VALUES (" + produktbatchkomponent.getPbId() + "," + produktbatchkomponent.getRbId() + "," + produktbatchkomponent.getTara() + "," + produktbatchkomponent.getNetto() + "," + produktbatchkomponent.getOprId() + "), WHERE pb_id_pbk = " + produktbatchkomponent.getPbId());
	}
	
	@Override
	public void deleteProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate("DELETE FROM produktbatchkomponent, WHERE pb_id_pbk =" + produktbatchkomponent.getPbId());
	}
}
