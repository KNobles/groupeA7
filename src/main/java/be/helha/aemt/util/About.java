package be.helha.aemt.util;

import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named(value = "about")
public class About {

	private static final String 
			authors = "Site r�alis� par Nill�s, Nobles, Rocroix", 
			content = "� �tudiants en informatique de gestion � la HELHa Campus Mons,\n" + 
						"dans le cadre du cours d'Applications entreprise multi tiers de Mr. V. Altares. �";
	
	public void showAbout() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, authors, content);
        PrimeFaces.current().dialog().showMessageDynamic(message);
	}
}
