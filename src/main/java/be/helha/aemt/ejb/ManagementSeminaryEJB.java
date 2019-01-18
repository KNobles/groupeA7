package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOSeminary;
import be.helha.aemt.entities.Seminary;

@LocalBean
@Stateless
public class ManagementSeminaryEJB implements IManagementSeminaryEJB{

	@EJB
	private DAOSeminary daoSeminary;
	
	@Override
	public List<Seminary> selectAll() {
		return this.daoSeminary.selectAll();
	}

	@Override
	public Seminary add(Seminary s) {
		return this.daoSeminary.add(s);
	}

	@Override
	public Seminary selectId(Long id) {
		return this.daoSeminary.selectId(id);
	}

	@Override
	public Seminary update(Seminary s) {
		return this.daoSeminary.updateSeminary(s);
	}

	@Override
	public void delete(Seminary s) {
		this.daoSeminary.deleteSeminary(s);
	}

	@Override
	public String select(Long idStudent, Long idSeminary) {
		return this.daoSeminary.select(idStudent, idSeminary);
	}
	
	public Long selectCount(Long idStudent) {
		return this.daoSeminary.selectCount(idStudent);
	}

}
