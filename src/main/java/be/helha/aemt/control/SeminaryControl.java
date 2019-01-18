package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementSeminaryEJB;
import be.helha.aemt.entities.Seminary;

@RequestScoped
@Named
public class SeminaryControl {
	
	@EJB
	private ManagementSeminaryEJB bean;
	private Seminary seminary = new Seminary();
	
	private int nPresent=0;
	private int n;
	
	public List<Seminary> doSelectAll(){
		List<Seminary> list = this.bean.selectAll();
		this.n = list.size();
		this.nPresent=0;
		return list;
	}
	
	public Seminary doAdd() {
		System.out.println("do add");
		return this.bean.add(this.seminary);
	}
	
	public String select(long idStudent, long idSeminary) {
		String result = this.bean.select(idStudent, idSeminary);
		if(result.equals("Présent"))
			this.nPresent++;
		return result;
	}
	
	public Long doSelectCount(long idStudent) {
		return this.bean.selectCount(idStudent);
	}

	public ManagementSeminaryEJB getBean() {
		return this.bean;
	}

	public void setBean(ManagementSeminaryEJB bean) {
		this.bean = bean;
	}

	public Seminary getSeminary() {
		return this.seminary;
	}

	public void setSeminary(Seminary seminary) {
		this.seminary = seminary;
	}

	public int getnPresent() {
		return this.nPresent;
	}

	public void setnPresent(int nPresent) {
		this.nPresent = nPresent;
	}

	public int getN() {
		return this.n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
