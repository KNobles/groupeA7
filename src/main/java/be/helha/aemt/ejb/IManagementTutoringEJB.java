package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Tutoring;

@Remote
public interface IManagementTutoringEJB {
	
	public List<Tutoring> selectAll();
	
	public String selectDemand(Long idStudent);
	
	public Tutoring add(Tutoring t);
	
	public Tutoring selectId(Long id);
	
	public Tutoring update(Tutoring t);
	
	public void delete(Tutoring t);

}
