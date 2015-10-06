package com.smacrs.mse2015.common.service;

import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import java.util.List;

public interface UserService {
//	public User getUser(User user);
        public List<LutUserType> getAllType();
}
