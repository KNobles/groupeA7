package be.helha.aemt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Course course;
	
	private String dateTimeRem;
	
	public Remediation() {
		
	}
	
	public Remediation(Course course, String dateTimeRem) {
		this.course = course;
		this.dateTimeRem = dateTimeRem;
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

	/**
	 * Exemple:
	 * 
	 * Remédiation du cours de Français (le 20/09/2019 à 15h00)
	 */
	@Override
	public String toString() {
		return "Remédiation du cours de " + this.course.getName() + " (" + this.dateTimeRem + ")\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.course == null) ? 0 : this.course.hashCode());
		result = prime * result + ((this.dateTimeRem == null) ? 0 : this.dateTimeRem.hashCode());
		return result;
	}

	/**
	 * Une remédiation concerne un cours, et a lieu à une date et une heure précise.
	 * Plusieurs remédiations d'un même cours pourraient avoir lieu le même jour mais à des heures différentes.
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
		return true;
	}
}
