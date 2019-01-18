package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Interview;

@Stateless
public class DAOInterview {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;	
	public List<Interview> selectAll (){
		return this.em.createQuery("SELECT i FROM Interview i", Interview.class).getResultList();
	}
	
	public Interview add(Interview i) {
		this.em.persist(i);
		return i;
	}
	
	public Interview selectId(Long id) {
		Query query;
		String sSelectId="SELECT i FROM Interview i WHERE i.idInterview=?1";
		query=this.em.createQuery(sSelectId);
		query.setParameter(1,id);
		Interview i =(Interview) query.getSingleResult();
		this.em.clear();
		return i;	
	}
	
	public Interview updateInterview(Interview i) {
		return this.em.merge(i);
	}
	
	//Delete
	public void deleteAllInterviews(Interview i) {
		Query query = this.em.createQuery("DELETE i FROM Interview i WHERE idInterview =?1");
		query.setParameter(1,  i.getIdInterview());
		query.executeUpdate();
	}
}
