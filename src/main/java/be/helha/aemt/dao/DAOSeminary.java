package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Seminary;

@Stateless
public class DAOSeminary {
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Seminary> selectAll(){
		return em.createQuery("SELECT s FROM Seminary s").getResultList();
	}
	
	public Seminary add(Seminary s) {
		em.persist(s);
		return s;
	}
	
	public Seminary selectId(long id) {
		Query query;
		String sSelect="SELECT s FROM Seminary s WHERE s.idSeminary=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Seminary s = (Seminary)query.getSingleResult();
		em.clear();
		return s;
	}
	
	//Update
		public Seminary updateSeminary(Seminary s) {
			return em.merge(s);
		}
		
		//Delete
		public void deleteSeminary(Seminary s) {
			Query query = this.em.createQuery("DELETE s FROM Seminary s WHERE idSeminary =?1");
			query.setParameter(1, s.getIdSeminary());
			query.executeUpdate();
		}
}
