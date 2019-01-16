package be.helha.aemt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	@ManyToMany(cascade = CascadeType.PERSIST) 
	@JoinTable //table d'association
	private List<Student> students; //tutorat individuel et parfois en groupe
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Course course;
	
	private String dateTime;
	
	public Tutoring() {
		
	}
	
	public Tutoring(List<Student> students, Course course, String dateTime) {
		this.students = students;
		this.course = course;
		this.dateTime = dateTime;
	}

	public Long getIdTutoring() {
		return this.idTutoring;
	}

	public void setIdTutoring(Long idTutoring) {
		this.idTutoring = idTutoring;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public boolean addStudent(Student s) {
		if(this.students.contains(s)) { //on vérifie si l'étudiant est déjà associé au tutorat
			return false; //L'étudiant est déjà lié au tutorat
		}
		this.students.add(s); //nouvel étudiant associé au tutorat
		return true;
	}
	
	public boolean removeStudent(Student s) {
		return this.students.remove(s);
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Exemple:
	 * 
	 * Tutorat du 15/03/2019 - 15h00 pour le cours de : Français
	 * Concerne l'étudiant : Nobles Kevin (IG-I1)
	 */
	@Override
	public String toString() {
		return "Tutorat du " + this.dateTime + " pour le cours de : " + this.course.getName() + "\n"
				+ "Concerne l'étudiant : " + this.students; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.course == null) ? 0 : this.course.hashCode());
		result = prime * result + ((this.dateTime == null) ? 0 : this.dateTime.hashCode());
		result = prime * result + ((this.students == null) ? 0 : this.students.hashCode());
		return result;
	}

	/**
	 * Un tutorat se caractérise par un cours, un groupe d'élève(s) et une date / heure
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutoring other = (Tutoring) obj;
		if (this.course == null) {
			if (other.course != null)
				return false;
		} else if (!this.course.equals(other.course))
			return false;
		if (this.dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!this.dateTime.equals(other.dateTime))
			return false;
		if (this.students == null) {
			if (other.students != null)
				return false;
		} else if (!this.students.equals(other.students))
			return false;
		return true;
	}
	
}
