package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOReport;
import be.helha.aemt.entities.Report;

@LocalBean
@Stateless
public class ManagementReportEJB implements IManagementReportEJB {

	DAOReport daoReport;
	
	@Override
	public List<Report> selectAll() {
		return this.daoReport.selectAll();
	}

	@Override
	public Report add(Report r) {
		return this.daoReport.add(r);
	}

	@Override
	public Report selectId(Long id) {
		return this.daoReport.selectId(id);
	}

	@Override
	public Report update(Report r) {
		return this.daoReport.updateReport(r);
	}

	@Override
	public void delete(Report r) {
		this.daoReport.deleteAllReports(r);
		
	}

}
