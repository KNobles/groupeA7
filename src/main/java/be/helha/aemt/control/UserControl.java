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
	private Users authenticatedUser = new Users(); //va contenir les données de l'utilisateur de la session en cours
	//private boolean admin;
	
	private static Logger log = Logger.getLogger(UserControl.class.getName());

//	public boolean isAdmin() {
//		return this.admin;
//	}
//
//	public void setAdmin(boolean admin) {
//		this.admin = admin;
//	}
	
	public Users getAuthenticatedUser() {
		return this.authenticatedUser;
	}

	public void setAuthenticatedUser(Users authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	//méthode utilisée lors de la création d'un utilisateur (relais)
	public String doValidatePassword() {
		//vérification des champs requis
		if(this.authenticatedUser.getPassword().equals("") //mot de passe
			|| this.authenticatedUser.getFirstname().equals("") //prénom
			|| this.authenticatedUser.getName().equals("")) { //nom
			
			return "createUser.xhtml"; //retour au formulaire de création
		}
		return doAdd(); //les champs du formulaire sont remplis, on va donc ajouter le nouveau relais à la bdd
	}
	
	//affichage de tous les relais
	public List<Users> doSelectAll(){
		return this.bean.selectAll();
	}
	
	//recherche d'un relais sur base d'un email
	public Users doSearchUserByMail(String mail) {
		return this.bean.searchByMail(mail);
	}
	
	//ajout d'un relais à la bdd
	public String doAdd() {
		log.info(this.authenticatedUser.toString() + " a bien été ajouté comme relais d'aide à la réussite!");
		System.out.println("Ajout de " + getAuthenticatedUser() + " comme relais");
		this.bean.add(this.authenticatedUser); //demande au dao d'ajouter à la bdd
		return "displayUsers.xhtml";
	}

	//méthode de connexion sécurisée
	public String doLogIn(String mail, String password) {
		//this.authenticatedUser.setMail(mail);
		//this.authenticatedUser.setPassword(password);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			System.out.println("Connexion de " + getAuthenticatedUser().getMail() + " avec le password : " + getAuthenticatedUser().getPassword());
			request.login("duroisins@helha.be", "azerty");	//essai de connexion en dur 
			//request.login(this.authenticatedUser.getMail(), this.authenticatedUser.getPassword());
		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Connexion échouée!", null));
			//FacesContext.addMessage() permet de définir un message géré par JSF, et de lui attribuer un niveau de gravité
			//fonctionne seulement si le param Development est mis dans le web.xml
			
			System.out.println("Connexion échouée");
			System.out.println(this.authenticatedUser.toString()); //renvoie null!!!
			return "loginerror.xhtml";
		}
		Principal principal = request.getUserPrincipal();
		System.out.println("Avant recherche dans la bdd l'utilisateur connecté : \n " + getAuthenticatedUser());
		
		this.authenticatedUser = this.bean.searchByMail(principal.getName());//on recherche dans la base de données l'utilisateur qui se connecte 
		//et on place les données (nom, prénom, genre) dans la variable de l'utilisateur connecté
		
		System.out.println("Après recherche dans la bdd l'utilisateur connecté : \n " + getAuthenticatedUser());
		log.info("Authentification réussie pour l'utilisateur : " + principal.getName());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("Users", this.authenticatedUser);
		if(request.isUserInRole("relay")) {
			//System.out.println("Connexion relais!!");
			return "relay/home.xhtml?faces-redirect=true&useSSL=false";
		}
		//else if(request.isUserInRole("admin"))
		//System.out.println("Connexion admin!!");
		return "admin/home.xhtml?faces-redirect=true&useSSL=false";
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
			System.out.println("Déconnexion échec");
		}
		return "/index?faces-redirect=true&useSSL=false"; //&useSSL=false : empêche des warnings en console
	}
}
