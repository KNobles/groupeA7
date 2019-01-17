package be.helha.aemt.control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import be.helha.aemt.ejb.ManagementStudentEJB;
import be.helha.aemt.entities.Student;
import be.helha.aemt.util.StudentReader;

@RequestScoped
@Named
public class StudentControl implements Serializable{
	
	@EJB
	private ManagementStudentEJB bean;
	private Student student = new Student();
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	List<Student> students = new ArrayList<Student>();
	
	private Part file; // +getter+setter
	public void save() {
	        File cFile = new File(file.getSubmittedFileName());
	        try {
	            cFile.createNewFile();
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        try (InputStream input = file.getInputStream()) {
	            Files.copy(input, cFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        try {
				students = StudentReader.getStudents(cFile);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        for(Student s: students) {
	        	bean.add(s);
	        }

	}
	
	public List<Student> doSelectBySection(String section) {
		return bean.selectBySection(section);
	}
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

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
