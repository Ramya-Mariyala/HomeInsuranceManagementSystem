package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Agent;
import com.capgemini.exceptions.AgentNotFoundException;
import com.capgemini.exceptions.DuplicateAgentException;
import com.capgemini.repository.IAgentRepository;

@Service("agentservice")
public class AgentServiceImpl implements IAgentService {

	@Autowired
	private IAgentRepository repository;

	
	/*
	 * Agent will be added
	 */
	@Override
	public Agent addAgent(Agent agent) throws DuplicateAgentException {
		if (repository.existsById(agent.getAgentId())) {
			throw new DuplicateAgentException("Duplicate Agent is Found");
		}
		repository.save(agent);
		return agent;

	}
	
	
	
	/*
	 *  Agent will be found by id 
	 */

	@Override
	public Agent findAgentByAgentId(int agentId) throws AgentNotFoundException {
		Optional<Agent> agentById = repository.findById(agentId);
		if (agentById.isPresent())
			return agentById.get();
		throw new AgentNotFoundException("Agent not found");
	}

	
	
	/*
	 *  Agent will be updated
	 */
	@Override
	public Agent updateAgentById(Agent agent) throws AgentNotFoundException {
		if (repository.existsById(agent.getAgentId())) {
			repository.save(agent);
			return agent;
		}
		throw new AgentNotFoundException("Agent not found");

	}
	
	
	
	/* 
	 * Agent will be deleted
	 */

	@Override
	public boolean deleteAgentById(int agentId) throws AgentNotFoundException {
		if (repository.existsById(agentId)) {
			repository.deleteById(agentId);
			return true;
		}
		throw new AgentNotFoundException("Agent not found");
	}
	
	
	/* 
	 * List of Agents 
	 */

	@Override
	public List<Agent> viewAllAgents() throws AgentNotFoundException {
		List<Agent> listOfAgents = repository.findAll();
		if (listOfAgents.isEmpty())
			throw new AgentNotFoundException("No Agents found");
		return listOfAgents;
	}
}
