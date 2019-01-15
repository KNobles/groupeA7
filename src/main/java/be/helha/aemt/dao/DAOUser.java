package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.User;
import be.helha.aemt.entities.Student;

@Stateless
public class DAOUser {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<User> selectAll(){
		return em.createQuery("SELECT u FROM user u").getResultList();
	}
	
	public User add(User u) {
		em.persist(u);
		return u;
	}
	
	public User selectId(long id) {
		Query query;
		String sSelect="SELECT u FROM user u WHERE u.idUser=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		User u = (User)query.getSingleResult();
		em.clear();
		return u;
	}
	
	//Update
	public User update(User u) {
		return em.merge(u);
	}
	
	//Delete
	public void delete(User u) {
		Query query = this.em.createQuery("DELETE u FROM user u WHERE idUser =?1");
		query.setParameter(1, u.getIdDirector());
		query.executeUpdate();
	}

}
