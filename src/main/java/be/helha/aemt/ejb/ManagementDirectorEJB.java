package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAODirector;
import be.helha.aemt.entities.Director;

@LocalBean
@Stateless
public class ManagementDirectorEJB implements IManagementDirectorEJB{
	
	@EJB
	private DAODirector dao;

	@Override
	public List<Director> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Director add(Director d) {
		// TODO Auto-generated method stub
		return dao.add(d);
	}

	@Override
	public Director selectId(long id) {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public Director update(Director d) {
		// TODO Auto-generated method stub
		return dao.updateDirector(d);
	}

	@Override
	public void delete(Director d) {
		// TODO Auto-generated method stub
		dao.deleteDirector(d);
	}

}
