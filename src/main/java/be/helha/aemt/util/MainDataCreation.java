package be.helha.aemt.util;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.GroupUser;
import be.helha.aemt.entities.Report;
import be.helha.aemt.entities.Section;
import be.helha.aemt.entities.Student;
import be.helha.aemt.entities.Users;

public class MainDataCreation {
	
	public static void main(String[] args) {
		Section sec = new Section("Test", "code");
		Student s = new  Student("Nobles", "Kevin", "Group", true, true, sec, new ArrayList<Report>());
		Student s1 = new  Student("Rocroix", "Alexandre", "Group", true, true, sec, new ArrayList<Report>());
		Student s2 = new  Student("Carpentier", "Quentin", "Group", true, true, sec, new ArrayList<Report>());
		Student s3 = new  Student("Buscato", "Bastien", "Group", true, true, sec, new ArrayList<Report>());
		Student s4 = new  Student("Detienne", "Arnaud", "Group", true, true, sec, new ArrayList<Report>());

		GroupUser relay = new GroupUser("relay", "user@helha.be");
		Users userTest = new Users(relay, "username", "userfirstname", "helha", 'f', new ArrayList<Section>());
		
		System.out.println(s.toString());
		System.out.println(userTest.getIdUser() + " " + userTest.toString()+ ", " + userTest.getFirstname()); //pas d'identifiant car pas de persistance
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("groupeA7");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		
		tx.begin();
		
		em.persist(relay);
		em.persist(userTest);
		em.persist(sec);
		em.persist(s);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		
		tx.commit();
		
		System.out.println(userTest.getIdUser() + " " + userTest + ", " + userTest.getFirstname()); //s'il a acquis un identifiant, alors il a été persisté

	}
}	