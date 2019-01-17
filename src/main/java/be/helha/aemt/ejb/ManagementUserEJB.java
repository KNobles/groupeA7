package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOUser;
import be.helha.aemt.entities.Users;

@LocalBean
@Stateless
public class ManagementUserEJB implements IManagementUserEJB{
	
	@EJB
	private DAOUser dao;

	@Override
	public List<Users> selectAll() {
		return this.dao.selectAll();
	}

	@Override
	public Users add(Users d) {
		return this.dao.add(d);
	}

	@Override
	public Users searchByMail(String mail) {
		return this.dao.findByMail(mail);
	}

	@Override
	public Users update(Users d) {
		return this.dao.update(d);
	}

	@Override
	public void delete(Users d) {
		this.dao.delete(d);
	}
}
