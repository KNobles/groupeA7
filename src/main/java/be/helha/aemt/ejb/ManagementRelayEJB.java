package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAORelay;
import be.helha.aemt.entities.Relay;

@LocalBean
@Stateless
public class ManagementRelayEJB implements IManagementRelayEJB {
	
	@EJB
	private DAORelay dao;

	@Override
	public List<Relay> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Relay add(Relay r) {
		// TODO Auto-generated method stub
		return dao.add(r);
	}

	@Override
	public Relay selectId(long id) {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public Relay update(Relay r) {
		// TODO Auto-generated method stub
		return dao.updateRelay(r);
	}

	@Override
	public void delete(Relay r) {
		// TODO Auto-generated method stub
		dao.deleteRelay(r);
	}

	

}
