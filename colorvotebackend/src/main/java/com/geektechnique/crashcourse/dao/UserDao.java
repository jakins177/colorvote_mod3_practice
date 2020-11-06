package com.geektechnique.crashcourse.dao;

import java.util.List;
import java.util.UUID;

import com.geektechnique.crashcourse.model.User;

public interface UserDao {
	int insertUser(User user);
	int insertUserYellow(User user);
	int insertUserBlue(User user);
	int insertUserRed(User user);
	int retrieveYellowCount();
	int retrieveBlueCount();
	int retrieveRedCount();
	List<User> checkForDupes(User user);
	
	List<User> selectAllUsers();
}
