package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.dao.DAOReport;
import be.helha.aemt.entities.Report;

public class ManagementReportEJB implements IManagementReportEJB {

	DAOReport daoReport;
	
	@Override
	public List<Report> selectAll() {
		return daoReport.selectAll();
	}

	@Override
	public Report add(Report r) {
		return daoReport.add(r);
	}

	@Override
	public Report selectId(Long id) {
		return daoReport.selectId(id);
	}

	@Override
	public Report update(Report r) {
		return daoReport.updateReport(r);
	}

	@Override
	public void delete(Report r) {
		daoReport.deleteAllReports(r);
		
	}

}
