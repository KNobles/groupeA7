package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Users;

@Remote
public interface IManagementUserEJB {

	public List<Users> selectAll();
	
	public Users add(Users d);
	
	public Users searchByMail(String mail);
	
	public Users update(Users d);
	
	public void delete(Users d);

}
