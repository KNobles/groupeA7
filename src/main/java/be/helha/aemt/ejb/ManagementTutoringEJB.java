package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOTutoring;
import be.helha.aemt.entities.Tutoring;

@LocalBean
@Stateless
public class ManagementTutoringEJB implements IManagementTutoringEJB {

	@EJB
	private DAOTutoring daoTutoring;
	
	@Override
	public List<Tutoring> selectAll() {
		return this.daoTutoring.selectAll();
	}

	@Override
	public Tutoring add(Tutoring t) {
		return this.daoTutoring.add(t);
	}

	@Override
	public Tutoring selectId(Long id) {
		return this.daoTutoring.selectId(id);
	}

	@Override
	public Tutoring update(Tutoring t) {
		return this.daoTutoring.updateTutoring(t);
	}

	@Override
	public void delete(Tutoring t) {
		this.daoTutoring.deleteTutoring(t);
		
	}

	@Override
	public String selectDemand(Long idStudent) {
		return this.daoTutoring.selectDemand(idStudent);
	}
	
}
