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
        
        public long getUserId(String code,String table);
        
        public List<CommonMessage> findMessage(Map<String,Object> filter,int from,int to);
}
