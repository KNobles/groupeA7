package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementTutoringEJB;
import be.helha.aemt.entities.Tutoring;

@RequestScoped
/**
 * permet de pr�ciser au serveur que ce bean a pour port�e la requ�te. 
 * Il s'agit en l�occurrence de la port�e utilis�e par d�faut en cas d'absence d'annotation. 
 * Ainsi, si vous omettez de l'�crire, le bean sera de toute mani�re plac� dans la port�e requ�te. 
 * C'est toutefois une bonne pratique de toujours �crire cette annotation, afin de clarifier le code.  *
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
