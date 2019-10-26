package org.satya.myplanner.dao;

import org.hibernate.SessionFactory;
import org.satya.myplanner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public long registerUserProfile(User user) {
		sessionfactory.getCurrentSession().save(user);	
		return user.getUserID();
	}

	@Override
	public User getUserProfile(long id) {
		User user= (User) sessionfactory.getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public User updateUserProfile(long id) {
		User user= (User) sessionfactory.getCurrentSession().load(User.class, id);
		if(user != null) {
			 sessionfactory.getCurrentSession().saveOrUpdate(user);
		}
		return user;
		
	}

	@Override
	public void deleteProfile(long id) {
		User user= (User) sessionfactory.getCurrentSession().load(User.class, id);
		sessionfactory.getCurrentSession().delete(user);		
	}

}
