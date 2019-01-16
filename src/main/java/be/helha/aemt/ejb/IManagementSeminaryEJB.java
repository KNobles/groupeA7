package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Seminary;

public interface IManagementSeminaryEJB {
	
	public List<Seminary> selectAll();
	
	public Seminary add(Seminary s);
	
	public Seminary selectId(Long id);
	
	public Seminary update(Seminary s);
	
	public void delete(Seminary s);
}
