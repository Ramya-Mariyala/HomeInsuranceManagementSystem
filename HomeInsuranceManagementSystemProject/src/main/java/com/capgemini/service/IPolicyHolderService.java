package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.PolicyHolder;
import com.capgemini.exceptions.DuplicatePolicyHolderFoundException;
import com.capgemini.exceptions.PolicyHolderNotFoundException;


public interface IPolicyHolderService {

	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws DuplicatePolicyHolderFoundException;

	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;

	public PolicyHolder findPolicyHolderById(int id) throws PolicyHolderNotFoundException;

	public boolean removePolicyHolder(int id) throws PolicyHolderNotFoundException;

	public List<PolicyHolder> showAllPolicyHolders();
	

}
