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
	private boolean sortAscending = true;
	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return this.dao.selectAll();
	}

	@Override
	public Student add(Student s) {
		// TODO Auto-generated method stub


		return this.dao.add(s);
	}

	@Override
	public Student selectId(Long id) {
		// TODO Auto-generated method stub
		return this.dao.selectId(id);
	}

	@Override
	public Student update(Student s) {
		// TODO Auto-generated method stub
		return this.dao.updateStudent(s);
	}

	@Override
	public void delete(Student s) {
		// TODO Auto-generated method stub
		this.dao.deleteStudent(s);
	}

	

	public List<Student> selectBySection(String section) {
		return this.dao.selectBySection(section);
	}

	public Student selectByName(String name, String firstname) {
		return this.dao.selectByName(name, firstname);
	}
	
	public String getSection(Long idStudent) {
		return this.dao.getSection(idStudent);
	}

	public boolean isSortAscending() {
		return this.sortAscending;
	}

	public void setSortAscending(boolean sortAscending) {
		this.sortAscending = sortAscending;
	}
	

}
