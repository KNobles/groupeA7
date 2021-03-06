package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Report;

@Stateless
public class DAOReport {
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;	
	public List<Report> selectAll (){
		return this.em.createQuery("SELECT r FROM Report r", Report.class).getResultList();
	}
	
	public Report add(Report r) {
		this.em.persist(r);
		return r;
	}
	
	public Report selectId(Long id) {
		Query query;
		String sSelectId="SELECT r FROM Report r WHERE r.idReport=?1";
		query=this.em.createQuery(sSelectId);
		query.setParameter(1,id);
		Report r =(Report) query.getSingleResult();
		this.em.clear();
		return r;	
	}
	
	public Report updateReport(Report r) {
		return this.em.merge(r);
	}
	
	//Delete
	public void deleteAllReports(Report r) {
		Query query = this.em.createQuery("DELETE r FROM Report r WHERE idReport =?1");
		query.setParameter(1,  r.getIdReport());
		query.executeUpdate();
	}
}
