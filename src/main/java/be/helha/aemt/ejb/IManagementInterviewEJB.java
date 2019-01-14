package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Interview;

@Remote
public interface IManagementInterviewEJB {

	public List<Interview> selectAll();
	
	public Interview add(Interview i);
	
	public Interview updateInterview(Interview i);
	
	public void deleteAllInterview(Interview i);
}
