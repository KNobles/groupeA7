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
	private Relay relay;
	private String date;
	private String resolutions;
	private String monitoring;
	
	public Interview() {
		
	}
	
	public Interview(Long idInterview, Student student, Relay  relay, String date, String resolutions,
			String monitoring) {
		this.idInterview = idInterview;
		this.student = student;
		this.relay = relay;
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

	public Relay getRelay() {
		return relay;
	}

	public void setRelay(Relay relay) {
		this.relay = relay;
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
	student.getName() + " " + student.getGroup() + ", relay: " + relay.getName() + ", date="
				+ date + ", resolutions=" + resolutions + ", monitoring=" + monitoring + "]";
	}
	
	
}
