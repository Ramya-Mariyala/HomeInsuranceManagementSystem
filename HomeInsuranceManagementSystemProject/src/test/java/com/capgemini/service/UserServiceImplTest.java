package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Agent;
import com.capgemini.entities.PolicyHolder;
import com.capgemini.entities.User;
import com.capgemini.exceptions.DuplicateUserException;
import com.capgemini.exceptions.InvalidUserException;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class UserServiceImplTest {

 

    @Autowired
    private UserServiceImpl userServiceImp;
    
    User user = new User();
    Agent agent = new Agent();
    PolicyHolder policyHolder =  new PolicyHolder();
    
    /*
	 *  tests whether the user is added or not
	 */
    @Order(1)
    @Test
    void testAddUserShouldBeAddedToDataBase() throws DuplicateUserException{
        user.setUserName("Anu");
        user.setPassword("anu12");
        user.setRole("Agent");
        agent.setAgentId(2);
        policyHolder.setPolicyHolderId(3);
        user.setAgent(agent);
        user.setPolicyHolder(policyHolder);
        User result = userServiceImp.addNewUser(user);
        assertEquals(result.hashCode(), user.hashCode());
    }
    
    
    /*
	 *  tests whether the user is signed as policyholder
	 */
    @Order(2)
    @Test
    void testPolicyHolderSignin() throws InvalidUserException{
        user.setUserName("Anu");
        user.setPassword("anu12");
        user.setRole("policyholder");
        policyHolder.setPolicyHolderId(3);
        user.setPolicyHolder(policyHolder);
        User result = userServiceImp.signIn("Anu","anu123","policyholder");
        assertEquals(result.getUserName(), user.getUserName());
    }
    
    /*
	 *  tests whether the user is signed as agent
	 */
    
    @Order(3)
    @Test
    void testAgentSignin() throws InvalidUserException{
        user.setUserName("Anu");
        user.setPassword("anu12");
        user.setRole("agent");
        agent.setAgentId(2);
        user.setAgent(agent);
        User result = userServiceImp.signIn("Anu","anu123","policyholder");
        assertEquals(result.getUserName(), user.getUserName());
    }
    
    
   

    
    
    /*
	 *  tests invalid user exception
	 */
    @Order(6)
    @Test
    public void InvalidUserException() {
        User user = new User();
        user.setUserName("Anusree");
        user.setPassword("anu12");
        user.setRole("Agent");
        agent.setAgentId(2);
        policyHolder.setPolicyHolderId(3);
        user.setAgent(agent);
        user.setPolicyHolder(policyHolder);
        assertThrows(InvalidUserException.class, () -> userServiceImp.signIn("Anusree","anu12","policyholder"),"user not found");
    }
    
    
    /*
	 *  tests duplicate user exception
	 */
    
    @Order(7)
    @Test
    public void DuplicateUserException() {
        User user = new User();
        user.setUserName("Anu");
        user.setPassword("anu12");
        user.setRole("Agent");
        agent.setAgentId(2);
        policyHolder.setPolicyHolderId(3);
        user.setAgent(agent);
        user.setPolicyHolder(policyHolder);
        assertThrows(DuplicateUserException.class, () -> userServiceImp.addNewUser(user),"user already exits");
    }
    
 

 

}