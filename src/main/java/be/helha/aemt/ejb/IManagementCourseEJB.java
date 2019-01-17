package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Course;

@Remote
public interface IManagementCourseEJB {

	public List<Course> selectAll();
	
	public List<Course> selectBySection(String sectionCode);
	
	public Course add(Course c);
	
	public Course selectId(String code);
	
	public Course update(Course c);
	
	public void delete(Course c);
}
