package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOInterview;
import be.helha.aemt.entities.Interview;

/**
 * 
 * @author Nobles
 *
 */
@LocalBean
@Stateless
public class ManagementInterviewEJB implements IManagementInterviewEJB {

	private DAOInterview daoInterview;
	
	@Override
	public List<Interview> selectAll() {
		return this.daoInterview.selectAll();
	}
	
	@Override
	public Interview selectId(Long id) {
		return this.daoInterview.selectId(id);
	}

	@Override
	public Interview add(Interview i) {
		return this.daoInterview.add(i);
	}

	@Override
	public Interview updateInterview(Interview i) {
		return this.daoInterview.updateInterview(i);
	}

	@Override
	public void deleteAllInterview(Interview i) {
		this.daoInterview.deleteAllInterviews(i);
	}

}
