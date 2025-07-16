package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Agent;
import com.capgemini.exceptions.AgentNotFoundException;
import com.capgemini.exceptions.DuplicateAgentException;

public interface IAgentService {

	public Agent addAgent(Agent agent) throws DuplicateAgentException;

	public Agent findAgentByAgentId(int agentId) throws AgentNotFoundException;

	public Agent updateAgentById(Agent agent) throws AgentNotFoundException;

	public boolean deleteAgentById(int agentId) throws AgentNotFoundException;

	public List<Agent> viewAllAgents() throws AgentNotFoundException;
}
