package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Student;

@Stateless
public class DAOStudent {
	
	@PersistenceContext(unitName="rocroixJTA")
	private EntityManager em;
	
	public List<Student> selectAll(){
		return em.createQuery("SELECT s FROM student s").getResultList();
	}
	
	public Student add(Student s) {
		em.persist(s);
		return s;
	}
	
	public Student selectId(long id) {
		Query query;
		String sSelect="SELECT s FROM student s WHERE s.idStudent=?1";
		query=em.createQuery(sSelect);
		query.setParameter(1, id);
		Student s = (Student)query.getSingleResult();
		em.clear();
		return s;
	}
	
	//Update
		public Student updateStudent(Student s) {
			return em.merge(s);
		}
		
		//Delete
		public void deleteStudent(Student s) {
			Query query = this.em.createQuery("DELETE s FROM Student s WHERE idStudent =?1");
			query.setParameter(1, s.getIdStudent());
			query.executeUpdate();
		}

}
