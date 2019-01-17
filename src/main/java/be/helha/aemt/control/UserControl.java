package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import be.helha.aemt.ejb.ManagementUserEJB;
import be.helha.aemt.entities.Users;

@RequestScoped
@Named
public class UserControl implements Serializable {

	@EJB
	private ManagementUserEJB bean;
	private Users user = new Users();
	private boolean admin;
	
	private static Logger log = Logger.getLogger(UserControl.class.getName());

	public boolean isAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public String doValidatePassword() {
		//vérification des champs requis
		if(this.user.getPassword().equals("") //mot de passe
			|| this.user.getFirstname().equals("") //prénom
			|| this.user.getName().equals("")) { //nom
			
			return "createUser.xhtml"; 
		}
		return doAdd();
	}
	
	public List<Users> doSelectAll(){
		return this.bean.selectAll();
	}
	
	public String doAdd() {
		log.info(this.user.toString() + " a bien été ajouté comme relais d'aide à la réussite!");
		this.bean.add(this.user);
		return "displayUsers.xhtml";
	}

	public String doLogIn() {
		if((!this.user.getMail().equals("test@helha.be"))&&(!this.user.getPassword().equals("admin"))) {
			return "loginerror.xhtml";
		}
		return "admin/home.xhtml";
	}
	
	public String doLogOut(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			this.user = null;
			request.logout();
			// clear the session
			((HttpSession) context.getExternalContext().getSession(false)).invalidate();
		} catch (ServletException e) {
			log.log(Level.SEVERE, "Échec lors de la déconnexion", e);
		}
		return "/index?faces-redirect=true";
	}
}
