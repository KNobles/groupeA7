package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;

import be.helha.aemt.ejb.ManagementSeminaryEJB;
import be.helha.aemt.ejb.ManagementStudentEJB;
import be.helha.aemt.entities.Seminary;
import be.helha.aemt.entities.Student;

@SessionScoped
@Named
public class FicheSeminaryControl implements Serializable{
	
	@EJB
	ManagementStudentEJB bean;
	
	@EJB
	ManagementSeminaryEJB beanSem;
	
	String name;
	String firstname;
	
	private Seminary seminary;

	public Seminary getSeminary() {
		return seminary;
	}

	public void setSeminary(Seminary seminary) {
		this.seminary = seminary;
	}
	
	public String buildSeminary(Seminary seminary) {		
		this.seminary = seminary;
		return "ficheseminaire.xhtml";
	}
	
	public Student doAddStudent() {
		Student student;
		try {
			
			student = bean.selectByName(name, firstname);
			
			seminary.initStudents();
			seminary.addStudent(student);
			beanSem.update(seminary);
			
			return null;
		} catch(NoResultException e) {
			return null;
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	
	

}
