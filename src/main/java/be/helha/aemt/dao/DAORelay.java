package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Director;
import be.helha.aemt.entities.Relay;

@Stateless
public class DAORelay {
	
	@PersistenceContext(unitName="rocroixJTA")
	private EntityManager em;
	
	public List<Relay> selectAll(){
		return em.createQuery("SELECT r FROM relay r").getResultList();
	}
	
	public Relay add(Relay s) {
		em.persist(s);
		return s;
	}
	
	public Relay selectId(long id) {
		Query query;
		String sSelect="SELECT r FROM relay r WHERE s.id=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Relay r = (Relay)query.getSingleResult();
		em.clear();
		return r;
	}
	
	//Update
		public Relay updateDirector(Relay r) {
			return em.merge(r);
		}
		
		//Delete
		public void deleteDirector(Relay r) {
			Query query = this.em.createQuery("DELETE r FROM relay r WHERE idRelay =?1");
			query.setParameter(1, r.getIdRelay());
			query.executeUpdate();
		}


}
