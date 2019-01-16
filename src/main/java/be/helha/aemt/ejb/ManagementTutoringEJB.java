package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOTutoring;
import be.helha.aemt.entities.Tutoring;

@LocalBean
@Stateless
public class ManagementTutoringEJB implements IManagementTutoringEJB {

	DAOTutoring daoTutoring;
	
	@Override
	public List<Tutoring> selectAll() {
		return daoTutoring.selectAll();
	}

	@Override
	public Tutoring add(Tutoring t) {
		return daoTutoring.add(t);
	}

	@Override
	public Tutoring selectId(Long id) {
		return daoTutoring.selectId(id);
	}

	@Override
	public Tutoring update(Tutoring t) {
		return daoTutoring.updateTutoring(t);
	}

	@Override
	public void delete(Tutoring t) {
		daoTutoring.deleteTutoring(t);
		
	}
	
}
