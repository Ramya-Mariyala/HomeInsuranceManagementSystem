package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Policy;
import com.capgemini.exceptions.DuplicatePolicyFoundException;
import com.capgemini.exceptions.PolicyNotFoundException;

public interface IPolicyService {
	public Policy addPolicy(Policy policy) throws DuplicatePolicyFoundException;

	 

    public Policy updatePolicy(Policy policy) throws PolicyNotFoundException;

 

    public Policy findPolicyByPolicyId(int policyId) throws PolicyNotFoundException;

 

    public boolean removePolicy(int policyId) throws PolicyNotFoundException;

 

    public List<Policy> showAllPolicies() throws PolicyNotFoundException;

}
