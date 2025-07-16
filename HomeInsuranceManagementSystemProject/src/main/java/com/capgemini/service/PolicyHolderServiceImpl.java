package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.PolicyHolder;
import com.capgemini.exceptions.DuplicatePolicyHolderFoundException;
import com.capgemini.exceptions.PolicyHolderNotFoundException;
import com.capgemini.repository.IPolicyHolderRepository;


@Service
public class PolicyHolderServiceImpl implements IPolicyHolderService {

	@Autowired
	private IPolicyHolderRepository policyHolderRepository;

	
	/*
	 * Policy holder will be added
	 */
	@Override
	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws DuplicatePolicyHolderFoundException {
		if (policyHolderRepository.existsById(policyHolder.getPolicyHolderId())) {
			throw new DuplicatePolicyHolderFoundException("Duplicate PolicyHolder is Found"); 

		}

		policyHolderRepository.save(policyHolder);
		return policyHolder;
	}

	
	/*
	 *  policy holder will be updated
	 */
	@Override
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		if (policyHolderRepository.existsById(policyHolder.getPolicyHolderId())) {
			policyHolderRepository.save(policyHolder);
			return policyHolder;
		}
		throw new PolicyHolderNotFoundException(
				"Policy Holder with id= " + policyHolder.getPolicyHolderId() + " is not found");

	}

	/*
	 *  policy holder will be found by id 
	 */
	@Override
	public PolicyHolder findPolicyHolderById(int id) throws PolicyHolderNotFoundException {
		Optional<PolicyHolder> employee = policyHolderRepository.findById(id);
		if (employee.isPresent())
			return employee.get();
		throw new PolicyHolderNotFoundException("Policy Holder with id= " + id + " is not found");
	}

	/* 
	 * policy holder will be deleted
	 */
	@Override
	public boolean removePolicyHolder(int id) throws PolicyHolderNotFoundException {
		if (policyHolderRepository.existsById(id)) {
			policyHolderRepository.deleteById(id);
			return true;
		}
		throw new PolicyHolderNotFoundException("Policy Holder with id= " + id + " is not found");
	}

	/* 
	 * List of policy holders 
	 */
	@Override
	public List<PolicyHolder> showAllPolicyHolders() {
		return policyHolderRepository.findAll();
	}

}
