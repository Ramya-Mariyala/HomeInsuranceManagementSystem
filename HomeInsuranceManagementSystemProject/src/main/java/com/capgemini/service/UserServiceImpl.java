package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.User;
import com.capgemini.exceptions.DuplicateUserException;
import com.capgemini.exceptions.InvalidUserException;
import com.capgemini.repository.IUserRepository;


@Service("userservice")
public class UserServiceImpl implements IUserService {
 
    @Autowired
    private IUserRepository dao;
 
    /*
     * User will be added
     */
    @Override
    public User addNewUser(User user) throws DuplicateUserException {
        if (dao.existsById(user.getUserName())) {
            throw new DuplicateUserException("Duplicate user is Found");
 
        }
        dao.save(user);
        return user;
    }
 
    /*
     * User can sign in
     */
 
    @Override
    public User signIn(String userName, String password, String role) throws InvalidUserException {
        User signedUser = dao.signIn(userName, password, role);
        if (signedUser != null)
            return signedUser;
        else
            throw new InvalidUserException("Invalid userName or Password");
    }
 
    /*
     * User can sign out
     */
    @Override
    public User signOut(User user) {
        return null;
    }
 
    @Override
    public String forgotPassword(String userName) throws InvalidUserException {
        User user = dao.findByUserName(userName);
        if (user != null && user.getUserName().equals(userName)) {
            return user.getPassword();
        }
        throw new InvalidUserException("No record found with this login");
    }
}