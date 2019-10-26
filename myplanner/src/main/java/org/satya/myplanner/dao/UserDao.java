package org.satya.myplanner.dao;

import org.satya.myplanner.model.User;

public interface UserDao {
	
	//Create user
	//Get User
	//update user
	//delete user
	
	public long registerUserProfile(User user);
	public User getUserProfile(long id);
	public User updateUserProfile(long id);
	public void deleteProfile(long id);
	
	

}
