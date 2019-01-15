package be.helha.aemt.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Section;

@Stateless
public class DAOSection {
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Section> selectAll(){
		return em.createQuery("SELECT s FROM Section s").getResultList();
	}
	
	public Section add(Section s) {
		em.persist(s);
		return s;
	}
	
	public Section selectId(String code) {
		Query query;
		String sSelect="SELECT s FROM Section s WHERE s.code=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, code);
		Section s = (Section)query.getSingleResult();
		em.clear();
		return s;
	}
	
	//Update
		public Section updateSection(Section s) {
			return em.merge(s);
		}
		
		//Delete
		public void deleteSection(Section s) {
			Query query = this.em.createQuery("DELETE s FROM Section s WHERE code =?1");
			query.setParameter(1, s.getCode());
			query.executeUpdate();
		}
}
