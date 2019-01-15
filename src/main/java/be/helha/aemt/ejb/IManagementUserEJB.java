package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.User;

public interface IManagementUserEJB {

	public List<User> selectAll();
	
	public User add(User d);
	
	public User selectId(long id);
	
	public User update(User d);
	
	public void delete(User d);
}
