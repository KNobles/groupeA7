package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOAdmin;
import be.helha.aemt.entities.Admin;

/**
 * 
 * @author Nobles
 *
 */

@Stateless
public class ManagementAdminEJB implements IManagementAdminEJB {

	private DAOAdmin daoAdmin;
	
	@Override
	public List<Admin> selectAll() {
		return daoAdmin.selectAll();
	}

	@Override
	public Admin add(Admin a) {
		return daoAdmin.add(a);
	}

	@Override
	public Admin updateAdmin(Admin a) {
		return daoAdmin.updateAdmin(a);
	}

	@Override
	public void deleteAllAdmin(Admin a) {
		daoAdmin.deleteAllAdmins(a);
	}

}
