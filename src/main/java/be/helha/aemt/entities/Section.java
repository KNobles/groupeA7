package be.helha.aemt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Laeti
 *
 */
@Entity
public class Section {
	
	@ManyToOne(cascade = CascadeType.PERSIST) 
	private User director;
	private String code;
	@Id
	private String name;

	public Section() {
		
	}
	
	public Section(String name, String code, User director) {
		this.name = name;
		this.code = code;
		this.director = director;
	}

	public User getDirector() {
		return this.director;
	}

	public void setDirector(User director) {
		this.director = director;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Exemple : 
	 * 
	 * Section "Informatique de gestion" [IG]
	 * Directeur : Mme Duroisin
	 */
	@Override
	public String toString() {
		return "Section \"" + this.name + "\" [ " + this.code + "]\n"
				+ "Directeur : " + this.director.getTitle() + this.director.getName() + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	/**
	 * Une section se différencie sur son identifiant, c'est-à-dire le nom de la section
	 * nécessaire car on a des listes de sections dans séminaire et cours, en cas de vérification d'ajout de doublon
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}
	
}
