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
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	
	private String name;
	private String firstname;
	private String password;
	private String mail;
	private char gender;
	
	public User() {
		
	}
	
	public User(String name, String firstname, String password, String mail, char gender) {
		this.name = name;
		this.firstname = firstname;
		this.password = password;
		this.mail = mail;
		this.gender = gender;
	}

	public Long getIdRelay() {
		return idUser;
	}

	public void setIdRelay(Long idRelay) {
		this.idUser = idRelay;
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
	
	public char getGender() {
		return gender;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Long getIdDirector() {
		return idUser;
	}

	public void setIdDirector(Long idDirector) {
		this.idUser = idDirector;
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
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getTitle() {
		if(gender == 'm' || gender == 'M')
			return "Mr";
		else
			return "Mme";
	}

}
