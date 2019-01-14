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
	
	@ManyToMany(cascade = CascadeType.PERSIST) //� v�rfifier
	private List<Section> sections; 
	
	private String date; //quand aura lieu le s�minaire /!\ regex lors de l'encodage /!\ ainsi on saura r�cup�rer le quadri
	private String theme; 

	public Seminary() {
		
	}
	
	public Seminary(String theme, String date, List<Section> sections) {
		this.theme = theme;
		this.date = date;
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

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * Exemple : 
	 * 
	 * Le s�minaire sur le th�me : "La cyber-s�curit�" aura lieu le 09/11/2019.
	 * Section(s) concern�e(s) : Informatique de gestion, Assistant(e) de direction, Comptabilit�.
	 */
	@Override
	public String toString() {
		return "Le s�minaire \"" + this.theme + "\" aura lieu le " + this.date + ".\n"
				+ "Section(s) concern�e(s) : " + this.sections + "\n"; 
	}
}
