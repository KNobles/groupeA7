package be.helha.aemt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Laeti
 *
 */
@Entity
public class Seminary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSeminary;
	
	@ManyToMany(cascade = CascadeType.PERSIST) 
	private List<Section> sections; 
	
	private String dateTime; //quand aura lieu le s�minaire (jour + heure) /!\ regex lors de l'encodage /!\ ainsi on saura r�cup�rer le quadri
	private String theme; 

	public Seminary() {
		
	}
	
	public Seminary(String theme, String date, List<Section> sections) {
		this.theme = theme;
		this.dateTime = date;
		this.sections = sections;
	}

	public Long getIdSeminary() {
		return this.idSeminary;
	}

	public void setIdSeminary(Long idSeminary) {
		this.idSeminary = idSeminary;
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String date) {
		this.dateTime = date;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public boolean addSection(Section s) {
		if(this.sections.contains(s)) { //on v�rifie si la section est d�j� associ�e au s�minaire
			return false; //Le s�minaire est d�j� li� � la section
		}
		this.sections.add(s); //nouvelle section associ�e au s�minaire
		return true;
	}
	
	public boolean removeSection(Section s) {
		return this.sections.remove(s);
	}

	/**
	 * Exemple : 
	 * 
	 * Le s�minaire sur le th�me : "La cyber-s�curit�" aura lieu le 09/11/2019 � 15h00.
	 * Section(s) concern�e(s) : Informatique de gestion, Assistant(e) de direction, Comptabilit�.
	 */
	@Override
	public String toString() {
		return "Le s�minaire \"" + this.theme + "\" aura lieu " + this.dateTime + ".\n"
				+ "Section(s) concern�e(s) : " + this.sections + "\n"; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dateTime == null) ? 0 : this.dateTime.hashCode());
		result = prime * result + ((this.sections == null) ? 0 : this.sections.hashCode());
		return result;
	}

	/**
	 * Un s�minaire se caract�rise par une date et des sections concern�es.
	 * Si la section informatique a d�j� un s�minaire le 15/03/2019 � assister, 
	 * on ne pourra pas ajouter un autre s�minaire sur un autre sujet au m�me moment.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seminary other = (Seminary) obj;
		if (this.dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!this.dateTime.equals(other.dateTime))
			return false;
		if (this.sections == null) {
			if (other.sections != null)
				return false;
		} else if (!this.sections.equals(other.sections))
			return false;
		return true;
	}
	
}
