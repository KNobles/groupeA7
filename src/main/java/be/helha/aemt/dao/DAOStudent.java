package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Student;
import be.helha.aemt.util.StudentReader;

@Stateless
public class DAOStudent {
	
	@PersistenceContext(unitName="groupeA7JTA")
	private EntityManager em;
	
	public List<Student> selectAll(){
		return em.createQuery("SELECT s FROM Student s").getResultList();
	}
	
	public Student add(Student s) {
		em.persist(s);
		return s;
	}

	
	public Student selectId(Long id) {
		Query query;
		String sSelect="SELECT s FROM Student s WHERE s.idStudent=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Student s = (Student)query.getSingleResult();
		em.clear();
		return s;
	}
	
	public List<Student> selectName(String firstname) {
		Query query;
		String sSelect="SELECT s FROM Student s WHERE s.firstname=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, firstname);
		List<Student> s = query.getResultList();
		em.clear();
		return s;
	}
	
	//Upddate
		public Student updateStudent(Student s) {
			return em.merge(s);
		}
		
		//Delete
		public void deleteStudent(Student s) {
			Query query = this.em.createQuery("DELETE s FROM Student s WHERE idStudent =?1");
			query.setParameter(1, s.getIdStudent());
			query.executeUpdate();
		}

		public List<Student> selectBySection(String section) {
			Query query;
			String sSelect="SELECT s FROM Student s WHERE s.section.code=?1";
			query=em.createQuery(sSelect);
			query.setParameter(1, section);
			return query.getResultList();
		}

		public Student selectByName(String name, String firstname) {
			Query query;
			String sSelect = "SELECT s FROM Student s WHERE s.name =?1 AND s.firstname =?2";
			query=em.createQuery(sSelect);
			query.setParameter(1, name);
			query.setParameter(2, firstname);
			Student s = (Student)query.getSingleResult();
			em.clear();
			return s;
		}

}
