package com.smacrs.mse2015.common.service.impl;

import com.mysql.fabric.xmlrpc.base.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smacrs.mse2015.common.dao.UserDao;
import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.CommonMessageRecipient;
import com.smacrs.mse2015.common.entity.CommonMessageThread;
import com.smacrs.mse2015.common.entity.CommonUserLogin;
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
    public boolean insertMessage(CommonMessage message, int recp, boolean reply) {
        if (!reply) {
            CommonMessageThread messageThread = new CommonMessageThread();
            messageThread.setOriginatorUserId(message.getSenderUserId());
            messageThread.setInstId(message.getInstId());
            messageThread.setStartDate(new Date());
            messageThread.setLastReplyDate(new Date());
            userDao.insertObject(messageThread);
            message.setMessageThreadId(messageThread);
        }
        message.setId(null);
        userDao.insertObject(message);
        CommonMessageRecipient messageRecipient = new CommonMessageRecipient();
        messageRecipient.setMessageId(message);
        messageRecipient.setRecipientUserId(new CommonUserLogin(recp));
        messageRecipient.setInstId(message.getInstId());
        userDao.insertObject(messageRecipient);
        return true;
    }

    public int getUserId(String code, String table) {
        return userDao.getUserId(code, table);
    }

    public List<CommonMessage> findMessage(String type, int userId, Map<String, Object> filter, int from, int to) {
        if (type != null && type.equalsIgnoreCase("inbox")) {
            return userDao.findinboxMessage(userId, filter, from, to);
        } else if (type != null && type.equalsIgnoreCase("sent")) {
            return userDao.findSentMessage(userId, filter, from, to);
        }
        return null;
    }

    public int getMessageCount(Map<String, Object> filter) {
        return userDao.getMessageCount(filter);
    }

    public int getMessageCount(String type, int userId, Map<String, Object> filter) {
        return userDao.getMessageCount(type, userId, filter);
    }

    public List<CommonMessage> getMessage(int threadId) {
        return userDao.getMessage(threadId);
    }
}
