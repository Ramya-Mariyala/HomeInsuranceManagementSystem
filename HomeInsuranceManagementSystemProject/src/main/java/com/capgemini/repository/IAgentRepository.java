package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Agent;

public interface IAgentRepository extends JpaRepository<Agent, Integer>{

}
