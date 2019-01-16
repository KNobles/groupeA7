package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author Alexandre
 *
 */

@Entity
public class Users implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private GroupUser group;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Section> sections; //la section dont le directeur ou le relais est responsable mais un relais peut intervenir dans plusieurs sections
	
	private String name;
	private String firstname;
	private String password; // /!\ le directeur ne doit pas encoder directement les mots de passe des nouveaux utilisateurs
	private String mail;
	private char gender;
	
	public Users() {
		
	}
	
	public Users(GroupUser group, String name, String firstname, String password, char gender, List<Section> sections) {
		this.group = group; //admin ou relais
		this.name = name;
		this.firstname = firstname;
		this.password = password;
		this.mail = name.toLowerCase() + "." + firstname.toLowerCase().charAt(0) + "@helha.be";
		this.gender = gender;
		this.sections = sections;
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
	
	public GroupUser getGroup() {
		return this.group;
	}

	public void setGroup(GroupUser group) {
		this.group = group;
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public boolean addSection(Section s) {
		if(this.sections.contains(s)) { //on v�rifie si la section est d�j� dans les acc�s de l'utilisateur
			return false; //l'utilisateur a d�j� acc�s � la section
		}
		this.sections.add(s); //nouvelle section associ�e � l'utilisateur
		return true;
	}
	
	public boolean removeSection(Section s) {
		return this.sections.remove(s);
	}

	//renvoie le genre suivi du nom
	public String toString() {
		if(this.gender == 'm' || this.gender == 'M')
			return "Mr " + this.name;
		return "Mme " + this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.mail == null) ? 0 : this.mail.hashCode());
		return result;
	}
	
	/**
	 * comparaison bas�e sur l'adresse mail unique (matricule helha)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (this.mail == null) {
			if (other.mail != null)
				return false;
		} else if (!this.mail.equals(other.mail))
			return false;
		return true;
	}
}