package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groupuser")
public class GroupUser implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="groupname", nullable=false, length=32)
	private String groupname; //stockage des différents rôles : admin - relais
	
	@Column(name="mail", nullable=false, length=255)
	private String mail;
	
	public static final String RELAY_GROUP = "relay", ADMIN_GROUP = "admin";

	public GroupUser() {
		
	}
	
	public GroupUser(String name, String email) {
		this.groupname = name;
		this.mail = email;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.groupname;
	}

	public void setName(String name) {
		this.groupname = name;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
