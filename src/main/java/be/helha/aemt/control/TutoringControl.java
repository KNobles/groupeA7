package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementTutoringEJB;
import be.helha.aemt.entities.Tutoring;

@RequestScoped
/**
 * permet de préciser au serveur que ce bean a pour portée la requête. 
 * Il s'agit en l’occurrence de la portée utilisée par défaut en cas d'absence d'annotation. 
 * Ainsi, si vous omettez de l'écrire, le bean sera de toute manière placé dans la portée requête. 
 * C'est toutefois une bonne pratique de toujours écrire cette annotation, afin de clarifier le code.  *
 */
@Named
public class TutoringControl {
	
	@EJB
	ManagementTutoringEJB bean;
	Tutoring tutoring;
	
	public List<Tutoring> doSelectAll(){
		return this.bean.selectAll();
	}
	
	public String selectDemand(Long idStudent) {
		return this.bean.selectDemand(idStudent);
	}

}
