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
		return daoInterview.selectAll();
	}

	@Override
	public Interview add(Interview i) {
		return daoInterview.add(i);
	}

	@Override
	public Interview updateInterview(Interview i) {
		return daoInterview.updateInterview(i);
	}

	@Override
	public void deleteAllInterview(Interview i) {
		daoInterview.deleteAllInterviews(i);
	}

}
