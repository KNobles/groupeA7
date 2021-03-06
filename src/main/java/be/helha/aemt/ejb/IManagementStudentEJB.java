package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Student;

@Remote
public interface IManagementStudentEJB {
	
	public List<Student> selectAll();
	
	public List<Student> selectBySection(String section);
	
	public String getSection(Long idStudent);
	
	public Student add(Student s);
		
	public Student selectId(Long id);
		
	public Student update(Student s);
	
	public void delete(Student s);
	


}
