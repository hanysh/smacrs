package com.smacrs.mse2015.common.service.impl;

import com.mysql.fabric.xmlrpc.base.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smacrs.mse2015.common.dao.UserDao;
import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.CommonMessageThread;
import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import com.smacrs.mse2015.common.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional
    public boolean insertMessage(CommonMessage message) {
        CommonMessageThread messageThread=new CommonMessageThread();
        messageThread.setOriginatorUserId(message.getSenderUserId());
        messageThread.setInstId(message.getInstId());
        messageThread.setStartDate(new Date());
        messageThread.setLastReplyDate(new Date());
        userDao.insertObject(messageThread);
        message.setMessageThreadId(messageThread);
        return  userDao.insertObject(message);
    }
    
    public long getUserId(String code ,String table ){
       return userDao.getUserId(code, table);
    }
    
    public List<CommonMessage> findMessage(Map<String,Object> filter,int from,int to){
        return userDao.findMessage(filter, from, to);
    }
}
