package be.helha.aemt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Nobles
 *
 */

@Entity
public class Remediation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRemediation;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Course course;
	
	@ManyToMany(cascade = CascadeType.PERSIST) 
	@JoinTable //table d'association
	private List<Student> students; //rem�diations individuelles et parfois en groupe
	
	private String dateTimeRem;
	
	public Remediation() {
		
	}
	
	public Remediation(Course course, String dateTimeRem, List<Student> students) {
		this.course = course;
		this.dateTimeRem = dateTimeRem;
		this.students = students;
	}

	public Long getIdRemediation() {
		return this.idRemediation;
	}

	public void setIdRemediation(Long idRemediation) {
		this.idRemediation = idRemediation;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course idCourse) {
		this.course = idCourse;
	}

	public String getDateTimeRem() {
		return this.dateTimeRem;
	}

	public void setDateTimeRem(String dateRem) {
		this.dateTimeRem = dateRem;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * Exemple:
	 * 
	 * Rem�diation du cours de Fran�ais (le 20/09/2019 � 15h00)
	 * �tudiants :
	 * Nobles, Kevin (IG - 3BI)
	 * Rocroix, Alexandre (IG - 3BI)
	 * Nill�s, Laetitia (IG - 3BI)
	 */
	@Override
	public String toString() {
		return "Rem�diation du cours de " + this.course.getName() + " (" + this.dateTimeRem + ")\n"
				+ "�tudiants : \n" + this.students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.course == null) ? 0 : this.course.hashCode());
		result = prime * result + ((this.dateTimeRem == null) ? 0 : this.dateTimeRem.hashCode());
		result = prime * result + ((this.students == null) ? 0 : this.students.hashCode());
		return result;
	}

	/**
	 * Une rem�diation concerne un cours, une liste d'�tudiant(s) et a lieu � une date et une heure pr�cise.
	 * Plusieurs rem�diations d'un m�me cours pourraient avoir lieu le m�me jour mais � des heures diff�rentes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Remediation other = (Remediation) obj;
		if (this.course == null) {
			if (other.course != null)
				return false;
		} else if (!this.course.equals(other.course))
			return false;
		if (this.dateTimeRem == null) {
			if (other.dateTimeRem != null)
				return false;
		} else if (!this.dateTimeRem.equals(other.dateTimeRem))
			return false;
		if (this.students == null) {
			if (other.students != null)
				return false;
		} else if (!this.students.equals(other.students))
			return false;
		return true;
	}
	
}
