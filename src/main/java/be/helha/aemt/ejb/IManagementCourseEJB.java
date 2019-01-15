package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Course;
import be.helha.aemt.entities.User;

public interface IManagementCourseEJB {

	public List<Course> selectAll();
	
	public Course add(Course c);
	
	public Course selectId(String id);
	
	public Course update(Course c);
	
	public void delete(Course c);
}
