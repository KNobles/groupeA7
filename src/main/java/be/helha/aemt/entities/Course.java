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
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCourse;
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST) //à vérifier
	private List<Section> sections;
	
	public Course() {
		
	}

	public Course(String name, List<Section> sections) {
		this.name = name;
		this.sections = sections;
	}

	public Long getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Section> getSection() {
		return this.sections;
	}

	public void setSection(List<Section> sections) {
		this.sections = sections;
	}
	
	/**
	 * Exemple : 
	 * 
	 * Le cours de Français est donné aux sections : Informatique de gestion, Comptabilité.
	 */
	@Override
	public String toString() {
		return "Le cours de " + this.name + " est donné aux sections : " + this.sections ;
	}
	
}
