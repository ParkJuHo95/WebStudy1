package kr.or.ddit.property.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class PropertyDAOTest {
	
	PropertyDAO dao = new InMemoryPropertyDAOImpl("/kr/or/ddit/message/message-common_en.properties");

	@Test
	void testInsertProperty() {
		PropertyVO newProp = new PropertyVO();
		newProp.setPropertyName("dummyName");
		newProp.setPropertyValue("dummyValue");
		int rowcnt = dao.insertProperty(newProp);
		assertEquals(1, rowcnt);
	}

	@Test
	void testSelectProperties() {
		List<PropertyVO> propList = dao.selectProperties();
//		assertion
		assert propList != null;
		assertNotNull(propList);
		assertNotEquals(0, propList.size());
	}

	@Test
	void testSelectProperty() {
		PropertyVO vo = dao.selectProperty("asdfasdf");
		assertNull(vo);
		vo = dao.selectProperty("fail.common.msg");
		assertNotNull(vo);
	}

	@Test
	void testUpdateProperty() {
		PropertyVO modifyProp = new PropertyVO();
		modifyProp.setPropertyName("fail.common.msg");
		modifyProp.setPropertyValue("modified value");
		int rowcnt = dao.updateProperty(modifyProp);
		assertEquals(1, rowcnt);
		
		modifyProp.setPropertyName("afsdasdf");
		modifyProp.setPropertyValue("modified value");
		rowcnt = dao.updateProperty(modifyProp);
		assertEquals(0, rowcnt);
	}

	@Test
	void testDeleteProperty() {
		fail("Not yet implemented");
	}

}








