package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Relay;


public interface IManagementRelayEJB {
	
	public List<Relay> selectAll();
	
	public Relay add(Relay r);
	
	public Relay selectId(long id);
	
	public Relay update(Relay r);
	
	public void delete(Relay r);

}
