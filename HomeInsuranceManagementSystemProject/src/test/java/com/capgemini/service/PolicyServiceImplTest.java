package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Policy;
import com.capgemini.exceptions.DuplicatePolicyFoundException;
import com.capgemini.exceptions.PolicyNotFoundException;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class PolicyServiceImplTest {
	@Autowired
	private PolicyServiceImpl policyServiceImpl;
	
	
	/*
	 *  tests whether the policy is added or not
	 */
	@Order(1)
	@Test
	void testGivenPolicyIsAdded() throws DuplicatePolicyFoundException {
		Policy policy = new Policy();
		policy.setPolicyId(111);
		policy.setPolicyEffectiveDate("2-2-1898");
		policy.setPolicyEndDate("1-1-2000");
		policy.setPolicyStatus("Active");
		policy.setPolicyTerm(9);
		Policy result = policyServiceImpl.addPolicy(policy);
		assertEquals(result.getPolicyId(), policy.getPolicyId());
	}

	/*
	 *  tests whether the policy is updated or not
	 */
	@Order(2)
	@Test
	void testGivenPolicyIsUpdated() throws PolicyNotFoundException {
		Policy policy = new Policy();
		policy.setPolicyId(111);
		policy.setPolicyEffectiveDate("2-2-1892");
		policy.setPolicyEndDate("1-1-2002");
		policy.setPolicyStatus("Pending");
		policy.setPolicyTerm(1);
		Policy result1 = policyServiceImpl.updatePolicy(policy);
		assertEquals(result1.getPolicyId(), policy.getPolicyId());

	}

	
	/*
	 *  tests whether the policy is found or not
	 */
	@Order(3)
	@Test
	public void theGivenPolicyIsFoundById() throws PolicyNotFoundException {
		Policy policy = new Policy();
		policy.setPolicyId(111);
		Policy res2 = policyServiceImpl.findPolicyByPolicyId(111);
		assertEquals(res2.getPolicyId(), policy.getPolicyId());

	}

	/*
	 *  tests the list of policies are present in database or not
	 */
	@Order(5)
	@Test
	public void theListOfPolicies() throws PolicyNotFoundException {
		Policy policy = new Policy();
		policy.setPolicyId(111);
		java.util.List<Policy> policies = policyServiceImpl.showAllPolicies();
		Boolean result = policies.contains(policy);
		assertEquals(true, result);
	}
	/*
	 *  tests whether the policy is removed or not
	 */

	@Order(7)
	@Test
	public void theGivenPolicyIsRemoved() throws PolicyNotFoundException {
		Policy policy = new Policy();
		policy.setPolicyId(111);
		boolean result = policyServiceImpl.removePolicy(111);
        assertTrue(result);

	}
	/*
	 *  tests the policy not found exception
	 */

	@Order(6)
	@Test
	public void policyNotFoundException() throws PolicyNotFoundException {
		Policy policy = new Policy();
		policy.setPolicyId(177);
		assertThrows(PolicyNotFoundException.class, () -> policyServiceImpl.updatePolicy(policy), "Policy not Found");
		assertThrows(PolicyNotFoundException.class, () -> policyServiceImpl.findPolicyByPolicyId(177),
				"Policy not Found");
		assertThrows(PolicyNotFoundException.class, () -> policyServiceImpl.removePolicy(177), "Policy not Found");
	}
	/*
	 *  tests the duplicate policy exception
	 */

	@Order(4)
	@Test
	public void DuplicatePolicyFoundException() {
		Policy policy = new Policy();
		policy.setPolicyId(111);
		assertThrows(DuplicatePolicyFoundException.class, () -> policyServiceImpl.addPolicy(policy),
				"policy already exits");
	}

}
