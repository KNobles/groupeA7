package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Student;


public interface IManagementStudentEJB {
	
	public List<Student> selectAll();
	
	public Student add(Student s);
	
	public Student selectId(long id);
	
	public Student update(Student s);
	
	public void delete(Student s);


}
