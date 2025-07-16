package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.entities.Property;
import com.capgemini.exceptions.DuplicatePropertyFoundException;
import com.capgemini.exceptions.PropertyNotFoundException;
import com.capgemini.repository.IPropertyRepository;

@SpringBootTest
public class PropertyServiceImplTestWithMockito {

	@Autowired
	private PropertyServiceImpl propertyService;

	@MockBean
	private IPropertyRepository dao;

	@Test
	public void theGivenPropertyIsAdded() throws DuplicatePropertyFoundException {
		Property property = new Property();
		property.setPropertyId(5);
		property.setMarketValue(10000);
		property.setYearBuilt(2020);
		property.setSquareFootage(40);
		property.setDwellingStyle(5000);
		property.setRoofMaterial("Asphalt");
		property.setGarageType("Detached");
		property.setFullBathCount(40);
		property.setHalfBathCount(20);
		property.setHasSwimmingPool(false);

		Property res = propertyService.addProperty(property);

		when(dao.save(property)).thenReturn(property);
		assertEquals(property.getMarketValue(), res.getMarketValue());
	}

	@Test
	public void theGivenPropertyIsViewed() throws PropertyNotFoundException {
		Property property = new Property();
		when(dao.findById(5)).thenReturn(Optional.of(property));
		when(dao.existsById(5)).thenReturn(true);
		Property result = propertyService.findPropertyByPropertyId(5);
		assertEquals(property, result);
	}

}