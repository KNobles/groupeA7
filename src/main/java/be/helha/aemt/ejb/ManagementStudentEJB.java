package be.helha.aemt.ejb;

import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.Order;

import be.helha.aemt.dao.DAOStudent;
import be.helha.aemt.entities.Student;
import be.helha.aemt.util.SortableStudent;

@LocalBean
@Stateless
public class ManagementStudentEJB implements IManagementStudentEJB{
	
	@EJB
	private DAOStudent dao;
	private boolean sortAscending = true;
	private SortableStudent<Student> sortableStudent;
	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Student add(Student s) {
		// TODO Auto-generated method stub


		return dao.add(s);
	}

	@Override
	public Student selectId(Long id) {
		// TODO Auto-generated method stub
		return dao.selectId(id);
	}

	@Override
	public Student update(Student s) {
		// TODO Auto-generated method stub
		return dao.updateStudent(s);
	}

	@Override
	public void delete(Student s) {
		// TODO Auto-generated method stub
		dao.deleteStudent(s);
	}

	@Override
	public List<Student> selectName(String name) {
		return dao.selectName(name);
	}
	
	@Override
	public String sortByName() {
	    
		if(sortAscending){
			
			sortableStudent.sortBy(new Comparator<Student>() {
				
			@Override
			public int compare(Student o1, Student o2) {
					
				return o1.getName().compareTo(o2.getName());
					
			}
		});
			
		sortAscending = false;
			
	  }else{

		//descending order
		  sortableStudent.sortBy(new Comparator<Student>() {
				
			@Override
			public int compare(Student o1, Student o2) {
					
				return o2.getName().compareTo(o1.getName());
					
			}
		});
		sortAscending = true;
	  }
		return null;
	}

	public List<Student> selectBySection(String section) {
		return dao.selectBySection(section);
	}

}
