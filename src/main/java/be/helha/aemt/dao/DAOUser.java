package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.User;

@Stateless
public class DAOUser {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<User> selectAll(){
		return this.em.createQuery("SELECT u FROM user u", User.class).getResultList();
	}
	
	public User add(User u) {
		this.em.persist(u);
		return u;
	}
	
	public User selectId(long id) {
		Query query;
		String sSelect="SELECT u FROM user u WHERE u.idUser=?1";
		query=this.em.createQuery(sSelect);
		query.setParameter(1, id);
		return (User)query.getSingleResult();
	}
	
	//Update
	public User update(User u) {
		return this.em.merge(u);
	}
	
	//Delete
	public void delete(User u) {
		Query query = this.em.createQuery("DELETE u FROM user u WHERE idUser =?1");
		query.setParameter(1, u.getIdUser());
		query.executeUpdate();
	}

}
