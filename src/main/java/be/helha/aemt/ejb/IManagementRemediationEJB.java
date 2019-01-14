package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Remediation;

/**
 * 
 * @author Nobles
 *
 */

@Remote
public interface IManagementRemediationEJB {
	
	public List<Remediation> selectAll();
	
	public Remediation add(Remediation r);
	
	public Remediation updateAdmin(Remediation r);
	
	public void deleteAllRemediation(Remediation r);
}
