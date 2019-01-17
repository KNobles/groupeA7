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
		return daoSeminary.selectAll();
	}

	@Override
	public Seminary add(Seminary s) {
		return daoSeminary.add(s);
	}

	@Override
	public Seminary selectId(Long id) {
		return daoSeminary.selectId(id);
	}

	@Override
	public Seminary update(Seminary s) {
		return daoSeminary.updateSeminary(s);
	}

	@Override
	public void delete(Seminary s) {
		daoSeminary.deleteSeminary(s);
	}

	@Override
	public String select(Long idStudent, Long idSeminary) {
		return daoSeminary.select(idStudent, idSeminary);
	}
	
	public Long selectCount(Long idStudent) {
		return daoSeminary.selectCount(idStudent);
	}

}
