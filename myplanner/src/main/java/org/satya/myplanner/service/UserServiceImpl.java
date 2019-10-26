package org.satya.myplanner.service;

import javax.transaction.Transactional;

import org.satya.myplanner.dao.UserDao;
import org.satya.myplanner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public long registerUserProfile(User user) {
		return userDao.registerUserProfile(user);

	}

	@Override
	public User getUserProfile(long id) {
		return userDao.getUserProfile(id);
	}

	@Override
	public User updateUserProfile(long id) {
		return userDao.updateUserProfile(id);

	}

	@Override
	@Transactional
	public void deleteProfile(long id) {
		userDao.deleteProfile(id);

	}

}
