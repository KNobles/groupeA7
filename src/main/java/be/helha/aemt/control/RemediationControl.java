package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementRemediationEJB;
import be.helha.aemt.entities.Remediation;
import be.helha.aemt.entities.Student;

@Named
@RequestScoped
public class RemediationControl implements Serializable {
	@EJB
	private ManagementRemediationEJB bean;
	private Remediation remediation = new Remediation();
	
	public List<Remediation> doSelectAll(){
		return bean.selectAll();
	}
	
	public ManagementRemediationEJB getBean() {
		return bean;
	}
	
	public void setBean(ManagementRemediationEJB bean) {
		this.bean = bean;
	}
	
	 public Remediation getRemediation() {
		 return remediation;
	 }
	 
	 public void setRemediation(Remediation remediation) {
		 this.remediation = remediation;
	 }
	 
	 public List<Student> selectAllStudents() {
		 return bean.selectAllStudents();
	 }
	 
}
