package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;

import be.helha.aemt.dao.DAOCoordinator;
import be.helha.aemt.entities.Coordinator;


public class ManagementCoordinatorEJB implements IManagementCoordinatorEJB {
	
	@EJB
	private DAOCoordinator dao;

	@Override
	public List<Coordinator> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Coordinator add(Coordinator c) {
		// TODO Auto-generated method stub
		return dao.add(c);
	}

	@Override
	public Coordinator selectId(long id) {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public Coordinator update(Coordinator c) {
		// TODO Auto-generated method stub
		return dao.updateCoordinator(c);
	}

	@Override
	public void delete(Coordinator c) {
		// TODO Auto-generated method stub
		dao.deleteCoordinator(c);
	}

}
