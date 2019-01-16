package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAORemediation;
import be.helha.aemt.entities.Remediation;

/**
 * 
 * @author Nobles
 *
 */

@LocalBean
@Stateless
public class ManagementRemediationEJB implements IManagementRemediationEJB{

	DAORemediation daoRemediation;
	
	@Override
	public List<Remediation> selectAll() {
		return daoRemediation.selectAll();
	}
	
	@Override
	public Remediation selectId(Long id) {
		return daoRemediation.selectId(id);
	}

	@Override
	public Remediation add(Remediation r) {
		return daoRemediation.add(r);
	}

	@Override
	public Remediation updateAdmin(Remediation r) {
		return daoRemediation.updateRemediation(r);
	}

	@Override
	public void deleteAllRemediation(Remediation r) {
		daoRemediation.deleteAllRemediations(r);
	}

}
