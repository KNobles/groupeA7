package be.helha.aemt.entities;

import java.io.Serializable;

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
public class User implements Serializable {
	
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
		return this.idUser;
	}

	public void setIdRelay(Long idRelay) {
		this.idUser = idRelay;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return this.firstname;
	}
	
	public char getGender() {
		return this.gender;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long id) {
		this.idUser = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getTitle() {
		if(this.gender == 'm' || this.gender == 'M')
			return "Mr";
		return "Mme";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.mail == null) ? 0 : this.mail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (this.mail == null) {
			if (other.mail != null)
				return false;
		} else if (!this.mail.equals(other.mail))
			return false;
		return true;
	}
}
