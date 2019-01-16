package be.helha.aemt.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DAOSeminaryStudent {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public String select(long idStudent, long idSeminary) {
		Query query;
		String sSelect = "SELECT s FROM seminary_student s WHERE s.idStudent=?1 AND s.idSeminary=?2";
		query = em.createQuery(sSelect);
		query.setParameter(1, idStudent);
		query.setParameter(2, idSeminary);
	
		try {
			query.getSingleResult();
			return "Présent";
		} catch(NoResultException e) {
			return "Absent";
		}
		
	}
	
	

}
