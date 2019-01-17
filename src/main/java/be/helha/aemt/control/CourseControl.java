package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementCourseEJB;
import be.helha.aemt.entities.Course;

@RequestScoped
@Named
public class CourseControl {
	
	@EJB
	ManagementCourseEJB bean;
	Course course;
	
	public List<Course> doSelectAll(){
		return bean.selectAll();
	}

	public List<Course> doSelectBySection(String sectionCode){
		return bean.selectBySection(sectionCode);
	}
	
	public Course doAdd(Course c) {
		return bean.add(c);
	}
}
