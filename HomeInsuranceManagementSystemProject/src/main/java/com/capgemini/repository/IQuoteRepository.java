package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Quote;

public interface IQuoteRepository extends JpaRepository<Quote, Integer>{

}
