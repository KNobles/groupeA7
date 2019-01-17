package be.helha.aemt.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.GroupUser;
import be.helha.aemt.entities.Users;
import be.helha.aemt.util.AuthenticationUtils;

@Stateless
public class DAOUser {
	
	@PersistenceContext(unitName="groupeA7JTA") 
	private EntityManager em;
	
	public List<Users> selectAll(){
		return this.em.createQuery("SELECT u FROM Users u", Users.class).getResultList(); 
		//renvoie tous les utilisateurs de la bdd
	}
	
	public Users add(Users u) {
		try {
			u.setPassword(AuthenticationUtils.encodeSHA256(u.getPassword())); //cryptage du mot de passe
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		
		u.setMail(); //le mail se crée sur base du nom - prénom encodés dans le formulaire
		
		GroupUser group = new GroupUser();
		group.setMail(u.getMail());
		group.setName(GroupUser.RELAY_GROUP);
		
		this.em.persist(u); //l'utilisateur est persisté dans la base de données
		this.em.persist(group); //le groupe est persisté dans la base de données
		return u;
	}
	
	//Search by email
	public Users findByMail(String mail) {
		Query query;
		String sSelect="SELECT u FROM Users u WHERE u.mail=?1"; // on cherche si un utilisateur dispose du mail placé en argument
		query=this.em.createQuery(sSelect);
		query.setParameter(1, mail);
		return (Users)query.getSingleResult(); //éxécution de la recherche + retour de l'utilisateur si existant
	}
	
	//Update
	public Users update(Users u) {
		return this.em.merge(u); 
	}
	
	//Delete
	public void delete(Users u) {
		Query query = this.em.createQuery("DELETE u FROM Users u WHERE mail =?1");
		query.setParameter(1, u.getMail());

		query.executeUpdate(); //suppression de l'utilisateur 
	}
}
