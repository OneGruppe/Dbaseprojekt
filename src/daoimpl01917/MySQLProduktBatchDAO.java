package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO {

	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pb_id = " + pbId);
		
		try {
	    	if (!rs.first()) 
	    	{
	    		throw new DALException("Produktbatchet " + pbId + " findes ikke");
	    	}
	    	return new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		List<ProduktBatchDTO> prodList = new ArrayList<ProduktBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
		try {
			while(rs.next()) {
				prodList.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
			}
			
		} catch(SQLException e) {
			throw new DALException(e);
		}
		
		return prodList;
	}

	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		Connector.doUpdate(
				"CALL add_pb (" 
				+produktbatch.getPbId()+ ", " +produktbatch.getStatus()+ ", " +produktbatch.getReceptId()+ ")"
				);		
	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		Connector.doUpdate(
				"CALL update_pb( " 
				+produktbatch.getPbId()+ ", " +produktbatch.getStatus()+ ", " +produktbatch.getReceptId()+ ")"
				);
		
	}

}
