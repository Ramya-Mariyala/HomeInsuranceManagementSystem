package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Property;
import com.capgemini.exceptions.DuplicatePropertyFoundException;
import com.capgemini.exceptions.PropertyNotFoundException;
import com.capgemini.repository.IPropertyRepository;


@Service("propertyservice")
public class PropertyServiceImpl implements IPropertyService {

	@Autowired
	private IPropertyRepository dao;

	
	/*
	 * Property will be added
	 */
	@Override
	public Property addProperty(Property property) throws DuplicatePropertyFoundException {
		if (dao.existsById(property.getPropertyId())) {
			throw new DuplicatePropertyFoundException("Duplicate Property is Found");

		}

		dao.save(property);
		return property;
	}
	
	
	/*
	 *  Property will be found by id 
	 */

	@Override
	public Property findPropertyByPropertyId(int propertyId) throws PropertyNotFoundException {
		Optional<Property> findproperty = dao.findById(propertyId);
		if (findproperty.isPresent()) {
			return findproperty.get();
		} else {
			throw new PropertyNotFoundException("Property not Found");
		}
	}


	@Override
	public List<Property> showAllProperties() throws PropertyNotFoundException {
		List<Property> allProperties = dao.findAll();
		if (allProperties.isEmpty()) {
		throw new PropertyNotFoundException("No Properties found");
		} else {
		return allProperties;

		 }
	}

}
