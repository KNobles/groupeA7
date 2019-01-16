package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOStudent;
import be.helha.aemt.entities.Student;

@LocalBean
@Stateless
public class ManagementStudentEJB implements IManagementStudentEJB{
	
	@EJB
	private DAOStudent dao;

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

}
