package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.dao.DAOCourse;
import be.helha.aemt.entities.Course;

public class ManagementCourseEJB implements IManagementCourseEJB {

	DAOCourse daoCourse;
	
	@Override
	public List<Course> selectAll() {
		return daoCourse.selectAll();
	}

	@Override
	public Course add(Course c) {
		return daoCourse.add(c);
	}

	@Override
	public Course selectId(String id) {
		return daoCourse.selectId(id);
	}

	@Override
	public Course update(Course c) {
		return daoCourse.updateCourse(c);
	}

	@Override
	public void delete(Course c) {
		daoCourse.deleteCourse(c);
	}

	

}
