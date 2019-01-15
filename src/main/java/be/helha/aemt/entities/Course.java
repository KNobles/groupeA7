package be.helha.aemt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Laeti
 */
@Entity
public class Course {
	
	@Id
	private String code;
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Section> sections;
	
	public Course() {
		
	}

	public Course(String code, String name, List<Section> sections) {
		this.code = code;
		this.name = name;
		this.sections = sections;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public boolean addSection(Section s) {
		if(this.sections.contains(s)) { //on vérifie si la section est déjà associée au cours
			return false; //Le cours est déjà lié à la section
		}
		this.sections.add(s); //nouvelle section associée au cours
		return true;
	}
	
	public boolean removeSection(Section s) {
		return this.sections.remove(s);
	}

	/**
	 * Exemple : 
	 * 
	 * Le cours d'Anglais (ECIG3B02IG302A) est donné aux sections : Informatique de gestion, Comptabilité.
	 */
	@Override
	public String toString() {
		return "Le cours de " + this.name + " ( " + this.code + ") est donné aux sections : " + this.sections ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (this.code == null) {
			if (other.code != null)
				return false;
		} else if (!this.code.equals(other.code))
			return false;
		return true;
	}
	
}
