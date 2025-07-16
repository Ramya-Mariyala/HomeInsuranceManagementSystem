package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Property;
import com.capgemini.exceptions.DuplicatePropertyFoundException;
import com.capgemini.exceptions.PropertyNotFoundException;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class PropertyServiceImplTest {

	@Autowired
	private PropertyServiceImpl propertyServiceImp;
	
	/*
	 *  tests whether the property is added or not
	 */

	@Order(1)
	@Test
	public void theGivenPropertyIsAdded() throws DuplicatePropertyFoundException {
		Property property = new Property();
		property.setPropertyId(100);
		property.setMarketValue(10000);
		property.setYearBuilt(2020);
		property.setSquareFootage(40);
		property.setDwellingStyle(5000);
		property.setRoofMaterial("Asphalt");
		property.setGarageType("Detached");
		property.setFullBathCount(40);
		property.setHalfBathCount(20);
		property.setHasSwimmingPool(false);

		Property res = propertyServiceImp.addProperty(property);
		assertEquals(property.getMarketValue(), res.getMarketValue());
	}

	
	/*
	 *  tests whether the property is found or not
	 */
	@Order(2)
	@Test
	public void theGivenPropertyIsViewed() throws PropertyNotFoundException {
		Property property = new Property();
		property.setPropertyId(100);
		Property res1 = propertyServiceImp.findPropertyByPropertyId(100);
		assertEquals(res1.getPropertyId(), property.getPropertyId());
	}
	
	/*
	 *  tests the property not found exception
	 */

	@Order(3)
	@Test
	public void PropertyNotFoundException() {
		Property property = new Property();
		property.setPropertyId(46);
		assertThrows(PropertyNotFoundException.class, () -> propertyServiceImp.findPropertyByPropertyId(46),
				"property not Found");

	}
	/*
	 *  tests the duplicate property exception
	 */

	@Order(4)
	@Test
	public void DuplicatePropertyFoundException() {
		Property property = new Property();
		property.setPropertyId(100);

		assertThrows(DuplicatePropertyFoundException.class, () -> propertyServiceImp.addProperty(property),
				" Duplicate property Found");

	}
}