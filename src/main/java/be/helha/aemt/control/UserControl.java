package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementUserEJB;
import be.helha.aemt.entities.User;

@RequestScoped
@Named
public class UserControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagementUserEJB bean;
	private User user = new User();
	
	public List<User> doSelectAll(){
		return bean.selectAll();
	}
	
	public ManagementUserEJB getBean() {
		return bean;
	}

	public void setBean(ManagementUserEJB bean) {
		this.bean = bean;
	}
	public String doAdd() {
		bean.add(user);
		return "liste.xhtml";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
//	public String doGetDetails(User user) {
//		this.user = user;
//		return "detail.xhtml";
//	}
	
	
}
