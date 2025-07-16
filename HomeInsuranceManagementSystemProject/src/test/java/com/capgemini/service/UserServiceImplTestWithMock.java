package com.capgemini.service;

 

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

 

import java.util.Optional;

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

 

import com.capgemini.entities.User;
import com.capgemini.exceptions.DuplicateUserException;
import com.capgemini.exceptions.InvalidUserException;
import com.capgemini.repository.IUserRepository;

 

@SpringBootTest
public class UserServiceImplTestWithMock {

 

    @Autowired
    private UserServiceImpl userServiceImp;
    
    @MockBean
    private IUserRepository userRepository;
    
    @Test
    void testAddUserShouldBeAddedToDataBase() throws DuplicateUserException{
        User user = new User();
        user.setUserName("AnuS");
        user.setPassword("anu12");
        user.setRole("Agent");
        when(userRepository.save(user)).thenReturn(user);
        User result = userServiceImp.addNewUser(user);
        assertEquals(result.getUserName(), user.getUserName());
    }
    
    
    @Test
    void testPolicyHolderSignin() throws InvalidUserException{
        User user = new User();
        user.setUserName("Anu");
        user.setPassword("anu1234");
        user.setRole("policyholder");  
        when(userRepository.existsById("Anu")).thenReturn(true);
        when(userRepository.findById("Anu")).thenReturn(Optional.of(user));
        when(userRepository.signIn("Anu","anu123","policyholder")).thenReturn(user);
        User result = userServiceImp.signIn("Anu","anu123","policyholder");
        assertEquals(result, user);
    }
    @Test
    void testAgentSignin() throws InvalidUserException{
        User user = new User();
        user.setUserName("Anushree");
        user.setPassword("anu1234");
        user.setRole("Agent");  
        when(userRepository.existsById("Anushree")).thenReturn(true);
        when(userRepository.findById("Anushree")).thenReturn(Optional.of(user));
        when(userRepository.signIn("Anu","anu123","policyholder")).thenReturn(user);
        User result = userServiceImp.signIn("Anu","anu123","policyholder");
        assertEquals(result, user);
    }
    
    
   
 

    
    

 

}