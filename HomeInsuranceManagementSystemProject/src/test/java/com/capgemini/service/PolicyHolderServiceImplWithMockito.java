package com.capgemini.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.entities.HomeAddress;
import com.capgemini.entities.PolicyHolder;
import com.capgemini.exceptions.DuplicatePolicyHolderFoundException;
import com.capgemini.exceptions.PolicyHolderNotFoundException;
import com.capgemini.repository.IPolicyHolderRepository;

@SpringBootTest
public class PolicyHolderServiceImplWithMockito {
	
	@Autowired
	private IPolicyHolderService policyHolderServiceImp;
	
	@MockBean
	private IPolicyHolderRepository respository;
	
	
	
	/*
	 *  tests whether the policyholder is added or not
	 */
	
	@Test
	public void theGivenPolicyHolderIsAdded() throws DuplicatePolicyHolderFoundException {
		HomeAddress address = new HomeAddress();
		PolicyHolder policyHolder = new PolicyHolder();

		policyHolder.setPolicyHolderId(1);
		policyHolder.setPolicyHolderName("Srihitha");
		policyHolder.setPolicyName("Personal Accident Insurance");
		policyHolder.setPremiumType("Monthly");
		policyHolder.setCreditCard("1234556");
		policyHolder.setDob("18-07-1998");
		policyHolder.setOccupation("Engineer");
		policyHolder.setAnnualIncome(12334);
		policyHolder.setIsRetired("Yes");
		policyHolder.setSsn("123");
		policyHolder.setEmailId("sri@gmail.com");
		address.setAddressLine1("Hyderabad");
		address.setAddressLine2("Telangana");
		address.setCity("Hyd");
		address.setResidenceType("Apartment");
		address.setResidenceUse("Personal");
		address.setZip("500000");
		address.setState("Tel");
		policyHolder.setAddress(address);
		when(respository.save(policyHolder)).thenReturn(policyHolder);
		assertEquals(policyHolderServiceImp.addPolicyHolder(policyHolder).getPolicyHolderId(), policyHolder.getPolicyHolderId());

	}
	
	
	
	/*
	 *  tests whether the policyholder is updated or not
	 */
	@Test
	public void theGivenPolicyHolderIsUpdated() throws PolicyHolderNotFoundException {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		when(respository.existsById(1)).thenReturn(true);
		when(respository.findById(1)).thenReturn(Optional.of(policyHolder));
		when(respository.save(policyHolder)).thenReturn(policyHolder);
		PolicyHolder result=policyHolderServiceImp.updatePolicyHolder(policyHolder);
		assertEquals(policyHolder, result);
		
		
		
	}
	
	
	/*
	 *  tests whether the policyholder is found or not
	 */
	
	@Test
	public void theGivenPolicyHolderIsFound() throws PolicyHolderNotFoundException {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		when(respository.findById(1)).thenReturn(Optional.of(policyHolder));
		when(respository.existsById(1)).thenReturn(true);
		PolicyHolder result=policyHolderServiceImp.findPolicyHolderById(1);
		assertEquals(policyHolder, result);
	}

	
	
	/*
	 *  tests whether the policyholder is removed or not
	 */
	@Test
	public void theGivenPolicyHolderIsRemoved() throws PolicyHolderNotFoundException {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		when(respository.findById(1)).thenReturn(Optional.of(policyHolder));
		when(respository.existsById(1)).thenReturn(true);
		boolean result=policyHolderServiceImp.removePolicyHolder(1);
		assertTrue(result);

	}
	
	/*
	 *  tests the list of policyholders are present in database or not
	 */

	@Test
	public void theListOfPolicyHolders() {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		List<PolicyHolder> policyholders = new ArrayList<>();
		policyholders.add(policyHolder);
		when(respository.findAll()).thenReturn(policyholders);
		List<PolicyHolder> result = policyHolderServiceImp.showAllPolicyHolders();
		assertEquals(result.size(),policyholders.size());	
		assertNotNull(result);
	}
	
	

}

