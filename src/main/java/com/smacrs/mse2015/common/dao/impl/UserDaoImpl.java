package com.smacrs.mse2015.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.smacrs.mse2015.common.dao.UserDao;
import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository("userDao")
public class UserDaoImpl implements UserDao{

@PersistenceContext 
private EntityManager em;
        
//	public User getUser(User user) { 
//		javax.persistence.Query query=em.createNamedQuery("User.findByUserNameAndPassword");
//		query.setParameter("userName",user.getUserName() );
//		query.setParameter("password", user.getPassword());
//		User updatedUser=(User) query.getSingleResult();
//		return  updatedUser;
//	}

    public List<LutUserType> getAllType() {
        javax.persistence.Query query=em.createNamedQuery("LutUserType.findAll");
		List<LutUserType> usertypes=(List<LutUserType>) query.getResultList();
		return  usertypes;
    }
}
