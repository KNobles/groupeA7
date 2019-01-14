package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private Long idCourse;
	
	private String dateRem;
	
	public Remediation() {
		
	}
	
	public Remediation(Long idRemediation, Long idCourse, String dateRem) {
		this.idRemediation = idRemediation;
		this.idCourse = idCourse;
		this.dateRem = dateRem;
	}

	public Long getIdRemediation() {
		return idRemediation;
	}

	public void setIdRemediation(Long idRemediation) {
		this.idRemediation = idRemediation;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getDateRem() {
		return dateRem;
	}

	public void setDateRem(String dateRem) {
		this.dateRem = dateRem;
	}

	@Override
	public String toString() {
		return "Remediation [idRemediation=" + idRemediation + ", idCourse=" + idCourse + ", dateRem=" + dateRem + "]";
	}
	
	
}
