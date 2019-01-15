package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Tutoring;

@Stateless
public class DAOTutoring {
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Tutoring> selectAll(){
		return em.createQuery("SELECT t FROM Tutoring s").getResultList();
	}
	
	public Tutoring add(Tutoring t) {
		em.persist(t);
		return t;
	}
	
	public Tutoring selectId(long id) {
		Query query;
		String sSelect="SELECT t FROM Tutoring t WHERE s.idTutoring=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Tutoring t = (Tutoring)query.getSingleResult();
		em.clear();
		return t;
	}
	
	//Update
		public Tutoring updateTutoring(Tutoring s) {
			return em.merge(s);
		}
		
		//Delete
		public void deleteTutoring(Tutoring s) {
			Query query = this.em.createQuery("DELETE t FROM Tutoring t WHERE idTutoring =?1");
			query.setParameter(1, s.getIdTutoring());
			query.executeUpdate();
		}
}
