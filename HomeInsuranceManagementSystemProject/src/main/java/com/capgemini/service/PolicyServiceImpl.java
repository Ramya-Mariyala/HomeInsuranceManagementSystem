package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Policy;
import com.capgemini.exceptions.DuplicatePolicyFoundException;
import com.capgemini.exceptions.PolicyNotFoundException;
import com.capgemini.repository.IPolicyRepository;


@Service("policyservice")
public class PolicyServiceImpl implements IPolicyService {

	@Autowired
	private IPolicyRepository policyRepository;

	
	
	/*
	 * Policy will be added
	 */
	@Override
	public Policy addPolicy(Policy policy) throws DuplicatePolicyFoundException {

		if (policyRepository.existsById(policy.getPolicyId())) {
			throw new DuplicatePolicyFoundException("Duplicate Policy is Found");
		}
		policyRepository.save(policy);
		return policy;
	}

	
	
	
	
	/*
	 *  Policy will be updated
	 */
	@Override
	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException {
		if (policyRepository.existsById(policy.getPolicyId())) {
			policyRepository.save(policy);
			return policy;
		} else {
			throw new PolicyNotFoundException("policy not found");
		}

	}
	
	
	/*
	 *  Policy will be found by id 
	 */

	@Override
	public Policy findPolicyByPolicyId(int policyId) throws PolicyNotFoundException {

		Optional<Policy> findpolicy = policyRepository.findById(policyId);
		if (findpolicy.isPresent()) {
			return findpolicy.get();
		} else {
			throw new PolicyNotFoundException("policy not found");
		}

	}
	
	
	/* 
	 * policy will be deleted
	 */

	@Override
	public boolean removePolicy(int policyId) throws PolicyNotFoundException {

		if (policyRepository.existsById(policyId)) {
			policyRepository.deleteById(policyId);
			return true;
		} else {
			throw new PolicyNotFoundException("policy not found");
		}

	}

	
	
	/* 
	 * List of policies 
	 */
	@Override
	public List<Policy> showAllPolicies() throws PolicyNotFoundException {
		List<Policy> allPolicies = policyRepository.findAll();
		if (allPolicies.isEmpty()) {
			throw new PolicyNotFoundException("No Policies found");
		} else {
			return allPolicies;

		}
	}

}