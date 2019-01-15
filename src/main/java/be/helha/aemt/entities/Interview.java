package be.helha.aemt.entities;

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
public class Interview {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInterview;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private User user;
	private String date;
	private String resolutions;
	private String monitoring;
	
	public Interview() {
		
	}
	
	public Interview(Long idInterview, Student student, User  user, String date, String resolutions,
			String monitoring) {
		this.idInterview = idInterview;
		this.student = student;
		this.user = user;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "Interview [idInterview=" + idInterview + ", idStudent=" + student.getFirstname() + " " +
	student.getName() + " " + student.getGroup() + ", relay: " + user.getName() + ", date="
				+ date + ", resolutions=" + resolutions + ", monitoring=" + monitoring + "]";
	}
	
	
}
