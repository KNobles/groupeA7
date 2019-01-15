package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAODirector;
import be.helha.aemt.entities.User;

@LocalBean
@Stateless
public class ManagementUserEJB implements IManagementUserEJB{
	
	@EJB
	private DAODirector dao;

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public User add(User d) {
		// TODO Auto-generated method stub
		return dao.add(d);
	}

	@Override
	public User selectId(long id) {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public User update(User d) {
		// TODO Auto-generated method stub
		return dao.updateDirector(d);
	}

	@Override
	public void delete(User d) {
		// TODO Auto-generated method stub
		dao.deleteDirector(d);
	}

}
