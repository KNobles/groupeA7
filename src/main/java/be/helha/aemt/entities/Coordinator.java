package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Alexandre
 *
 */

@Entity
public class Coordinator {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCoordinator;
	
	private String name;
	private String firstname;
	private String password;
	private String mail;
	
	public Coordinator() {
		
	}
	
	public Coordinator(String name, String firstname, String password, String mail) {
		this.name = name;
		this.firstname = firstname;
		this.password = password;
		this.mail = mail;
	}

	public Integer getIdRelay() {
		return idCoordinator;
	}

	public void setIdRelay(Integer idRelay) {
		this.idCoordinator = idRelay;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
