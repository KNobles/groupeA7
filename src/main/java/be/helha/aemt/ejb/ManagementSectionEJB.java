package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DAOSection;
import be.helha.aemt.entities.Section;

@LocalBean
@Stateless
public class ManagementSectionEJB implements IManagementSectionEJB {

	DAOSection daoSection;
	
	@Override
	public List<Section> selectAll() {
		return this.daoSection.selectAll();
	}

	@Override
	public Section add(Section s) {
		return this.daoSection.add(s);
	}

	@Override
	public Section selectId(long id) {
		return this.daoSection.selectId(id);
	}

	@Override
	public Section update(Section s) {
		return this.daoSection.updateSection(s);
	}

	@Override
	public void delete(Section s) {
		this.daoSection.deleteSection(s);
		
	}

}
