package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Laeti
 * Les comptes-rendu s'afficheront lorsque l'on cliquera sur le d�tail d'un �tudiant (s'il y en a)
 */

@Entity
public class Report {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReport;
	private String note;
	private String date;
	private Users author; //auteur de la note : directeur ou relais
	
	public Report() {
		
	}
	
	public Report(String note, String date, Users author) {
		this.note = note; //contenu du compte-rendu
		this.date = date; //r�cup�rer la date automatiquement lors de l'encodage -> pas d'insertion manuelle
		this.author = author; //r�cup�rer le type d'utilisateur connect� : directeur ou relais?
	}

	public Long getIdReport() {
		return this.idReport;
	}

	public void setIdReport(Long idReport) {
		this.idReport = idReport;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Users getAuthor() {
		return this.author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}
	
	/**
	 * Exemple : 
	 * 
	 * Compte-rendu n�2 du 20/04/2019, r�alis� par Mr Servais
	 * 
	 * L'�tudiant n'est pas venu � la rencontre individuelle planifi�e du 19/04/2019.
	 * De plus, l'�tudiant a �galement manqu� les deux derniers cours.
	 * 
	 */
	public String toString() {
		return "Compte-rendu n�" + this.idReport 
				+ " du " + this.date 
				+ ", r�alis� par " + this.author + "\n\n"
				
				+ this.note + "\n"; 
	}
}
