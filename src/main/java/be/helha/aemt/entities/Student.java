package be.helha.aemt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author Alexandre
 *
 */
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStudent;
	private String firstname;
	private String name;
	private String group;	//classe
	private boolean coordBroadcast;
	private boolean photoBroadcast;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Report> reports;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Section section;
	
	public Student() {}
	
	public Student(String firstname, String name, String group, boolean coord, boolean photo, Section section, List<Report> reports) {
		this.firstname = firstname;
		this.name = name;
		this.group=group;
		this.coordBroadcast = coord;
		this.photoBroadcast = photo;
		this.section = section;
		this.reports =reports;
	}

	public Long getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isCoordBroadcast() {
		return this.coordBroadcast;
	}

	public void setCoordBroadcast(boolean coordBroadcast) {
		this.coordBroadcast = coordBroadcast;
	}

	public boolean isPhotoBroadcast() {
		return this.photoBroadcast;
	}

	public void setPhotoBroadcast(boolean photoBroadcast) {
		this.photoBroadcast = photoBroadcast;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	//renvoie le nom, prénom (orientation - classe)
	public String toString() {
		return getFullName() + " (" + this.section.getName() + " - " +this.group + ")";
	}
	
	//renvoie le nom et le prénom de l'étudiant
	public String getFullName() {
		return this.name + ", " + this.firstname;
	}

}
