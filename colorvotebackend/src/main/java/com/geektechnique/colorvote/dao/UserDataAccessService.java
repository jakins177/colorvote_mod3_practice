package com.geektechnique.colorvote.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.geektechnique.colorvote.model.ColorDataBase;
import com.geektechnique.colorvote.model.User;

@Repository("colorVotePsql")
public class UserDataAccessService implements UserDao {
	
	ColorDataBase realDB = new ColorDataBase();
	
    @Override
    public int insertUser(User user) {
        realDB.createUserRecord(user.getName());
        return 0;
    }
    
    @Override
    public List<User> selectAllUsers() {
        return realDB.getAllUserRecords();
    }

	@Override
	public List<User> checkForDupes(User user) {
		// TODO Auto-generated method stub
		return realDB.checkForDupes(user.getName());
	}

	@Override
	public int insertUserYellow(User user) {
		realDB.createUserYellow(user.getName());
		return 0;
	}

	@Override
	public int insertUserBlue(User user) {
		// TODO Auto-generated method stub
		realDB.createUserBlue(user.getName());
		return 0;
	}

	@Override
	public int insertUserRed(User user) {
		// TODO Auto-generated method stub.
		realDB.createUserRed(user.getName());
		return 0;
	}

	@Override
	public int retrieveYellowCount() {
		
		return realDB.getYellowCount();
	}
	
	@Override
	public int retrieveBlueCount() {
		
		return realDB.getBlueCount();
	}
    
	@Override
	public int retrieveRedCount() {
		
		return realDB.getRedCount();
	}
    

}
