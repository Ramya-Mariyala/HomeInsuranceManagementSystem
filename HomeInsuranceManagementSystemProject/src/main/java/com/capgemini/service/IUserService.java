package com.capgemini.service;

import com.capgemini.entities.User;
import com.capgemini.exceptions.DuplicateUserException;
import com.capgemini.exceptions.InvalidUserException;

public interface IUserService {
	public User addNewUser(User user) throws DuplicateUserException;
	
	public User signIn(String userName, String password, String role) throws InvalidUserException;                                                                                                         
	public String forgotPassword(String email) throws InvalidUserException;
	public User signOut(User user);
	

}
