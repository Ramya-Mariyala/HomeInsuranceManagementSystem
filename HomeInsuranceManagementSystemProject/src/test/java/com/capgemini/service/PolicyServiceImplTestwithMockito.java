package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.entities.Policy;
import com.capgemini.exceptions.DuplicatePolicyFoundException;
import com.capgemini.exceptions.PolicyNotFoundException;
import com.capgemini.repository.IPolicyRepository;

@SpringBootTest
public class PolicyServiceImplTestwithMockito {
    @Autowired
    private PolicyServiceImpl policyServiceImpl;
    @MockBean
    private IPolicyRepository repository;

 

    @Test
    void testGivenPolicyIsAdded() throws DuplicatePolicyFoundException {
        Policy policy = new Policy();
        policy.setPolicyId(111);
        policy.setPolicyEffectiveDate("2-2-1898");
        policy.setPolicyEndDate("1-1-2000");
        policy.setPolicyStatus("Active");
        policy.setPolicyTerm(9);
        when(repository.save(policy)).thenReturn(policy);
        Policy result = policyServiceImpl.addPolicy(policy);
        assertEquals(result.getPolicyId(), policy.getPolicyId());
    }

 

    @Test
    void testGivenPolicyIsUpdated() throws PolicyNotFoundException {
        Policy policy = new Policy();
        policy.setPolicyId(111);
        policy.setPolicyEffectiveDate("2-2-1892");
        policy.setPolicyEndDate("1-1-2002");
        policy.setPolicyStatus("Pending");
        policy.setPolicyTerm(1);
        when(repository.existsById(111)).thenReturn(true);
        when(repository.findById(111)).thenReturn(Optional.of(policy));
        when(repository.save(policy)).thenReturn(policy);
        Policy result1 = policyServiceImpl.updatePolicy(policy);
        assertEquals(result1.getPolicyId(), policy.getPolicyId());

 

    }

 

    @Test
    public void theGivenPolicyIsFoundById() throws PolicyNotFoundException {
        Policy policy = new Policy();
        policy.setPolicyId(111);
        when(repository.findById(111)).thenReturn(Optional.of(policy));
        when(repository.existsById(111)).thenReturn(true);
        Policy res2 = policyServiceImpl.findPolicyByPolicyId(111);
        assertEquals(res2.getPolicyId(), policy.getPolicyId());

 

    }

 

    @Test
    public void theListOfPolicies() throws PolicyNotFoundException {
        Policy policy = new Policy();
        policy.setPolicyId(111);
        List<Policy> policies = new ArrayList<>();
        policies.add(policy);
        when(repository.findAll()).thenReturn(policies);
        List<Policy> result = policyServiceImpl.showAllPolicies();
        assertEquals(result.size(), policies.size());
        assertNotNull(result);
    }

 

    @Test
    public void theGivenPolicyIsRemoved() throws PolicyNotFoundException {
        Policy policy = new Policy();
        policy.setPolicyId(111);
        when(repository.findById(111)).thenReturn(Optional.of(policy));
        when(repository.existsById(111)).thenReturn(true);
        boolean result = policyServiceImpl.removePolicy(111);
        assertTrue(result);

 

    }
}
