package be.helha.aemt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author Laeti
 *
 */
@Entity
public class Tutoring {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTutoring;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Student> students; //tutorat individuel et parfois en groupe
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Course course;
	
	public Tutoring() {
		
	}
	
	public Tutoring(List<Student> students, Course course) {
		this.students = students;
		this.course = course;
	}

	public Long getIdTutoring() {
		return this.idTutoring;
	}

	public void setIdTutoring(Long idTutoring) {
		this.idTutoring = idTutoring;
	}

	public List<Student> getStudent() {
		return this.students;
	}

	public void setStudent(List<Student> students) {
		this.students = students;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Exemple:
	 * 
	 * Tutorat pour le cours de : Français
	 * Concerne l'étudiant : Nobles Kevin (IG-I1)
	 */
	@Override
	public String toString() {
		return "Tutorat pour le cours de : " + this.course.getName() + "\n"
				+ "Concerne l'étudiant : " + this.students; 
	}
	
}
