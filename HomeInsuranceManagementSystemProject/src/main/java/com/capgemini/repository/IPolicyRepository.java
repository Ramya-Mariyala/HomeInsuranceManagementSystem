package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Policy;

public interface IPolicyRepository extends JpaRepository<Policy, Integer>{

}
