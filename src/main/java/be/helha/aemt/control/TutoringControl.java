package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementTutoringEJB;
import be.helha.aemt.entities.Tutoring;

@RequestScoped
@Named
public class TutoringControl {
	
	@EJB
	ManagementTutoringEJB bean;
	Tutoring tutoring;
	
	public List<Tutoring> doSelectAll(){
		return bean.selectAll();
	}
	
	public String selectDemand(Long idStudent) {
		return bean.selectDemand(idStudent);
	}

}
