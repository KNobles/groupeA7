package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Nobles
 *
 */

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdmin;
	
	private String password;
	private String mail;
	private String firstName;
	private String lastName;
	
	public Admin() {
	}

	public Admin(Long idAdmin, String password, String mail, String firstName, String lastName) {
		super();
		this.idAdmin = idAdmin;
		this.password = password;
		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", mail=" + mail + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
		
}
