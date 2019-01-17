package be.helha.aemt.control;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import be.helha.aemt.ejb.ManagementUserEJB;
import be.helha.aemt.entities.Users;

@SessionScoped //le temps de la session config dans web.xml, ou d'une requête
//on ne va pas toujours l'utiliser, il faut le mettre en passif en attendant son utilisation -> implements Serializable
@Named //annotation d'injection !ne pas utiliser ManagedBean! //sert au serveur pour injecter ce composant dans xhmtl
public class UserControl implements Serializable {

	@EJB
	private ManagementUserEJB bean;
	private Users authenticatedUser = new Users();
	private boolean admin;
	
	private static Logger log = Logger.getLogger(UserControl.class.getName());

	public boolean isAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public Users getAuthenticatedUser() {
		return this.authenticatedUser;
	}

	public void setAuthenticatedUser(Users authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public String doValidatePassword() {
		//vérification des champs requis
		if(this.authenticatedUser.getPassword().equals("") //mot de passe
			|| this.authenticatedUser.getFirstname().equals("") //prénom
			|| this.authenticatedUser.getName().equals("")) { //nom
			
			return "createUser.xhtml"; 
		}
		return doAdd();
	}
	
	public List<Users> doSelectAll(){
		return this.bean.selectAll();
	}
	
	public Users doSearchUserByMail(String mail) {
		return this.bean.searchByMail(mail);
	}
	
	public String doAdd() {
		log.info(this.authenticatedUser.toString() + " a bien été ajouté comme relais d'aide à la réussite!");
		this.bean.add(this.authenticatedUser);
		return "displayUsers.xhtml";
	}

	public String doLogIn() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			request.login(this.authenticatedUser.getMail(), this.authenticatedUser.getPassword());
		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Connexion échouée!", null));
			return "loginerror.xhtml";
		}
		Principal principal = request.getUserPrincipal();
		this.authenticatedUser = this.bean.searchByMail(principal.getName());
		log.info("Authentication réussie pour l'utilisateur : " + principal.getName());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("Users", this.authenticatedUser);
		if(request.isUserInRole("relay"))
			return "relay/home.xhtml?faces-redirect=true";
		//else if(request.isUserInRole("admin"))
			return "admin/home.xhtml?faces-redirect=true";
	}
	
	public String doLogOut(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			this.authenticatedUser = null;
			request.logout();
			// clear the session
			((HttpSession) context.getExternalContext().getSession(false)).invalidate();
		} catch (ServletException e) {
			log.log(Level.SEVERE, "Échec lors de la déconnexion", e);
		}
		return "/index?faces-redirect=true";
	}
}
