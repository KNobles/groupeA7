package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Coordinator;


public interface IManagementCoordinatorEJB {
	
	public List<Coordinator> selectAll();
	
	public Coordinator add(Coordinator c);
	
	public Coordinator selectId(long id);
	
	public Coordinator update(Coordinator c);
	
	public void delete(Coordinator c);


}
