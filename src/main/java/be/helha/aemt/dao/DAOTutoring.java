package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Tutoring;

@Stateless
public class DAOTutoring {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Tutoring> selectAll(){
		return this.em.createQuery("SELECT t FROM Tutoring t", Tutoring.class).getResultList();
	}
	
	public Tutoring add(Tutoring t) {
		this.em.persist(t);
		return t;
	}
	
	public String selectDemand(Long idStudent) {
		Query query;
		String sSelect="SELECT t FROM Tutoring t JOIN t.students s WHERE s.idStudent =?1";
		query=this.em.createQuery(sSelect);
		query.setParameter(1, idStudent);
		try {
			query.getSingleResult();
			return "Demande";
		} catch(NoResultException e) {
			return "";
		}
	}
	
	public Tutoring selectId(Long id) {
		Query query;
		String sSelect="SELECT t FROM Tutoring t WHERE s.idTutoring=?1";
		query=this.em.createQuery(sSelect);
		query.setParameter(1, id);
		Tutoring t = (Tutoring)query.getSingleResult();
		this.em.clear();
		return t;
	}
	
	//Update
	public Tutoring updateTutoring(Tutoring t) {
		return this.em.merge(t);
	}
	
	//Delete
	public void deleteTutoring(Tutoring t) {
		Query query = this.em.createQuery("DELETE t FROM Tutoring t WHERE idTutoring =?1");
		query.setParameter(1, t.getIdTutoring());
		query.executeUpdate();
	}
}
