package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementStudentEJB;
import be.helha.aemt.ejb.ManagementUserEJB;
import be.helha.aemt.entities.Student;
import be.helha.aemt.entities.Users;

@RequestScoped
@Named
public class StudentControl {
	
	@EJB
	private ManagementStudentEJB bean;
	private Student student = new Student();
	
	public List<Student> doSelectAll(){
		return bean.selectAll();
	}
	
	public ManagementStudentEJB getBean() {
		return bean;
	}
	
	public void setBean(ManagementStudentEJB bean) {
		this.bean = bean;
	}
	
	 public Student getStudent() {
		 return student;
	 }
	 
	 public void setStudent(Student student) {
		 this.student = student;
	 }
	 
	 public String doAdd() {
		 bean.add(student);
		 return "liste.xhtml";
	 }
	 
	 
	
	

}
