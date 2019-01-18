package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOCourse;
import be.helha.aemt.entities.Course;

@LocalBean
@Stateless
public class ManagementCourseEJB implements IManagementCourseEJB {

	@EJB
	private DAOCourse daoCourse;
	
	@Override
	public List<Course> selectAll() {
		return this.daoCourse.selectAll();
	}

	@Override
	public Course add(Course c) {
		return this.daoCourse.add(c);
	}

	@Override
	public Course selectId(String id) {
		return this.daoCourse.selectId(id);
	}

	@Override
	public Course update(Course c) {
		return this.daoCourse.updateCourse(c);
	}

	@Override
	public void delete(Course c) {
		this.daoCourse.deleteCourse(c);
	}

	@Override
	public List<Course> selectBySection(String sectionCode) {
		return this.daoCourse.selectBySection(sectionCode);
	}

	

}
