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
		return em.createQuery("SELECT c FROM Course c").getResultList();
	}
	
	public Course add(Course c) {
		em.persist(c);
		return c;
	}
	
	public Course selectId(String id) {
		Query query;
		String sSelect="SELECT c FROM Course c WHERE c.code=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Course c = (Course)query.getSingleResult();
		em.clear();
		return c;
	}
	
	//Update
	public Course updateCourse(Course c) {
		return em.merge(c);
	}
	
	//Delete
	public void deleteCourse(Course c) {
		Query query = this.em.createQuery("DELETE c FROM Course c WHERE code =?1");
		query.setParameter(1, c.getCode());
		query.executeUpdate();
	}
}
