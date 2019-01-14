package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Remediation;

public class DAORemediation {
	@PersistenceContext(unitName="noblesJTA")
	private EntityManager em;	
	public List<Remediation> selectAll (){
		return em.createQuery("SELECT r FROM Remediation r").getResultList();
	}
	
	public Remediation add(Remediation r) {
		em.persist(r);
		return r;
	}
	
	public Remediation selectId(long id) {
		Query query;
		String sSelectId="SELECT r FROM Remediation r WHERE r.id=?1";
		query=em.createQuery(sSelectId);
		query.setParameter(1,id);
		Remediation r =(Remediation) query.getSingleResult();
		em.clear();
		return r;	
	}
	
	public Remediation updateRemediation(Remediation r) {
		return em.merge(r);
	}
	
	//Delete
	public void deleteAllRemediations(Remediation r) {
		Query query = this.em.createQuery("DELETE r FROM Remediation r WHERE idRemediation =?1");
		query.setParameter(1,  r.getIdRemediation());
		query.executeUpdate();
	}
}