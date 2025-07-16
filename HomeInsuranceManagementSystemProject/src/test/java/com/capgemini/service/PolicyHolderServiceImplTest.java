package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.HomeAddress;
import com.capgemini.entities.PolicyHolder;
import com.capgemini.exceptions.DuplicatePolicyHolderFoundException;
import com.capgemini.exceptions.PolicyHolderNotFoundException;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class PolicyHolderServiceImplTest {

	@Autowired
	private IPolicyHolderService policyHolderServiceImp;

	
	/*
	 *  tests whether the policyholder is added or not
	 */

	@Order(1)
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
		policyHolder.setAnnualIncome(1233433);
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
		PolicyHolder result = policyHolderServiceImp.addPolicyHolder(policyHolder);
		assertEquals(result.getPolicyHolderId(), policyHolder.getPolicyHolderId());

	}
	
	/*
	 *  tests whether the policyholder is updated or not
	 */

	@Order(2)
	@Test
	public void theGivenPolicyHolderIsUpdated() throws PolicyHolderNotFoundException {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		policyHolder.setPremiumType("Mon");
		policyHolder.setCreditCard("1234556");
		policyHolder.setDob("18-07-1998");
		policyHolder.setOccupation("Engineer");
		policyHolder.setAnnualIncome(12334);
		policyHolder.setIsRetired("Yes");
		policyHolder.setSsn("abcd");
		policyHolder.setEmailId("ddddd@gmail.com");

		
		assertEquals(policyHolder.getPolicyHolderId(), policyHolderServiceImp.updatePolicyHolder(policyHolder).getPolicyHolderId());

		
	}

	
	
	/*
	 *  tests whether the policyholder is found or not
	 */
	@Order(3)
	@Test
	public void theGivenPolicyHolderIsFound() throws PolicyHolderNotFoundException {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		PolicyHolder result = policyHolderServiceImp.findPolicyHolderById(1);
		assertEquals(policyHolder.getPolicyHolderId(),result.getPolicyHolderId());

	}
	
	
	/*
	 *  tests whether the policyholder is removed or not
	 */

	@Order(7)
	@Test
	public void theGivenPolicyHolderIsRemoved() throws PolicyHolderNotFoundException {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		boolean result = policyHolderServiceImp.removePolicyHolder(1);
		assertTrue(result);

	}
	
	/*
	 *  tests the list of policyholders are present in database or not
	 */

	@Order(5)
	@Test
	public void theListOfPolicyHolders() {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		List<PolicyHolder> policyholders = new ArrayList<>();
		policyholders.add(policyHolder);

		policyholders = policyHolderServiceImp.showAllPolicyHolders();
		Boolean result = policyholders.contains(policyHolder);
		assertEquals(true, result);

	}
	
	
	
	/*
	 *  tests the policyholder not found exception
	 */
	@Order(6)
	@Test
	public void policyHolderNotFoundException() {
		PolicyHolder policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(4);
		assertThrows(PolicyHolderNotFoundException.class, () -> policyHolderServiceImp.updatePolicyHolder(policyHolder),
				"PolicyHolder not Found");
		assertThrows(PolicyHolderNotFoundException.class, () -> policyHolderServiceImp.findPolicyHolderById(4),
				"PolicyHolder not Found");
		assertThrows(PolicyHolderNotFoundException.class, () -> policyHolderServiceImp.removePolicyHolder(4),
				"PolicyHolder not Found");

	}
	
	
	/*
	 *  tests the duplicate policyholder exception
	 */
	
	@Order(4)
	@Test
	public void duplicatePolicyHolderFoundException() {
		PolicyHolder policyHolder=new PolicyHolder();
		policyHolder.setPolicyHolderId(1);
		assertThrows(DuplicatePolicyHolderFoundException.class, ()->policyHolderServiceImp.addPolicyHolder(policyHolder),"Duplicate policyHolder is found");
	}
	

}
