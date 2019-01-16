package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Tutoring;


public interface IManagementTutoringEJB {
	
	public List<Tutoring> selectAll();
	
	public Tutoring add(Tutoring t);
	
	public Tutoring selectId(Long id);
	
	public Tutoring update(Tutoring t);
	
	public void delete(Tutoring t);

}
