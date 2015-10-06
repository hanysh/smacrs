package com.smacrs.mse2015.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smacrs.mse2015.common.dao.UserDao;
import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import com.smacrs.mse2015.common.service.UserService;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
 
//	public User getUser(User user) {
//		return userDao.getUser(user);
//	}

    public List<LutUserType> getAllType() {
        return userDao.getAllType();
    }
}
