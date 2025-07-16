package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Property;
import com.capgemini.exceptions.DuplicatePropertyFoundException;
import com.capgemini.exceptions.PropertyNotFoundException;

public interface IPropertyService {
	public Property addProperty(Property property) throws DuplicatePropertyFoundException;
	public Property findPropertyByPropertyId(int propertyId) throws PropertyNotFoundException;
	public List<Property> showAllProperties() throws PropertyNotFoundException;


}
