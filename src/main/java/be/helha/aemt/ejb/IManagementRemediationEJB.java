package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Remediation;
import be.helha.aemt.entities.Student;

/**
 * 
 * @author Nobles
 *
 */

@Remote
public interface IManagementRemediationEJB {
	
	public List<Remediation> selectAll();
	
	public Remediation selectId(Long id);
	
	public Remediation add(Remediation r);
	
	public Remediation updateAdmin(Remediation r);
	
	public void deleteAllRemediation(Remediation r);
	
	public List<Student> selectAllStudents();
}
