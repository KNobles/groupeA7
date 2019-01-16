package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Coordinator;

@Stateless
public class DAOCoordinator {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Coordinator> selectAll(){
		return em.createQuery("SELECT c FROM coordinator c").getResultList();
	}
	
	public Coordinator add(Coordinator c) {
		em.persist(c);
		return c;
	}
	
	public Coordinator selectId(Integer id) {
		Query query;
		String sSelect="SELECT c FROM coordinator c WHERE c.idCoordinator=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Coordinator c = (Coordinator)query.getSingleResult();
		em.clear();
		return c;
	}
	
	//Update
		public Coordinator updateCoordinator(Coordinator c) {
			return em.merge(c);
		}
		
		//Delete
		public void deleteCoordinator(Coordinator c) {
			Query query = this.em.createQuery("DELETE r FROM relay r WHERE idRelay =?1");
			query.setParameter(1, c.getIdRelay());
			query.executeUpdate();
		}

}
