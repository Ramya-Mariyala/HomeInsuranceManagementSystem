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

import com.capgemini.entities.PolicyHolder;
import com.capgemini.exceptions.DuplicatePolicyHolderFoundException;
import com.capgemini.exceptions.PolicyHolderNotFoundException;
import com.capgemini.service.IPolicyHolderService;

@RestController
@CrossOrigin
public class PolicyHolderController {
	
	@Autowired
	IPolicyHolderService policyholderservice;
	
	
	/*
	 * Policy holder will be added
	 */
	
	@PostMapping("/policyHolder")
	public String addPolicyHolder(@RequestBody PolicyHolder policyHolder) throws DuplicatePolicyHolderFoundException{
		if(policyholderservice.addPolicyHolder(policyHolder)!=null)
			return "policy holder is added";
		else
			return "PolicyHolder is not added";
	}
	
	/*
	 *  policy holder will be updated
	 */
	
	
	@PutMapping("/policyHolder/policyHolderUpdate")
	public ResponseEntity<PolicyHolder> updatePolicyHolder(@RequestBody PolicyHolder policyHolder) throws PolicyHolderNotFoundException{
		if(policyholderservice.updatePolicyHolder(policyHolder)!=null)
			return new ResponseEntity<PolicyHolder>(policyHolder,HttpStatus.OK);
		return new ResponseEntity("Policy Holder not found",HttpStatus.NOT_FOUND);
	}
	
	
	/*
	 *  policy holder will be found by id 
	 */
	
	@GetMapping("/policyHolder/policyHolderById/{id}")
	public ResponseEntity<PolicyHolder> findPolicyHolderById(@PathVariable int id) throws PolicyHolderNotFoundException{
		PolicyHolder policyHolder=policyholderservice.findPolicyHolderById(id);
		if(policyHolder!=null)
			return new ResponseEntity<PolicyHolder>(policyHolder,HttpStatus.OK);
		return new ResponseEntity("PolicyHolder is not found", HttpStatus.NOT_FOUND);
	}
	
	
	/* 
	 * policy holder will be deleted
	 */
	
	@DeleteMapping("/policyHolder/policyHolderDeleteById/{policyHolderId}")
	public ResponseEntity<String> deletePolicyHolderById(@PathVariable int policyHolderId) throws PolicyHolderNotFoundException{
		if(policyholderservice.removePolicyHolder(policyHolderId))
			return new ResponseEntity<>("Policy Holder is deleted",HttpStatus.NOT_FOUND);
		return new ResponseEntity<>("Policy Holder not found",HttpStatus.NOT_FOUND);
	}
	
	
	/* 
	 * List of policy holders 
	 */
	
	@GetMapping("/policyHolder/policyHolderList")
	public ResponseEntity<List<PolicyHolder>> findAllPolicyHolders(){
		List<PolicyHolder> policyholders=policyholderservice.showAllPolicyHolders();
		if(policyholders.isEmpty())
			return new ResponseEntity("Policy Holder not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<PolicyHolder>>(policyholders,HttpStatus.OK);
			
	}
	
	
	
	/*
	 *  policyholder not found exception
	 */
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = PolicyHolderNotFoundException.class)
	public ResponseEntity<String> handleException(PolicyHolderNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/*
	 *  duplicate policyholder exception
	 */
	
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=DuplicatePolicyHolderFoundException.class)
	public ResponseEntity<String> handleException2(DuplicatePolicyHolderFoundException e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	

}
