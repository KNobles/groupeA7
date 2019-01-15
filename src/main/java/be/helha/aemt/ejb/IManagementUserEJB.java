package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.User;

@Remote
public interface IManagementUserEJB {

	public List<User> selectAll();
	
	public User add(User d);
	
	public User selectId(long id);
	
	public User update(User d);
	
	public void delete(User d);
}
