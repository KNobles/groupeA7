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
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Users add(Users d) {
		// TODO Auto-generated method stub
		return dao.add(d);
	}

	@Override
	public Users selectId(String id) {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public Users update(Users d) {
		// TODO Auto-generated method stub
		return dao.update(d);
	}

	@Override
	public void delete(Users d) {
		// TODO Auto-generated method stub
		dao.delete(d);
	}

}
