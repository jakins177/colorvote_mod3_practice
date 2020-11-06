package com.geektechnique.colorvote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.geektechnique.colorvote.dao.UserDao;
import com.geektechnique.colorvote.model.User;

@Service
public class UserService {
	
	 private final UserDao userDao;
	 
	 @Autowired
	    public UserService(@Qualifier("colorVotePsql") UserDao userDao) {
	        this.userDao = userDao;
	    }
	 
	 public int addUser(User user){
	        return userDao.insertUser(user);
	    }
	 
	 public int addUserYellow(User user){
	        return userDao.insertUserYellow(user);
	    }
	 public int addUserBlue(User user){
	        return userDao.insertUserBlue(user);
	    }
	 public int addUserRed(User user){
	        return userDao.insertUserRed(user);
	    }
	 
	 public int getYellowCount(){
	        return userDao.retrieveYellowCount();
	    }
	 public int getBlueCount(){
	        return userDao.retrieveBlueCount();
	    }
	 public int getRedCount(){
	        return userDao.retrieveRedCount();
	    }
	 
	 
	 public List<User> getAllUsers(){
	        return userDao.selectAllUsers();
	    }
	 
	 public List<User> checkDupes(User user){
	        return userDao.checkForDupes(user);
	    }

}
