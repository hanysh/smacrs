package com.smacrs.mse2015.common.dao;

import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import java.util.List;
import java.util.Map;

public interface UserDao {
//	public User getUser(User user);

    public List<LutUserType> getAllType();

    public boolean insertMessage(CommonMessage message);

    public boolean insertObject(Object o);

    public int getUserId(String code, String table);

    public List<CommonMessage> findMessage(Map<String, Object> filter, int from, int to);

    public int getMessageCount(Map<String, Object> filter);

    public List<CommonMessage> findSentMessage(int senderId, Map<String, Object> filter, int from, int to);

    public List<CommonMessage> findinboxMessage(int recip, Map<String, Object> filter, int from, int to);
    
    public int getMessageCount(String type, int userId, Map<String, Object> filter) ;
    
    public List<CommonMessage> getMessage(int threadId);
}
