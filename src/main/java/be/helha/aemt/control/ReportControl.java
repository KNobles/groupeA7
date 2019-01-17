package be.helha.aemt.control;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagementReportEJB;

@Named
@RequestScoped
public class ReportControl {
	
	@EJB
	ManagementReportEJB bean;

}
