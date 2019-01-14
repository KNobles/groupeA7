package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Admin;

public class DAOAdmin {
	@PersistenceContext(unitName="noblesJTA")
	private EntityManager em;	
	public List<Admin> selectAll (){
		return em.createQuery("SELECT a FROM Admin a").getResultList();
	}
	
	public Admin add(Admin a) {
		em.persist(a);
		return a;
	}
	
	public Admin selectId(long id) {
		Query query;
		String sSelectId="SELECT a FROM Admin a WHERE a.id=?1";
		query=em.createQuery(sSelectId);
		query.setParameter(1,id);
		Admin a =(Admin) query.getSingleResult();
		em.clear();
		return a;	
	}
	
	public Admin updateAdmin(Admin a) {
		return em.merge(a);
	}
	
	//Delete
	public void deleteAllAdmins(Admin a) {
		Query query = this.em.createQuery("DELETE a FROM Admin a WHERE idAdmin =?1");
		query.setParameter(1,  a.getIdAdmin());
		query.executeUpdate();
	}
}
