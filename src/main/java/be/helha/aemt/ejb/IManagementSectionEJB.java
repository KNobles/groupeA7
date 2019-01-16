package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Section;

@Remote
public interface IManagementSectionEJB {
	
	public List<Section> selectAll();
	
	public Section add(Section s);
	
	public Section selectId(String code);
	
	public Section update(Section s);
	
	public void delete(Section s);
}
