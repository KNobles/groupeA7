package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Remediation;
import be.helha.aemt.entities.Student;

@Stateless
public class DAORemediation {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;	
	
	public List<Remediation> selectAll (){
		return this.em.createQuery("SELECT r FROM Remediation r", Remediation.class).getResultList();
	}
	
	public Remediation add(Remediation r) {
		this.em.persist(r);
		return r;
	}
	
	public Remediation selectId(long id) {
		Query query;
		String sSelectId="SELECT r FROM Remediation r WHERE r.idRemediation=?1";
		query=this.em.createQuery(sSelectId);
		query.setParameter(1,id);
		Remediation r =(Remediation) query.getSingleResult();
		this.em.clear();
		return r;	
	}
	
	public List<Student> selectAllStudents() {
		return this.em.createQuery("SELECT r.students FROM Remediation r JOIN r.students s", Student.class).getResultList();
	}
	
	public Remediation updateRemediation(Remediation r) {
		return this.em.merge(r);
	}
	
	//Delete
	public void deleteAllRemediations(Remediation r) {
		Query query = this.em.createQuery("DELETE r FROM Remediation r WHERE idRemediation =?1");
		query.setParameter(1,  r.getIdRemediation());
		query.executeUpdate();
	}
}
