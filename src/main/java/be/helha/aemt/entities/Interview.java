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
public class Interview {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInterview;
	
	private Long idStudent;
	private String nameRel;
	private String date;
	private String resolutions;
	private String monitoring;
	
	public Interview() {
		
	}
	
	public Interview(Long idInterview, Long idStudent, String nameRel, String date, String resolutions,
			String monitoring) {
		this.idInterview = idInterview;
		this.idStudent = idStudent;
		this.nameRel = nameRel;
		this.date = date;
		this.resolutions = resolutions;
		this.monitoring = monitoring;
	}

	public Long getIdInterview() {
		return idInterview;
	}

	public void setIdInterview(Long idInterview) {
		this.idInterview = idInterview;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameRel() {
		return nameRel;
	}

	public void setNameRel(String nameRel) {
		this.nameRel = nameRel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getResolutions() {
		return resolutions;
	}

	public void setResolutions(String resolutions) {
		this.resolutions = resolutions;
	}

	public String getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(String monitoring) {
		this.monitoring = monitoring;
	}

	@Override
	public String toString() {
		return "Interview [idInterview=" + idInterview + ", idStudent=" + idStudent + ", nameRel=" + nameRel + ", date="
				+ date + ", resolutions=" + resolutions + ", monitoring=" + monitoring + "]";
	}
	
	
}
