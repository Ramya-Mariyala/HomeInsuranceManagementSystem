package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Policy;
import com.capgemini.exceptions.DuplicatePolicyFoundException;
import com.capgemini.exceptions.PolicyNotFoundException;
import com.capgemini.service.IPolicyService;

@RestController
@CrossOrigin
public class PolicyController {

	@Autowired
	IPolicyService policyservice;
	
	

	/*
	 * Policy will be added
	 */

	@PostMapping("/policy")
	public ResponseEntity<String> addPolicy(@RequestBody Policy policy) throws DuplicatePolicyFoundException {
		if (policyservice.addPolicy(policy) != null) {
			return new ResponseEntity<>("policy added successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("policy not found", HttpStatus.NOT_FOUND);
		}
	}
	
	
	/*
	 *  Policy will be updated
	 */

	@PutMapping("/updatepolicy/{policyId}")
	public ResponseEntity<String> updatePolicy(@RequestBody Policy Policy) throws PolicyNotFoundException {
		if (policyservice.updatePolicy(Policy) != null)
			return new ResponseEntity<>("Policy is updated",HttpStatus.OK);
		return new ResponseEntity<>("policy is not found", HttpStatus.NOT_FOUND);
	}
	
	
	/*
	 *  Policy will be found by id 
	 */

	@GetMapping("/policybyid/{policyId}")
	public ResponseEntity<Policy> findPolicyByPolicyId(@PathVariable int policyId) throws PolicyNotFoundException {
		Policy findPolicy = policyservice.findPolicyByPolicyId(policyId);
		if (findPolicy == null)
			return new ResponseEntity("Policy not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<Policy>(findPolicy, HttpStatus.OK);
	}
	
	
	/* 
	 * policy will be deleted
	 */

	@DeleteMapping("/deletepolicy/{policyId}")
	public ResponseEntity<String> removePolicy(@PathVariable int policyId) throws PolicyNotFoundException {
		if (policyservice.removePolicy(policyId))
			return new ResponseEntity<>("policy deleted successfully", HttpStatus.OK);
		return new ResponseEntity<>("policy not found", HttpStatus.NOT_FOUND);
	}
	
	/* 
	 * List of policies 
	 */

	@GetMapping("/allpolicies")
	public ResponseEntity<List<Policy>> showAllPolicies() throws PolicyNotFoundException {
		List<Policy> allPolicies = policyservice.showAllPolicies();
		if (allPolicies.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Policy>>(allPolicies, HttpStatus.OK);
	}
	
	
	/*
	 *  policy not found exception
	 */

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = PolicyNotFoundException.class)
	public ResponseEntity<String> handleException(PolicyNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 *  duplicate policy exception
	 */

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = DuplicatePolicyFoundException.class)
	public ResponseEntity<String> handleException2(DuplicatePolicyFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
