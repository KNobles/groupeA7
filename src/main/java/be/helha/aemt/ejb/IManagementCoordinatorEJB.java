package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Coordinator;

@Remote
public interface IManagementCoordinatorEJB {
	
	public List<Coordinator> selectAll();
	
	public Coordinator add(Coordinator c);
	
	public Coordinator selectId(Integer id);
	
	public Coordinator update(Coordinator c);
	
	public void delete(Coordinator c);


}
