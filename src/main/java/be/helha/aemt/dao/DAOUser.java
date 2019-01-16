package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Users;

@Stateless
public class DAOUser {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Users> selectAll(){
		return this.em.createQuery("SELECT u FROM User u", Users.class).getResultList();
	}
	
	public Users add(Users u) {
		this.em.persist(u);
		return u;
	}
	
	public Users selectId(String mail) {
		Query query;
		String sSelect="SELECT u FROM User u WHERE u.mail=?1";
		query=this.em.createQuery(sSelect);
		query.setParameter(1, mail);
		return (Users)query.getSingleResult();
	}
	
	//Update
	public Users update(Users u) {
		return this.em.merge(u);
	}
	
	//Delete
	public void delete(Users u) {
		Query query = this.em.createQuery("DELETE u FROM User u WHERE mail =?1");
		query.setParameter(1, u.getMail());

		query.executeUpdate();
	}

}
