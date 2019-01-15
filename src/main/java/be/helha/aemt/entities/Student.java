package be.helha.aemt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private String group;
	private boolean coordBroadcast;
	private boolean photoBroadcast;
	private String noteDir;
	private String dateDir;
	private String noteRel;
	private String dateRel;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Section section;
	
	public Student() {}
	
	public Student(String name, String group, boolean coord, boolean photo, String noteDir, String dateDir, String noteRel, 
			String dateRel, Section section) {
		super();
		this.name = name;
		this.group=group;
		this.coordBroadcast = coord;
		this.photoBroadcast = photo;
		this.noteDir = noteDir;
		this.dateDir = dateDir;
		this.noteRel = noteRel;
		this.dateRel = dateRel;
		this.section = section;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isCoordBroadcast() {
		return coordBroadcast;
	}

	public void setCoordBroadcast(boolean coordBroadcast) {
		this.coordBroadcast = coordBroadcast;
	}

	public boolean isPhotoBroadcast() {
		return photoBroadcast;
	}

	public void setPhotoBroadcast(boolean photoBroadcast) {
		this.photoBroadcast = photoBroadcast;
	}

	public String getNoteDir() {
		return noteDir;
	}

	public void setNoteDir(String noteDir) {
		this.noteDir = noteDir;
	}

	public String getDateDir() {
		return dateDir;
	}

	public void setDateDir(String dateDir) {
		this.dateDir = dateDir;
	}

	public String getNoteRel() {
		return noteRel;
	}

	public void setNoteRel(String noteRel) {
		this.noteRel = noteRel;
	}

	public String getDateRel() {
		return dateRel;
	}

	public void setDateRel(String dateRel) {
		this.dateRel = dateRel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	


	
	
	
	

}
