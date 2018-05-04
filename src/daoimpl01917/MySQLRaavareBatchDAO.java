package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO {

	@Override
	public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE rb_id = " + rbId);

		try {
			if (!rs.first())
			{
				throw new DALException("Råvarebatchet " + rbId + " findes ikke");
			}
			return new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		List<RaavareBatchDTO> raaBatchList = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
		try {
			while(rs.next()) {
				raaBatchList.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
			}
			
		} catch(SQLException e) {
			throw new DALException(e);
		}
		
		return raaBatchList;
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		List<RaavareBatchDTO> raaBatchList = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE raavare_id= " +raavareId);
		try {
			while(rs.next()) {
				raaBatchList.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
			}
			
		} catch(SQLException e) {
			throw new DALException(e);
		}
		
		return raaBatchList;	
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate("INSERT INTO raavarebatch (raavare_id_pb, maengde), VALUES = (" + raavarebatch.getRaavareId() + "," + raavarebatch.getMaengde());
	}

	@Override
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate("UPDATE raavarebatch SET raavare_id_rb = " + raavarebatch.getRbId() + ", maengde = " + raavarebatch.getMaengde() + ", WHERE rb_id = " + raavarebatch.getRaavareId());
	}

}
