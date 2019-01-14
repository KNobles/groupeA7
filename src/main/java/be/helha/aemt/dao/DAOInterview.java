package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Interview;

@Stateless
public class DAOInterview {
	
	@PersistenceContext(unitName="noblesJTA")
	private EntityManager em;	
	public List<Interview> selectAll (){
		return em.createQuery("SELECT i FROM Interview i").getResultList();
	}
	
	public Interview add(Interview i) {
		em.persist(i);
		return i;
	}
	
	public Interview selectId(long id) {
		Query query;
		String sSelectId="SELECT i FROM Interview i WHERE i.id=?1";
		query=em.createQuery(sSelectId);
		query.setParameter(1,id);
		Interview i =(Interview) query.getSingleResult();
		em.clear();
		return i;	
	}
	
	public Interview updateInterview(Interview i) {
		return em.merge(i);
	}
	
	//Delete
	public void deleteAllInterviews(Interview i) {
		Query query = this.em.createQuery("DELETE i FROM Interview i WHERE idInterview =?1");
		query.setParameter(1,  i.getIdInterview());
		query.executeUpdate();
	}
}
