package be.helha.aemt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Student student;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Users user;
	private String date;
	private String resolutions;
	private String monitoring;
	
	public Interview() {
		
	}
	
	public Interview(Student student, Users user, String date, String resolutions, String monitoring) {
		this.student = student;
		this.user = user;
		this.date = date;
		this.resolutions = resolutions;
		this.monitoring = monitoring;
	}

	public Long getIdInterview() {
		return this.idInterview;
	}

	public void setIdInterview(Long idInterview) {
		this.idInterview = idInterview;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getResolutions() {
		return this.resolutions;
	}

	public void setResolutions(String resolutions) {
		this.resolutions = resolutions;
	}

	public String getMonitoring() {
		return this.monitoring;
	}

	public void setMonitoring(String monitoring) {
		this.monitoring = monitoring;
	}

	/**
	 * Exemple: 
	 * 
	 * Rencontre individuelle entre Mme Duroisin et l'étudiant(e) Nobles Kevin du 20/01/2019
	 * Résolution(s) de l'étudiant(e) : Travailler plus régulièrement.
	 * Suivi : proposé et refusé.
	 */
	@Override
	public String toString() {
		return "Rencontre individuelle entre " + this.user + " et l'étudiant(e) " + this.student.getFullName()
			+ " du " + this.date + "\n"
			+ "Résolution(s) de l'étudiant(e) : " + this.resolutions + "\n"
			+ "Suivi : " + this.monitoring + "\n";
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
		result = prime * result + ((this.student == null) ? 0 : this.student.hashCode());
		result = prime * result + ((this.user == null) ? 0 : this.user.hashCode());
		return result;
	}

	/**
	 * Une rencontre individuelle se définit par un étudiant, et un responsable (relais ou directeur) ainsi qu'une date.
	 * Un étudiant peut rencontrer la directrice le 9/05/2019 et un autre rencontrer un relais le même jour.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interview other = (Interview) obj;
		if (this.date == null) {
			if (other.date != null)
				return false;
		} else if (!this.date.equals(other.date))
			return false;
		if (this.student == null) {
			if (other.student != null)
				return false;
		} else if (!this.student.equals(other.student))
			return false;
		if (this.user == null) {
			if (other.user != null)
				return false;
		} else if (!this.user.equals(other.user))
			return false;
		return true;
	}
	
}
