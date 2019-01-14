package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Director;
import be.helha.aemt.entities.Student;

@Stateless
public class DAODirector {
	
	@PersistenceContext(unitName="rocroixJTA")
	private EntityManager em;
	
	public List<Director> selectAll(){
		return em.createQuery("SELECT d FROM director d").getResultList();
	}
	
	public Director add(Director s) {
		em.persist(s);
		return s;
	}
	
	public Director selectId(long id) {
		Query query;
		String sSelect="SELECT d FROM director d WHERE d.idDirector=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Director s = (Director)query.getSingleResult();
		em.clear();
		return s;
	}
	
	//Update
		public Director updateDirector(Director d) {
			return em.merge(d);
		}
		
		//Delete
		public void deleteDirector(Director d) {
			Query query = this.em.createQuery("DELETE d FROM director d WHERE idDirector =?1");
			query.setParameter(1, d.getIdDirector());
			query.executeUpdate();
		}

}
