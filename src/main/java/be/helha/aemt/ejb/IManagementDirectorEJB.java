package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Director;

public interface IManagementDirectorEJB {

public List<Director> selectAll();
	
	public Director add(Director d);
	
	public Director selectId(long id);
	
	public Director update(Director d);
	
	public void delete(Director d);
}
