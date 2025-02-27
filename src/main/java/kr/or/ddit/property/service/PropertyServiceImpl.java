package kr.or.ddit.property.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import kr.or.ddit.property.dao.InMemoryPropertyDAOImpl;
import kr.or.ddit.property.dao.PropertyDAO;
import kr.or.ddit.vo.PropertyVO;

public class PropertyServiceImpl implements PropertyService {
	
	private PropertyDAO dao = new InMemoryPropertyDAOImpl("/kr/or/ddit/message/message-common_en.properties");

	@Override
	public boolean createProperty(PropertyVO newProp) {
		int rowcnt = dao.insertProperty(newProp);
		return rowcnt > 0;
	}

	@Override
	public PropertyVO retrieveProperty(String propertyName) {
		return dao.selectProperty(propertyName);
	}

	@Override
	public List<PropertyVO> retrieveProperties() {
		return dao.selectProperties();
	}

	@Override
	public Set<String> retrieveKeySet() {
		return retrieveProperties().stream()
					.map(PropertyVO::getPropertyName)
					.collect(Collectors.toSet());
	}

	@Override
	public boolean updateProperty(PropertyVO modifyProp) {
		return dao.updateProperty(modifyProp) > 0;
	}

	@Override
	public boolean deleteProperty(String propetyName) {
		return dao.deleteProperty(propetyName) > 0;
	}

}









