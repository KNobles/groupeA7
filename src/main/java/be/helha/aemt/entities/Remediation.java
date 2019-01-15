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
	
	private String dateRem;
	
	public Remediation() {
		
	}
	
	public Remediation(Long idRemediation, Course course, String dateRem) {
		this.idRemediation = idRemediation;
		this.course = course;
		this.dateRem = dateRem;
	}

	public Long getIdRemediation() {
		return idRemediation;
	}

	public void setIdRemediation(Long idRemediation) {
		this.idRemediation = idRemediation;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course idCourse) {
		this.course = idCourse;
	}

	public String getDateRem() {
		return dateRem;
	}

	public void setDateRem(String dateRem) {
		this.dateRem = dateRem;
	}

	@Override
	public String toString() {
		return "Remediation [idRemediation=" + idRemediation + ", Course: " + course.getName() + ", dateRem=" + dateRem + "]";
	}
	
	
}
