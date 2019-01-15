package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.User;
import be.helha.aemt.entities.Student;

@Stateless
public class DAODirector {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<User> selectAll(){
		return em.createQuery("SELECT d FROM director d").getResultList();
	}
	
	public User add(User s) {
		em.persist(s);
		return s;
	}
	
	public User selectId(long id) {
		Query query;
		String sSelect="SELECT d FROM director d WHERE d.idDirector=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		User s = (User)query.getSingleResult();
		em.clear();
		return s;
	}
	
	//Update
		public User updateDirector(User d) {
			return em.merge(d);
		}
		
		//Delete
		public void deleteDirector(User d) {
			Query query = this.em.createQuery("DELETE d FROM director d WHERE idDirector =?1");
			query.setParameter(1, d.getIdDirector());
			query.executeUpdate();
		}

}
