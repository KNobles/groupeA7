package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Seminary;

@Remote
public interface IManagementSeminaryEJB {
	
	public List<Seminary> selectAll();
	
	public String select(Long idStudent, Long idSeminary);
	
	public Seminary add(Seminary s);
	
	public Seminary selectId(Long id);
	
	public Seminary update(Seminary s);
	
	public void delete(Seminary s);
}
