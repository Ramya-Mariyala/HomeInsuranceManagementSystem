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

import com.capgemini.entities.Agent;
import com.capgemini.exceptions.AgentNotFoundException;
import com.capgemini.exceptions.DuplicateAgentException;
import com.capgemini.repository.IAgentRepository;

@SpringBootTest
public class AgentServiceImplWithMockito {

	@MockBean
	private IAgentRepository repository;

	@Autowired
	private AgentServiceImpl agentService;

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
		when(repository.save(agent)).thenReturn(agent);
		Agent result = agentService.addAgent(agent);
		assertEquals(result.getAgentId(), agent.getAgentId(), "Agent has been added");

	}

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

		when(repository.existsById(3)).thenReturn(true);
		when(repository.findById(3)).thenReturn(Optional.of(agent));
		when(repository.save(agent)).thenReturn(agent);
		Agent result = agentService.updateAgentById(agent);
		assertEquals(agent, result);

	}

	@Test
	public void theGivenAgentIsFound() throws AgentNotFoundException {
		Agent agent = new Agent();
		agent.setAgentId(3);
		agent.setAgentName("swetha s");
		agent.setDesignation("Helping Agent");
		agent.setAddress("Tamilnadu");
		agent.setEmail("swetha@gmail.com");
		agent.setMobileNo("8531970678");
		agent.setSalary("20000");

		when(repository.findById(3)).thenReturn(Optional.of(agent));
		when(repository.existsById(3)).thenReturn(true);
		Agent result = agentService.findAgentByAgentId(3);
		assertEquals(agent, result);

	}

	@Test
	public void theGivenAgentIsRemoved() throws AgentNotFoundException {
		Agent agent = new Agent();
		agent.setAgentId(3);

		when(repository.findById(3)).thenReturn(Optional.of(agent));
		when(repository.existsById(3)).thenReturn(true);
		boolean result = agentService.deleteAgentById(3);
		assertTrue(result);

	}

	@Test
	public void listOfAllAgents() throws AgentNotFoundException {
		Agent agent = new Agent();

		agent.setAgentId(3);
		agent.setAgentName("swetha");
		agent.setDesignation("Helping Agent");
		agent.setAddress("Tamilnadu");
		agent.setEmail("swetha@gmail.com");
		agent.setMobileNo("8531970678");
		agent.setSalary("20000");

		List<Agent> listOfAgents = new ArrayList<>();
		listOfAgents.add(agent);
		when(repository.findAll()).thenReturn(listOfAgents);
		List<Agent> result = agentService.viewAllAgents();
		assertEquals(result.size(), listOfAgents.size());
		assertNotNull(result);

	}

	

}
