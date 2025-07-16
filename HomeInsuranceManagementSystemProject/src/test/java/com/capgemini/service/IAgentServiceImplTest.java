package com.capgemini.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Agent;
import com.capgemini.exceptions.AgentNotFoundException;
import com.capgemini.exceptions.DuplicateAgentException;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class IAgentServiceImplTest {

	@Autowired
	private AgentServiceImpl agentService;
	
	
	/*
	 *  tests whether the agent is added or not
	 */

	@Order(1)
	@Test
	public void theGivenAgentIsAdded() throws DuplicateAgentException {
		Agent agent = new Agent();

		agent.setAgentId(3);
		agent.setAgentName("swetha");
		agent.setDesignation("Helping Agent");
		agent.setAddress("Tamilnadu");
		agent.setEmail("swetha@gmail.com");
		agent.setMobileNo("8531970678");
		agent.setSalary("20000");

		Agent result = agentService.addAgent(agent);
		assertEquals(result.getAgentId(), agent.getAgentId(), "Agent has been added");

	}

	
	/*
	 *  tests whether the agent is updated or not
	 */
	@Order(2)
	@Test
	public void theGivenAgentIsUpdated() throws AgentNotFoundException {
		Agent agent = new Agent();

		agent.setAgentId(3);
		agent.setAgentName("swetha s");
		agent.setDesignation("Helping Agent");
		agent.setAddress("Tamilnadu");
		agent.setEmail("swetha@gmail.com");
		agent.setMobileNo("8531970678");
		agent.setSalary("20000");

		Agent agentUpdated = agentService.updateAgentById(agent);
		assertEquals(agentUpdated.getAgentId(), agent.getAgentId());

	}


	/*
	 *  tests whether the agent is found or not
	 */
	@Order(3)
	@Test
	public void theGivenAgentIsFound() throws AgentNotFoundException {
		Agent agent = new Agent();
		agent.setAgentId(3);
		Agent agentFound = agentService.findAgentByAgentId(3);
		System.out.println(agentFound.toString());
		assertEquals(agentFound.hashCode(), agent.hashCode());

	}
	
	/*
	 *  tests whether the agent is removed or not
	 */

	@Order(7)
	@Test
	public void theGivenAgentIsRemoved() throws AgentNotFoundException {
		Agent agent = new Agent();

		agent.setAgentId(3);
		boolean agentRemoved = agentService.deleteAgentById(3);
		assertTrue(agentRemoved);

	}
	
	
	/*
	 *  tests the list of agents are present in database or not
	 */

	@Order(4)
	@Test
	public void listOfAllAgents() throws AgentNotFoundException {
		Agent agent = new Agent();

		agent.setAgentId(3);
		List<Agent> listOfAgents = agentService.viewAllAgents();
		Boolean containsAgentList = listOfAgents.contains(agent);
		assertEquals(true, containsAgentList);
	}

	
	/*
	 *  tests the agent not found exception
	 */
	@Order(6)
	@Test
	public void testAgentNotFoundException() {
		Agent agent = new Agent();

		agent.setAgentId(10);
		assertThrows(AgentNotFoundException.class, () -> agentService.updateAgentById(agent), "Agent not found");
		assertThrows(AgentNotFoundException.class, () -> agentService.findAgentByAgentId(10), "Agent not found");
		assertThrows(AgentNotFoundException.class, () -> agentService.deleteAgentById(10), "Agent not found");
	}

	
	/*
	 *  tests the duplicate agent exception
	 */
	@Order(5)
	@Test
	public void testDuplicateAgentException() {
		Agent agent = new Agent();

		agent.setAgentId(3);

		assertThrows(DuplicateAgentException.class, () -> agentService.addAgent(agent), "Duplicate Agent is Found");
	}

}
