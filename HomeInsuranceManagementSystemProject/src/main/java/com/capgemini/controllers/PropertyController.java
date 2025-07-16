package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Property;
import com.capgemini.exceptions.DuplicatePropertyFoundException;
import com.capgemini.exceptions.PropertyNotFoundException;
import com.capgemini.service.IPropertyService;

@RestController
@CrossOrigin
public class PropertyController {

	@Autowired
	IPropertyService propertyservice;

	/*
	 *
	 * To insert a new Property
	 *
	 */
	@PostMapping("/property")
	public ResponseEntity<String> addProperty(@RequestBody Property property) throws DuplicatePropertyFoundException {
		if (propertyservice.addProperty(property) != null) {
			return new ResponseEntity<>("Property is added", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Property is not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/*
	 *
	 * To find the quote by PropertyId
	 *
	 */
	@GetMapping("/property/propertyById/{propertyId}")
	public ResponseEntity<Property> findPropertyBypropertyId(@PathVariable int propertyId)
			throws PropertyNotFoundException {
		Property findproperty = propertyservice.findPropertyByPropertyId(propertyId);
		if (findproperty.equals(null))
			return new ResponseEntity("Property is not found", HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Property>(findproperty, HttpStatus.OK);

	}

	@GetMapping("/property/allproperties")
	public ResponseEntity<List<Property>> showAllProperties() throws PropertyNotFoundException {
		List<Property> allProperties = propertyservice.showAllProperties();
		if (allProperties.isEmpty())
			return new ResponseEntity("No Property found", HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<List<Property>>(allProperties, HttpStatus.OK);
	}

	/*
	 *
	 * Property not found exception
	 *
	 */
	@ExceptionHandler(value = PropertyNotFoundException.class)
	public ResponseEntity<String> handleException(PropertyNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 *
	 * Duplicate property found exception
	 *
	 */
	@ExceptionHandler(value = DuplicatePropertyFoundException.class)
	public ResponseEntity<String> handleException2(DuplicatePropertyFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}