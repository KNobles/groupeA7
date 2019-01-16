package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOSeminary;
import be.helha.aemt.entities.Seminary;

@LocalBean
@Stateless
public class ManagementSeminaryEJB implements IManagementSeminaryEJB{

	DAOSeminary daoSeminary;
	
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

}
