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
		return daoSection.selectAll();
	}

	@Override
	public Section add(Section s) {
		return daoSection.add(s);
	}

	@Override
	public Section selectId(String code) {
		return daoSection.selectId(code);
	}

	@Override
	public Section update(Section s) {
		return daoSection.updateSection(s);
	}

	@Override
	public void delete(Section s) {
		daoSection.deleteSection(s);
		
	}

}
