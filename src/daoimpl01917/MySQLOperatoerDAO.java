package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import dto01917.OperatoerDTO;

public class MySQLOperatoerDAO implements OperatoerDAO {
	public OperatoerDTO getOperatoer(int oprId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM UserViewWithRoles WHERE opr_id = " + oprId);
	    try {
	    	if (!rs.first()) 
	    	{
	    		throw new DALException("Operatoeren " + oprId + " findes ikke");
	    	}
	    	return new OperatoerDTO (rs.getInt("opr_id"), rs.getString("fornavn"), rs.getString("efternavn"), rs.getString("ini"), rs.getInt("aktiv"), rs.getString("cpr"), rs.getString("password"), null);
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createOperatoer(OperatoerDTO opr) throws DALException {		
			List<Integer> roles = opr.getRoles();
			Connector.doUpdate(
				"CALL add_operatoer('" +opr.getFornavn()+ "', '" +opr.getEfternavn()+ "', '" +opr.getIni()+ "', "
				+opr.getAktiv()+ ", '" +opr.getCpr()+ "', '" +opr.getPassword()+ "')"
			);
			
			for(int role : roles)
			{
				Connector.doUpdate("CALL add_oprRolle(" +opr.getOprId()+ ", " +role+ ")");
			}
	}
	
	public void updateOperatoer(OperatoerDTO opr) throws DALException {
		Connector.doUpdate(
				"CALL update_operatoer (" +opr.getOprId()+ ", '"  +opr.getFornavn()+ "', '" +opr.getEfternavn()+ "', '" +opr.getIni()+ 
				"', '" + opr.getCpr() + "', '" +opr.getPassword()+ "', " +opr.getAktiv()+ ")"
		);
	}
	
	public List<OperatoerDTO> getOperatoerList() throws DALException {
		List<OperatoerDTO> list = new ArrayList<OperatoerDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM UserView");
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatoerDTO(rs.getInt("opr_id"), rs.getString("fornavn"), rs.getString("efternavn"), rs.getString("ini"), rs.getInt("aktiv"), rs.getString("cpr"), rs.getString("password"), null));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
		
		
}
	
