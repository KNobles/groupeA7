package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAORemediation;
import be.helha.aemt.entities.Remediation;
import be.helha.aemt.entities.Student;

/**
 * 
 * @author Nobles
 *
 */

@LocalBean
@Stateless
public class ManagementRemediationEJB implements IManagementRemediationEJB{
	@EJB
	private DAORemediation daoRemediation;
	
	@Override
	public List<Remediation> selectAll() {
		return this.daoRemediation.selectAll();
	}
	
	@Override
	public Remediation selectId(Long id) {
		return this.daoRemediation.selectId(id);
	}

	@Override
	public Remediation add(Remediation r) {
		return this.daoRemediation.add(r);
	}

	@Override
	public Remediation updateAdmin(Remediation r) {
		return this.daoRemediation.updateRemediation(r);
	}

	@Override
	public void deleteAllRemediation(Remediation r) {
		this.daoRemediation.deleteAllRemediations(r);
	}

	@Override
	public List<Student> selectAllStudents() {
		return this.daoRemediation.selectAllStudents();
	}

}
