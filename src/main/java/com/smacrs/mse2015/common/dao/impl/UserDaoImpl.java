package com.smacrs.mse2015.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.smacrs.mse2015.common.dao.UserDao;
import com.smacrs.mse2015.common.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository("userDao")
public class UserDaoImpl implements UserDao{

@PersistenceContext 
private EntityManager em;
        
	public User getUser(User user) { 
		javax.persistence.Query query=em.createNamedQuery("User.findByUserNameAndPassword");
		query.setParameter("userName",user.getUserName() );
		query.setParameter("password", user.getPassword());
		User updatedUser=(User) query.getSingleResult();
		return  updatedUser;
	}
}
