package be.helha.aemt.util;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManagementUserEJB;

public class MainUserClient {
	
	public static void main(String[] args) {
		
		try {
			Context ctx = new InitialContext();
			IManagementUserEJB bean = (IManagementUserEJB) ctx.lookup("java:global/groupeA7/ManagementUserEJB!be.helha.aemt.ejb.IManagementUserEJB"); 
			System.out.println(bean.selectAll());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
