package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.Report;

public interface IManagementReportEJB {
	
	public List<Report> selectAll();
	
	public Report add(Report r);
	
	public Report selectId(Long id);
	
	public Report update(Report r);
	
	public void delete(Report r);
}
