package be.helha.aemt.ejb;

import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.Order;

import be.helha.aemt.dao.DAOStudent;
import be.helha.aemt.entities.Student;

@LocalBean
@Stateless
public class ManagementStudentEJB implements IManagementStudentEJB{
	
	@EJB
	private DAOStudent dao;
	private boolean sortAscending = true;
	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Student add(Student s) {
		// TODO Auto-generated method stub


		return dao.add(s);
	}

	@Override
	public Student selectId(Long id) {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public Student update(Student s) {
		// TODO Auto-generated method stub
		return dao.updateStudent(s);
	}

	@Override
	public void delete(Student s) {
		// TODO Auto-generated method stub
		dao.deleteStudent(s);
	}

	

	public List<Student> selectBySection(String section) {
		return dao.selectBySection(section);
	}

	public Student selectByName(String name, String firstname) {
		return dao.selectByName(name, firstname);
	}
	
	public String getSection(Long idStudent) {
		return dao.getSection(idStudent);
	}
	

}
