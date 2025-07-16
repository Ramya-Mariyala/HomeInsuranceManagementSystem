package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.User;
import com.capgemini.exceptions.InvalidUserException;

public interface IUserRepository extends JpaRepository<User, String>{
	
	@Query("select u from User u where userName=?1 and password=?2 and role=?3 ")
    public User signIn(String userName,String password, String role);
	
	public User findByUserName(String userName) throws InvalidUserException;

}
