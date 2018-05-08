package dto01917;

import java.util.List;

/**
 * Operatoer Data Access Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class OperatoerDTO
{
	/** Operatoer-identifikationsnummer (opr_id) i omraadet 1-99999999. Vaelges af brugerne */
	int oprId;                     
	/** Operatoernavn (fornavn) max. 45 karakterer */
	String fornavn;
	/** Operatoernavn (efternavn) max. 45 karakterer */
	String efternavn;  
	/** Operatoer-initialer max. 45 karakterer */
	String ini;                 
	/** Operatoer cpr-nr 11 karakterer */
	String cpr;                  
	/** Operatoer password max. 45 karakterer */
	String password;
	/** Operatoer rolle */
	List<Integer> roles;

	public OperatoerDTO(int oprId, String fornavn, String efternavn, String ini, String cpr, String password, List<Integer> roles)
	{
		this.oprId = oprId;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
		this.roles = roles;
	}
	
    public OperatoerDTO(OperatoerDTO opr)
    {
    	this.oprId = opr.getOprId();
    	this.fornavn = opr.getFornavn();
    	this.efternavn =opr.getEfternavn();
    	this.ini = opr.getIni();
    	this.cpr = opr.getCpr();
    	this.password = opr.getPassword();
    	this.roles = opr.getRoles();
    }
    
    public int getOprId() { return oprId; }
	public void setOprId(int oprId) { this.oprId = oprId; }
	public String getFornavn() { return fornavn; }
	public void setFornavn(String fornavn) { this.fornavn = fornavn; }
	public String getEfternavn() { return efternavn; }
	public void setEfternavn(String efternavn) { this.efternavn = efternavn; }
	public String getIni() { return ini; }
	public void setIni(String ini) { this.ini = ini; }
	public String getCpr() { return cpr; }
	public void setCpr(String cpr) { this.cpr = cpr; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public List<Integer> getRoles() { return roles; }
	public void setRoles(List<Integer> roles) {	this.roles = roles; }

	public String toString() { return "Id: " + oprId + ", Fornavn: " + fornavn + ", Efternavn: " + efternavn + ", Ini: " + ini + ", CPR: " + cpr + ", Password:" + password; }
}
