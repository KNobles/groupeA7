package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private Student student; //tutorat individuel ou multiple? liste?
	//Annotation
	private Course course;
	
	public Tutoring() {
		
	}
	
	public Tutoring(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

	public Long getIdTutoring() {
		return this.idTutoring;
	}

	public void setIdTutoring(Long idTutoring) {
		this.idTutoring = idTutoring;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
	 * Concerne l'étudiant : Nobles Kevin
	 */
	@Override
	public String toString() {
		return "Tutorat pour le cours de : " + this.course.getName() + "\n"
				+ "Concerne l'étudiant : " + this.student.getName() + " " + this.student;
	}
	
}
