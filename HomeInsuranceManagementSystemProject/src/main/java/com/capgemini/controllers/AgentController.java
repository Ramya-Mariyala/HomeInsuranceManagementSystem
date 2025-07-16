package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Agent;
import com.capgemini.exceptions.AgentNotFoundException;
import com.capgemini.exceptions.DuplicateAgentException;
import com.capgemini.service.IAgentService;

@RestController
@RequestMapping("agents")
@CrossOrigin
public class AgentController {

	@Autowired
	IAgentService agentservice;

	
	/*
	 * Agent will be added
	 */
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/agent")
	public String addAgent(@RequestBody Agent agent) throws DuplicateAgentException {
		if (agentservice.addAgent(agent)!=null)
			return "Agent is added";
		else
			return "Agent is not added";

	}

	/*
	 *  Agent will be found by id 
	 */
	@GetMapping("/agentById/{agentId}")
	public ResponseEntity<Agent> findAgentById(@PathVariable int agentId) throws AgentNotFoundException {
		Agent agent = agentservice.findAgentByAgentId(agentId);
		if (agent == null)
			return new ResponseEntity("Agent is not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Agent>(agent, HttpStatus.OK);

	}
	
	/* 
	 * List of Agents 
	 */

	@GetMapping("/viewAllAgents")
	public ResponseEntity<List<Agent>> viewAllAgents() throws AgentNotFoundException {
		List<Agent> agents = agentservice.viewAllAgents();
		if (agents.isEmpty())
			return new ResponseEntity("Agent not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Agent>>(agents, HttpStatus.OK);

	}
	/*
	 *  Agent will be updated
	 */

	@PutMapping("/agentUpdate/{agentId}")
	public ResponseEntity<Agent> updateAgentById(@RequestBody Agent agent) throws AgentNotFoundException {
		if (agentservice.updateAgentById(agent)!=null)
			return new ResponseEntity<Agent>(agent, HttpStatus.NOT_FOUND);
		return new ResponseEntity("Agent not found", HttpStatus.NOT_FOUND);

	}
	/* 
	 * Agent will be deleted
	 */

	@DeleteMapping("/agentDelete/{agentId}")
	public ResponseEntity<String> deleteAgentById(@PathVariable int agentId) throws AgentNotFoundException {
		if (agentservice.deleteAgentById(agentId))
			return new ResponseEntity<>("Agent is deleted", HttpStatus.OK);
		return new ResponseEntity<>("Agent not found", HttpStatus.NOT_FOUND);
	}
	
	
	/*
	 *  agent not found exception
	 */

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = AgentNotFoundException.class)
	public ResponseEntity<String> handleException(AgentNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/*
	 *  duplicate agent exception
	 */

	@ExceptionHandler(value = DuplicateAgentException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException2(DuplicateAgentException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
