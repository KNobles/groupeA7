package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Course;

@Stateless
public class DAOCourse {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Course> selectAll(){
		return this.em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
	}
	
	public Course add(Course c) {
		this.em.persist(c);
		return c;
	}
	
	public List<Course> selectBySection(String sectionCode){
		Query query;
		String sSelect = "Select c FROM Course c JOIN c.sections s WHERE s.code =?1";
		query=this.em.createQuery(sSelect);
		query.setParameter(1, sectionCode);
		return query.getResultList();
	}
	
	public Course selectId(String id) {
		Query query;
		String sSelect="SELECT c FROM Course c WHERE c.code=?1";
		query=this.em.createQuery(sSelect);
		query.setParameter(1, id);
		Course c = (Course)query.getSingleResult();
		this.em.clear();
		return c;
	}
	
	//Update
	public Course updateCourse(Course c) {
		return this.em.merge(c);
	}
	
	//Delete
	public void deleteCourse(Course c) {
		Query query = this.em.createQuery("DELETE c FROM Course c WHERE code =?1");
		query.setParameter(1, c.getCode());
		query.executeUpdate();
	}
}
