package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Admin;

public interface IManagementAdminEJB {
	
	public List<Admin> selectAll();
	
	public Admin add(Admin a);
	
	public Admin updateAdmin(Admin a);
	
	public void deleteAllAdmin(Admin a);
}
