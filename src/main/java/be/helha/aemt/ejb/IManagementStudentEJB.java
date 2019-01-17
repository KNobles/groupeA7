package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Student;

@Remote
public interface IManagementStudentEJB {
	
	public List<Student> selectAll();
	
	public Student add(Student s);
		
	public Student selectId(Long id);
	
	public List<Student> selectName(String name);
	
	public Student update(Student s);
	
	public void delete(Student s);
	
	public String sortByName();


}
