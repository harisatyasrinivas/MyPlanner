package org.satya.myplanner.service;

import org.satya.myplanner.model.User;

public interface UserService {

	public long registerUserProfile(User user);
	public User getUserProfile(long id);
	public User updateUserProfile(long id);
	public void deleteProfile(long id);
}

