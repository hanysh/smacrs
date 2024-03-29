package com.smacrs.mse2015.common.service;

import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import java.util.List;
import java.util.Map;

public interface UserService {
//	public User getUser(User user);
        public List<LutUserType> getAllType();
     
        public boolean insertMessage(CommonMessage message,int recp,boolean reply);
         
        public int getUserId(String code ,String table );
        
        public List<CommonMessage> findMessage(String type, int userId, Map<String, Object> filter, int from, int to);
        
//        public int getMessageCount(Map<String, Object> filter) ;
        
        public int getMessageCount(String type, int userId, Map<String, Object> filter) ;
        
        public List<CommonMessage> getMessage(int threadId);
}
