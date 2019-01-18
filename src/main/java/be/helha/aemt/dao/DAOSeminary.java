package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Seminary;

@Stateless
public class DAOSeminary {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Seminary> selectAll(){
		return this.em.createQuery("SELECT s FROM Seminary s", Seminary.class).getResultList();
	}
	
	public String select(Long idStudent, Long idSeminary) {
		String sSelect="SELECT s FROM Seminary s  JOIN s.students sem WHERE sem.idStudent =?1 AND s.idSeminary=?2";

		Query query = this.em.createQuery(sSelect);
		query.setParameter(1, idStudent);
		query.setParameter(2, idSeminary);
		try {
			query.getSingleResult();
			return "Présent";
		} catch(NoResultException e) {
			return "Absent";
		}

	}
	
	public Long selectCount(Long idStudent) {
		String sSelect="SELECT count(s) FROM Seminary s JOIN s.students st WHERE st.idStudent =?1";
		Query query = this.em.createQuery(sSelect);
		query.setParameter(1, idStudent);
		try {
			return (Long)query.getSingleResult();
		} catch(NoResultException e) {
			return 0L;
		}
	}
	
	public Seminary add(Seminary s) {
		this.em.persist(s);
		return s;
	}
	
	public Seminary selectId(Long id) {
		Query query;
		String sSelect="SELECT s FROM Seminary s WHERE s.idSeminary=?1";
		query=this.em.createQuery(sSelect);
		query.setParameter(1, id);
		Seminary s = (Seminary)query.getSingleResult();
		this.em.clear();
		return s;
	}
	
	//Update
	public Seminary updateSeminary(Seminary s) {
		return this.em.merge(s);
	}
	
	//Delete
	public void deleteSeminary(Seminary s) {
		Query query = this.em.createQuery("DELETE s FROM Seminary s WHERE idSeminary =?1");
		query.setParameter(1, s.getIdSeminary());
		query.executeUpdate();
	}
}
